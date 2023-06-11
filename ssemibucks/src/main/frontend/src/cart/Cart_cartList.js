import React, { useEffect, useState } from "react";

import PropTypes from "prop-types";
import { alpha } from "@mui/material/styles";
import Box from "@mui/material/Box";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TablePagination from "@mui/material/TablePagination";
import TableRow from "@mui/material/TableRow";
import TableSortLabel from "@mui/material/TableSortLabel";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Paper from "@mui/material/Paper";
import Checkbox from "@mui/material/Checkbox";
import IconButton from "@mui/material/IconButton";
import Tooltip from "@mui/material/Tooltip";
import FormControlLabel from "@mui/material/FormControlLabel";
import Switch from "@mui/material/Switch";
import DeleteIcon from "@mui/icons-material/Delete";
import FilterListIcon from "@mui/icons-material/FilterList";
import { visuallyHidden } from "@mui/utils";
import { useNavigate } from "react-router-dom";
import ArrowCircleLeftIcon from "@mui/icons-material/ArrowCircleLeft";
import AddCircleIcon from "@mui/icons-material/AddCircle";
import axios from "axios";

function descendingComparator(a, b, orderBy) {
  if (b[orderBy] < a[orderBy]) {
    return -1;
  }
  if (b[orderBy] > a[orderBy]) {
    return 1;
  }
  return 0;
}

function getComparator(order, orderBy) {
  return order === "desc"
    ? (a, b) => descendingComparator(a, b, orderBy)
    : (a, b) => -descendingComparator(a, b, orderBy);
}

// Since 2020 all major browsers ensure sort stability with Array.prototype.sort().
// stableSort() brings sort stability to non-modern browsers (notably IE11). If you
// only support modern browsers you can replace stableSort(exampleArray, exampleComparator)
// with exampleArray.slice().sort(exampleComparator)
function stableSort(array, comparator) {
  const stabilizedThis = array.map((el, index) => [el, index]);
  stabilizedThis.sort((a, b) => {
    const order = comparator(a[0], b[0]);
    if (order !== 0) {
      return order;
    }
    return a[1] - b[1];
  });
  return stabilizedThis.map((el) => el[0]);
}

const headCells = [
  {
    id: "cId",
    numeric: false,
    disablePadding: true,
    label: "번호",
  },
  {
    id: "category",
    numeric: true,
    disablePadding: false,
    label: "카테고리",
  },
  {
    id: "pName",
    numeric: true,
    disablePadding: false,
    label: "상품명",
  },
  {
    id: "pOption",
    numeric: true,
    disablePadding: false,
    label: "옵션",
  },
  {
    id: "price",
    numeric: true,
    disablePadding: false,
    label: "가격",
  },
  {
    id: "cQTY",
    numeric: true,
    disablePadding: false,
    label: "수량",
  },
];

function EnhancedTableHead(props) {
  const {
    onSelectAllClick,
    order,
    orderBy,
    numSelected,
    rowCount,
    onRequestSort,
  } = props;
  const createSortHandler = (property) => (event) => {
    onRequestSort(event, property);
  };

  return (
    <TableHead>
      <TableRow>
        <TableCell padding="checkbox">
          <Checkbox
            color="primary"
            indeterminate={numSelected > 0 && numSelected < rowCount}
            checked={rowCount > 0 && numSelected === rowCount}
            onChange={onSelectAllClick}
            inputProps={{
              "aria-label": "select all desserts",
            }}
          />
        </TableCell>
        {headCells.map((headCell) => (
          <TableCell
            key={headCell.id}
            align={headCell.numeric ? "right" : "left"}
            padding={headCell.disablePadding ? "none" : "normal"}
            sortDirection={orderBy === headCell.id ? order : false}
          >
            <TableSortLabel
              active={orderBy === headCell.id}
              direction={orderBy === headCell.id ? order : "asc"}
              onClick={createSortHandler(headCell.id)}
            >
              {headCell.label}
              {orderBy === headCell.id ? (
                <Box component="span" sx={visuallyHidden}>
                  {order === "desc" ? "sorted descending" : "sorted ascending"}
                </Box>
              ) : null}
            </TableSortLabel>
          </TableCell>
        ))}
      </TableRow>
    </TableHead>
  );
}

