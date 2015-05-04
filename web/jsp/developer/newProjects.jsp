<%--
  Created by IntelliJ IDEA.
  User: olga
  Date: 29.04.15
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!-- Header -->
<%@ include file="../common/header.jspf"%>

<a class="btn btn-primary btn-large" href="Controller?executionCommand=DEV"> Go to Home page </a>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <div class="row">

        <h2 class="sub-header">
<fmt:message key="jsp.employee.current.body.header" bundle="${msg}">
        </h2>
        <table class="table table-bordered table-striped">

            <thead>
            <tr>
                <td><b>id</b></td>
                <td><b>name</b></td>
                <td><b>spetification_id</b></td>
                <td><b>time</b></td>
                <td><b>employees</b></td>
                <td><b>manager</b></td>
                <td><b>status</b></td>
                <th>Action</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="item" items="${simpleinfo}">
                <c:if test="${item.getClass().getSimpleName() eq 'Project' }">
                    <tr>
                            ${item.id}
                        <td><c:out value="${item.id}"></c:out></td>
                        <td><c:out value="${item.name}"></c:out></td>
                        <td><c:out value="${item.spetification_id}"></c:out></td>
                        <td><c:out value="${item.time}"></c:out></td>
                        <td><c:out value="${item.employees}"></c:out></td>
                        <td><c:out value="${item.manager}"></c:out></td>
                        <td><c:out value="${item.status}"></c:out></td>
                        <td>
                            <form class="form-signin" action="Controller" method="post">
                                <input type="hidden" name="executionCommand" value="TRANSFER_NEW_PROJECT" />
                                <button class="btn btn-lg btn-success" type="submit" name="id_project" value="${item.id}">Confirm</button>
                        </form>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>

    </div>
    </div>



