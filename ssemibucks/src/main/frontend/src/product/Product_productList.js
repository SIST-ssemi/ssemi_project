import * as React from "react";
import CssBaseline from "@mui/material/CssBaseline";
import Box from "@mui/material/Box";
import Container from "@mui/material/Container";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import { useParams } from "react-router-dom";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";

function Product_productList() {
  const { category } = useParams();

  return (
    <React.Fragment>
      <CssBaseline />
      <Container
        maxWidth="xl"
        style={{
          justifyContent: "center",
          padding: "50px",
        }}
      >
        <h1 style={{ textAlign: "center" }}>
          {category == null ? "all" : category}
        </h1>

        <Box
          sx={{
            border: "1px solid #cfe8fc",
            marginBottom: "20px",
            display: "flex",
            flexWrap: "wrap",
            justifyContent: "center",
          }}
        >
          <Card
            sx={{
              width: "300px",
              height: "400px",
              marginRight: "50px",
              marginBottom: "50px",
            }}
          >
            <CardMedia
              component="img"
              alt=""
              height="140"
              image="/static/images/cards/contemplative-reptile.jpg"
            />
            <CardContent>
              <Typography
                gutterBottom
                variant="h5"
                component="div"
              ></Typography>
              <Typography style={{ textAlign: "center", fontWeight: "bold" }}>
                카페 아메리카노
              </Typography>
            </CardContent>
            <CardActions style={{ justifyContent: "center" }}>
              <Button size="large">
                <ShoppingCartIcon />
                add a cart
              </Button>
            </CardActions>
          </Card>
        </Box>
      </Container>
    </React.Fragment>
  );
}

export default Product_productList;
