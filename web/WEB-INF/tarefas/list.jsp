<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<p>Tarefas a serem feitas</p>
<p><a href="tarefa-nova.html">Tarefa novas</a></p>

<table>
    <th>id</th>
    <th>titulo</th>
    <c:forEach var="tarefa" items="${tarefas}">
        <tr>
            <td>${tarefa.id}</td>
            <td>${tarefa.titulo}</td>
            <td>
                <form method="post" action="tarefa-exclui.html">
                 <input type="hidden" name="id" value="${tarefa.id}">
                <input type="submit" value="X"/>
            </form>
        </td>
    </tr>
</c:forEach>
</table>
<%@include file="../jspf/rodape.jspf" %>
