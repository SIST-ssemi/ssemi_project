import React, { useState } from "react";
import "../style.css";
import "../bootStrap.css";
import { useNavigate } from "react-router-dom";
import ArrowCircleLeftIcon from "@mui/icons-material/ArrowCircleLeft";
import AddCircleIcon from "@mui/icons-material/AddCircle";
import axios from "axios";

function Product_productInsert(props) {
  const navi = useNavigate();

  const onBack = (e) => {
    navi(-1);
  };

  const [pId, setPId] = useState("");
  const [pName, setPName] = useState("");
  const [pOption, setPOption] = useState("hot");
  const [category, setCategory] = useState("coffee");
  const [price, setPrice] = useState("");
  const [pStock, setPStock] = useState("");
  const [pDetail, setPDetail] = useState("");
  const [pImage, setPImage] = useState("");

  const onCheck = () => {
    if (pId !== "") {
      if (/^p\d{4}$/.test(pId)) {
        window.open("/product/pIdchk/" + pId, "chk", "width=500, height=300");
        setPId(pId);
      } else {
        alert("올바른 아이디 형식이 아닙니다. 아이디를 다시 입력해주세요.");
      }
    } else {
      alert("아이디를 입력해주세요.");
    }
  };

  const [previewUrl, setPreviewUrl] = useState(
    "https://cdn11.bigcommerce.com/s-4f830/stencil/21634b10-fa2b-013a-00f1-62a1dd733893/e/4a0532a0-6207-013b-8ab2-261f9b1f5b00/icons/icon-no-image.svg"
  );

  const handlePreview = () => {
    setPreviewUrl(pImage);
    setPImage(pImage);
  };

  let insertUrl = "http://localhost:8080/product/insert";

  const onInsert = () => {
    axios
      .post(insertUrl, {
        pId,
        pName,
        pOption,
        category,
        price,
        pStock,
        pDetail,
        pImage,
      })
      .then((res) => {
        alert("'" + pName + "' 추가 완료");
        navi("/admin/pmanagement");
      });
  };

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
          <form>
            <div>
              <button
                type="button"
                className="btn"
                onClick={onBack}
                style={{ marginBottom: "20px" }}
              >
                <ArrowCircleLeftIcon /> back
              </button>
              <button
                type="button"
                className="btn"
                style={{ marginBottom: "20px", float: "right" }}
                id="add"
                onClick={onInsert}
              >
                <AddCircleIcon /> add
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
                    src={previewUrl}
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
                          value={pId}
                          onChange={(e) => setPId(e.target.value)}
                          placeholder="Product Id"
                          required
                        />
                        <label>start with p and 4 digits</label>
                      </div>
                    </div>
                    <div className="col-sm-2" style={{ lineHeight: "50px" }}>
                      <button
                        type="button"
                        className="btn btn-primary"
                        onClick={onCheck}
                      >
                        Check
                      </button>
                    </div>
                  </div>

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
                          value={pName}
                          onChange={(e) => setPName(e.target.value)}
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
                          checked={pOption === "hot"}
                          onChange={(e) => setPOption(e.target.value)}
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
                          checked={pOption === "ice"}
                          onChange={(e) => setPOption(e.target.value)}
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
                          checked={pOption === "none"}
                          onChange={(e) => setPOption(e.target.value)}
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
                        value={category}
                        onChange={(e) => setCategory(e.target.value)}
                      >
                        <option value="coffee">coffee</option>
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
                          value={price}
                          onChange={(e) => setPrice(e.target.value)}
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
                          value={pStock}
                          onChange={(e) => setPStock(e.target.value)}
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
                          value={pDetail}
                          onChange={(e) => setPDetail(e.target.value)}
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
                          name="pImage"
                          placeholder="pImage"
                          value={pImage}
                          onChange={(e) => setPImage(e.target.value)}
                          required
                        />
                        <label>Product Image URL</label>
                      </div>
                    </div>
                    <div className="col-sm-2" style={{ lineHeight: "50px" }}>
                      <button
                        type="button"
                        className="btn btn-primary"
                        onClick={handlePreview}
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

export default Product_productInsert;
