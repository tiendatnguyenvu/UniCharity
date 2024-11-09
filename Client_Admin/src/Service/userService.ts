import { toast } from "react-toastify";
import { ResponseListCampaignAPI } from "../Models/ResponseAPI";
import axiosInstance from "./axios_instance";
import { UserReponse } from "../Models/User";

const api = "/users";

export const UserGetAPI = async (page: number = 1, size: number = 5) => {
    try {
        const data = await  axiosInstance.get<UserReponse>(
            `${api}`,
            {
              params: { page, size },
            }
          );

          return data;
    } catch (error) {
        console.log(error);
        toast.error("Campaign does not exist!");
    }
}