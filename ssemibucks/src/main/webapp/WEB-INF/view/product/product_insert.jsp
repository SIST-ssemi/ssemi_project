<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="css/styles.css" rel="stylesheet" />
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

            $("#checkBtn").click(function () {
                // pId check 함수 호출
                $("#pId").css("disabled");
            });
        });
    </script>
</head>

<body>

    <!-- Navbar -->
    <div include-html="/navbar.html"></div>
    <script>includeHTML();</script>

    <!-- Header-->
    <header class="py-5" style="background-color: rgb(167, 193, 55); height: 100px;">
        <h1 class="display-4 fw-bolder" style="line-height: 0px; text-align: center; color: white">Add</h1>
    </header>

        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <!-- btn -->
                <div>
                    <button class="btn" onclick="location.href='/product/product_list';" style="margin-bottom: 20px;"><i
                            class="bi bi-arrow-left-circle"></i></span>
                        Back</button>
                    <button class="btn" style="float: right;" data-bs-toggle="modal"
                            data-bs-target="#staticBackdrop"><i class="bi bi-plus-circle"></i>
                        add</button>

                    <!-- 추가 modal -->
                    <!-- Modal -->
                    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false"
                         tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="staticBackdropLabel">add</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    Admin 계정의 비밀번호를 입력해주세요
                                    <input type="password" class="form-control" id="inputPassword">
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary"
                                            onclick="location.href='/product/product_list';">Add</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <form>
                        <div class="row gx-4 gx-lg-5 align-items-center">
                            <!-- pImage preview -->
                            <div class="col-md-6">
                                <img class="card-img-top mb-5 mb-md-0" id="preview"
                                     src="https://cdn11.bigcommerce.com/s-4f830/stencil/21634b10-fa2b-013a-00f1-62a1dd733893/e/4a0532a0-6207-013b-8ab2-261f9b1f5b00/icons/icon-no-image.svg"
                                     alt="...">
                            </div>

                            <div class="col-md-6">

                                <!-- pId -->
                                <div class="row mb-3">
                                    <label class="col-sm-2 col-form-label">Product Id</label>
                                    <div class="col-sm-10">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="pId" name="pId"
                                                   placeholder="Product Id">
                                            <label>start with p and 4 digits</label>
                                        </div>
                                    </div>
                                </div>

                                <!-- pName -->
                                <div class="row mb-3">
                                    <label class="col-sm-2 col-form-label">Name</label>
                                    <div class="col-sm-10">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="pName" name="pName"
                                                   placeholder="Product Name">
                                            <label>Product Name</label>
                                        </div>
                                    </div>
                                </div>

                                <!-- pOption -->
                                <fieldset class="row mb-3">
                                    <legend class="col-form-label col-sm-2 pt-0">Option</legend>
                                    <div class="col-sm-10">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="pOption" id="pOption" value="hot"
                                                   checked>
                                            <label class="form-check-label" for="pOption">
                                                hot
                                            </label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="pOption" id="pOption"
                                                   value="ice">
                                            <label class="form-check-label" for="pOption">
                                                ice
                                            </label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="pOption" id="pOption"
                                                   value="none">
                                            <label class="form-check-label" for="pOption">
                                                none
                                            </label>
                                        </div>
                                    </div>
                                </fieldset>

                                <!-- category -->
                                <div class="row mb-3">
                                    <label class="col-sm-2 col-form-label">Category</label>
                                    <div class="col-sm-10">
                                        <select class="form-select" aria-label="Category" name="category">
                                            <option value="coffee" selected>coffee</option>
                                            <option value="non-coffee">non-coffee</option>
                                            <option value="desserts">desserts</option>
                                        </select>
                                    </div>
                                </div>

                                <!-- price -->
                                <div class="row mb-3">
                                    <label class="col-sm-2 col-form-label">Price</label>
                                    <div class="col-sm-10">
                                        <div class="input-group mb-3">
                                            <span class="input-group-text">￦</span>
                                            <input type="text" class="form-control" aria-label="Price" name="price"
                                                   placeholder="0">
                                        </div>
                                    </div>
                                    
                                    <!-- detail -->
                                    <div class="row mb-3">
                                        <label class="col-sm-2 col-form-label">Detail</label>
                                        <div class="col-sm-10">
                                            <div class="form-floating">
                                                <textarea class="form-control" placeholder="Detail" name="datail"
                                                    style="height: 100px;"></textarea>
                                                <label>product detail</label>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- pImage -->
                                    <div class="row mb-3">
                                        <label class="col-sm-2 col-form-label">Image</label>
                                        <div class="col-sm-8">
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="pImageUrl" name="pImage"
                                                    placeholder="pImage">
                                                <label>Product Image URL</label>
                                            </div>

                                        </div>
                                        <div class="col-sm-2" style="line-height: 50px;">
                                            <button type="button" class="btn btn-primary" id="previewBtn">preview</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
</body>

</html>