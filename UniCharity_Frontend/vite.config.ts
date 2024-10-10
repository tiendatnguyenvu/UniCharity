import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
})


export default defineConfig({
  server: {
    host: '0.0.0.0', // Địa chỉ IP mà bạn muốn sử dụng
    port: 3000 // Bạn cũng có thể thay đổi port nếu cần
  }
})