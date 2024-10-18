import React, { useEffect, useState } from "react";
import Table from "../../../components/admin/Table/Table";
import { CampaignGet } from "../../../models/Campaign";
import { useNavigate } from "react-router";
import {
  CampaignGetAPI,
  // CampaignUpfateStatusAPI,
} from "../../../services/CampaignService";
import { toast } from "react-toastify";

const Campaign = () => {
  const [campaigns, setCampaigns] = useState<CampaignGet[] | null>(null);
  // const [status,setStatus] = useState<string>("active")

  const navigate = useNavigate();

  useEffect(() => {
    getCampaigns();
  }, []);

  const getCampaigns = () => {
    CampaignGetAPI()
      .then((res) => {
        if (res?.result) {
          setCampaigns(res?.result);
          
        }
      })
      .catch((error) => {
        toast.warning(error);
        setCampaigns([]);
      });
  };
// console.log("list: ",campaigns)
  // const updateStatusAPI = (campaignID: number) => {
  //   CampaignUpfateStatusAPI(campaignID).then((res) => {
  //     if (res?.data) {
  //       // const updateCampaign = campaigns.map((supllier) => {
  //       //   return supllier.campaign_id == res?.data.supplierId
  //       //     ? { ...supllier, status: res?.data.status }
  //       //     : supllier;
  //       // });

  //       setCampaigns(res?.data);
  //     }
  //   });
  // };

  console.log(campaigns)
  const configs = [
    {
      label: "# ",
      render: (campaign: CampaignGet) => campaign.id,
    },
    {
      label: "Title",
      render: (campaign: CampaignGet) => campaign.title,
    },

    {
      label: "Target amount",
      render: (campaign: CampaignGet) => campaign.targetAmount,
    },

    {
      label: "Created date",
      render: (campaign: CampaignGet) => campaign.createdAt,
    },
    {
      label: "Status",
      render: (campaign: CampaignGet) => (
        <td>
          <div className="form-check form-switch">{campaign.status}</div>
        </td>
      ),
    },

    {
      label: "Action",
      render: (campaign: CampaignGet) => {
        return (
          <td className="d-flex">
            <button
              type="button"
              className="btn-sm btn-success d-flex align-items-center me-2"
              onClick={() =>
                navigate(`/admin/campaigns/update/${campaign.id}`)
              }
            >
              Update
            </button>
            <button
              type="button"
              className="btn-sm btn-warning d-flex align-items-center me-2"
              onClick={() =>
                navigate(`/admin/campaigns/get-by-id/${campaign.id}`)
              }
            >
              Detail
            </button>
          </td>
        );
      },
    },
  ];

  return (
    <div>
      {campaigns ? (
        <div className="container-fluid pt-4 px-4">
          <h1 className="py-3">Campaign Management</h1>
          <div className="col-12">
            <div className="rounded custom-container  h-100 p-4">
              <div className="d-flex py-2">
                <h6 className="mb-4">Campaign List</h6>
                <button
                  className="admin-btn-primary ms-auto"
                  onClick={() => {
                    navigate("/admin/campaigns/create");
                  }}
                >
                  Create a new campaign
                </button>
                {/*  */}
              </div>
              <div className="table-responsive"></div>
              <Table data={campaigns} configs={configs} />
            </div>
          </div>
        </div>
      ) : (
        <>Loading</>
      )}
    </div>
  );
};

export default Campaign;