EnhancedTableHead.propTypes = {
  numSelected: PropTypes.number.isRequired,
  onRequestSort: PropTypes.func.isRequired,
  onSelectAllClick: PropTypes.func.isRequired,
  order: PropTypes.oneOf(["asc", "desc"]).isRequired,
  orderBy: PropTypes.string.isRequired,
  rowCount: PropTypes.number.isRequired,
};

function EnhancedTableToolbar(props) {
  const { numSelected, cartDelete } = props;

  const DeleteAction = () => {
    cartDelete();
  };

  return (
    <Toolbar
      sx={{
        pl: { sm: 2 },
        pr: { xs: 1, sm: 1 },
        ...(numSelected > 0 && {
          bgcolor: (theme) =>
            alpha(
              theme.palette.primary.main,
              theme.palette.action.activatedOpacity
            ),
        }),
      }}
    >
      {numSelected > 0 ? (
        <Typography
          sx={{ flex: "1 1 100%" }}
          color="inherit"
          variant="subtitle1"
          component="div"
        >
          {numSelected} selected
        </Typography>
      ) : (
        <Typography
          sx={{ flex: "1 1 100%" }}
          variant="h6"
          id="tableTitle"
          component="div"
        >
          장바구니리스트
        </Typography>
      )}

      {numSelected > 0 ? (
        <Tooltip title="Delete">
          <IconButton onClick={DeleteAction}>
            <DeleteIcon />
          </IconButton>
        </Tooltip>
      ) : (
        <Tooltip title="Filter list">
          <IconButton>
            <FilterListIcon />
          </IconButton>
        </Tooltip>
      )}
    </Toolbar>
  );
}

EnhancedTableToolbar.propTypes = {
  numSelected: PropTypes.number.isRequired,
};

