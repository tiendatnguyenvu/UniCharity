
import axios from 'axios';


const BASE_URL = import.meta.env.VITE_BASE_URL || 'http://localhost:8080/UniCharity';
const axiosInstance = axios.create({
  baseURL: BASE_URL, 
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json',
    "Set-Cookie": `auth_token=eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJkZXZ0ZXJpYS5jb20iLCJzdWIiOiIxMyIsInJvbGUiOiJ1c2VyIiwiZXhwIjoxNzMxMjM4MDg0LCJpYXQiOjE3MzEyMzQ0ODQsImVtYWlsIjoidGllbmRhdEBnbWFpbC5jb20ifQ.Y-MrqBWUrgwit3GBPW0e0C5Ge6Pl6gdyZKjCOhkAKf9QblNuwH-65lU7mNuYIW2PYF3QPXCUzWItl_5bJWpk3A; Path=/; Secure; HttpOnly
`
  }
});



export default axiosInstance;