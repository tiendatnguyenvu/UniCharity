import { CampaignGet } from "./Campaign";

export type ImageGet = {
  id: number;
  Campaign: CampaignGet;
  imagePath: string;
  imageType: string;
};


export interface RootImageGet {
  code: number;
  result: ResultImageGet[];
}
 export interface ResultImageGet {
  id: number;
  campaign: Campaign;
  imagePath: string;
}
 export interface Campaign {
  id: number;
  title: string;
  description: string;
  targetAmount: number;
  currentAmount: number;
  createdAt: string;
  startDate: string;
  endDate: string;
  createdBy: CreatedBy;
  status: string;
}
export interface CreatedBy {
  id: number;
  name: string;
  email: string;
  phone: string;
  password: string;
  role: string;
}