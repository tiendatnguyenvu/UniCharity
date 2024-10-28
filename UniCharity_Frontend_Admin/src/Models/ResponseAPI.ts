import { CampaignDto } from "./Campaig"
import { PageObject } from "./Paging"

export type ResponseListCampaign = 
{
  "code":number,
  "result":{
    "page": PageObject,
    "items": CampaignDto[]
  }
}
