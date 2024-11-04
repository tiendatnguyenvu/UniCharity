

export interface CampaignPostAdminAPI {
    title: string;
    description: string;
    targetAmount: number;
    currentAmount: number;
    createdAt: string;
    startDate: string;
    endDate: string;
    status: string;
    createdBy: number;
    imageDto: CampaignImageDto[];
    policyDtos: CampaignPolicyDto[];
}

export interface CampaignDto {
    campaignId: number;
    title: string;
    description: string;
    targetAmount: number;
    currentAmount: number;
    createdAt: string;
    startDate: string;
    endDate: string;
    status: string;
    createdBy: number;
    imageDto: CampaignImageDto[];
    policyDtos: CampaignPolicyDto[];
}

export interface CampaignImageDto {
    imageId: number;
    campaignId: number;
    imagePath: string;
    imageType: string;
}

export class CampaignPolicyDto {
    policyId: number;
    campaignId: number;
    policyDescription: string;
    eligibilityCriteria: string;
    approvalRequired: string;
    createdAt: string | null;
    updatedAt: string | null;

  
    constructor( _policyId: number,
        _campaignId: number,
        _policyDescription: string,
        _eligibilityCriteria: string,
        _approvalRequired: string,
        
    ){
            this.policyId = _policyId
            this.campaignId = _campaignId;
            this.policyDescription=_policyDescription;
            this.eligibilityCriteria=_eligibilityCriteria;
            this.approvalRequired = _approvalRequired
            this.createdAt=Date.now().toString();
            this.updatedAt= Date.now().toString();
        }
  
}