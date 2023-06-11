import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function User_login(props) {
  const navi = useNavigate();

  let loginUrl = "http://localhost:8080/user/loginaction";

  const [inputId, setInputId] = useState("");
  const [inputPw, setInputPw] = useState("");

  const loginInfo = new FormData();
  loginInfo.append("uId", inputId);
  loginInfo.append("pw", inputPw);

  const LoginAction = () => {
    axios({
      method: "post",
      url: loginUrl,
      data: loginInfo,
    })
      .then((res) => {
        if (res.data == "ok") {
          sessionStorage.setItem("loginId", loginInfo.get("uId"));
          alert(
            sessionStorage.getItem("loginId") + "님, 로그인 성공하였습니다."
          );
          navi("/");
        } else {
          alert("다시 로그인해주세요.");
          navi("/user/login");
        }
      })
      .catch((err) => {
        alert(err + "로그인 오류");
      });
  };

  return (
    <div>
      <div className="content">
        <div className="header" style={{ padding: "15px 50px" }}>
          <h4>
            <span className="glyphicon glyphicon-lock"></span> Login
          </h4>
        </div>
        <div className="body" style={{ padding: "20px 50px" }}>
          <div className="form-group">
            <label for="username">
              <span className="glyphicon glyphicon-user"></span> UserID
            </label>
            <input
              name="inputId"
              type="text"
              className="form-control"
              id="username"
              placeholder="Enter userID"
              onChange={(e) => setInputId(e.target.value)}
            />
          </div>
          <div className="form-group">
            <label for="psw">
              <span className="glyphicon glyphicon-eye-open"></span>
              &nbsp;Password
            </label>
            <input
              name="inputPw"
              type="password"
              className="form-control"
              id="psw"
              placeholder="Enter password"
              onChange={(e) => setInputPw(e.target.value)}
            />
          </div>
          <button
            type="button"
            className="btn btn-success btn-block"
            style={{
              marginTop: "30px",
              padding: "10px 0 10px 0",
              backgroundColor: "rgb(167, 193, 55)",
              border: "rgb(167, 193, 55)",
            }}
            onClick={LoginAction}
          >
            <span style={{ height: "30px", fontSize: "1.2em" }}>Login</span>
          </button>
        </div>
        <div className="footer">
          <p style={{ marginLeft: "50px" }}>
            Not a member? <a href="/user/register">Sign Up</a>
          </p>
        </div>
        <div style={{ float: "right" }}>
          <button
            type="button"
            className="btn mybtn"
            onClick={() => {
              navi(-1);
            }}
            style={{ marginRight: "50px" }}
          >
            Back
          </button>
        </div>
      </div>
    </div>
  );
}

export default User_login;
