<%@ page import="ssemi.ssemibucks.PRODUCT.Product" %>
<%@ page import="ssemi.ssemibucks.PRODUCT.ProductDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Template Stylesheet -->
    <link href="/css/style.css" rel="stylesheet" />

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
<%
    String pId = request.getParameter("pId");

    ProductDao dao = new ProductDao();
    Product product = dao.selectProduct(pId);
%>

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
        <form action="/product/product_update?pId=<%=product.getpId()%>" method="post">
            <!-- btn -->
            <div>
                <button class="btn" onclick="location.href='/admin/admin_pManagement'" style="margin-bottom: 20px;"><i
                        class="bi bi-arrow-left-circle"></i> back</button>
                <button class="btn" style="margin-bottom: 20px; float: right;" data-bs-toggle="modal"
                        data-bs-target="#staticBackdrop"><i class="bi bi-trash"></i>
                    delete</button>
                <button class="btn" style="margin-bottom: 20px; float: right;" data-bs-toggle="modal"
                        data-bs-target="#staticBackdrop2"><i class="bi bi-pencil"></i>
                    update</button>

                <!-- 삭제 modal -->
                <!-- Modal -->
                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false"
                     tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">delete</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                정말 삭제하시겠습니까?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary"
                                        onclick="location.href='/product/product_delete';">Delete</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                <!-- 수정 modal -->
                <!-- Modal -->
                <div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static" data-bs-keyboard="false"
                     tabindex="-1" aria-labelledby="staticBackdropLabel2" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel2">update</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                정말 수정하시겠습니까?
<%--                                    <form action="" method="post">--%>
<%--                                        Admin 계정의 비밀번호를 입력해주세요--%>
<%--                                        <input type="password" class="form-control" id="inputPw" name="inputPw">--%>
<%--                                    </form>--%>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Update</button>
<%--                                 onclick="location.href='/product/product_update?pId=<%=product.getpId()%>';"--%>
                            </div>
                        </div>
                    </div>
                </div>



            <div class="row gx-4 gx-lg-5 align-items-center">
                <!-- pImage preview -->
                <div class="col-md-6">
                    <img class="card-img-top mb-5 mb-md-0" id="preview"
                         src="<%=product.getpImage() %>"
                         alt="...">
                </div>

                <div class="col-md-6">

                    <!-- pName -->
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Name</label>
                        <div class="col-sm-10">
                            <div class="mb-3">
                                <input type="text" class="form-control" id="pName" name="pName" value="<%=product.getpName() %>" disabled>
                            </div>
                        </div>
                    </div>

                    <!-- pOption -->
                    <fieldset class="row mb-3">
                        <legend class="col-form-label col-sm-2 pt-0">Option</legend>
                        <div class="col-sm-10">

                            <%
                                String [] pOption = {"hot", "ice", "none"};

                                for(int i = 0; i < pOption.length; i++) {
                                    if(product.getpOption().equals(pOption[i])) {
                            %>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="pOption" id="pOption" value="<%=pOption[i] %>"
                                            checked>
                                        <label class="form-check-label" for="pOption">
                                            <%=pOption[i] %>
                                        </label>
                                    </div>
                            <%
                                    } else {
                            %>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="pOption" id="pOption" value="<%=pOption[i] %>" disabled>
                                            <label class="form-check-label" for="pOption">
                                                <%=pOption[i] %>
                                            </label>
                                        </div>
                            <%
                                    }
                                }
                            %>
                        </div>
                    </fieldset>

                    <!-- category -->
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Category</label>
                        <div class="col-sm-10">

                            <div class="mb-3">
                                <input type="text" class="form-control" id="category" name="category" placeholder="category" value="<%=product.getCategory() %>" disabled>
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
                                       value="<%=product.getPrice() %>">
                            </div>
                        </div>
                    </div>

                    <!-- pStock -->
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Stock</label>
                        <div class="col-sm-10">
                            <div class="mb-3">
                                <input type="text" class="form-control" id="pStock" name="pStock" value="<%=product.getpStock() + 100%>">
                            </div>
                        </div>
                    </div>

                    <!-- detail -->
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Detail</label>
                        <div class="col-sm-10">
                            <div class="form-floating">
                                <textarea class="form-control" placeholder="Detail" name="pDetail" style="height: 100px;"><%=product.getpDetail() %></textarea>
                            </div>
                        </div>
                    </div>

                    <!-- pImage -->
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Image</label>
                        <div class="col-sm-8">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="pImageUrl" name="pImage"
                                       placeholder="pImage" value="<%=product.getpImage() %>">
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