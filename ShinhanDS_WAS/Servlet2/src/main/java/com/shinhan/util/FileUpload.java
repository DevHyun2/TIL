
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUpload
 */
//@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("uploadForm.jsp").forward(request, response);
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
			String encoding = "utf-8";
			String path = getServletContext().getRealPath(".");
			File currentDirPath = new File(path+"/upload");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(currentDirPath);
			factory.setSizeThreshold(1024 * 1024);

			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List items = upload.parseRequest(request);
				for (int i = 0; i < items.size(); i++) {
					FileItem fileItem = (FileItem) items.get(i);
	
					if (fileItem.isFormField()) {
						System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					} else {
						System.out.println("getFieldName:" + fileItem.getFieldName());
						System.out.println("getName:" + fileItem.getName());
						System.out.println("getSize:" + fileItem.getSize() + "bytes");
	
						if (fileItem.getSize() > 0) {
							int idx = fileItem.getName().lastIndexOf("\\");
							if (idx == -1) {
								idx = fileItem.getName().lastIndexOf("/");
							}
							String fileName = fileItem.getName().substring(idx + 1);
							File uploadFile = new File(currentDirPath + "\\" + fileName);
							fileItem.write(uploadFile);
						} // end if
					} // end if
				} // end for
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}