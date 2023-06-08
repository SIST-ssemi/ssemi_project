import React from "react";

function Main(props) {
  return (
    <div className="mainStyle">
      <div class="container-fluid p-0 pb-5">
        <img class="img-fluid" src="./img/cafe.JPG" alt="" />
        <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center">
          <div class="container">
            <div class="row justify-content-center">
              <div class="text-center">
                <h5 class="text-white text-uppercase mb-3 animated slideInDown">
                  Welcome To Ssemibucks
                </h5>
                <h3 class="display-3 text-white animated slideInDown mb-4">
                  Ssemibucks와 함께 커피 한잔의 여유를 가져보세요
                </h3>
                <p class="fs-5 fw-medium text-white mb-4 pb-2">
                  나의 취향이 머무는 곳. 더욱 편리하게 Ssemibucks를 만나보세요.
                  <br />
                  함께해서 더 따뜻한 지역사회 소통 공간. 다양한 Ssemibucks
                  매장이 여러분을 기다립니다.
                </p>

                <a
                  href="/user/login"
                  class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft"
                >
                  Login
                </a>
                <a
                  href="/user/register"
                  class="btn btn-light py-md-3 px-md-5 animated slideInRight"
                >
                  Sign Up
                </a>

                <a
                  href="/user/user_logout"
                  class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft"
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
