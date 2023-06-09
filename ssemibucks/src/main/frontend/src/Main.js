import React from "react";
import cafeImg from "./img/cafe.JPG";
function Main(props) {
  return (
    <div className="mainStyle">
      <div className="container-fluid p-0 pb-5">
        <img
          className="img-fluid"
          src={cafeImg}
          alt=""
          style={{ height: "500px" }}
        />
        <div
          className="position-absolute top-10 start-0 w-100 h-75 d-flex align-items-center"
          style={{ backgroundColor: "rgba(53, 53, 53, 0.7)" }}
        >
          <div className="container">
            <div className="row justify-content-center">
              <div className="text-center">
                <h5 className="text-white text-uppercase mb-3 animated slideInDown">
                  Welcome To Ssemibucks
                </h5>
                <h3 className="display-3 text-white animated slideInDown mb-4">
                  Ssemibucks와 함께 커피 한잔의 여유를 가져보세요
                </h3>
                <p className="fs-5 fw-medium text-white mb-4 pb-2">
                  나의 취향이 머무는 곳. 더욱 편리하게 Ssemibucks를 만나보세요.
                  <br />
                  함께해서 더 따뜻한 지역사회 소통 공간. 다양한 Ssemibucks
                  매장이 여러분을 기다립니다.
                </p>

                <a
                  href="/user/login"
                  className="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft"
                >
                  Login
                </a>
                <a
                  href="/user/register"
                  className="btn btn-light py-md-3 px-md-5 animated slideInRight"
                >
                  Sign Up
                </a>

                <a
                  href="/user/user_logout"
                  className="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft"
                >
                  Log out
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Main;
