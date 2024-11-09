import { CampaignDto } from "./Campaign"
import { PageObject } from "./Paginate"

export interface UserReponse {
    code: number
    result: Result
  }
  
  export interface Result {
    items: UserGet[]
    page: PageObject
  }
  
  export interface UserGet {
    id: number
    name: string
    email: string
    phone: string
    password: string
    role: string
    donations: Donation2[]
  }

export interface Donation2 {
    id: number
    amount: number
    paymentMethod: string
    donationDate: string
    campaign: CampaignDto
  }