import { toast } from "react-toastify";
import axiosInstance from "./axios_instance";
import { CreateCampaignDto } from "../Models/Campaign";
import { ResponseCreateCampaignAPI, ResponseListCampaignAPI } from "../Models/ResponseAPI";

const api = "/campaigns";

export const GetListCampaignByStatus = async (
  status: string,
  page: number = 1,
  limit: number = 5
) => {
  try {
    // const x = `${api}/get-by-status/${status}`;
    // console.log("x:",x);
    const response = await axiosInstance.get<ResponseListCampaignAPI>(
      `${api}/get-by-status/${status}`,
      {
        params: {
          page: page,
          size: limit
        },
      }
    );
    // console.log("response service:", response);
    return response;
  } catch (error) {
    console.log("error", error);
    toast.warning("List empty!");
  }
};

export const GetCampaignById = async (campaignId: string) => {
  try {
    const response = await axiosInstance.get<CreateCampaignDto | null>(
      `${api}/get-by-id/${campaignId}`
    );
    return response.data;
  } catch (error) {
    console.log(error);
    toast.error("Campaign does not exist!");
  }
};


export const CreateCampaignAPI = async (formInput: CreateCampaignDto) => {
  try {
    console.log("into:",formInput)
    const response = await axiosInstance.post<ResponseCreateCampaignAPI>(`${api}/create`,formInput);
    return response;
  } catch (error) {
    console.log(error);
    throw error;
  }
};
