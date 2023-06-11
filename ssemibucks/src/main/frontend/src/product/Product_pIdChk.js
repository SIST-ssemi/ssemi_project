import React from "react";

function Product_pIdChk(props) {
  return (
    <div>
      <form method="post">
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
              />
              <button type="submit" className="btn btn-sm mybtn">
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
