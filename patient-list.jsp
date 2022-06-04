<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
        <html>

        <head>
            <title>Patient Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                       <b>Patient Management App</b> 
  
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/PatientServelet" class="nav-link">Patients</a></li>
                        <li><a href="<%=request.getContextPath()%>/rdvs" class="nav-link">RDV</a></li>
                        <li><a href="<%=request.getContextPath()%>/ord" class="nav-link">ordonnance</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Patients</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Patient</a>
                    
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>CIN</th>
                                <th>Nom</th>
                                <th>Prenom</th>
                                <th>Adresse</th>
                                 <th>Age</th>
                                  <th>Tel</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="patient" items="${listPatient}">

                                <tr>
                                  <td>
                                        <c:out value="${patient.cin}" />
                                    </td>
                                    <td>
                                        <c:out value="${patient.nom}" />
                                    </td>
                                    <td>
                                        <c:out value="${patient.prenom}" />
                                    </td>
                                    <td>
                                        <c:out value="${patient.adresse}" />
                                    </td>
                                    <td>
                                        <c:out value="${patient.age}" />
                                    </td>
                                    <td>
                                        <c:out value="${patient.tel}" />
                                   </td>
                                   <td><a href="edit?cin=<c:out value='${patient.cin}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?cin=<c:out value='${patient.cin}' />">Delete</a></td>
                           </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>