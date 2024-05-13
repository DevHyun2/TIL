package com.shinhan.frontpattern;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shinhan.dto.BoardDTO;
import com.shinhan.emp.EmpDTO;
import com.shinhan.model.BoardService;

public class BoardInsertController implements CommonControllerInterface{

	@Override
	public String execute(Map<String, Object> dataMap) {
		String page = "boardinsert.jsp";
		String method = (String)dataMap.get("method");
		
		if(method.equals("get")) {
			return "boardinsert.jsp";
		}else {
			EmpDTO loginEmp = (EmpDTO)dataMap.get("loginEmp");
			HttpServletRequest request = (HttpServletRequest)dataMap.get("request");
			String encoding = "utf-8";
			
			String path = request.getServletContext().getRealPath(".");
			
			File currentDirPath = new File(path+"/upload");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(currentDirPath);
			factory.setSizeThreshold(1024 * 1024);

			ServletFileUpload upload = new ServletFileUpload(factory);
			BoardDTO board = new BoardDTO();
			try {
				List items = upload.parseRequest(request);
				for (int i = 0; i < items.size(); i++) {
					FileItem fileItem = (FileItem) items.get(i);

					if (fileItem.isFormField()) {
						//입력 text field
						System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
						if(fileItem.getFieldName().equals("title")) board.setTitle(fileItem.getString(encoding));
						if(fileItem.getFieldName().equals("content")) board.setContent(fileItem.getString(encoding));
					} else {
						//이미지
						if(fileItem.getFieldName().equals("pic")) board.setPic(fileItem.getName());
						
//						System.out.println("getFieldName:" + fileItem.getFieldName());
//						System.out.println("getName:" + fileItem.getName());
//						System.out.println("getSize:" + fileItem.getSize() + "bytes");

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
				//DB에 저장하기
				HttpSession session = request.getSession(); 
				EmpDTO emp = (EmpDTO)session.getAttribute("loginEmp"); 
				String writer = emp.getFirst_name()+ emp.getLast_name();
				
				board.setWriter(writer);
				
				int result = new BoardService().insertBoard(board); 
				System.out.println(result +"건 입력"); 
				page = "redirect:selectAll.do";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//post end
	return page;
	}//method end

}//class end
