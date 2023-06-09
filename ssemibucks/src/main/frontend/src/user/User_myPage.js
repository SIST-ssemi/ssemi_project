import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router";

function User_myPage(props) {
  const navi = useNavigate();

  let userDataUrl = "http://localhost:8080/user/userdata";

  const [uId, setUId] = useState("");
  const [uName, setUName] = useState("");
  const [pw, setPw] = useState("");
  const [hp, setHp] = useState("");
  const [addr, setAddr] = useState("");

  axios
    .get(userDataUrl, { uId, uName, pw, hp, addr }) //원래는 key값:value값인데 spring과 동일하게 해놔서 value만 써도 됨
    .then((res) => {
      setUId(res.data.uId);
      setUName(res.data.uName);
      setPw(res.data.pw);
      setHp(res.data.hp);
      setAddr(res.data.addr);
    })
    .catch((err) => {
      alert("오류");
    });

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
            {uId}
          </h1>
          <p class=" text-white-50 mb-0">{uName}님, 환영합니다</p>
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
                  <td style={{ verticalAlign: "middle" }}>{uId}</td>
                </div>
              </tr>
              <tr>
                <div class="pw">
                  <th style={{ verticalAlign: "middle" }}>비밀번호</th>
                  <td style={{ verticalAlign: "middle" }}>{pw}</td>
                </div>
              </tr>
              <tr>
                <div class="uName">
                  <th style={{ verticalAlign: "middle" }}>이름</th>
                  <td style={{ verticalAlign: "middle" }}>{uName}</td>
                </div>
              </tr>
              <tr>
                <div class="hp">
                  <th style={{ verticalAlign: "middle" }}>전화번호</th>
                  <td style={{ verticalAlign: "middle" }}>{hp}</td>
                </div>
              </tr>
              <tr>
                <div class="addr">
                  <th style={{ verticalAlign: "middle" }}>주소</th>
                  <td style={{ verticalAlign: "middle" }}>{addr}</td>
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
