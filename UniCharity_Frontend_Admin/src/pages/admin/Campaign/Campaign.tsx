import React, { useEffect, useState } from "react";
import Table from "../../../components/admin/Table/Table";
import { CampaignGet } from "../../../models/Campaign";
import { useNavigate } from "react-router";
import {
  CampaignGetAPI,
  CampaignUpfateStatusAPI,
} from "../../../services/CampaignService";
import { toast } from "react-toastify";

const Campaign = () => {
  const [campaigns, setCampaigns] = useState<CampaignGet[] | null>(null);

  const navigate = useNavigate();

  useEffect(() => {
    getCampaigns();
  }, []);

  console.log(campaigns);

  const getCampaigns = () => {
    CampaignGetAPI()
      .then((res) => {
        if (res?.data) {
          setCampaigns(res?.data);
          console.log(res?.data);
        }
      })
      .catch((error) => {
        toast.warning(error);
        setCampaigns([]);
      });
  };

  const onStatusChange = (supplierID: number) => {
    updateStatusAPI(supplierID);
  };

  const updateStatusAPI = (campaignID: number) => {
    CampaignUpfateStatusAPI(campaignID).then((res) => {
      if (res?.data) {
        // const updateCampaign = campaigns.map((supllier) => {
        //   return supllier.campaign_id == res?.data.supplierId
        //     ? { ...supllier, status: res?.data.status }
        //     : supllier;
        // });

        setCampaigns(res?.data);
      }
    });
  };

  const configs = [
    {
      label: "#",
      render: (campaign: CampaignGet, index: number) => index + 1,
    },
    {
      label: "campaign's title",
      render: (campaign: CampaignGet) => campaign.title,
    },
    {
      label: "campaign's description",
      render: (campaign: CampaignGet) => campaign.description,
    },
    {
      label: "campaign's target amount",
      render: (campaign: CampaignGet) => campaign.target_amount,
    },
    {
      label: "campaign's current amount",
      render: (campaign: CampaignGet) => campaign.current_amount,
    },
    {
      label: "campaign's start date",
      render: (campaign: CampaignGet) => campaign.start_date,
    },
    {
      label: "campaign's end date",
      render: (campaign: CampaignGet) => campaign.end_date,
    },
    {
      label: "campaign's Status",
      render: (campaign: CampaignGet) => (
        <td>
          <div className="form-check form-switch">{campaign.description}</div>
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
                navigate(`/admin/supplier/edit/${campaign.campaign_id}`)
              }
            >
              {/* <FaPen className='me-2' /> */}
              Update
            </button>
          </td>
        );
      },
    },
  ];

  console.log("campaigns", campaigns);

  return (
    <div>
      {(campaigns) ? (
        (<div className="container-fluid pt-4 px-4">
          <h1 className="py-3">Supplier Management</h1>
          <div className="col-12">
            <div className="rounded custom-container  h-100 p-4">
              <div className="d-flex py-2">
                <h6 className="mb-4">Supplier List</h6>
                <button
                  className="admin-btn-primary ms-auto"
                  onClick={() => {
                    navigate("/admin/supplier/create");
                  }}
                >
                  Create a new supplier
                </button>
              </div>
              <div className="table-responsive"></div>
              <Table data={campaigns} configs={configs} />
            </div>
          </div>
        </div>)
      ) : (
        <>Loading</>
      )}
    </div>
  );
};

export default Campaign;
