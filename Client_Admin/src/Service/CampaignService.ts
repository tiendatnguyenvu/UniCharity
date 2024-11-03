import { toast } from "react-toastify";
import { ResponseListCampaignAPI } from "../Models/ResponseAPI";
import axiosInstance from "./axios_instance";
import {  CampaignPostAdminAPI } from "../Models/Campaign";

const api = "/campaigns";

export const GetListCampaignByStatus = async (
  status: string,
  page: number = 1,
  limit: number = 5
) => {
  try {
    const x = `${api}/get-by-status/${status}`;
    console.log("x:",x);
    const response = await axiosInstance.get<ResponseListCampaignAPI>(
      `${api}/get-by-status/${status}`,
      {
        params: {
          page: page,
          size: limit,
        },
      }
    );
    console.log("data:", response.data);
    return response.data;
  } catch (error) {
    console.log("error", error);
  }
};

export const GetCampaignById = async (campaignId: string) => {
  try {
    const response = await axiosInstance.get<CampaignPostAdminAPI | null>(
      `${api}/get-by-id/${campaignId}`
    );
    return response.data;
  } catch (error) {
    console.log(error);
    toast.error("Campaign does not exist!");
  }
};
