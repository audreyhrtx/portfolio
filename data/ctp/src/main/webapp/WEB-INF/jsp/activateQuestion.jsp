<%@page import="ctp.Question"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Activer une question</title>
</head>
<body>
<h1>Activer une question</h1>

<% Iterable<Question> questions = (ArrayList<Question>)request.getAttribute("questions");%>

<form method="POST" action="/activer">
    <% for(Question question: questions){ %>
        <div>
            <input type="radio" id="question<%= question.getQno() %>" name="questionId" value="<%= question.getQno() %>">
            <label for="question<%= question.getQno() %>"><%= question.getLibquest() %></label>
        </div>
    <% } %>
    <input type="submit" value="Activer">
</form>

<% String message = (String)request.getAttribute("message"); %>
<% if(message != null && !message.isEmpty()){ %>
    <div>
        <p><%= message %></p>
    </div>
<% } %>

</body>
</html>