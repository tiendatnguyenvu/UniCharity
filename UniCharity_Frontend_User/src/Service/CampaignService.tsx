import axios from "axios";
import { BASE_URL, CAMPAIGN_API } from "../Utils/Constant";
import { CampaignFormRequest, CampaignGet, CampaignReponse, CampaignRequestRes, CampaignsReponse } from "../Models/Campaign";
import { handleError } from "../Helper/ErrorHandler";

export const CampaignRequest = async (dataPost: CampaignFormRequest) => {
    try {
        const data = await axios.post<CampaignRequestRes>(`${BASE_URL}/campaigns/create-request-campaign`, dataPost);
        return data;
    } catch (error) {
        handleError(error);
    }
};

export const CampaignGetAPI = async (page: number = 1, size: number = 4) => {
    try {
        const data = await axios.get<CampaignsReponse>(CAMPAIGN_API, {
            params: { page, size },
        });
        return data;
    } catch (error) {
        handleError(error);
    }
};

export const CampaignGetByIDAPI = async (idCam: number = 4) => {
    try {
        const data = await axios.get<CampaignReponse>(`${CAMPAIGN_API}/get-by-id/${idCam}`, {
            headers: {
                Authorization: `Bearer ${`eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJkZXZ0ZXJpYS5jb20iLCJzdWIiOiJuZ3V5ZW52YW5hQGV4YW1wbGUuY29tIiwicm9sZSI6ImFkbWluIiwiaWQiOjEsImV4cCI6MTczMjg5MzM1MSwiaWF0IjoxNzMyODg5NzUxfQ.BJT0vuiEhVT4w4SGDBNDfrK9HQkVe6_IDJxYW8Q3DJRnEzkStcTn7ewX5CC72ODTsfg0j7dp-h4_BXhwsX2RnQ`}`
            }
        });
        return data;
    } catch (error) {
        handleError(error);
    }
};

export const CampaignGetByStatusAPI = async (status: string, page: number = 1, size: number = 4) => {
    try {
        const data = await axios.get<CampaignsReponse>(`${CAMPAIGN_API}/get-by-status/${status}`, {
            params: { page, size },
            headers: {
                Authorization: `Bearer ${`eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJkZXZ0ZXJpYS5jb20iLCJzdWIiOiJuZ3V5ZW52YW5hQGV4YW1wbGUuY29tIiwicm9sZSI6ImFkbWluIiwiaWQiOjEsImV4cCI6MTczMjg5MzM1MSwiaWF0IjoxNzMyODg5NzUxfQ.BJT0vuiEhVT4w4SGDBNDfrK9HQkVe6_IDJxYW8Q3DJRnEzkStcTn7ewX5CC72ODTsfg0j7dp-h4_BXhwsX2RnQ`}`
            }
        },);
        return data;
    } catch (error) {
        handleError(error);
    }
};

