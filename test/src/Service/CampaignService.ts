import { toast } from "react-toastify";
import { ResponseGetCampaignUpdaytAPI, ResponseListCampaignAPI } from "../Models/ResponseAPI";
import axiosInstance from "./axios_instance";
import { CampaignPostAdminAPI } from "../Models/Campaign";

const api = "/campaigns";

export const GetListCampaignByStatus = async (
  status: string,
  page: number ,
  limit: number 
) => {
  
  try {
    const response = await axiosInstance.get<ResponseListCampaignAPI>(
      `${api}/get-by-status/${status}`,
      {
        params: {
          page: page,
          size: limit,
        },
      }
    );
    return response;
  } catch (error) {
    console.log("error", error);
  }
};

export const GetCampaignById = async (campaignId: string) => {
  try {
    const response = await axiosInstance.get<ResponseGetCampaignUpdaytAPI| null>(
      `${api}/get-by-id/${campaignId}`
    );
    // console.log("response",response)
    return response;
  } catch (error) {
    console.log(error);
    toast.error("Campaign does not exist!");
  }
};

export const CreateCampaignAPI = async (formInput: CampaignPostAdminAPI) => {
  try {
    const response  = await axiosInstance.post(`${api}/create`,formInput);
    console.log(response);
    return response;
  } catch (error) {
    
    console.log(error)
  }
}
