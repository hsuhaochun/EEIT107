package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CompanyServletAll.do")
public class CompanyServletAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("YA");
						response.setCharacterEncoding("UTF-8");
						CompanyDAO service = new CompanyDAO();
						List<CompanyBean> list=new ArrayList<>();
						StringBuffer sb = new StringBuffer();
						list=service.selectAll();
						sb.append("<table><tr><th width='120'>公司代號</th><th width='120'>公司名稱</th><th width='120'>產業別</th> <th width='120'>董事長</th><th width='120'>上市日期</th> <th width='200'>電子信箱</th></tr>");
						for(CompanyBean b:list) {
							sb.append("<tr><td>"+b.getComco()+"</td>");
							sb.append("<td>"+b.getComname()+"</td>");
							sb.append("<td>"+b.getIndustry()+"</td>");
							sb.append("<td>"+b.getChariman()+"</td>");
							sb.append("<td>"+b.getListdate()+"</td>");
							sb.append("<td>"+b.getEmail()+"</td></tr>");
							}
						sb.append("<table>");
						System.out.println(sb);
						response.getWriter().print(sb);
				
	}
}
