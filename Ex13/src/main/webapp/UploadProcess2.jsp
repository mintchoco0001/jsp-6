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

	String name1= multi.getParameter("name1");
	String subject1 = multi.getParameter("subject1");
	String name2= multi.getParameter("name2");
	String subject2 = multi.getParameter("subject2");
	String name3= multi.getParameter("name3");
	String subject3 = multi.getParameter("subject3");

	Enumeration files = multi.getFileNames();
	
	String file3 = (String)files.nextElement();
	String filename3 = multi.getFilesystemName(file3);
	String file2 = (String)files.nextElement();
	String filename2 = multi.getFilesystemName(file2);
	String file1 = (String)files.nextElement();
	String filename1 = multi.getFilesystemName(file1);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th with="100">이름</th>
			<th with="100">제목</th>
			<th with="100">파일</th>
		</tr>
		<%
			out.print("<tr><td>"+name1+"</td>");		
			out.print("<td>"+subject1+"</td>");		
			out.print("<td>"+filename1+"</td></tr>");	
			
			out.print("<tr><td>"+name2+"</td>");		
			out.print("<td>"+subject2+"</td>");		
			out.print("<td>"+filename2+"</td></tr>");	
			
			out.print("<tr><td>"+name3+"</td>");		
			out.print("<td>"+subject3+"</td>");		
			out.print("<td>"+filename3+"</td></tr>");		
		%>
	</table>
</body>
</html>