import React from 'react'
import { useNavigate } from 'react-router'
import { CampaignPost } from '../../../models/Campaign';

const InputCampaign = () => {
    const navigate = useNavigate();
    
    const handleSubmit = (formInput: CampaignPost)=>{
        
        useNavigate("/campaigns");
    }
  return (
    <>
    </>
  )
}

export default InputCampaign
