// import React from "react";
// import { NavLink } from "react-router-dom";

// function Navbar(props) {
//   return (
//     <div>
//       <ul className="menu">
//         <li>
//           <NavLink to="/">SsemiBucks</NavLink>
//         </li>
//         <li>
//           <NavLink to="/product">상품목록</NavLink>
//         </li>
//         <li>
//           <NavLink to="/user">마이페이지</NavLink>
//         </li>
//         <li>
//           <NavLink to="/cart">장바구니</NavLink>
//         </li>
//         <li>
//           <NavLink to="/admin">어드민</NavLink>
//         </li>
//       </ul>
//     </div>
//   );
// }

// export default Navbar;

import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import IconButton from "@mui/material/IconButton";
import Typography from "@mui/material/Typography";
import Menu from "@mui/material/Menu";
import MenuIcon from "@mui/icons-material/Menu";
import Container from "@mui/material/Container";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import Tooltip from "@mui/material/Tooltip";
import MenuItem from "@mui/material/MenuItem";
import FreeBreakfastIcon from "@mui/icons-material/FreeBreakfast";
import { ToggleButton, ToggleButtonGroup } from "@mui/material";
import { useParams } from "react-router-dom";

const categories = [
  { name: "All Menu", url: "/product" },
  { name: "Coffee", url: "/product/coffee" },
  { name: "Non-Coffee", url: "/product/non-coffee" },
  { name: "Dessert", url: "/product/dessert" },
];

function Navbar() {
  const { loginId } = useParams();

  const pages = [
    { name: "상품목록", url: "/product" },
    {
      name: "마이페이지",
      url: loginId == null ? "/user/login" : "/user/" + loginId,
    },
    { name: "장바구니", url: "/cart" },
    { name: "어드민", url: "/admin" },
  ];

  const [anchorElNav, setAnchorElNav] = React.useState("/");
  const [anchorElUser, setAnchorElUser] = React.useState(null);

  const handleOpenNavMenu = (event) => {
    setAnchorElNav(event.currentTarget);
  };
  const handleOpenUserMenu = (event) => {
    setAnchorElUser(event.currentTarget);
  };

  const handleCloseNavMenu = () => {
    setAnchorElNav(null);
  };

  const handleCloseUserMenu = () => {
    setAnchorElUser(null);
  };

  return (
    <AppBar position="static" style={{ backgroundColor: "rgb(167, 193, 55)" }}>
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <FreeBreakfastIcon
            sx={{ display: { xs: "none", md: "flex" }, mr: 1 }}
          />
          <Typography
            variant="h6"
            noWrap
            component="a"
            href="/"
            sx={{
              mr: 2,
              display: { xs: "none", md: "flex" },
              fontFamily: "monospace",
              fontWeight: 700,
              letterSpacing: ".3rem",
              color: "inherit",
              textDecoration: "none",
            }}
          >
            SsemiBucks
          </Typography>
          <Box sx={{ flexGrow: 1, display: { xs: "flex", md: "none" } }}>
            <IconButton
              size="large"
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleOpenNavMenu}
              color="inherit"
            >
              <MenuIcon />
            </IconButton>
            <Menu
              id="menu-appbar"
              anchorEl={anchorElNav}
              anchorOrigin={{
                vertical: "bottom",
                horizontal: "left",
              }}
              keepMounted
              transformOrigin={{
                vertical: "top",
                horizontal: "left",
              }}
              open={Boolean(anchorElNav)}
              onClose={handleCloseNavMenu}
              sx={{
                display: { xs: "block", md: "none" },
              }}
            >
              {pages.map((page) => (
                <MenuItem key={page.name} onClick={handleCloseNavMenu}>
                  <Typography textAlign="center">{page.name}</Typography>
                </MenuItem>
              ))}
            </Menu>
          </Box>
          <FreeBreakfastIcon
            sx={{ display: { xs: "flex", md: "none" }, mr: 1 }}
          />
          <Typography
            variant="h5"
            noWrap
            component="a"
            href=""
            sx={{
              mr: 2,
              display: { xs: "flex", md: "none" },
              flexGrow: 1,
              fontFamily: "monospace",
              fontWeight: 700,
              letterSpacing: ".3rem",
              color: "inherit",
              textDecoration: "none",
            }}
          >
            LOGO
          </Typography>
          <Box sx={{ flexGrow: 1, display: { xs: "none", md: "flex" } }}>
            {pages.map((page, index) => (
              <React.Fragment key={page.name}>
                {index === 0 ? (
                  <ToggleButtonGroup
                    value={anchorElUser ? "menu" : null}
                    exclusive
                    onChange={handleOpenUserMenu}
                    aria-label="상품목록"
                    sx={{
                      my: 2,
                      display: "block",
                      "&:hover": {
                        backgroundColor: "transparent",
                      },
                      "& .MuiToggleButton-root": {
                        border: "none",
                      },
                      "& .Mui-selected": {
                        backgroundColor: "transparent",
                        color: "white",
                        "&:hover": {
                          backgroundColor: "transparent",
                        },
                      },
                    }}
                  >
                    <ToggleButton
                      value="menu"
                      aria-label="상품목록 메뉴"
                      aria-haspopup="true"
                      sx={{
                        color: "white",
                      }}
                    >
                      상품목록
                    </ToggleButton>
                    <Menu
                      sx={{ mt: "45px" }}
                      id="menu-appbar"
                      anchorEl={anchorElUser}
                      anchorOrigin={{
                        vertical: "top",
                        horizontal: "right",
                      }}
                      keepMounted
                      transformOrigin={{
                        vertical: "top",
                        horizontal: "right",
                      }}
                      open={Boolean(anchorElUser)}
                      onClose={handleCloseUserMenu}
                    >
                      {categories.map((category) => (
                        <MenuItem
                          key={category.name}
                          component="a" // 변경된 부분: a 태그로 설정하여 클릭 시 페이지 이동
                          href={category.url}
                          onClick={handleCloseUserMenu}
                        >
                          <Typography textAlign="center">
                            {category.name}
                          </Typography>
                        </MenuItem>
                      ))}
                    </Menu>
                  </ToggleButtonGroup>
                ) : (
                  <Button
                    href={page.url}
                    onClick={handleCloseNavMenu}
                    sx={{
                      my: 2,
                      color: "white",
                      display: "block",
                      "&:hover": {
                        color: "white",
                      },
                      marginTop: "22px",
                    }}
                  >
                    {page.name}
                  </Button>
                )}
              </React.Fragment>
            ))}
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
export default Navbar;
