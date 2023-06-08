import React from "react";
import { useNavigate } from "react-router-dom";

function User_update(props) {
  const navi = useNavigate();
  return (
    <div>
      <div className="title">
        <h1>마이페이지 정보수정</h1>
      </div>
      <form action="/user/user_registerAction" METHOD="post">
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
                />

                <button
                  type="button"
                  className="btn btn-sm mybtn"
                  id="chkbtn"
                  style={{ marginLeft: "20px" }}
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
                />
              </td>
            </div>
          </tr>
          <tr>
            <td colspan="2" align="center">
              <button type="submit" id="signup" className="btn mybtn">
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
      </form>
    </div>
  );
}

export default User_update;
