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

            var ccQTY = 1;

            $("#plus").click(function () {
                ccQTY += 1;

                $("#ccQTY").attr("value", ccQTY);
                $("#ccQTY2").attr("value", ccQTY);
            });

            $("#minus").click(function () {
                cQTY -= 1;

                if (ccQTY < 1) {
                    alert("수량을 다시 설정해주세요");
                    ccQTY = 1;
                }
                $("#ccQTY").attr("value", ccQTY);
                $("#ccQTY2").attr("value", ccQTY);
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
    <h1 class="display-4 fw-bolder" style="line-height: 0px; text-align: center; color: white">Detail</h1>
</header>

<!-- Product section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <!-- btn -->
        <div>
            <button class="btn" onclick="location.href='javascript:history.back();'" style="margin-bottom: 20px;"><i
                    class="bi bi-arrow-left-circle"></i>
                back
            </button>

            <c:if test="${sessionScope.uId == null}">
                <span></span>
            </c:if>

            <c:if test="${sessionScope.uId == 'admin'}">
            <button class="btn" style="margin-bottom: 20px; float: right;" data-bs-toggle="modal"
                    data-bs-target="#staticBackdrop"><i class="bi bi-trash"></i>
                delete
            </button>
            <button class="btn" style="margin-bottom: 20px; float: right;" data-bs-toggle="modal"
                    data-bs-target="#staticBackdrop2"><i class="bi bi-pencil"></i>
                update
            </button>

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
                                    onclick="location.href='/product/product_delete?pId=${product.getPId() }'">Delete
                            </button>
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
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary"
                                    onclick="location.href='/product/product_update?pId=${product.getPId() }'">Update
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            </c:if>
        </div>

        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0"
                                       src="${product.getPImage() }"
                                       alt="..."/></div>
            <div class="col-md-6">
                <div class="small mb-1">${product.getPOption().toUpperCase() }
                </div>
                <h1 class="display-5 fw-bolder">${product.getPName() }
                </h1>
                <div class="fs-5 mb-5">
                    <span>￦${product.getPrice() }</span>
                </div>
                <p class="lead">${product.getPDetail() }
                </p><br>

                <form action="/cart/cart_insertAction" method="post">
                    <input type="hidden" name="uId" value="${sessionScope.uId }">
                    <input type="hidden" name="pId" value="${product.getPId() }">

                    <div class="d-flex">
                        <button class="btn btn-outline-dark flex-shrink-0" type="button" style="margin-right: 5px;"
                                id="minus">-
                        </button>

                        <input type="text" class="form-control text-center" placeholder="1" id="ccQTY"
                               style="text-align:center; width: 50px; margin-right: 5px;" name="cQTY" readonly>

                        <button class="btn btn-outline-dark flex-shrink-0" type="button" id="plus">+</button>

                        <button type="submit" class="btn btn-outline-dark flex-shrink-0" style="margin-left: 50px;"
                                id="cartBtn">
                            <i class="bi-cart-fill me-1"></i>
                            Add to cart
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

</body>

</html>