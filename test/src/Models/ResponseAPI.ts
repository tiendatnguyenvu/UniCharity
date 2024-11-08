import { CampaignDto, CampaignPostAdminAPI } from "./Campaign";
import { PageObject } from "./Paging";

export type ResponseListCampaignAPI = {
  code: number,
  result: {
  items: CampaignDto[] ,
  page: PageObject,

  }
};


export type ResponseGetCampaignUpdaytAPI = {
  code: number,
  result: CampaignPostAdminAPI
  
};


