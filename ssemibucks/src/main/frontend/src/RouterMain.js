import React from "react";
import Navbar from "./components/Navbar";
import { Route, Router, Routes } from "react-router-dom";
import Main from "./Main";
import Admin_adminPage from "./admin/Admin_adminPage";
import Product_productList from "./product/Product_productList";
import User_myPage from "./user/User_myPage";
import Cart_cartList from "./cart/Cart_cartList";
import { Login, Register, Update } from "./user";
import { Pmanagement, Umanagement } from "./admin";

function RouterMain(props) {
  return (
    <div>
      <Navbar />
      <hr />
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/admin" element={<Admin_adminPage />} />
        <Route path="/admin/umanagement" element={<Umanagement />} />
        <Route path="/admin/pmanagement" element={<Pmanagement />} />
        <Route path="/product" element={<Product_productList />} />
        <Route path="/product/:category" element={<Product_productList />} />
        <Route path="/user/:loginId" element={<User_myPage />} />
        <Route path="/user/login" element={<Login />} />
        <Route path="/user/register" element={<Register />} />
        <Route path="/user/update" element={<Update />} />
        <Route path="/cart" element={<Cart_cartList />} />
        <Route path="*" element={<h1>404 Error</h1>} />
      </Routes>
    </div>
  );
}

export default RouterMain;
