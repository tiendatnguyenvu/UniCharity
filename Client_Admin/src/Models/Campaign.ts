import { User } from "./User";


export class CreateCampaignDto {
    id:number;
    title: string;
    description: string;
    targetAmount: number;
    currentAmount: number;
    createdAt: Date|null;
    startDate: Date|null;
    endDate: Date|null;
    status: string;
    createdBy: number;
    policies: CampaignPolicyDto[];
    

    constructor(
        _title: string,
        _description: string,
        _targetAmount: number,
        _currentAmount: number,
        _createdAt: Date|null,
        _startDate: Date|null,
        _endDate: Date|null,
        _status: string,
        _createdBy: number,
        _policiesDtos: CampaignPolicyDto[]
    ) {
        this.id  = 0;
        this.title = _title;
        this.description= _description;
        this.targetAmount=_targetAmount;
        this.currentAmount=_currentAmount;
        this.createdAt=_createdAt;
        this.startDate=_startDate;
        this.endDate=_endDate;
        this.status=_status;
        this.createdBy=_createdBy;
        this.policies=_policiesDtos;
        
    }
}

export class UpdateCampaignDto {
    id:number;
    title: string;
    description: string;
    targetAmount: number;
    currentAmount: number;
    createdAt: Date|null;
    startDate: Date|null;
    endDate: Date|null;
    status: string;
    createdBy: User;
    policyCreateRequests: CampaignPolicyDto[];
    

    constructor(
        _title: string,
        _description: string,
        _targetAmount: number,
        _currentAmount: number,
        _createdAt: Date|null,
        _startDate: Date|null,
        _endDate: Date|null,
        _status: string,
        _createdBy: User,
        _policiesDtos: CampaignPolicyDto[]
    ) {
        this.id  = 0;
        this.title = _title;
        this.description= _description;
        this.targetAmount=_targetAmount;
        this.currentAmount=_currentAmount;
        this.createdAt=_createdAt;
        this.startDate=_startDate;
        this.endDate=_endDate;
        this.status=_status;
        this.createdBy=_createdBy;
        this.policyCreateRequests=_policiesDtos;
        
    }
}


export class UploadListImageDto{
    fileImages: FileList |null
    constructor(fileImages: FileList | null ) {
        this.fileImages = fileImages;
    }
}
export interface CampaignDto {
    id: number;
    title: string;
    description: string;
    targetAmount: number;
    currentAmount: number;
    createdAt: Date;
    startDate: Date;
    endDate: Date;
    status: string;
    createdBy: User;
    policies: CampaignPolicyDto[];
    images:[];
    campaignReports:[];
    donations:[]
}


export interface GetCampaignDto {
    id: number;
    title: string;
    description: string;
    targetAmount: number;
    currentAmount: number;
    createdAt: Date;
    startDate: Date;
    endDate: Date;
    status: string;
    createdBy: number;
    policiesDtos: CampaignPolicyDto[];
}
export interface CampaignFormFiles {
    imageId: number;
    campaignId: number;
    imagePath: string;
    imageType: string;
}

export class CampaignPolicyDto {
        campaign: number;
        policyDescription: string;
        eligibilityCriteria: string;
        approvalRequired: string;
        createdAt: Date | null;
        updatedAt: Date | null;

  
    constructor( 
        
        _policydescription: string,
        _eligibilityCriteria: string,
        _approvalRequired: string,
        
    ){
            this.campaign = 0;
            this.policyDescription=_policydescription;
            this.eligibilityCriteria=_eligibilityCriteria;
            this.approvalRequired = _approvalRequired
            this.createdAt=new Date();
            this.updatedAt= new Date();
        }
  
}