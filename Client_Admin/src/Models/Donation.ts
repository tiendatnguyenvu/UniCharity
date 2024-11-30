export interface DonationGet{
         id:number;
         amount:number;
         paymentMethod:string;
         donationDate:Date;
         campaign:CampaignSimple;
         user:UserSimple;
      transactions: TransactionSimple[]

    
    
}
export interface CampaignSimple {
    id: number;
    title: string;
    description: string;
    targetAmount: number;
    currentAmount: number;
    createdAt: Date;
    startDate: Date;
    endDate: Date;
    status: string;
  }

  export interface UserSimple {
    id:number;
    name:string;
    email:string;
    phone:string;
    password:string;
    role:string;
}

export interface TransactionSimple {
     id:number;
     transactionCode:string;
     paymentGateway:string;
     transactionDate:Date;
     transactionStatus:string;
     amount:number;
     responseCode:string;
     transactionDescription:string
    }
