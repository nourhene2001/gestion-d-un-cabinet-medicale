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
                       <b>RDV Management App</b> 
  
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
                    <h3 class="text-center">List of RDV</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/newr" class="btn btn-success">Add New RDV</a>
                    
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                
                                <th>DateRDV</th>
                                <th>CINPatient</th>
                                <th>HeureRDV</th>
                                
                                <th>Actions</th>
                            </tr>
                        </thead>
                       
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="rdv" items="${listRDV}">

                                <tr>
                                  <td>
                                        <c:out value="${rdv.ID}" />
                                    </td>
                                    <td>
                                        <c:out value="${rdv.CINPatient}" />
                                    </td>
                                    <td>
                                        <c:out value="${rdv.dateRDV}" />
                                    </td>
                                    <td>
                                        <c:out value="${rdv.heureRDV}" />
                                    </td>
                                    
                                   <td><a href="editr?id=<c:out value='${rdv.ID}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="deleter?id=<c:out value='${rdv.ID}' />">Delete</a></td>
                           </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

