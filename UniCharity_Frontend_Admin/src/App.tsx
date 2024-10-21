import { RouterProvider as Routers } from "react-router-dom";
import "./App.css";
import Router from "./routes/Router";
// import cookie from 'cookie';
import { useEffect } from "react";
import Cookies from "js-cookie";

function App() {
  // useEffect(() => {
  //   console.log("setToken")
  //   const cookies = Cookies.get("token");
  //   if (cookies) {
  //     Cookies.set(
  //       "token","eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJkZXZ0ZXJpYS5jb20iLCJzdWIiOiJuZ3V5ZW5jb25nZHVjMThUSERAZ21haWwuY29tIiwiZXhwIjoxNzI5MzI1MDgyLCJpYXQiOjE3MjkzMjE0ODIsInVzZXJJZCI6MTF9.O-agDalz53ym9zVi-OqsoYWROrdiBT5ORdmiPvEf7dfKXYSIx53p0oWn9Wdv3xt0v6WCBOm5U2C1tAyTwVbf8g"
        
  //     ); // Cookie hết hạn sau 7 ngày
  //   }
  // }, []);
  // Lấy cookie
  return <Routers router={Router} />;
}

export default App;
