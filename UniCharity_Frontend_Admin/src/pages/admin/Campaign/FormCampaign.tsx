import React from "react";
import InputCampaign from "./InputCampaign";
import { useNavigate } from "react-router";
import { CampaignPostAdmin } from "../../../models/Campaign";
import { CampaignPostAPI } from "../../../services/CampaignService";
import { toast } from "react-toastify";
import { handleError } from "../../../Helpers/ErrorHandler";
import {
  UploadListImagesPostAPI,
} from "../../../services/ImageService";

const FormCampaign = () => {
  const navigate = useNavigate();

  const handleSubmit = async (
    formInput: CampaignPostAdmin,
    images: FileList | null
  ) => {
    try {
      CampaignPostAPI(formInput).then(async (res) => {
        if (res?.status == 200) {
          console.log("res:", res);
          console.log("id", res.data.result.id);
          const campaignId = res.data.result.id;
          if (images && images.length > 0 && campaignId) {
            console.log("images",images)
             const imageResponse =await UploadListImagesPostAPI(campaignId, images);
             console.log("images:",imageResponse);
          } 
          // ImagesCampaignPostAPI(campaignId, images);

          toast.success("Add campaign successfully!");
          navigate("/admin/campaigns");
        }
      });
    } catch (error) {
      handleError(error);
    }
  };

  return (
    <div className="custom-container m-4 rounded h-100 p-4">
      <h6 className="mb-4">
        <h1>Add a new campaign</h1>
      </h6>
      <InputCampaign handleCampaign={handleSubmit} isUpdate={false} />
    </div>
  );
};

export default FormCampaign;
