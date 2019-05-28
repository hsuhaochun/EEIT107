<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上市公司資料</title>
<script>
	function chk() {
		if (document.getElementById("num1").value == '') {
			alert('未輸入資料');
			return false;
		}
		return true;
	}
	function chgA() {
		var act = document.getElementById("selectID").value;
		var va = document.getElementById("num1").value;
		if (act == 1) {
			document.getElementById("fo").action = "CompanyForm.jsp";
		}
		if (act == 2) {
			document.getElementById("fo").action = "CompanyServletD.do";
		}
		if (act == 3) {
			document.getElementById("fo").action = "CompanyForm.jsp";
		}

		if (act == 4) {
			document.getElementById("fo").action = "CompanyServletS.do";
		}

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

.in {
	margin-right: 250px;
}

tr, td {
	border: 1px solid #cccccc;
	text-align: center;
}

th {
	background-color: #408080;
	color: #F5F5F5;
}

.sel {
	width: 850px;
	margin: 0 auto;
	height: 600px;
	overflow: auto;
}

select {
	margin-right: 50px;
	border: 2px solid #8e8e8e;
	width: 150px;
	height: 30px;
	appearance: none;
	-moz-appearance: none;
	-webkit-appearance: none;
	background:
		url("https://raw.githubusercontent.com/ourjs/static/gh-pages/2015/arrow.png")
		no-repeat scroll right center transparent;
	padding-right: 14px;
}

body {
	background: url(bg1.jpg);
	background-height: auto;
	background-position: left;
}
</style>
</head>
<body>
	<form id="fo" action="CompanyForm.jsp" method="POST"
		onsubmit="return chk()">
		<fieldset>
			<legend>上市公司資料</legend>

			<div class="d">
				<label>公司代號：</label> <input id='num1' style="text-align: left"
					name="comCo" value="${param.comCo}" type="text" size="16">
				<input type="button" value="查詢全部" onclick="qryAll()"> <span
					id=spd1></span><span>${ErrorMsg.exception}</span>
				<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.comCo}</div>
			</div>

			<div align="center">

				<select id="selectID" name="selectName" onchange="chgA()">
					<option value='1'>新增</option>
					<option value='2'>刪除</option>
					<option value='3'>修改</option>
					<option value='4'>查詢</option>
				</select> <input class="in" type="submit" value="送出">

			</div>
			<script>
				var xhttp = new XMLHttpRequest();
				function qryAll() {
					xhttp.onload = function() {
						document.getElementById("ser").innerHTML = this.responseText;
					}
					xhttp.open("POST", "CompanyServletAll.do", true);
					xhttp.setRequestHeader("Content-type",
							"application/x-www-form-urlencoded");
					xhttp.send();
				}
			</script>

		</fieldset>
	</form>
	<div class="sel" id="ser"></div>
</body>
</html>