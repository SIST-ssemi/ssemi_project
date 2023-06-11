import React from "react";
import Navbar from "./components/Navbar";
import { Route, Routes } from "react-router-dom";
import Main from "./Main";
import Admin_adminPage from "./admin/Admin_adminPage";
import Product_productList from "./product/Product_productList";
import User_myPage from "./user/User_myPage";
import Cart_cartList from "./cart/Cart_cartList";
import { Login, Register, Update } from "./user";
import { Pmanagement, Umanagement } from "./admin";
import { AddProduct, ChkPid, ProductDetail, UpdateProduct } from "./product";

function RouterMain(props) {
  return (
    <div>
      <Navbar />
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/admin" element={<Admin_adminPage />} />
        <Route path="/admin/umanagement" element={<Umanagement />} />
        <Route path="/admin/pmanagement" element={<Pmanagement />} />
        <Route path="/product" element={<Product_productList />} />
        <Route path="/product/:category" element={<Product_productList />} />
        <Route path="/product/add" element={<AddProduct />} />
        <Route path="/product/pIdchk/:pId" element={<ChkPid />} />
        <Route path="/product/update/:pId" element={<UpdateProduct />} />
        <Route path="/product/detail/:pId" element={<ProductDetail />} />
        <Route path="/user" element={<User_myPage />} />
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
