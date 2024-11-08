/* eslint-disable @typescript-eslint/no-unused-vars */
import { useParams } from "react-router";
import FormCampaign from "./FormCampaign";
import { CampaignDto, CampaignPostAdminAPI } from "../../../Models/Campaign";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import { GetCampaignById } from "../../../Service/CampaignService";
import { ResponseGetCampaignUpdaytAPI } from "../../../Models/ResponseAPI";

const UpdateCampaign = () => {
  const { id } = useParams();
  const [response, setResponse] = useState<ResponseGetCampaignUpdaytAPI | null>(
    null
  );
  const [data, setData] = useState<CampaignPostAdminAPI | null>(null);

  useEffect(() => {
    GetCampaignById(id!)
      .then((res) => {
        if (res) {
          setResponse(res!.data);
          setData(res.data!.result);
        }
      })
      .catch(() => {
        toast.error("campaign is not exist!");
      });
  }, []);

  const handleSubmit = (
    data: CampaignPostAdminAPI,
    images: FileList | null
  ) => {

    toast.success("yess");
  };
  return (


<div className="custom-container m-4 rounded h-100 p-4">
      <h6 className="mb-4">
        <h1>Update  campaign and policy</h1>
      </h6>
      {( data && (
      <div>
           <div className="col-sm-12 col-xl-12 shadow rounded">
           <div className=" rounded h-100 p-4">
           <FormCampaign
          handleCampaign={handleSubmit}
          isUpdate={true}
          initData={data}
          id={id}
        />
           </div>
           </div>

       
      </div>
    ))}
    </div>

   
  );
};

export default UpdateCampaign;
