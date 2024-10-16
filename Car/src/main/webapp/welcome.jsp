<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "car.carDAO" %>
<%@ page import = "car.carDTO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SM랜트카</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"/>
    <style>
        nav {
            margin-bottom: 20px; /* 내비게이션 바 하단 여백 */
            background-color: #f8f9fa; /* 밝은 배경색 */
        }
        .navbar-brand {
            margin-right: 20px; /* 브랜드 및 링크 간 여백 */
            color: #0056b3; /* SM랜트카 색상 변경 */
            font-size: 1.5rem; /* 글자 크기 키우기 */
            transition: color 0.3s; /* 마우스 오버 시 색상 전환 효과 */
        }
        .navbar-brand:hover {
            color: #003d7a; /* 마우스 오버 시 색상 변경 */
        }
        .nav-item {
            margin-right: 15px; /* 내비게이션 항목 간의 간격 */
        }
        .nav-item:last-child {
            margin-right: 0; /* 마지막 항목의 여백 제거 */
        }
        .navbar {
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 내비게이션 바 그림자 효과 */
        }
        .container {
            max-width: 1200px; /* 최대 너비 설정 */
        }
    </style>
</head>


<body onload="clock()">
	<jsp:include page="header.jsp"/>
	
	<div class="container">
		<!-- 검색 폼 -->
		<form method="get" action="">
			<div class="form-group">
				<label for="search">차량검색:</label>
				<input type="text" id="search" name="search" class="form-control" placeholder="차량명 또는 제조회사 입력">
			</div>
			<button type="submit" class="btn btn-primary">검색</button>
		</form>
		<hr>

		<!-- 자동차 정보를 표시할 곳 -->
		<%
			carDAO dao = new carDAO();
			String searchQuery = request.getParameter("search"); // 검색어 가져오기
			List<carDTO> carList = dao.getAllCars(); // 자동차 정보 가져오기

			if (searchQuery != null && !searchQuery.trim().isEmpty()) {
				carList = dao.searchCars(searchQuery); // 검색 기능 호출
			}

			if (carList != null && !carList.isEmpty()) {
		%>
			<div class="row">
				<%
					for (carDTO car : carList) {
				%>
					<div class="col-md-4">
						<div class="card">
							<img src="img/<%= car.getCarURL() %>" class="card-img-top" alt="<%= car.get자동차이름() %>">
							<div class="card-body">
								<h5 class="card-title">차량명: <%= car.get자동차이름() %></h5>
								<p class="card-text">제조회사: <%= car.get제조회사() %></p>
								<p class="card-text">색상: <%= car.get색상() %></p>
								<p class="card-text">가격: <%= car.get가격() %></p>
								<p class="card-text">출고날짜: <%= car.get출고날짜() %></p>
								<p class="card-text">상세사양: <%= car.get상세사양() %></p>
							</div>
						</div>
					</div>
				<%
					}
				%>
			</div>
		<%
			} else {
		%>
			<p>등록된 자동차 정보가 없습니다.</p>
		<%
			}
		%>
	</div>

	<div class="container">
		<div class="text-center">
			<h3 id="clock"></h3>
		</div>
		<hr>
	</div> 
</body>
</html>
