import axios from "axios";
import React from "react";
import { useParams } from "react-router-dom";

function Product_pIdChk(props) {
  const { pId } = useParams();

  let ckeckUrl = "http://localhost:8080/product/pIdCheck";

  const onCheck = () => {
    axios
      .get(ckeckUrl + "?pId=" + pId)
      .then((res) => {
        if (res.data === true) {
          localStorage.setItem("chk", res.data);
          alert("사용 가능한 상품 아이디입니다.");
        } else {
          localStorage.setItem("chk", res.data);
          alert("중복된 상품 아이디입니다. 다시 입력해주세요.");
        }
        window.close();
      })
      .catch((err) => {
        alert(err);
      });
  };

  return (
    <div>
      <form>
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
                value={pId}
                readOnly
              />
              <button
                type="button"
                className="btn btn-sm mybtn"
                onClick={onCheck}
              >
                Check
              </button>
            </td>
          </tr>
        </table>
      </form>
    </div>
  );
}

export default Product_pIdChk;
