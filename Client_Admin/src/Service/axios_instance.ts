
import axios from 'axios';


const BASE_URL = import.meta.env.VITE_BASE_URL || 'http://localhost:8080/UniCharity';
const axiosInstance = axios.create({
  baseURL: BASE_URL, 
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json',
 }
});



export default axiosInstance;