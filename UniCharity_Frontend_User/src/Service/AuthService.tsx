import axios from "axios";
import { BASE_URL } from "../Utils/Constant";
import { handleError } from "../Helper/ErrorHandler";
import { AuthenRes } from "../Models/Auth";

export const loginAPI = async (email: string, password: string) => {
    try {

        const data = await axios.post<AuthenRes>(`${BASE_URL}/auth/token`, {
            email, password
        });
        return data;
    } catch (error) {
        handleError(error);
    }
};

export interface DonationPost {
    campaign: string
    amount: string
    email: string
    name: string
  }

