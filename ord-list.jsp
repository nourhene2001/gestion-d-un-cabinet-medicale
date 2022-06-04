<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@page import="model.Ordonnance" %>
<%@page import="java.lang.reflect.Field" %>
        <html>

        <head>
            <title>Ordonnance Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                       <b>Ordonnance Management App</b> 
  
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/ord" class="nav-link">Ordonnance</a></li>
                        <li><a href="<%=request.getContextPath()%>/rdvs" class="nav-link">RDV</a></li>
                        <li><a href="<%=request.getContextPath()%>/PatientServelet" class="nav-link">Patient</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Ordonnance</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/newo" class="btn btn-success">Add New Ordonnance</a>
     				
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>numord</th>
                                <th>nompatient</th>
                                <th>prenompatient</th>
                                <th>nommedicament</th>
                                <th>dosagemedicament</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="ordonnance" items="${listord}">
	 
									
                                <tr>
                                  <td>
                                        <c:out value="${ordonnance.numord}" />
                                    </td>
                                    <td>
                                        <c:out value="${ordonnance.nompatient}" />
                                    </td>
                                    <td>
                                        <c:out value="${ordonnance.prenompatient}" />
                                    </td>
                                    <td>
                                        <c:out value="${ordonnance.nommedicament}" />
                                    </td>
                                    <td>
                                        <c:out value="${ordonnance.dosagemedicament}" />
                                    </td>
                                   <td><a href="edito?numord=<c:out value='${ordonnance.numord}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteo?numord=<c:out value='${ordonnance.numord}' />">Delete</a></td>
                           </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>