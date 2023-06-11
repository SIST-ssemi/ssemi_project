import React from "react";
import "../style.css";
import "../bootStrap.css";

function Product_productUpdate(props) {
  return (
    <div>
      <header
        className="py-5"
        style={{ backgroundColor: "rgb(167, 193, 55)", height: "100px" }}
      >
        <h1
          className="display-4 fw-bolder"
          style={{ lineHeight: "0px", textAlign: "center", color: "white" }}
        >
          Add
        </h1>
      </header>

      <section className="py-5">
        <div className="container px-4 px-lg-5 my-5">
          <form action="/product/product_insertAction" method="post">
            <div>
              <button
                className="btn"
                onclick="location.href='/admin/admin_pManagement'"
                style={{ marginBottom: "20px" }}
              >
                <i className="bi bi-arrow-left-circle"></i>
                back
              </button>
              <button
                type="submit"
                className="btn"
                style={{ marginBottom: "20px", float: "right" }}
                id="add"
              >
                <i className="bi bi-plus-circle"></i>
                add
              </button>
              {/* <script>
                    $("#add").click(function () {
                        if ($("input[name='checked_id']").val() != "check") {
                            alert('상품 아이디 중복확인을 해주세요.');
                        }
                    })
                </script> */}

              <div className="row gx-4 gx-lg-5 align-items-center">
                <div className="col-md-4">
                  <img
                    className="card-img-top mb-5 mb-md-0"
                    id="preview"
                    src="https://cdn11.bigcommerce.com/s-4f830/stencil/21634b10-fa2b-013a-00f1-62a1dd733893/e/4a0532a0-6207-013b-8ab2-261f9b1f5b00/icons/icon-no-image.svg"
                    alt="..."
                  />
                </div>

                <div className="col-md-8">
                  <div className="row mb-3">
                    <label className="col-sm-2 col-form-label l-fs">
                      Product Id
                    </label>
                    <div className="col-sm-8">
                      <div className="form-floating mb-3">
                        <input
                          type="text"
                          className="form-control"
                          id="pId"
                          name="pId"
                          placeholder="Product Id"
                          pattern="^p[0-9]{4}"
                          required
                        />
                        <label>start with p and 4 digits</label>
                      </div>
                    </div>
                    <div className="col-sm-2" style={{ lineHeight: "50px" }}>
                      <button
                        type="button"
                        className="btn btn-primary"
                        id="chkbtn"
                      >
                        Check
                      </button>
                    </div>
                  </div>

                  <input type="hidden" name="checked_id" value="" />
                  {/* <script>
                            $("#chkbtn").click(function () {
                                if ($('#pId').val() != '') {
                                    window.open("product_chkId", "chk", "width=500, height=200");
                                    $("input[name=checked_id]").val("check");
                                } else
                                    alert("아이디를 입력해주세요.")
                            })
                        </script> */}

                  <div className="row mb-3">
                    <label className="col-sm-2 col-form-label">Name</label>
                    <div className="col-sm-10">
                      <div className="form-floating mb-3">
                        <input
                          type="text"
                          className="form-control"
                          id="pName"
                          name="pName"
                          placeholder="Product Name"
                          required
                        />
                        <label>Product Name</label>
                      </div>
                    </div>
                  </div>

                  <fieldset className="row mb-3">
                    <label className="col-sm-2 col-form-label">Option</label>
                    <div className="col-sm-10">
                      <div className="form-check form-check-inline">
                        <input
                          className="form-check-input"
                          type="radio"
                          name="pOption"
                          id="pOption1"
                          value="hot"
                          checked
                        />
                        <label className="form-check-label" for="pOption1">
                          hot
                        </label>
                      </div>
                      <div className="form-check form-check-inline">
                        <input
                          className="form-check-input"
                          type="radio"
                          name="pOption"
                          id="pOption2"
                          value="ice"
                        />
                        <label className="form-check-label" for="pOption2">
                          ice
                        </label>
                      </div>
                      <div className="form-check form-check-inline">
                        <input
                          className="form-check-input"
                          type="radio"
                          name="pOption"
                          id="pOption3"
                          value="none"
                        />
                        <label className="form-check-label" for="pOption3">
                          none
                        </label>
                      </div>
                    </div>
                  </fieldset>

                  <div className="row mb-3">
                    <label className="col-sm-2 col-form-label">Category</label>
                    <div className="col-sm-10">
                      <select
                        className="form-select"
                        aria-label="Category"
                        name="category"
                      >
                        <option value="coffee" selected>
                          coffee
                        </option>
                        <option value="non-coffee">non-coffee</option>
                        <option value="dessert">dessert</option>
                      </select>
                    </div>
                  </div>

                  <div className="row mb-3">
                    <label className="col-sm-2 col-form-label">Price</label>
                    <div className="col-sm-10">
                      <div className="input-group mb-3">
                        <span className="input-group-text">￦</span>
                        <input
                          type="number"
                          className="form-control"
                          aria-label="Price"
                          name="price"
                          placeholder="0"
                          required
                        />
                      </div>
                    </div>
                  </div>

                  <div className="row mb-3">
                    <label className="col-sm-2 col-form-label">Stock</label>
                    <div className="col-sm-10">
                      <div className="mb-3">
                        <input
                          type="text"
                          className="form-control"
                          id="pStock"
                          name="pStock"
                          placeholder="100"
                          required
                        />
                      </div>
                    </div>
                  </div>

                  <div className="row mb-3">
                    <label className="col-sm-2 col-form-label">Detail</label>
                    <div className="col-sm-10">
                      <div className="form-floating">
                        <textarea
                          className="form-control"
                          placeholder="pDetail"
                          name="pDetail"
                          style={{ height: "100px" }}
                          required
                        ></textarea>
                        <label>product detail</label>
                      </div>
                    </div>
                  </div>

                  <div className="row mb-3">
                    <label className="col-sm-2 col-form-label">Image</label>
                    <div className="col-sm-8">
                      <div className="form-floating mb-3">
                        <input
                          type="text"
                          className="form-control"
                          id="pImageUrl"
                          name="pImage"
                          placeholder="pImage"
                          required
                        />
                        <label>Product Image URL</label>
                      </div>
                    </div>
                    <div className="col-sm-2" style={{ lineHeight: "50px" }}>
                      <button
                        type="button"
                        className="btn btn-primary"
                        id="previewBtn"
                      >
                        preview
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </form>
        </div>
      </section>
    </div>
  );
}

export default Product_productUpdate;
