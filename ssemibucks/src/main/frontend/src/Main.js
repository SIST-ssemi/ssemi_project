import React, { useEffect, useState } from "react";

function Main(props) {
  const loginId = sessionStorage.getItem("loginId");

  const Logout = () => {
    alert(loginId + "님, 로그아웃되었습니다.");
    sessionStorage.removeItem("loginId");
    setLoginStatus(false);
  };

  const [loginStatus, setLoginStatus] = useState(false);

  useEffect(() => {
    if (loginId != undefined) setLoginStatus(true);
  }, [loginId]);

  return (
    <div className="mainStyle">
      <div className="container-fluid p-0 pb-5">
        <img className="img-fluid" src="./img/cafe.JPG" alt="" />
        <div className="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center">
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

                {!loginStatus && (
                  <div>
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
                  </div>
                )}

                {loginStatus && (
                  <div>
                    <a
                      onClick={Logout}
                      className="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft"
                    >
                      LogOut
                    </a>
                  </div>
                )}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Main;
