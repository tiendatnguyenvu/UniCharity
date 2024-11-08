import axios from "axios"
import { CampaignGet, CampaignReponse, CampaignsReponse } from "../Models/Campaign"
import { CAMPAIGN_API } from "../Utils/Constant"
import { handleError } from "../Helper/ErrorHandler"

export const CampaignGetAPI = async (page: number = 1, size: number = 4) => {
    try {
        const data = await axios.get<CampaignsReponse>(CAMPAIGN_API, {
            params: { page, size }
        })
        return data;
    } catch (error) {
        handleError(error)
    }
}


export const CampaignGetByIDAPI = async (idCam: number = 4) => {
    try {
        const data = await axios.get<CampaignReponse>(`${CAMPAIGN_API}/get-by-id/${idCam}`)
        console.log(data?.data);
        return data;
    } catch (error) {
        handleError(error)
    }
}


export const CampaignGetByStatusAPI = async (status: string, page: number = 1, size: number = 4) => {
    try {
        
        const data = await axios.get<CampaignsReponse>(`${CAMPAIGN_API}/get-by-status/${status}`, {
            params: { page, size }
        })
        return data;
    } catch (error) {
        handleError(error)
    }
}