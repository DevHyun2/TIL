import {
  AppBar,
  Button,
  Card,
  Container,
  Grid,
  Toolbar,
  Typography,
} from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";
import { signout } from "login/service/ApiService";

function Home(props) {
  const mystyle = {
    display: "flex",
    flexDirection: "column",
    alignItems: "start",
  };
  var navigationBar = (
    <AppBar position="static">
      <Toolbar>
        <Grid justify="space-between" container>
          <Grid item>
            <Typography variant="h6">메뉴</Typography>
          </Grid>
          <Grid>
            <Button color="inherit" onClick={signout}>
              로그아웃
            </Button>
          </Grid>
        </Grid>
      </Toolbar>
    </AppBar>
  );

  return (
    <div>
      {navigationBar}
      <Container component="main" maxWidth="xs" style={{ marginTop: "8%" }}>
        <Card color="success" orientation="vertical" variant="outlined">
          <Link overlay="true" to="/login" underline="none" sx={mystyle}>
            로그인하기
          </Link>
        </Card>
        <Card color="success" orientation="vertical" variant="outlined">
          <Link overlay="true" to="/signup" underline="none" sx={mystyle}>
            사용자등록
          </Link>
        </Card>
        <Card color="success" orientation="vertical" variant="outlined">
          <Link overlay="true" to="/todo" underline="none" sx={mystyle}>
            할일등록
          </Link>
        </Card>
        <Card color="success" orientation="vertical" variant="outlined">
          <Link overlay="true" to="/image" underline="none" sx={mystyle}>
            이미지upload
          </Link>
        </Card>
      </Container>
    </div>
  );
}

export default Home;
