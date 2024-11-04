/* eslint-disable @typescript-eslint/no-unused-vars */
import { useParams } from 'react-router'
import FormCampaign from './FormCampaign'
import { CampaignDto, CampaignPostAdminAPI } from '../../../Models/Campaign'
import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';
import { GetCampaignById } from '../../../Service/CampaignService';

const UpdateCampaign = () => {
  const {id} = useParams();
  const [initData,setInitData] = useState<CampaignPostAdminAPI|null>(null);

  useEffect(()=>{
    GetCampaignById(id!)
    .then((res)=>{
      setInitData(res!);
    })
    .catch(()=>{ toast.error("campaign is not exist!")})
  },[])


  const handleSubmit  =  (data:CampaignPostAdminAPI,images:FileList|null)=>
  {

  } 
  return (
    <div>
     <FormCampaign handleCampaign={handleSubmit} isUpdate={true} initData={initData} id={id}/>
    </div>
  )
}

export default UpdateCampaign
