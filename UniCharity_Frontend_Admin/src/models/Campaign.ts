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
