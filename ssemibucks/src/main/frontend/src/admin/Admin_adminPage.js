import React from "react";
import { useNavigate } from "react-router";

function Admin_adminPage(props) {
  const navi = useNavigate();

  return (
    <div>
      <header
        className="py-5"
        style={{ backgroundColor: "rgb(167, 193, 55)", height: "100px" }}
      >
        <h1
          className=" display-4 fw-bolder"
          style={{ lineHeight: "0px", textAlign: "center", color: "white" }}
        >
          ADMIN PAGE
        </h1>
      </header>

      <div class="container my-5">
        <div class="row justify-content-center">
          <button
            type="button"
            class="btn mybtn btnmodify"
            onClick={() => {
              navi("/admin/umanagement");
            }}
          >
            회원관리
          </button>
          <br />
          <button
            type="button"
            class="btn mybtn btnmodify"
            onClick={() => {
              navi("/admin/pmanagement");
            }}
          >
            재고관리
          </button>
        </div>
      </div>
    </div>
  );
}

export default Admin_adminPage;
