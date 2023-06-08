import * as React from "react";
import { useParams } from "react-router";

function Product_productList() {
  const { category } = useParams();

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
            onclick="location.href='javascript:history.back();'"
            style={{ marginBottom: "20px" }}
          >
            <i className="bi bi-arrow-left-circle"></i> back
          </button>

          <div
            className="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"
            style={{ border: "2px solid white", marginTop: "80px" }}
          >
            {/* <c:if test="${products.size() != 0 }">
            <c:forEach var="product" items="${products }"> */}
            <div className="col mb-5">
              <div
                className="card h-100"
                id="product"
                style={{ cursor: "pointer" }}
              >
                <img
                  className="card-img-top"
                  src="${product.getPImage() }"
                  alt="..."
                  onclick="location.href='/product/product_detail?pId=${product.getPId() }'"
                />

                <div className="card-body p-4">
                  <div className="text-center">
                    <h5 className="fw-bolder">카페아메리카노</h5>
                  </div>
                </div>

                <form action="/cart/cart_insertAction" method="post">
                  <input type="hidden" name="uId" value="${sessionScope.uId}" />
                  <input
                    type="hidden"
                    name="pId"
                    value="${product.getPId() }"
                  />
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
            {/* </c:forEach>
          </c:if> */}
          </div>
        </div>
      </section>
    </div>
  );
}

export default Product_productList;
