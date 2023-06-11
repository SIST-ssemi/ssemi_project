import React, { useEffect, useState } from "react";
import "../style.css";
import "../bootStrap.css";
import { useNavigate, useParams } from "react-router-dom";
import ArrowCircleLeftIcon from "@mui/icons-material/ArrowCircleLeft";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";
import axios from "axios";

function Product_productUpdate(props) {
  const navi = useNavigate();

  const onBack = (e) => {
    navi(-1);
  };

  const handlePreview = () => {
    setPImage(pImage);
  };

  let productDataUrl = "http://localhost:8080/product/detail";
  let updateUrl = "http://localhost:8080/product/update";
  let deleteUrl = "http://localhost:8080/product/delete";

  const { pId } = useParams();
  const [pName, setPName] = useState("");
  const [pOption, setPOption] = useState("");
  const [category, setCategory] = useState("");
  const [price, setPrice] = useState("");
  const [pStock, setPStock] = useState("");
  const [pDetail, setPDetail] = useState("");
  const [pImage, setPImage] = useState(
    "https://cdn11.bigcommerce.com/s-4f830/stencil/21634b10-fa2b-013a-00f1-62a1dd733893/e/4a0532a0-6207-013b-8ab2-261f9b1f5b00/icons/icon-no-image.svg"
  );

  useEffect(() => {
    axios({
      method: "get",
      url: productDataUrl + "?pId=" + pId,
    })
      .then((res) => {
        setPName(res.data.pName);
        setPOption(res.data.pOption);
        setCategory(res.data.category);
        setPrice(res.data.price);
        setPStock(res.data.pStock);
        setPDetail(res.data.pDetail);
        setPImage(res.data.pImage);
      })
      .catch((err) => {
        alert(err);
      });
  }, []);

  const goUpdate = () => {
    if (window.confirm("상품을 수정하시겠습니까?")) {
      axios
        .post(updateUrl, { pId, price, pStock, pDetail, pImage })
        .then((res) => {
          alert("'" + pId + "' 수정 완료");
          navi("/admin/pmanagement");
        })
        .catch((err) => {
          alert(err);
        });
    }
  };

  const goDelete = () => {
    if (window.confirm("ds" + pId + "상품을 삭제하시겠습니까?")) {
      axios
        .post(deleteUrl + "?pId" + pId, { pId })
        .then((res) => {
          alert("'" + pId + "' 삭제 완료");
          navi("/admin/pmanagement");
        })
        .catch((err) => {
          alert(err);
        });
    }
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
          Update
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
                onClick={goDelete}
              >
                <DeleteIcon />
                delete
              </button>
              <button
                type="button"
                className="btn"
                style={{ marginBottom: "20px", float: "right" }}
                onClick={goUpdate}
              >
                <EditIcon />
                update
              </button>
            </div>

            <div className="row gx-4 gx-lg-5 align-items-center">
              <div className="col-md-4">
                <img
                  className="card-img-top mb-5 mb-md-0"
                  id="preview"
                  src={pImage}
                  alt="..."
                />
              </div>

              <div className="col-md-8">
                <div className="row mb-3">
                  <label className="col-sm-2 col-form-label l-fs">
                    Product Id
                  </label>
                  <div className="col-sm-10">
                    <div className="form-floating mb-3">
                      <input
                        type="text"
                        className="form-control"
                        id="pId"
                        name="pId"
                        value={pId}
                        placeholder="Product Id"
                        disabled
                      />
                      <label>start with p and 4 digits</label>
                    </div>
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
                        disabled
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
                        disabled
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
                        disabled
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
                        disabled
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
                      disabled
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
          </form>
        </div>
      </section>
    </div>
  );
}

export default Product_productUpdate;