export default function Cart_cartList() {
  let cartListUrl = "http://localhost:8080/cart/list";
  const loginId = sessionStorage.getItem("loginId");
  const [carts, setCarts] = useState([]);

  useEffect(() => {
    axios({
      method: "get",
      url: cartListUrl + "?uId=" + loginId,
    })
      .then((res) => {
        setCarts(res.data);
      })
      .catch((err) => {
        alert(err);
      });
  }, []);

  const cartDelete = () => {
    // 선택된 항목을 삭제하는 로직을 작성합니다.
    let cartDeleteUrl = "http://localhost:8080/cart/delete";

    const deletecarts = {
      delcarts: carts.filter((cart) => selected.includes(cart.cId)),
    };

    axios
      .post(cartDeleteUrl, deletecarts)
      .then((res) => {
        alert(res.data + "개의 상품을 장바구니에서 삭제했습니다.");
        window.location.replace("/cart/" + loginId);
      })
      .catch((err) => {
        alert(err);
      });
  };

  const [order, setOrder] = React.useState("asc");
  const [orderBy, setOrderBy] = React.useState("cId");
  const [selected, setSelected] = React.useState([]);
  const [page, setPage] = React.useState(0);
  const [dense, setDense] = React.useState(false);
  const [rowsPerPage, setRowsPerPage] = React.useState(5);

  const handleRequestSort = (event, property) => {
    const isAsc = orderBy === property && order === "asc";
    setOrder(isAsc ? "desc" : "asc");
    setOrderBy(property);
  };

  const handleSelectAllClick = (event) => {
    if (event.target.checked) {
      const newSelected = carts.map((n) => n.cId);
      setSelected(newSelected);
      return;
    }
    setSelected([]);
  };

  const handleClick = (event, cId) => {
    const selectedIndex = selected.indexOf(cId);
    let newSelected = [];

    if (selectedIndex === -1) {
      newSelected = newSelected.concat(selected, cId);
    } else if (selectedIndex === 0) {
      newSelected = newSelected.concat(selected.slice(1));
    } else if (selectedIndex === selected.length - 1) {
      newSelected = newSelected.concat(selected.slice(0, -1));
    } else if (selectedIndex > 0) {
      newSelected = newSelected.concat(
        selected.slice(0, selectedIndex),
        selected.slice(selectedIndex + 1)
      );
    }

    setSelected(newSelected);
  };

  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  const handleChangeDense = (event) => {
    setDense(event.target.checked);
  };

  const isSelected = (cId) => selected.indexOf(cId) !== -1;

  // Avoid a layout jump when reaching the last page with empty rows.
  const emptyRows =
    page > 0 ? Math.max(0, (1 + page) * rowsPerPage - carts.length) : 0;

  const visibleRows = React.useMemo(
    () =>
      stableSort(carts, getComparator(order, orderBy)).slice(
        page * rowsPerPage,
        page * rowsPerPage + rowsPerPage
      ),
    [order, orderBy, page, rowsPerPage, carts]
  );

  const navi = useNavigate();
  const onBack = (e) => {
    navi("/admin");
  };

  return (
    <div>
      <header
        className="py-5"
        style={{ backgroundColor: "rgb(167, 193, 55)", height: "100px" }}
      >
        <h1
          className=" display-4 fw-bolder"
          style={{ lineHeight: "0px", textAlign: "center", color: "white" }}
        >
          {loginId}'s Cart
        </h1>
      </header>

      <div className="container-fluid py-5 col-10">
        <button
          type="button"
          className="btn"
          onClick={onBack}
          style={{ marginBottom: "20px" }}
        >
          <ArrowCircleLeftIcon /> back
        </button>

        <div className="row">
          <div className="col-12">
            <div className="card my-4">
              <div className="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                <div className="bg-primary shadow-primary border-radius-lg pt-4 pb-3">
                  <h6 className="text-white text-capitalize ps-3">
                    Carts table
                  </h6>
                </div>
              </div>
              <div className="card-body px-0 pb-2">
                <Box sx={{ width: "100%" }}>
                  <Paper sx={{ width: "100%", mb: 2 }}>
                    <EnhancedTableToolbar
                      numSelected={selected.length}
                      cartDelete={cartDelete}
                    />
                    <TableContainer>
                      <Table
                        sx={{ minWidth: 750 }}
                        aria-labelledby="tableTitle"
                        size={dense ? "small" : "medium"}
                      >
                        <EnhancedTableHead
                          numSelected={selected.length}
                          order={order}
                          orderBy={orderBy}
                          onSelectAllClick={handleSelectAllClick}
                          onRequestSort={handleRequestSort}
                          rowCount={carts.length}
                        />
                        <TableBody>
                          {visibleRows.map((cart, index) => {
                            const isItemSelected = isSelected(cart.cId);
                            const labelId = `enhanced-table-checkbox-${index}`;

                            return (
                              <TableRow
                                hover
                                onClick={(event) =>
                                  handleClick(event, cart.cId)
                                }
                                role="checkbox"
                                aria-checked={isItemSelected}
                                tabIndex={-1}
                                key={cart.cId}
                                selected={isItemSelected}
                                sx={{ cursor: "pointer" }}
                              >
                                <TableCell padding="checkbox">
                                  <Checkbox
                                    color="primary"
                                    checked={isItemSelected}
                                    inputProps={{
                                      "aria-labelledby": labelId,
                                    }}
                                  />
                                </TableCell>
                                <TableCell
                                  component="th"
                                  id={labelId}
                                  scope="cart"
                                  padding="none"
                                >
                                  {cart.cId}
                                </TableCell>
                                <TableCell align="right">
                                  {cart.category}
                                </TableCell>
                                <TableCell align="right">
                                  {cart.pName}
                                </TableCell>
                                <TableCell align="right">
                                  {cart.pOption}
                                </TableCell>
                                <TableCell align="right">
                                  {cart.price}
                                </TableCell>
                                <TableCell align="right">{cart.cQTY}</TableCell>
                              </TableRow>
                            );
                          })}
                          {emptyRows > 0 && (
                            <TableRow
                              style={{
                                height: (dense ? 33 : 53) * emptyRows,
                              }}
                            >
                              <TableCell colSpan={6} />
                            </TableRow>
                          )}
                        </TableBody>
                      </Table>
                    </TableContainer>
                    <TablePagination
                      rowsPerPageOptions={[5, 10, 25]}
                      component="div"
                      count={carts.length}
                      rowsPerPage={rowsPerPage}
                      page={page}
                      onPageChange={handleChangePage}
                      onRowsPerPageChange={handleChangeRowsPerPage}
                    />
                  </Paper>
                </Box>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
