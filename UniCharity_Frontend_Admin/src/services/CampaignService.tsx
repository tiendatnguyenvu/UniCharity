import axios from "axios";
import { CampaignGet, CampaignPost } from "../models/Campaign";
import { handleError } from "../Helpers/ErrorHandler";

const api = "http://localhost:5173/admin/campaigns";

export const CampaignGetAPI = async () => {
  try {
    const data = await axios.get<CampaignGet[]>(api);
    return data;
  } catch (error) {
    handleError(error)
    
  }
};

export const CampaignUpfateStatusAPI = async (id: number) => {
    try {
        const data = await axios.put(api + "/updateStatus/" + id)
        return data;
    }  catch (error) {
        handleError(error);
    }
}

export const CampaignPostAPI = async (formInput: CampaignPost)=>{
  try{
      const data  = await axios.post<CampaignPost>(api+"/create",formInput)
      return data;
  }catch(error)
  {
    handleError(error);
  }
}
