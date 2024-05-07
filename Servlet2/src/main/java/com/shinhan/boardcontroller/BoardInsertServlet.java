package com.shinhan.boardcontroller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shinhan.dto.BoardDTO;
import com.shinhan.emp.EmpDTO;
import com.shinhan.model.BoardService;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board/boardInsert.do")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("boardinsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		String path = getServletContext().getRealPath(".");
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
					
//					System.out.println("getFieldName:" + fileItem.getFieldName());
//					System.out.println("getName:" + fileItem.getName());
//					System.out.println("getSize:" + fileItem.getSize() + "bytes");

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
			 response.sendRedirect("selectAll.do");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		/*
		 * String title = request.getParameter("title"); String content =
		 * request.getParameter("contente"); String pic = request.getParameter("pic");
		 * 
		 * HttpSession session = request.getSession(); EmpDTO emp =
		 * (EmpDTO)session.getAttribute("loginEmp"); String writer = emp.getFirst_name()
		 * + emp.getLast_name();
		 * 
		 * BoardDTO board = new BoardDTO(0, title, content, writer, pic, null); int
		 * result = new BoardService().insertBoard(board); System.out.println(result +
		 * "건 입력"); response.sendRedirect("selectAll.do");
		 */
}

