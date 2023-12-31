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
                        <th>Action</th>
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
                        <th>Action</th>
                    </tr>
                </tfoot>
                <tbody>
                    <c:forEach items="${listBook}" var="book">
                        <tr>
                            <!-- name -->
                            <td>${book.name}</td>
                            <!-- img -->
                            <td>
                                <img width="100px" height="100px" src="https://scontent.fhan14-2.fna.fbcdn.net/v/t39.30808-6/393634678_1041601000298413_346950940742341386_n.jpg?stp=c0.93.843.843a_dst-jpg_p843x403&_nc_cat=100&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEpB3VlUAkAuSc1SkPm9fWPXN6vGAMaeBRc3q8YAxp4FBQQid7n5J3VKVLJbrgMBnIbh_rR1gk8X2P_WbFQL8b4&_nc_ohc=__PWCoUojFQAX_haNP1&_nc_ht=scontent.fhan14-2.fna&oh=00_AfBpFQFgJcEpQ49wV410IlSSKY4VA2k0gXJqCbreEKRMzA&oe=654BF879" 
                                     alt="..." class="card-img-top">
                            </td>
                            <!-- Author -->                      
                            <td>${book.author}</td>
                            <!-- Price -->   
                            <td>${book.price}</td>
                            <!-- Quantity -->  
                            <td>${book.quantity}</td>
                            <!-- Description --> 
                            <td>${book.description}</td>
                            <td>
                                <!-- edit -->
                                <i class="fa fa-edit fa-2x"
                                   style="color: #469408"
                                   data-toggle="modal"
                                   data-target="#editBookModal"
                                   onclick="editBookModal(
                                                   ${book.id},
                                                   `${book.name}`,
                                                   `${book.description}`,
                                                   `${book.author}`,
                                                   ${book.price},
                                                   ${book.quantity},
                                                   `${book.image}`,
                                                   ${book.categoryId})"
                                   ">
                                </i>
                                &nbsp;&nbsp;&nbsp;
                                <!--Delete-->
                                <i class="fa fa-trash fa-2x"
                                   style="color: #e70808"
                                   data-toggle="modal"
                                   data-target="#delete-modal"
                                   onclick="deleteBookModal(${book.id})">
                                </i>


                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
</div>
