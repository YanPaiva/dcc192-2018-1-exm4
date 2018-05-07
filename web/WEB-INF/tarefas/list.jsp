<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<p>Tarefas a serem feitas:</p>
<ul>
    <c:forEach var="tarefa" items="${tarefas}">
        <li>${tarefa}</li>
    </c:forEach>
</ul>
<%@include file="../jspf/rodape.jspf" %>
