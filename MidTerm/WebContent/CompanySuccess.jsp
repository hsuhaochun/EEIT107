<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上市公司資料</title>
</head>
<style>
tr,td{ 
border:1px solid #cccccc; text-align:center;
}
th{
background-color:	#408080;
color:#F5F5F5;
}
table{
margin: 30px auto;

border-style:double;
}
body{
width:800px;
margin: 0 auto;
text-align:center;
background: url(bg1.jpg);
background-height:auto;
background-position : left ;
 

}
h3{
color:	#ce0000;
}

</style>
<body>
 <h3>${title}</h3>
			<table>
				<tr>
					<th width='120'>公司代號</th>
					<th width='120'>公司名稱</th>
					<th width='120'>產業別</th>
					<th width='120'>董事長</th>
					<th width='120'>上市日期</th>
					<th width='200'>電子信箱</th>
				</tr>
			
					<tr>
						<td>${companyBean.comco}</td>
						<td>${companyBean.comname}</td>
						<td>${companyBean.industry}</td>
						<td>${companyBean.chariman}</td>
						<td>${companyBean.listdate}</td>
						<td>${companyBean.email}</td>
					</tr>
				
			</table>
			
			<a href="CompanyHome.jsp">回首頁</a>
			
      
</body>
</html>