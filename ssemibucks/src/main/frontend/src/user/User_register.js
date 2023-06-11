import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function User_register(props) {
  const navi = useNavigate();

  let registerUrl = "http://localhost:8080/user/registeraction";

  const [uId, setUId] = useState("");
  const [uName, setUName] = useState("");
  const [pw, setPw] = useState("");
  const [hp, setHp] = useState("");
  const [addr, setAddr] = useState("");

  const registerAction = () => {
    axios({
      method: "post",
      url: registerUrl,
      data: { uId, pw, uName, hp, addr },
    })
      .then((res) => {
        alert("회원가입 완료");
        navi("/");
      })
      .catch((err) => {
        alert(err);
      });
  };

  const OpenUIdChk = () => {
    if (uId != "") {
      const newWindow = window.open(
        "/user/uIdchk/" + uId,
        "_blank",
        "width=500, height=200"
      );
      newWindow.addEventListener("message", handleMessage);
    } else {
      alert("아이디를 입력해주세요.");
    }
  };

  const handleMessage = (event) => {
    const result = event.data;
    if (result == "중복아이디") {
      setUId("");
    }
  };

  return (
    <div>
      <div className="title">
        <h1>Sign Up</h1>
      </div>
      <table className="table table-stripped" align="center">
        <tr>
          <div className="uId">
            <th style={{ verticalAlign: "middle" }}>UserID</th>
            <td style={{ verticalAlign: "middle" }}>
              <input
                type="text"
                name="uId"
                id="uId"
                placeholder="Enter UserID"
                required="required"
                onChange={(e) => setUId(e.target.value)}
              />
              <button
                type="button"
                className="btn btn-sm mybtn"
                id="chkbtn"
                style={{ marginLeft: "20px" }}
                onClick={OpenUIdChk}
              >
                Check
              </button>
              <input type="hidden" name="checked_id" value="" />
            </td>
          </div>
        </tr>
        <tr>
          <div className="pw">
            <th style={{ verticalAlign: "middle" }}>Password</th>
            <td style={{ verticalAlign: "middle" }}>
              <input
                type="password"
                name="pw"
                placeholder="Enter Password"
                required="required"
                onChange={(e) => setPw(e.target.value)}
              />
            </td>
          </div>
        </tr>
        <tr>
          <div className="uName">
            <th style={{ verticalAlign: "middle" }}>UserName</th>
            <td style={{ verticalAlign: "middle" }}>
              <input
                type="text"
                name="uName"
                placeholder="Enter UserName"
                required="required"
                onChange={(e) => setUName(e.target.value)}
              />
            </td>
          </div>
        </tr>
        <tr>
          <div className="hp">
            <th style={{ verticalAlign: "middle" }}>HP</th>
            <td style={{ verticalAlign: "middle" }}>
              <input
                type="text"
                name="hp"
                placeholder="Enter HP (without ' - ')"
                required="required"
                onChange={(e) => setHp(e.target.value)}
              />
            </td>
          </div>
        </tr>
        <tr>
          <div className="addr">
            <th style={{ verticalAlign: "middle" }}>Address</th>
            <td style={{ verticalAlign: "middle" }}>
              <input
                type="text"
                name="addr"
                placeholder="Enter Address"
                required="required"
                onChange={(e) => setAddr(e.target.value)}
              />
            </td>
          </div>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <button
              type="button"
              id="signup"
              className="btn mybtn"
              onClick={registerAction}
            >
              Sign Up
            </button>
            <button
              type="button"
              className="btn mybtn"
              onClick={() => {
                navi(-1);
              }}
            >
              Cancel
            </button>
          </td>
        </tr>
      </table>
    </div>
  );
}

export default User_register;
