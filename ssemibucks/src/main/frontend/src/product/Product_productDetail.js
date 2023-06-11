import React, { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import ArrowCircleLeftIcon from "@mui/icons-material/ArrowCircleLeft";
import DeleteIcon from "@mui/icons-material/Delete";
import EditIcon from "@mui/icons-material/Edit";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import axios from "axios";

function Product_productDetail(props) {
  const loginId = sessionStorage.getItem("loginId");

  const navi = useNavigate();

  const onBack = () => {
    navi(-1);
  };

  let productDataUrl = "http://localhost:8080/product/detail";

  const { pId } = useParams();
  const [pName, setPName] = useState("");
  const [pOption, setPOption] = useState("");
  const [category, setCategory] = useState("");
  const [price, setPrice] = useState("");
  const [pStock, setPStock] = useState("");
  const [pDetail, setPDetail] = useState("");
  const [pImage, setPImage] = useState("");
  const [cQTY, setCQTY] = useState(1);

  const Plus = () => {
    setCQTY((prevQTY) => prevQTY + 1);
  };

  const Minus = () => {
    if (cQTY > 1) {
      setCQTY((prevQTY) => prevQTY - 1);
    } else {
      alert("수량을 다시 설정해주세요");
    }
  };

  const goUpdatePage = () => {
    if (window.confirm("상품을 수정하시겠습니까?"))
      navi("/product/update/" + pId);
  };

  let deleteUrl = "http://localhost:8080/product/delete";

  const goDelete = () => {
    if (window.confirm("'" + pName + "'을/를 삭제하시겠습니까?")) {
      axios
        .get(deleteUrl + "?pId=" + pId)
        .then((res) => {
          alert("'" + pName + "' 삭제 완료");
          navi("/admin/pmanagement");
        })
        .catch((err) => {
          alert(err);
        });
    }
  };

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
          Detail
        </h1>
      </header>

      <section className="py-5">
        <div className="container px-4 px-lg-5 my-5">
          <div>
            <button
              className="btn"
              onClick={onBack}
              style={{ marginBottom: "20px" }}
            >
              <ArrowCircleLeftIcon />
              &nbsp;back
            </button>

            {loginId === null ? (
              <div>
                <button
                  className="btn"
                  style={{ marginBottom: "20px", float: "right" }}
                  onClick={goDelete}
                >
                  <DeleteIcon />
                  delete
                </button>
                <button
                  className="btn"
                  style={{ marginBottom: "20px", float: "right" }}
                  onClick={goUpdatePage}
                >
                  <EditIcon />
                  update
                </button>
              </div>
            ) : (
              <span></span>
            )}

            <div
              className="modal fade"
              id="staticBackdrop2"
              data-bs-backdrop="static"
              data-bs-keyboard="false"
              tabindex="-1"
              aria-labelledby="staticBackdropLabel2"
              aria-hidden="true"
            >
              <div className="modal-dialog">
                <div className="modal-content">
                  <div className="modal-header">
                    <h1 className="modal-title fs-5" id="staticBackdropLabel2">
                      update
                    </h1>
                    <button
                      type="button"
                      className="btn-close"
                      data-bs-dismiss="modal"
                      aria-label="Close"
                    ></button>
                  </div>
                  <div className="modal-body">정말 수정하시겠습니까?</div>
                  <div className="modal-footer">
                    <button
                      type="button"
                      className="btn btn-secondary"
                      data-bs-dismiss="modal"
                    >
                      Close
                    </button>
                    <button
                      type="button"
                      className="btn btn-primary"
                      onclick=""
                    >
                      Update
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div className="row gx-4 gx-lg-5 align-items-center">
            <div className="col-md-6">
              <img className="card-img-top mb-5 mb-md-0" src={pImage} alt="" />
            </div>
            <div className="col-md-6">
              <div className="small mb-1">{pOption.toUpperCase()}</div>
              <h1 className="display-5 fw-bolder">{pName}</h1>
              <div className="fs-5 mb-5">
                <span>￦{price}</span>
              </div>
              <p className="lead">{pDetail}</p>
              <br />

              <form action="/cart/insert" method="post">
                <input type="hidden" name="uId" value={loginId} />
                <input type="hidden" name="pId" value={pId} />

                <div className="d-flex">
                  <button
                    className="btn btn-outline-dark flex-shrink-0"
                    type="button"
                    style={{ marginRight: "5px" }}
                    onClick={Minus}
                  >
                    -
                  </button>
                  <input
                    type="text"
                    className="form-control text-center"
                    placeholder="1"
                    style={{
                      textAlign: "center",
                      width: "50px",
                      margitRight: "5px",
                    }}
                    name="cQTY"
                    value={cQTY}
                    readonly
                  />
                  &nbsp;
                  <button
                    className="btn btn-outline-dark flex-shrink-0"
                    type="button"
                    onClick={Plus}
                  >
                    +
                  </button>
                  <button
                    type="submit"
                    className="btn btn-outline-dark flex-shrink-0"
                    style={{ marginLeft: "50px" }}
                    id="cartBtn"
                  >
                    <ShoppingCartIcon />
                    &nbsp; Add to cart
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Product_productDetail;
