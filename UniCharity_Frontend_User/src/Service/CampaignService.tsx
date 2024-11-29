import axios from "axios";
import { BASE_URL, CAMPAIGN_API } from "../Utils/Constant";
import { CampaignFormRequest, CampaignGet, CampaignReponse, CampaignRequestRes, CampaignsReponse } from "../Models/Campaign";
import { handleError } from "../Helper/ErrorHandler";

const token = "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJkZXZ0ZXJpYS5jb20iLCJzdWIiOiJuZ3V5ZW52YW5hQGV4YW1wbGUuY29tIiwicm9sZSI6ImFkbWluIiwiaWQiOjEsImV4cCI6MTczMTczODUwMywiaWF0IjoxNzMxNzM0OTAzfQ.qVnMOjLqnqpQXFovHcL-W7vepC683A-5cSbVK1mpNyWuFMFzRXYrcrKuVoW069VXRe15JHG_R1ZE-1OGg3wiuQ"
const dataPost = {
    token: token
}

export const IntrospectAPI = async (page: number = 1, size: number = 4) => {
    try {

        const data = await axios.post<boolean>(`${BASE_URL}/auth/introspect`, dataPost);
        return data;
    } catch (error) {
        handleError(error);
    }
};

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
                Authorization: `Bearer ${token}` // Thêm Bearer token vào header
            }
        });
        console.log(data?.data);
        return data;
    } catch (error) {
        handleError(error);
    }
};

export const CampaignGetByStatusAPI = async (status: string, page: number = 1, size: number = 4) => {
    try {
        const data = await axios.get<CampaignsReponse>(`${CAMPAIGN_API}/get-by-status/${status}`, {
            params: { page, size },
        });
        return data;
    } catch (error) {
        handleError(error);
    }
};
