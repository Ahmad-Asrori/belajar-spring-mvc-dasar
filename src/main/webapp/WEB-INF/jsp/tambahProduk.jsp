<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Products</h1>
            <p>Add products</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form method="POST" modelAttribute="produkBaru" class="form-horizontal">
        <fieldset>
            <legend>Tambah Produk Baru</legend>
            <div class="form-group">
                <label class="control-label col col-lg-2" for="produkId"><spring:message code="tambahProduk.form.produkId.label"/></label>
                <div class="col col-lg-10">
                    <form:input id="produkId" path="produkId" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col col-lg-2" for="namaProduk">Nama Produk</label>
                <div class="col col-lg-10">
                    <form:input id="namaProduk" path="namaProduk" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col col-lg-2" for="hargaProduk">Harga Produk</label>
                <div class="col col-lg-10">
                    <form:input id="hargaProduk" path="hargaUnit" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col col-lg-2" for="manufaktur">Manufaktur</label>
                <div class="col col-lg-10">
                    <form:input id="manufaktur" path="manufaktur" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col col-lg-2" for="kategori">Kategori</label>
                <div class="col col-lg-10">
                    <form:input id="kategori" path="kategori" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col col-lg-2" for="stokUnit">Stok Unit</label>
                <div class="col col-lg-10">
                    <form:input id="stokUnit" path="stokUnit" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col col-lg-2" for="orderUnit">Order Unit</label>
                <div class="col col-lg-10">
                    <form:input id="orderUnit" path="orderUnit" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col col-lg-2" for="deskripsi">Deskripsi</label>
                <div class="col col-lg-10">
                    <form:textarea id="deskripsi" path="deskripsi" rows="2"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col col-lg-2" for="diskontinue">Discontinued</label>
                <div class="col col-lg-10">
                    <form:checkbox id="diskontinue" path="discontinue"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col col-lg-2">Kondisi</label>
                <div class="col col-lg-10">
                    <form:radiobutton path="kondisi" value="Baru"/>Baru
                    <form:radiobutton path="kondisi" value="Lama"/>Lama
                    <form:radiobutton path="kondisi" value="Rekondisi"/>Rekondisi
                </div>
            </div>

            <div class="form-group">
                <div class="col col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Tambah Produk"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
