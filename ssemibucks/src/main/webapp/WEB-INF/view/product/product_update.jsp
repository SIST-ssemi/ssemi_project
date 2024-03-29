<%@ page import="ssemi.ssemibucks.PRODUCT.ProductService" %>
<%@ page import="ssemi.ssemibucks.PRODUCT.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Template Stylesheet -->
    <link href="/css/style.css" rel="stylesheet"/>

    <script src="/js/includeHTML.js" type="text/javascript"></script>

    <title>Document</title>

    <script>
        $(function () {
            $("#previewBtn").click(function () {
                var url = $("#pImageUrl").val();
                console.log(url);

                $("#preview").attr("src", url);
            });
        });
    </script>
</head>

<body>

<!-- Navbar -->
<div include-html="/navbar"></div>
<script>includeHTML();</script>

<!-- Header-->
<header class="py-5" style="background-color: rgb(167, 193, 55); height: 100px;">
    <h1 class="display-4 fw-bolder" style="line-height: 0px; text-align: center; color: white">Update</h1>
</header>

<!-- Product section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <form action="/product/produt_updateAction" method="post">
            <!-- hidden으로 표시 -->
            <input type="hidden" name="pId" value="${product.getPId() }">

            <!-- btn -->
            <div>
                <button type="button" class="btn" onclick="history.back()" style="margin-bottom: 20px;"><i
                        class="bi bi-arrow-left-circle"></i>
                    back
                </button>
                <button type="button" class="btn" style="margin-bottom: 20px; float: right;"
                        onclick="location.href='/product/product_delete?pId=${product.getPId() }'"><i
                        class="bi bi-trash"></i>
                    delete
                </button>
                <button type="submit" class="btn" style="margin-bottom: 20px; float: right;"><i
                        class="bi bi-pencil"></i>
                    update
                </button>
            </div>

            <div class="row gx-4 gx-lg-5 align-items-center">
                <!-- pImage preview -->
                <div class="col-md-6">
                    <img class="card-img-top mb-5 mb-md-0" id="preview"
                         src="${product.getPImage() }"
                         alt="...">
                </div>

                <div class="col-md-6">

                    <!-- pId -->
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label l-fs">Product Id</label>
                        <div class="col-sm-10">
                            <div class="mb-3">
                                <input type="text" class="form-control" id="pId" name="pId"
                                       value="${product.getPId() }" disabled>
                            </div>
                        </div>
                    </div>

                    <!-- pName -->
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Name</label>
                        <div class="col-sm-10">
                            <div class="mb-3">
                                <input type="text" class="form-control" id="pName" name="pName"
                                       value="${product.getPName() }" disabled>
                            </div>
                        </div>
                    </div>

                    <!-- pOption -->
                    <fieldset class="row mb-3">
                        <legend class="col-form-label col-sm-2 pt-0">Option</legend>
                        <div class="col-sm-10">

                            <c:set var="pOption" value="${['hot', 'ice', 'none']}" />

                            <c:forEach var="option" items="${pOption}" varStatus="i">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="pOption" id="pOption${i.index + 1}"
                                           value="${option}" ${product.POption eq option ? 'checked' : ''} disabled>
                                    <label class="form-check-label" for="pOption${i.index + 1}">
                                            ${option}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                    </fieldset>

                    <!-- category -->
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Category</label>
                        <div class="col-sm-10">

                            <div class="mb-3">
                                <input type="text" class="form-control" id="category" name="category"
                                       placeholder="category" value="${product.getCategory() }" disabled>
                            </div>
                        </div>
                    </div>

                    <!-- price -->
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Price</label>
                        <div class="col-sm-10">
                            <div class="input-group mb-3">
                                <span class="input-group-text">￦</span>
                                <input type="text" class="form-control" aria-label="Price" name="price"
                                       value="${product.getPrice() }">
                            </div>
                        </div>
                    </div>

                    <!-- pStock -->
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Stock</label>
                        <div class="col-sm-10">
                            <div class="mb-3">
                                <input type="text" class="form-control" id="pStock" name="pStock"
                                       value="${product.getPStock()}">
                            </div>
                        </div>
                    </div>

                    <!-- detail -->
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Detail</label>
                        <div class="col-sm-10">
                            <div class="form-floating">
                                <textarea class="form-control" placeholder="Detail" name="pDetail"
                                          style="height: 100px;">${product.getPDetail() }</textarea>
                            </div>
                        </div>
                    </div>

                    <!-- pImage -->
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Image</label>
                        <div class="col-sm-8">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="pImageUrl" name="pImage"
                                       placeholder="pImage" value="${product.getPImage() }">
                                <label>Product Image URL</label>
                            </div>

                        </div>
                        <div class="col-sm-2" style="line-height: 50px;">
                            <button type="button" class="btn btn-primary" id="previewBtn">preview</button>
                        </div>
                    </div>

                </div>
            </div>
        </form>
    </div>
</section>

</body>

</html>