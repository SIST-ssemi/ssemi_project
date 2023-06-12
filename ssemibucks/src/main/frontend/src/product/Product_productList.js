import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import { useNavigate } from "react-router-dom";
import ArrowCircleLeftIcon from "@mui/icons-material/ArrowCircleLeft";
import axios from "axios";
import "../style.css";

function Product_productList() {
  const { category } = useParams();

  const navi = useNavigate();
  const onBack = (e) => {
    navi(-1);
  };

  const onDetail = (pId) => {
    navi("/product/detail/" + pId);
  };

  let pListUrl = "http://localhost:8080/product/getplist";

  const [cnt, setCnt] = useState("");
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios
      .get(pListUrl) //원래는 key값:value값인데 spring과 동일하게 해놔서 value만 써도 됨
      .then((res) => {
        if (res != null) {
          setCnt("not null");
          setProducts(res.data);
        } else setCnt("null");
      });
  }, []);

  return (
    <div>
      <header
        className="py-5"
        style={{ backgroundColor: "rgb(167, 193, 55)", height: "200px" }}
      >
        <div className="container px-4 px-lg-5 my-5">
          <div className="text-center">
            <h1
              className="display-4 fw-bolder"
              style={{ lineHeight: "0px", color: "white" }}
            >
              {category == null ? "All Menu" : category}
            </h1>
          </div>
        </div>
      </header>

      <section className="py-5">
        <div
          className="container px-4 px-lg-5 mt-5"
          style={{ border: "2px solid white" }}
        >
          <button
            className="btn"
            onClick={onBack}
            style={{ marginBottom: "20px" }}
          >
            <ArrowCircleLeftIcon /> back
          </button>

          {cnt !== "null" && (
            <div
              className="row row-cols-1 row-cols-md-2 row-cols-xl-4 justify-content-center"
              style={{ marginTop: "40px" }}
            >
              {products.map((product) => (
                <div className="col mb-5">
                  <div
                    className="card"
                    id="product"
                    style={{ cursor: "pointer" }}
                  >
                    <img
                      className="card-img-top"
                      src={product.pImage}
                      alt="..."
                      onClick={() => onDetail(product.pId)}
                    />
                    <div className="card-body p-4">
                      <div className="text-center">
                        <h5 className="fw-bolder">{product.pName}</h5>
                      </div>
                    </div>
                    <form action="/cart/insert" method="post">
                      <input type="hidden" name="uId" value="sessionUId" />
                      <input type="hidden" name="pId" value={product.pId} />
                      <input type="hidden" name="cQTY" value="1" />
                      <div className="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div className="text-center">
                          <button
                            type="submit"
                            className="btn btn-outline-dark mt-auto"
                          >
                            Add to cart
                          </button>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              ))}
            </div>
          )}
        </div>
      </section>
    </div>
  );
}

export default Product_productList;
