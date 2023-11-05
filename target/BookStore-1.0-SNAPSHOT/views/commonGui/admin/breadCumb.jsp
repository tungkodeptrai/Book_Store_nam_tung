<%-- 
    Document   : breadCumb
    Created on : Nov 5, 2023, 6:49:41 PM
    Author     : TNO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="#">Dashboard</a>
    </li>
    <li class="breadcrumb-item active">Overview</li>
    <li class="breadcrumb-item ml-auto">
        <button class="btn btn-success" type="button" data-toggle="modal" data-target="#addBookModal">
            <i class="fas fa-plus"></i> Add book
        </button>
    </li>
</ol>