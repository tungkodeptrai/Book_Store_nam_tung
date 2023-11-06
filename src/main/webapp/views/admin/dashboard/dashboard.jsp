<%-- 
    Document   : dashboard
    Created on : Nov 5, 2023, 6:23:13 PM
    Author     : TNO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin - Dashboard</title>

        <!-- Custom fonts for this template-->
        <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/colReorder-bootstrap4.css">

    </head>

    <body id="page-top">
        <jsp:include page="../../commonGui/admin/navigationBar.jsp" ></jsp:include>

            <div id="wrapper">

                <!-- Sidebar -->
            <jsp:include page="../../commonGui/admin/sideBar.jsp" ></jsp:include>

                <div id="content-wrapper">

                    <div class="container-fluid">

                        <!-- Breadcrumbs-->
                    <jsp:include page="../../commonGui/admin/breadCumb.jsp" ></jsp:include>

                        <!-- Icon Cards-->
                    <jsp:include page="../../commonGui/admin/iconCard.jsp" ></jsp:include>


                        <!-- DataTables Example -->
                    <jsp:include page="../../commonGui/admin/dataExample.jsp" ></jsp:include>

                    </div>
                    <!-- /.container-fluid -->

                    <!-- Sticky Footer -->
                <jsp:include page="../../commonGui/admin/footer.jsp" ></jsp:include>

                </div>
                <!-- /.content-wrapper -->

            </div>
            <!-- /#wrapper -->

            <!-- Scroll to Top Button-->
        <jsp:include page="../../commonGui/admin/scrollTop.jsp" ></jsp:include>

            <!-- Logout Modal-->
        <jsp:include page="../../commonGui/admin/logOutModal.jsp" ></jsp:include>
            <!-- add Modal-->
        <jsp:include page="../../commonGui/admin/addBookModal.jsp" ></jsp:include>

        <!-- delete Modal -->
        <jsp:include page="../../commonGui/admin/deleteBookModal.jsp" ></jsp:include>

            <!-- Bootstrap core JavaScript-->
            <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendor/datatables/jquery.dataTables.js"></script>
        <script src="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="${pageContext.request.contextPath}/js/sb-admin.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/colReorder-bootstrap4-min.js"></script>
        <script src="${pageContext.request.contextPath}/js/colReorder-dataTables-min.js"></script>

        <!-- Demo scripts for this page-->
        <script src="${pageContext.request.contextPath}/js/demo/datatables-demo.js"></script>
        <script src="${pageContext.request.contextPath}/js/demo/chart-area-demo.js"></script>
        <script src="${pageContext.request.contextPath}/js/colReorder-dataTables-min.js"></script>
        <script src="${pageContext.request.contextPath}/js/colReorder-bootstrap4-min.js"></script>


    </body>

</html>
