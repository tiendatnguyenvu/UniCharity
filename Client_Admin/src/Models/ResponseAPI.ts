import { CampaignDto, CreateCampaignDto } from "./Campaign";
import { ImageGet } from "./Image";
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


export type ResponseListImageByCampaignIdAPI = {
  code:number,
  result: ImageGet[]
}

export type ResponseDeleteImageAPI = {
  code:number,
  result: ImageGet
}

