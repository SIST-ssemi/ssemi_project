import axios from "axios";
import React from "react";
import { useParams } from "react-router-dom";

function User_uIdChk(props) {
  const { chkuId } = useParams();

  let duplicateUidChkUrl = "http://localhost:8080/user/duplicateUidChk";
  const chkUid = new FormData();
  chkUid.append("uId", chkuId);

  const duplicateUidChk = () => {
    axios({
      method: "post",
      url: duplicateUidChkUrl,
      data: chkUid,
    })
      .then((res) => {
        const result = res.data == "중복아이디" ? "사용 불가" : "사용 가능";
        alert(result);
        window.opener.postMessage(result, "*");
        window.close();
      })
      .catch((err) => {
        alert(err);
      });
  };

  return (
    <div>
      <table
        className="table"
        style={{ width: "100%", height: "100%", borderStyle: "none" }}
      >
        <tr style={{ borderStyle: "none" }}>
          <td align="center" style={{ borderStyle: "none" }}>
            <h3 style={{ color: "rgb(167, 193, 55)", fontWeight: "bold" }}>
              Press Check button
            </h3>
            <br />
            <input
              type="text"
              name="chkId"
              id="chkId"
              style={{ width: "100px" }}
              readonly
              defaultValue={chkuId}
            />
            <button className="btn btn-sm mybtn" onClick={duplicateUidChk}>
              Check
            </button>
          </td>
        </tr>
      </table>
    </div>
  );
}

export default User_uIdChk;
