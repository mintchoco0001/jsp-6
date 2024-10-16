<%@page import="com.oreilly.servlet.multipart.*"%>
<%@page import="javax.swing.DefaultBoundedRangeModel"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="com.oreilly.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MultipartRequest multi = new MultipartRequest(request, "c://upload", 10 * 1024 * 1024, "utf-8",
			new DefaultFileRenamePolicy());

	Enumeration params = multi.getParameterNames();
	while(params.hasMoreElements()){
		String name = (String)params.nextElement();
		String value = multi.getParameter(name);
		out.print(name+ "=" + value + "<br>");
	}
	
	Enumeration files = multi.getFileNames();
	while(files.hasMoreElements()){
		String name = (String)files.nextElement();
		String filename = multi.getFilesystemName(name);
		String type = multi.getContentType(name);
		File file = multi.getFile(name);
		
		out.print("요청 파라미터 이름 " + name + "<br>");
		out.print("파일 이름 " + filename + "<br>");
		out.print("파일 유형 " + type + "<br>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>