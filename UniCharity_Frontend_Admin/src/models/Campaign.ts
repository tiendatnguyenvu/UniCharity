export type CampaignGet = {
    campaignId:number,
    title: string,
    description:string,
    targetAmount:number,
    currentAmount:number,
    createdAt:Date,
    startDate:Date,
    endDate:Date,
    departmentId:number,
    createdBy:number,
    image:string,
    status:string
}

export type CampaignPostAdmin = {
    title: string,
    description:string,
    targetAmount:number,
    startDate:Date|null,
    endDate:Date|null,
    createdBy:number,
    status:string
}

// title: "",
// description: "",
// targetAmount: 0, // Đảm bảo là số
// startDate: null,
// endDate: null,
// createdBy: 0,
// status: "pending",