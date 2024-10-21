import Campaign from "../pages/admin/Campaign/Campaign";
import { CampaignGet } from "./Campaign";

export type ImageGet = {
  id: number;
  Campaign: CampaignGet;
  imagePath: string;
  imageType: string;
};
