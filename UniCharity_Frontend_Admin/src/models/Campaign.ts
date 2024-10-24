export type CampaignGet = {
  id: number;
  title: string;
  description: string;
  targetAmount: number;
  currentAmount: number;
  createdAt: Date;
  startDate: Date;
  endDate: Date;
  departmentId: number;
  createdBy: number;
  status: string;
};

export type CampaignPostAdmin = {
  title: string;
  description: string;
  targetAmount: number;
  startDate: Date|null;
  endDate: Date|null;
  createdBy: number;
  status: string;
};


export interface RootCampaignGet {
  code: number;
  result: Result;
}
export interface ResultCampaign {
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