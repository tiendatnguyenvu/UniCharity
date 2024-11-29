import { PageObject } from "./Paginate"

export interface ReportRoot {
    code: number
    result: ReportResult
  }
  
  export interface ReportResult {
    items: ReportItem[]
    page: PageObject
  }
  
  export interface ReportItem {
    id: number
    totalDonations: number
    totalRecipients: number
    resultsSummary: string
    lessonsLearned: string
    reportDate: string
    createdAt: string
    updatedAt: string
    campaign: ReportCampaign
    fundAllocations: ReportFundAllocation[]
  }
  
  export interface ReportCampaign {
    id: number
    title: string
    description: string
    targetAmount: number
    currentAmount: number
    createdAt: string
    startDate: string
    endDate: string
    status: string
  }
  
  export interface ReportFundAllocation {
    id: number
    category: string
    amount: number
    description: string
    createdAt: string
    report: Report
    user: ReportUser
  }
  
  export interface ReportReport {
    id: number
    totalDonations: number
    totalRecipients: number
    resultsSummary: string
    lessonsLearned: string
    reportDate: string
    createdAt: string
    updatedAt: string
  }
  
  export interface ReportUser {
    id: number
    name: string
    email: string
    phone: string
    password: string
    role: string
  }
  
  export interface ReportPage {
    totalItem: number
    currentPage: number
    totalPages: number
    pageSize: number
  }
  