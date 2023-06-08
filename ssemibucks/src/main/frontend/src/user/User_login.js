import React from "react";

function User_login(props) {
  return (
    <div>
      <div class="content">
        <div class="header" style={{ padding: "15px 50px" }}>
          <h4>
            <span class="glyphicon glyphicon-lock"></span> Login
          </h4>
        </div>
        <div class="body" style={{ padding: "20px 50px" }}>
          <form action="/user/user_loginAction" method="post">
            <div class="form-group">
              <label for="username">
                <span class="glyphicon glyphicon-user"></span> UserID
              </label>
              <input
                name="uId"
                type="text"
                class="form-control"
                id="username"
                placeholder="Enter userID"
              />
            </div>
            <div class="form-group">
              <label for="psw">
                <span class="glyphicon glyphicon-eye-open"></span>
                &nbsp;Password
              </label>
              <input
                name="pw"
                type="password"
                class="form-control"
                id="psw"
                placeholder="Enter password"
              />
            </div>
            <button
              type="submit"
              class="btn btn-success btn-block"
              style={{
                marginTop: "30px",
                padding: "10px 0 10px 0",
                backgroundColor: "rgb(167, 193, 55)",
                border: "rgb(167, 193, 55)",
              }}
            >
              <span style={{ height: "30px", fontSize: "1.2em" }}>Login</span>
            </button>
          </form>
        </div>
        <div class="footer">
          <p style={{ marginLeft: "50px" }}>
            Not a member? <a href="/user/register">Sign Up</a>
          </p>
        </div>
        <div style={{ float: "right" }}>
          <button
            type="button"
            class="btn mybtn"
            onclick="history.back()"
            style={{ marginRight: "50px" }}
          >
            Back
          </button>
        </div>
      </div>
    </div>
  );
}

export default User_login;
