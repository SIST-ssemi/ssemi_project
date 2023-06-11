import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function User_update(props) {
  const navi = useNavigate();

  let userDataUrl = "http://localhost:8080/user/userdata";
  let userUpdateUrl = "http://localhost:8080/user/updateaction";

  const loginId = sessionStorage.getItem("loginId");
  const [uId, setUId] = useState("");
  const [uName, setUName] = useState("");
  const [pw, setPw] = useState("");
  const [hp, setHp] = useState("");
  const [addr, setAddr] = useState("");

  useEffect(() => {
    axios({
      method: "get",
      url: userDataUrl + "?uId=" + loginId,
    })
      .then((res) => {
        setUId(res.data.uId);
        setUName(res.data.uName);
        setPw(res.data.pw);
        setHp(res.data.hp);
        setAddr(res.data.addr);
      })
      .catch((err) => {
        alert(err);
      });
  }, []);

  const updateAction = () => {
    axios({
      method: "post",
      url: userUpdateUrl,
      data: { uId, pw, uName, hp, addr },
    })
      .then((res) => {
        alert("정보 수정 완료");
        navi("/user/" + loginId);
      })
      .catch((err) => {
        alert(err);
      });
  };

  return (
    <div>
      <div className="title">
        <h1>마이페이지 정보수정</h1>
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
                required="required"
                defaultValue={uId}
                readOnly
              />
            </td>
          </div>
        </tr>
        <tr>
          <div className="pw">
            <th style={{ verticalAlign: "middle" }}>Password</th>
            <td style={{ verticalAlign: "middle" }}>
              <input
                type="text"
                name="pw"
                required="required"
                defaultValue={pw}
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
                required="required"
                defaultValue={uName}
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
                required="required"
                defaultValue={hp}
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
                required="required"
                defaultValue={addr}
                onChange={(e) => setAddr(e.target.value)}
              />
            </td>
          </div>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <button id="signup" className="btn mybtn" onClick={updateAction}>
              회원정보 수정
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

export default User_update;
