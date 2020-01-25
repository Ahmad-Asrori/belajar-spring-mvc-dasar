<%--
  Created by IntelliJ IDEA.
  User: asrori
  Date: 26/12/19
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <title>Produk</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Produk</h1>
                <p>Semua Produk Yang Tersedia Di Toko</p>
            </div>
        </div>
    </section>

    <section class="container">
        <div class="row">
            <c:forEach items="${produks}" var="produk">
                <div class="col col-sm-6 col col-md-3" style="padding-bottom: 15px">
                    <div class="thumbnail">
                        <img src="<c:url value="/img/${produk.produkId}.png"/>" alt="image" width="100%">
                        <div class="caption">
                            <h3>${produk.namaProduk}</h3>
                            <p>${produk.deskripsi}</p>
                            <p>${produk.hargaUnit} USD</p>
                            <p>Tersedia ${produk.stokUnit} unit</p>
                            <p>
                                <a href=" <spring:url value="produk?id=${produk.produkId}"/>" class="btn btn-primary">
                                    <span class="glyphicon-hand-left glyphicon"/></span> Details
                                </a>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
