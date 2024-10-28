import { ResponseListCampaign } from "../Models/ResponseAPI";
import axiosInstance from "./axios_instance";

const api = "/campaigns"

export const GetListCampaignByStatus= async (status:string,page:number = 1,size:number = 5)=>
{
    // page-=1;
    console.log(page)
    try {
        const response = await axiosInstance.get<ResponseListCampaign>(`${api}/get-by-status/${status}`,{
            params:
            {
                page: page,
                size:size,
                // sort:sort
            }
        })
        console.log("data:",response.data);
        return response.data;

    } catch (error) {
        console.log("error",error)
    }
};