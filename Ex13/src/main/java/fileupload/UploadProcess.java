package fileupload;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadProcess
 */
@WebServlet("/UploadProcess.do")
@MultipartConfig(maxFileSize = 1024 * 1024 * 1, maxRequestSize = 1024 * 1024 * 10)
public class UploadProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String saveDirectory = getServletContext().getRealPath("/Uploads");
			String originalFileName = FileUtil.uploadFile(request, saveDirectory);
			String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
			insertMyFile(request, originalFileName, savedFileName);
			response.sendRedirect("FileList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "파일 업로드 오류");
			request.getRequestDispatcher("FileUploadMain.jsp").forward(request, response);
		}
	}

	public void insertMyFile(HttpServletRequest request, String oFileName, String sFilename) {
		String title = request.getParameter("title");
		String[] cateArray = request.getParameterValues("cate");
		StringBuffer cateBuf =new StringBuffer();
		if(cateArray == null) {
			cateBuf.append("선택한 항목 없음");
		}else {
			for(String s : cateArray) {
				cateBuf.append(s+", ");
			}
		}
		
		MyFileDTO dto = new MyFileDTO();
		dto.setTitle(title);
		dto.setCate(cateBuf.toString());
		dto.setOfile(oFileName);
		dto.setSfile(sFilename);
		
		MyFileDAO dao = new MyFileDAO();
		dao.insertFile(dto);
		dao.close();
		
	}
}
