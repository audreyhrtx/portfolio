<%@page import="ctp.Question"%>
<%@page import="ctp.Choix"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Voter</title>
</head>
<body>
<h1><%= ((Question)request.getAttribute("question")).getLibquest() %></h1>
<%-- This will print the Question object --%>
<p><%= ((Question)request.getAttribute("question"))%></p>

<form method="POST" action="/voter">
    <% Set<Choix> choix = (Set<Choix>) request.getAttribute("choices"); %>
    <% int i = 0; %>
    <% for(Choix choixItem: choix){ %>
        <div>
            <input type="radio" id="choix<%= choixItem.getCno() %>" name="choixId" value="<%= choixItem.getCno() %>" <%= (i++ == 0) ? "checked" : "" %>>
            <label for="choix<%= choixItem.getCno() %>"><%= choixItem.getLibchoix() %></label>
        </div>
    <% } %>
    <input type="submit" value="Voter">
</form>

<% if (choix.isEmpty()) { %>
    <p>No choices found for the active question.</p>
<% } %>

</body>
</html>