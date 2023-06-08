import React from "react";
import { useNavigate } from "react-router";

function User_myPage(props) {
  const navi = useNavigate();
  return (
    <div>
      <header
        class="py-5"
        style={{ backgroundColor: "rgb(167, 193, 55)", height: "100px" }}
      >
        <h1
          class="display-4 fw-bolder"
          style={{ lineHeight: "100px", textAlign: "center", color: "white" }}
        >
          MY PAGE
        </h1>
      </header>

      <div class="py-0">
        <div class="text-center ">
          <br />
          <br />
          <h1 class="text-white fs-3 fw-bolder" style={{ marginTop: "0px" }}>
            유저아이디
          </h1>
          <p class=" text-white-50 mb-0">유저이름님, 환영합니다</p>
        </div>
      </div>
      <div class="container my-5">
        <div class="col-lg text-xl-center">
          <h1>My Information</h1>
          <hr />
          <form action="user_delete" method="post">
            <table class="table table-stripped" align="center">
              <tr>
                <div class="uId">
                  <th style={{ verticalAlign: "middle" }}>아이디</th>
                  <td style={{ verticalAlign: "middle" }}>유저아이디</td>
                </div>
              </tr>
              <tr>
                <div class="pw">
                  <th style={{ verticalAlign: "middle" }}>비밀번호</th>
                  <td style={{ verticalAlign: "middle" }}>유저비밀번호</td>
                </div>
              </tr>
              <tr>
                <div class="uName">
                  <th style={{ verticalAlign: "middle" }}>이름</th>
                  <td style={{ verticalAlign: "middle" }}>유저이름</td>
                </div>
              </tr>
              <tr>
                <div class="hp">
                  <th style={{ verticalAlign: "middle" }}>전화번호</th>
                  <td style={{ verticalAlign: "middle" }}>유저전화번호</td>
                </div>
              </tr>
              <tr>
                <div class="addr">
                  <th style={{ verticalAlign: "middle" }}>주소</th>
                  <td style={{ verticalAlign: "middle" }}>유저주소</td>
                </div>
              </tr>
              <tr>
                <td colspan="2" align="center">
                  <button
                    type="button"
                    class="btn mybtn"
                    onClick={() => {
                      navi("/user/update");
                    }}
                  >
                    정보수정
                  </button>
                  <button
                    type="button"
                    class="btn mybtn"
                    onClick={() => {
                      navi("/user/delete");
                    }}
                  >
                    회원탈퇴
                  </button>
                </td>
              </tr>
            </table>
          </form>
        </div>
      </div>
    </div>
  );
}

export default User_myPage;
