export type CampaignGet = {
    campaign_id:number,
    title: string,
    description:string,
    target_amount:number,
    current_amount:number,
    start_date:Date,
    end_date:Date,
    department_id:number,
    created_by:number,
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