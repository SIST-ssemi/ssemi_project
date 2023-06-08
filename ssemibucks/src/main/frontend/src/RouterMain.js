import React from "react";
import Navbar from "./components/Navbar";
import { Route, Router, Routes } from "react-router-dom";
import Main from "./Main";
import Admin_adminPage from "./admin/Admin_adminPage";
import Product_productList from "./product/Product_productList";
import User_myPage from "./user/User_myPage";
import Cart_cartList from "./cart/Cart_cartList";
import { Login, Register } from "./user";
import { AddProduct } from "./product";

function RouterMain(props) {
  return (
    <div>
      <Navbar />
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/admin" element={<Admin_adminPage />} />
        <Route path="/product" element={<Product_productList />} />
        <Route path="/product/:category" element={<Product_productList />} />
        <Route path="/product/add" element={<AddProduct />} />
        <Route path="/user" element={<User_myPage />} />
        <Route path="/user/login" element={<Login />} />
        <Route path="/user/register" element={<Register />} />
        <Route path="/cart" element={<Cart_cartList />} />
        <Route path="*" element={<h1>404 Error</h1>} />
      </Routes>
    </div>
  );
}

export default RouterMain;
