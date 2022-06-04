<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> ord Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/ord" class="nav-link">ordonnance</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${ordonnance != null}">
                            <form action="updateo" method="post">
                        </c:if>
                        <c:if test="${ordonnance == null}">
                            <form action="inserto" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${Ordonnance != null}">
                                    Edit ord
                                </c:if>
                                <c:if test="${Ordonnance == null}">
                                    Add New ord
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${ordonnance != null}">
                            <input type="hidden" name="numord" value="<c:out value='${Ordonnance.numord}' />" />
                        </c:if>
 						<fieldset class="form-group">
                            <label>numord</label> <input type="text" value="<c:out value='${ordonnance.numord}' />" class="form-control" name="numord" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Nom du Patient</label> <input type="text" value="<c:out value='${ordonnance.nompatient}' />" class="form-control" name="nompatient" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Prenom du Patient</label> <input type="text" value="<c:out value='${ordonnance.prenompatient}' />" class="form-control" name="prenompatient">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Nom du medicament</label> <input type="text" value="<c:out value='${ordonnance.nommedicament}' />" class="form-control" name="nommedicament">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Dosage du medicament</label> <input type="text" value="<c:out value='${ordonnance.dosagemedicament}' />" class="form-control" name="dosagemedicament">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

