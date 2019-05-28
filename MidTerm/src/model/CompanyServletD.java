package model;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CompanyServletD.do")
public class CompanyServletD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
		request.setCharacterEncoding("UTF-8");
		String comco = request.getParameter("comCo");

		if (comco == null || comco.trim().length() == 0) {
			errorMessage.put("comCo", "必須輸入");
		}

		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/CompanyForm.jsp");
			rd.forward(request, response);
			return;
		}

		int icomco = Integer.parseInt(comco);
		
		CompanyBean cb = new CompanyBean();
		CompanyDAO service = new CompanyDAO();
		cb = service.select(icomco);
		session.setAttribute("companyBean", cb);
		int updatecount=service.remove(icomco);
		if(updatecount==0) {
			errorMessage.put("exception", "查無此資料");
			RequestDispatcher rd = request.getRequestDispatcher("/CompanyHome.jsp");
			rd.forward(request, response);
			return;
		}else {
			session.setAttribute("title", "刪除成功");
			RequestDispatcher rd = request.getRequestDispatcher("/CompanySuccess.jsp");
			rd.forward(request, response);

			return;
		}
		
	}
}
