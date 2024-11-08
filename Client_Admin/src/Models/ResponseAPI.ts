import { CampaignDto, CreateCampaignDto } from "./Campaign";
import { PageObject } from "./Paginate";

export type ResponseListCampaignAPI = {
  code: number,
  result: {
  items: CampaignDto[] ,
  page: PageObject,

  }
};


export type ResponseCreateCampaignAPI = {
  code: number,
  result: CreateCampaignDto
  
};


