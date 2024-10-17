import  { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { CampaignPostAdmin } from "../../../models/Campaign";
import {
  CampaignGetByIdAPI,
  CampaignUpdateAPI,
} from "../../../services/CampaignService";
import { toast } from "react-toastify";
import InputCampaign from "./InputCampaign";

const EditCampaign = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [initData, setInitData] = useState<CampaignPostAdmin | null>(null);

  // console.log("Edit campaign");
  useEffect(() => {
    const fetchCampaign = async () => {
      console.log("get by id")
      try {
        if (id) {
          const response = await CampaignGetByIdAPI(id);
          if (response && response?.result) {
            // console.log("response:", response);
            setInitData({
              title: response.result.title,
              description: response.result.description,
              targetAmount: response.result.targetAmount,
              startDate: new Date(response.result.startDate),
              endDate: new Date(response.result.endDate),
              createdBy: response.result.createdBy,
              status: response.result.status,
            });
          }
        }
      } catch (error) {
        toast.error("Failed to fetch campaign details.");
        console.log(error)
      }
    };

    fetchCampaign();
  }, [id]);

  const handleSubmit = async (formInput: CampaignPostAdmin, images: FileList | null ) => {
      try {
        if (id) {
          console.log("start update nè:");
          const response = await CampaignUpdateAPI(id, formInput);
          console.log("response after update: ",response?.data.result);
          toast.success("Campaign updated successfully!");
          navigate("/admin/campaigns");
        }
      } catch (error) {
        toast.warning("Campaign updated fail!");
      }
  }

  return (
    <div>
      <div className="custom-container m-4 rounded h-100 p-4">
        <h6 className="mb-4">Edit Campaign</h6>
        {initData && (
          <InputCampaign
            handleCampaign={handleSubmit}
            initData={initData}
            isUpdate={true}
          />
        )}
      </div>
    </div>
  );
};

export default EditCampaign;
