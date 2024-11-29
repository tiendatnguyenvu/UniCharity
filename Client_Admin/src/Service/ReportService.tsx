import { CreateReportDto, ResponseCreateReport } from "../Models/Report";
import { PAGE_REPORT, SIZE_REPORT } from "../Utils/ReportConstant";
import axiosInstance from "./axios_instance";

const api = "/campaign_reports";

export const getAllReportAPI=async (page:number=PAGE_REPORT,size:number = SIZE_REPORT)=>{
    try {
        const response  = await axiosInstance.get(api,{
            params:{
                page: page,
                size:size
            }
        });
        return response;
    } catch (error) {
        console.log(error+"")
    }
}

export const getAllReportByCampaignIdAPI=async (campaignId:number,page:number=PAGE_REPORT,size:number = SIZE_REPORT)=>{
    try {
        const response  = await axiosInstance.get(api+``,{
            params:{
                page: page,
                size:size
            }
        });
        return response;
    } catch (error) {
        console.log(error+"")
    }
}


export const CreateReportAPI=async (data:CreateReportDto)=>{
    try {
        const response  = await axiosInstance.post<ResponseCreateReport>(api+`/create`,data);
        return response;
    } catch (error) {
        console.log(error+"")
    }
}