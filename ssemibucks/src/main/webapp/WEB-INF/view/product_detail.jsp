<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet" />

    <script src="/js/includeHTML.js"></script>

    <title>Document</title>


    <script>
        $(function () {

            var cQTY = parseInt($("#cQTY").val());

            $("#plus").click(function () {
                cQTY += 1;

                $("#cQTY").attr("value", cQTY)
            });

            $("#minus").click(function () {
                cQTY -= 1;

                if (cQTY < 0) {
                    alert("수량을 다시 설정해주세요");
                    cQTY = 0;
                }
                $("#cQTY").attr("value", cQTY)
            });
        });
    </script>
</head>

<body>

    <!-- Navbar -->
    <div include-html="navbar"></div>
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
                <button class="btn" onclick="location.href='/product_list';" style="margin-bottom: 20px;"><i
                        class="bi bi-arrow-left-circle"></i></span>
                    Back</button>
                <button class="btn" style="margin-bottom: 20px; float: right;" data-bs-toggle="modal"
                    data-bs-target="#staticBackdrop2"><i class="bi bi-trash"></i></span>
                    delete</button>
                <button class="btn" style="margin-bottom: 20px; float: right;" data-bs-toggle="modal"
                    data-bs-target="#staticBackdrop"><i class="bi bi-pencil"></i></span>
                    update</button>

                <!-- 수정 modal -->
                <!-- Modal -->
                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false"
                    tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">update</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                정말 수정하시겠습니까?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary"
                                    onclick="location.href='/product_update';">Update</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 삭제 modal -->
                <!-- Modal -->
                <div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static" data-bs-keyboard="false"
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
                                    onclick="location.href='/product_list';">Delete</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row gx-4 gx-lg-5 align-items-center">
                <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0"
                        src="https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[94]_20210430103337157.jpg"
                        alt="..." /></div>
                <div class="col-md-6">
                    <div class="small mb-1" id="pOption">HOT</div>
                    <h1 class="display-5 fw-bolder">카페 아메리카노</h1>
                    <div class="fs-5 mb-5">
                        <span id="price">₩4500</span>
                    </div>
                    <p class="lead" id="pDetail">진한 에스프레소와 뜨거운 물을 섞어 깔끔하고 강렬한 에스프레소를 가장 부드럽게 잘 느낄 수 있는 커피</p><br>

                    <div class="d-flex">
                        <button class="btn btn-outline-dark flex-shrink-0" type="button" style="margin-right: 5px;"
                            id="minus">-</button>

                        <input type="text" class="form-control text-center" value="0" id="cQTY" readonly="readonly"
                            style="text-align:center; width: 50px; margin-right: 5px;">


                        <button class="btn btn-outline-dark flex-shrink-0" type="button" id="plus">+</button>

                        <button class="btn btn-outline-dark flex-shrink-0" type="button" style="margin-left: 50px;">
                            <i class="bi-cart-fill me-1"></i>
                            Add to cart
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </section>

</body>

</html>