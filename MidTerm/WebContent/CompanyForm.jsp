<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上市公司資料</title>
<script>
	function ins() {
		var act = document.getElementById("in").value;
		document.getElementById("fo").action = "CompanyServletI.do";
		document.getElementById("fo").submit();

	}
	function upd() {
		var act = document.getElementById("up").value;
		document.getElementById("fo").action = "CompanyServletU.do";
		document.getElementById("fo").submit();
	}
	function chkEmail() {
		let Email = document.getElementById("mail").value;
		re = /^.+@.+\..{2,3}$/;
		if (re.test(Email)) {
			document.getElementById("spe").innerHTML = "";
		} else {
			document.getElementById("spe").innerHTML = "未輸入資料或格式有誤";
		}
	}
	function chkData() {

		let No = parseInt(this.id.charAt(3));
		theData = document.getElementById("num" + No).value;

		if (theData == "") {
			document.getElementById("spd" + No).innerHTML = "未輸入資料";
		} else {
			document.getElementById("spd" + No).innerHTML = "";
		}

	}

	function chkDate() {
		let theDate = document.getElementById("date").value;
		re = /^\d{4}\-\d{1,2}\-\d{1,2}$/;
		if (re.test(theDate)) {
			document.getElementById("spd").innerHTML = "";
		} else {
			document.getElementById("spd").innerHTML = "未輸入資料或格式有誤";
		}
	}
	document.addEventListener("DOMContentLoaded", function() {
		for (let i = 1; i <= 4; i++) {
			document.getElementById("num" + i)
					.addEventListener("blur", chkData);
		}
	})
	document.addEventListener("DOMContentLoaded", function() {
		document.getElementById("mail").addEventListener("blur", chkEmail);
	})
	document.addEventListener("DOMContentLoaded", function() {
		document.getElementById("date").addEventListener("blur", chkDate);
	})
</script>
<style>
form {
	margin: 0 auto;
	width: 600px;
}

.d {
	width: 500;
	margin: 60px;
	text-align: left;
}

fieldset {
	width: 500px;
	border-radius: 15px;
	margin-bottom: 20px;
	border-style: outset;
}

span {
	font-size: 8px;
	color: red;
}

legend {
	color: #408080;
	font-size: 30px;
	text-align: center;
	font-size: 30px;
}

select {
	margin-right: 120px;
}

.in {
	margin-right: 30px;
}

body {
	background: url(bg1.jpg);
	background-height: auto; 
 	background-position: left;
}
</style>
</head>
<body>
	<form id="fo" action="CompanyServletI.do" method="POST">
		<fieldset>
			<legend>上市公司資料</legend>

			<div class="d">
				<label>公司代號：</label> <input id='num1' style="text-align: left"
					name="comCo" value="${param.comCo}" type="text" size="16">
				<span id=spd1></span>
				<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.comCo}</div>
			</div>

			<div class="d">
				<label>公司名稱：</label> <input id='num2' style="text-align: left"
					name="comName" value="${param.comName}" type="text" size="16">
				<span id=spd2></span>
				<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.comName}</div>
			</div>

			<div class="d">
				<label>產業別：&nbsp&nbsp&nbsp</label> <input name="Industry" id='num3'
					value="${param.Industry}" type="text" size="16"> <span
					id=spd3></span>
				<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.Industry}</div>
			</div>

			<div class="d">
				<label>董事長：&nbsp&nbsp&nbsp</label> <input name="chariMan" id='num4'
					value="${param.chariMan}" type="text" size="16"> <span
					id=spd4></span>
				<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.chariMan}</div>
			</div>
			<div class="d">
				<label>上市日期：</label> <input name="listDate" id="date"
					value="${param.listDate}" type="text" size="16"> <span
					id=spd></span>
				<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.listDate}</div>
				<br> <font color="#0044BB" size="-2">ex:&nbsp;yyyy-MM-dd</font>
			</div>
			<div class="d">
				<label>電子信箱：</label> <input name="Email" id="mail"
					value="${param.Email}" type="text" size="16"> <span id=spe></span>
				<div style="color: #FF0000; font-size: x-small; display: inline">${ErrorMsg.Email}</div>
				<br> <font color="#0044BB" size="-2">ex:&nbsp;abc@gmail.com</font>

			</div>
			<div>

				<input class="in" id="in" type="button" value="新增" onclick="ins()">
				<input class="in" id="up" type="button" value="修改" onclick="upd()">
				<input class="in" type="button"
					onclick="javascript:location.href='CompanyHome.jsp'" value="返回">
				<span>${ErrorMsg.exception}</span>
			</div>
		</fieldset>
	</form>
</body>
</html>