import React from "react";
import InputCampaign from "./InputCampaign";
import { useNavigate } from "react-router";
import {  CampaignPostAdmin } from "../../../models/Campaign";
import { CampaignPostAPI } from "../../../services/CampaignService";
import { toast } from "react-toastify";
import { handleError } from "../../../Helpers/ErrorHandler";

const FormCampaign = () => {
const navigate = useNavigate();

const handleSubmit = async (formInput:CampaignPostAdmin, images: FileList |null) => {

  try {
    const response = await CampaignPostAPI(formInput);

    console.log(response?.data)
    if(response && response.data)
    {
      // const campaignId =response.data;
      // console.log(response.data)
      // if(images && images.length > 0 && campaignId)
      // {

      // }

    }

    
  } catch (error) {
    handleError(error)
    
  }
  CampaignPostAPI(formInput)
  .then((res)=>{
    if(res?.status == 200)
    {
      toast.success("Add campaign successfully!");
      navigate("/admin/campaigns")
    }
  })
}

  return (
    <div className="custom-container m-4 rounded h-100 p-4">
      <h6 className="mb-4"><h1>Add a new campaign</h1></h6>
      <InputCampaign handleCampaign={handleSubmit}/>
    </div>
  );
};

export default FormCampaign;
