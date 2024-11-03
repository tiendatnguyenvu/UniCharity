/* eslint-disable @typescript-eslint/no-unused-vars */
import React from 'react'
import FormCampaign from './FormCampaign'
import { toast, ToastContainer } from 'react-toastify'
import { CampaignDto, CampaignPostAdminAPI } from '../../../Models/Campaign';
import { useNavigate } from 'react-router';

const CreateCampaign = () => {
  const navigate = useNavigate();

  const handleSubmit = async (
    _formInput: CampaignPostAdminAPI,
    _images: FileList | null
  ) => {
    try {
      console.log(1);
      // CampaignPostAPI(formInput).then(async (res) => {
      //   if (res?.status == 200) {
      //     const campaignId = res.data.result.id;
      //     if (images && images.length > 0 && campaignId) {
      //       await UploadListImagesPostAPI(campaignId, images);
      //     } 
      //     toast.success("Add campaign successfully!");
      //     navigate("/admin/campaigns");
      //   }
      // });
      toast.success("Create Successfully!");
    } catch (error) {
      toast.error("Create Fail!");
    }
  };

  return (
    <div className="custom-container m-4 rounded h-100 p-4">
      <h6 className="mb-4">
        <h1>Create new campaign and policy</h1>
      </h6>
      <FormCampaign handleCampaign={handleSubmit} isUpdate={false} />
    </div>
  );
}

export default CreateCampaign;
