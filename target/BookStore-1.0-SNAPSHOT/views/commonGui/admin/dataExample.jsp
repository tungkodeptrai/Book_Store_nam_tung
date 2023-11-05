<%-- 
    Document   : dataExample
    Created on : Nov 5, 2023, 6:52:08 PM
    Author     : TNO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card mb-3">
    <div class="card-header">
        <i class="fas fa-table"></i>
        Data Table Example
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Author</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Author</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Description</th>
                    </tr>
                </tfoot>
                <tbody>
                    <c:forEach items="${listBook}" var="li">
                        <tr>
                            <!-- name -->
                            <td>${li.name}</td>
                            <!-- img -->
                            <td>
                                <img width="100px" height="100px" src="https://scontent.fhan14-2.fna.fbcdn.net/v/t39.30808-6/393634678_1041601000298413_346950940742341386_n.jpg?stp=c0.93.843.843a_dst-jpg_p843x403&_nc_cat=100&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEpB3VlUAkAuSc1SkPm9fWPXN6vGAMaeBRc3q8YAxp4FBQQid7n5J3VKVLJbrgMBnIbh_rR1gk8X2P_WbFQL8b4&_nc_ohc=__PWCoUojFQAX_haNP1&_nc_ht=scontent.fhan14-2.fna&oh=00_AfBpFQFgJcEpQ49wV410IlSSKY4VA2k0gXJqCbreEKRMzA&oe=654BF879" 
                                     alt="..." class="card-img-top">
                            </td>
                            <!-- Author -->                      
                            <td>${li.author}</td>
                            <!-- Price -->   
                            <td>${li.price}</td>
                            <!-- Quantity -->  
                            <td>${li.quantity}</td>
                            <!-- Description --> 
                            <td>${li.description}</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
</div>
