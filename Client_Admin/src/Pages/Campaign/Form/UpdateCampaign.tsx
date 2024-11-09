/* eslint-disable @typescript-eslint/no-unused-vars */
import { useParams } from "react-router";
import FormCampaign from "./FormCampaign";
import { CampaignDto, CreateCampaignDto } from "../../../Models/Campaign";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import { GetCampaignById } from "../../../Service/CampaignService";

const UpdateCampaign = () => {
  const { id } = useParams();
  const [initData, setInitData] = useState<CreateCampaignDto | null>(null);

  useEffect(() => {
    GetCampaignById(id!)
      .then((res) => {
        // console.log("res Update",res)
        if(res)
        {
        setInitData(res?.result);
        }
      })
      .catch(() => {
        toast.error("campaign is not exist!");
      });
  }, []);

  const handleSubmit = (data: CreateCampaignDto, images: FileList | null) => {};
  console.log("initData Update",initData)
  return (
    <div>
      {initData && (
        <FormCampaign
          handleCampaign={handleSubmit}
          isUpdate={true}
          initData={initData}
          id={id}
        />
      )}
    </div>
  );
};

export default UpdateCampaign;
