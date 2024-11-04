import { CampaignDto } from "./Campaign";
import { PageObject } from "./Paging";

export type ResponseListCampaignAPI = {
  code: number,
  result: { items: CampaignDto[] ,
  page: PageObject,

  }
};

