import React from "react";
import { NavLink } from "react-router-dom";

function Navbar(props) {
  return (
    <div>
      <ul className="menu">
        <li>
          <NavLink to="/">SsemiBucks</NavLink>
        </li>
        <li>
          <NavLink to="/product">상품목록</NavLink>
        </li>
        <li>
          <NavLink to="/user">마이페이지</NavLink>
        </li>
        <li>
          <NavLink to="/cart">장바구니</NavLink>
        </li>
        <li>
          <NavLink to="/admin">어드민</NavLink>
        </li>
      </ul>
    </div>
  );
}

export default Navbar;
