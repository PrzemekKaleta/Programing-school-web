<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Witaj w szkole programowania</title>
</head>
<body>
<jsp:include page="header.jsp" />

<h1>Ostatnie rozwiązania: </h1>
<c:forEach var="solution" items="${recentSolutions}">
    <p>${solution.authorId}, ${solution.body}</p>
</c:forEach>

<jsp:include page="footer.jsp" />
</body>
</html>
