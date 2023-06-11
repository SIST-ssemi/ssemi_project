import React from "react";

function Cart_cartList(props) {
  const loginId = sessionStorage.getItem("loginId");

  return (
    <div>
      <h1>{loginId}님의 카트리스트</h1>
    </div>
  );
}

export default Cart_cartList;
