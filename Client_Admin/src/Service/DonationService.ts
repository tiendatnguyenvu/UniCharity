import { toast } from "react-toastify";
import { ResponseListDonationAPI } from "../Models/ResponseDonationAPI";
import axiosInstance from "./axios_instance";

const api = "/donation";

export const GetListDonationAPI = async (page:number,limit:number,sort:string)=>
{
try {
    const response = await axiosInstance.get<ResponseListDonationAPI>(api,
        {
            params:
            {
                page: page,
                size: limit,
                sort:sort
            }
        }
    );
    console.log("response list donation api: ", response);
    return response;
} catch (error) {
    toast.warning("erorr:"+error);
}    
}