<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link href="css/header.css" rel="stylesheet" />
</head>
<body>

<div class="d-flex" id="wrapper">
            <div class="bg-light"  id="sidebar-wrapper">
             <div class="sidebar-heading border-bottom bg-secondary">Start Bootstrap</div>
                <div class="list-group list-group-flush bg-secondary">
                    <a class="list-group-item list-group-item-secondary list-group-item-dark p-3" href="${pageContext.request.contextPath}/cabinet.jsp">Home</a>
                    <a class="list-group-item list-group-item-secondary list-group-item-dark p-3" href="${pageContext.request.contextPath}/createArticle.jsp">Add periodical</a>
                    <a class="list-group-item list-group-item-secondary list-group-item-dark p-3" href="${pageContext.request.contextPath}/bucket.jsp">Bucket</a>
                </div>
            </div>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-dark border-bottom">
                    <div class="container-fluid">
                        <button class="btn btn-outline-danger" id="sidebarToggle">Toggle Menu</button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                               <button class = "btn btn-danger" id = "logout">Log Out</button>
                            </ul>
                        </div>
                    </div>
                </nav>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/header.js"></script>
</body>
</html>