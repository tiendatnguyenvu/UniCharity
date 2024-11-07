/* eslint-disable @typescript-eslint/no-unused-vars */
import React from 'react'
import FormCampaign from './FormCampaign'
import { toast, ToastContainer } from 'react-toastify'
import { CampaignDto, CampaignPolicyDto, CampaignPostAdminAPI } from '../../../Models/Campaign';
import { useNavigate } from 'react-router';
import { CreateCampaignAPI } from '../../../Service/CampaignService';

const CreateCampaign = () => {
  const navigate = useNavigate();

  const handleSubmit = async (
    _formInput: CampaignPostAdminAPI,
    _images: FileList | null,
    _Policies: CampaignPolicyDto[]|null
  ) => {
    console.log("submit")
    try {
      _formInput = new CampaignPostAdminAPI(_formInput.title,
        _formInput.description,_formInput.targetAmount,
        _formInput.currentAmount,
        _formInput.createdAt,
        _formInput.startDate,
        _formInput.endDate,
        _formInput.status,
        _formInput.createdBy,
        _Policies!
      )

      await CreateCampaignAPI(_formInput).then(async (res) => {
        if (res?.status == 200) {
          toast.success("Add campaign successfully!");
          navigate("/admin/campaigns");
        }
      });
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
