<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Patient Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/PatientServelet" class="nav-link">Patients</a></li>
                        <li><a href="<%=request.getContextPath()%>/rdvs" class="nav-link">RDV</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${patient != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${patient == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${patient != null}">
                                    Edit Patient
                                </c:if>
                                <c:if test="${patient == null}">
                                    Add New Patient
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${patient != null}">
                            <input type="hidden" name="cin" value="<c:out value='${patient.cin}' />" />
                        </c:if>
 						<fieldset class="form-group">
                            <label>CIN du Patient</label> <input type="text" value="<c:out value='${patient.cin}' />" class="form-control" name="cin" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Nom du Patient</label> <input type="text" value="<c:out value='${patient.nom}' />" class="form-control" name="nom" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Prenom du Patient</label> <input type="text" value="<c:out value='${patient.prenom}' />" class="form-control" name="prenom">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Adresse du Patient</label> <input type="text" value="<c:out value='${patient.adresse}' />" class="form-control" name="adresse">
                        </fieldset>
                         <fieldset class="form-group">
                            <label>Age du Patient</label> <input type="text" value="<c:out value='${patient.age}' />" class="form-control" name="age">
                        </fieldset>
                         <fieldset class="form-group">
                            <label>Tel du Patient</label> <input type="text" value="<c:out value='${patient.tel}' />" class="form-control" name="tel">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>