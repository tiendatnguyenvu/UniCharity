import axios from "axios";
import { BASE_URL } from "../Utils/Constant";
import { handleError } from "../Helper/ErrorHandler";
import { AuthenRes } from "../Models/Auth";

const dataLogin = {
    email: "nguyenvana@example.com",
    password: "password123"
}

export const loginAPI = async (email: string, password: string) => {
    try {

        const data = await axios.post<AuthenRes>(`${BASE_URL}/auth/token`, {
            email, password
        });
        return data;
    } catch (error) {
        handleError(error);
        console.log(error);
    }
};