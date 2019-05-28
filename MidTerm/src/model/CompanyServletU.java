package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CompanyServletU.do")
public class CompanyServletU extends HttpServlet {
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
		String comname = request.getParameter("comName");

		if (comname == null || comname.trim().length() == 0) {
			errorMessage.put("comName", "必須輸入");
		}

		String industry = request.getParameter("Industry");

		if (industry == null || industry.trim().length() == 0) {
			errorMessage.put("Industry", "必須輸入");
		}

		String chariman = request.getParameter("chariMan");

		if (chariman == null || chariman.trim().length() == 0) {
			errorMessage.put("chariMan", "必須輸入");
		}

		String listdate = request.getParameter("listDate");

		java.sql.Date date = null;

		if (listdate != null && listdate.trim().length() > 0) {
			try {
				date = java.sql.Date.valueOf(listdate);
			} catch (IllegalArgumentException e) {
				errorMessage.put("listDate", "日期格式錯誤");
			}
		}else {
			errorMessage.put("listDate", "必須輸入");
		}

		String email = request.getParameter("Email");

		if (email == null || email.trim().length() == 0) {
			errorMessage.put("Email", "必須輸入");
		}

		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/CompanyForm.jsp");
			rd.forward(request, response);
			return;
		}
		int icomco = Integer.parseInt(comco);
		CompanyBean cb = new CompanyBean(icomco, comname, industry, chariman, date, email);
		CompanyDAO service = new CompanyDAO();
		int updateCount = service.update(cb);
		if (updateCount == 0) {
			errorMessage.put("exception", "查無此資料");
			RequestDispatcher rd = request.getRequestDispatcher("/CompanyForm.jsp");
			rd.forward(request, response);
			return;
		} else {
			cb = service.select(icomco);
			session.setAttribute("companyBean", cb);
			session.setAttribute("title", "修改成功");
			RequestDispatcher rd = request.getRequestDispatcher("/CompanySuccess.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
