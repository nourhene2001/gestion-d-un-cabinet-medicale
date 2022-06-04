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
                        <a href="https://www.javaguides.net" class="navbar-brand"> RDV Management App </a>
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
                        <c:if test="${rdv != null}">
                            <form action="updater" method="post">
                        </c:if>
                        <c:if test="${rdv == null}">
                            <form action="insertr" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${rdv != null}">
                                    Edit RDV
                                </c:if>
                                <c:if test="${rdv == null}">
                                    Add New RDV
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${rdv != null}">
                            <input type="hidden" name="ID" value="<c:out value='${rdv.ID}' />" />
                        </c:if>
 						<fieldset class="form-group">
                            <label>Id du Patient</label> <input type="text" value="<c:out value='${rdv.ID}' />" class="form-control" name="ID" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>CIN de patient</label> <input type="text" value="<c:out value='${rdv.CINPatient}' />" class="form-control" name="CINPatient">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Date de rdv</label> <input type="text" value="<c:out value='${rdv.DateRDV}' />" class="form-control" name="DateRDV" >
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Heure de rdv</label> <input type="text" value="<c:out value='${rdv.HeureRDV}' />" class="form-control" name="HeureRDV">
                        </fieldset>

                        
                         

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>