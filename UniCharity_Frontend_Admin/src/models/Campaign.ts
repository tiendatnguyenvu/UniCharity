export type CampaignGet = {
    campaignId:number,
    title: string,
    description:string,
    targetAmount:number,
    currentAmount:number,
    startDate:Date,
    endDate:Date,
    departmentId:number,
    createdBy:number,
    image:string,
    status:string
}

export type CampaignPost = {
    title: string,
    description:string,
    target_amount:number,
    current_amount:number,
    start_date:Date,
    end_date:Date,
    department_id:number,
    created_by:number,
}