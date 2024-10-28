
import axios from 'axios';


const BASE_URL = import.meta.env.VITE_BASE_URL || 'http://localhost:8080/UniCharity';
const axiosInstance = axios.create({
  baseURL: BASE_URL, // Đặt baseURL
  timeout: 10000, // Giới hạn thời gian chờ (tuỳ chọn)
  headers: {
    'Content-Type': 'application/json',
    // Thêm các header khác nếu cần
  }
});



export default axiosInstance;