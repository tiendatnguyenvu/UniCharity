import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import { toast } from "react-toastify";
// import "./CampaignTab.scss";
import { CampaignDto } from "../../Models/Campaig";
import { GetListCampaignByStatus } from "../../Service/CampaignService";
import { ResponseListCampaign } from "../../Models/ResponseAPI";
import Table from "../../Components/Table/Table";
import {
  CAMPAIGN_STATUS,
  LIMIT_CAMPAIGN,
  PAGE_CAMPAIGN,
  STATUS_ACTIVE,
  STATUS_CANCLE,
  STATUS_COMPLETE,
  STATUS_PENDING,
} from "../../Utils/CampaignConstant";
import { PageObject } from "../../Models/Paging";
import Paging from "../../Components/Paging/Paging";
import CampaignTab from "./CampaignTab";
const Campaign = () => {
  const [response, setRespnse] = useState<ResponseListCampaign | null>(null);
  const [campaigns, setCampaigns] = useState<CampaignDto[] | null>(null);
  const [pageObject, setPageObject] = useState<PageObject|null>();
  const [tabs, setTabs] = useState(CAMPAIGN_STATUS);

  const [status, setStatus] = useState(STATUS_PENDING);

  const navigate = useNavigate();

  useEffect(() => {
    setStatus(STATUS_PENDING);
    getListCampaigns(STATUS_PENDING);
    setTabs(CAMPAIGN_STATUS);
  }, []);

  useEffect(() => {
    getListCampaigns(status);
  }, [status]);
  const renderContenTabs = () => {
    const render = tabs.map((item, index: number) => {
      return (
        <li
          key={index}
          className={`shadow tab-content tab-content-${
            index == 0 ? "first" : index == tabs.length - 1 ? "last" : index + 1
          } typography`}
        >
          {campaigns && (
            <div>
              {" "}
              <Paging
                currentPage={pageObject?.currentPage!}
                onPageChange={handlePageChange}
                pageSize={pageObject?.pageSize!}
                totalItems={pageObject?.totalItems!}
                totalPages={pageObject?.totalPages!}
              />
              <Table data={campaigns} configs={configs} />
            </div>
          )}
        </li>
      );
    });

    // render.join(" ");
    console.log(render);
    return render;
  };

  const handleClickTab = (tab: string) => {
    setStatus(tab);
  };
  const getListCampaigns = (
    status: string,
    page: number = PAGE_CAMPAIGN,
    size: number = LIMIT_CAMPAIGN
  ) => {
    GetListCampaignByStatus(status, page, size)
      .then((res) => {
        if (res?.result.items) {
          setRespnse(res);
          setCampaigns(res?.result.items);
          setPageObject(res?.result.page);  
        }
      })
      .catch((error) => {
        toast.warning(error);
        setRespnse(null);
        setCampaigns(null);
        setPageObject(null);
      });
  };

  const handlePageChange = (pageNumber: number) => {
    GetListCampaignByStatus(status, pageNumber, LIMIT_CAMPAIGN)
      .then((res) => {
        if (res?.result.items) {
          setRespnse(res);
          setCampaigns(res?.result.items);
          // setPageObject(res?.result.page);
        }
      })
      .catch((error) => toast.error(error));
  };
  console.log("campaign", campaigns);
  const configs = [
    {
      label: "# ",
      render: (campaign: CampaignDto) => campaign.id,
    },
    {
      label: "Title",
      render: (campaign: CampaignDto) => {
        if (campaign.title.length > 20)
          return campaign.title.slice(0, 10) + "...";
        return campaign.title;
      },
    },

    {
      label: "Target amount",
      render: (campaign: CampaignDto) => campaign.targetAmount,
    },
    {
      label: "Current amount",
      render: (campaign: CampaignDto) => campaign.currentAmount,
    },

    {
      label: "Created date",
      render: (campaign: CampaignDto) => campaign.createdAt,
    },
    {
      label: "Start",
      render: (campaign: CampaignDto) => campaign.startDate,
    },
    {
      label: "End ",
      render: (campaign: CampaignDto) => campaign.endDate,
    },
    {
      label: "Status",
      render: (campaign: CampaignDto) => (
        <td>
          <div className="form-check form-switch">{campaign.status}</div>
        </td>
      ),
    },
    {
      label: "Action",
      render: (campaign: CampaignDto) => {
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
      <div className="container-fluid pt-4 px-4">
        <h1 className="py-3">Campaign Management</h1>
        <div className="col-12">
          <div className=" shadow rounded bg-light custom-container  h-100 p-4">
            <div className="d-flex py-2">
              <button
                className="btn btn-primary ms-auto"
                onClick={() => {
                  navigate("/admin/campaigns/create");
                }}
              >
                Create a new campaign
              </button>
            </div>
            <div className="bg-light rounded  table-responsive"></div>
            {campaigns ? (

              <div>
                {" "}
                <div className="shadow-lg rounded my-tab">
                  <div className=" pcss3t pcss3t-effect-scale pcss3t-theme-1">
                    <input
                      type="radio"
                      name="pcss3t"
                      id="tab1"
                      className="tab-content-first"
                      checked={status === STATUS_PENDING}
                    />
                    <label
                      htmlFor="tab1"
                      onClick={() => handleClickTab(STATUS_PENDING)}
                    >
                      <i className="icon-bolt"></i>
                      <h6>{STATUS_PENDING}</h6>
                    </label>

                    <input
                      type="radio"
                      name="pcss3t"
                      id="tab2"
                      className="tab-content-2"
                    />
                    <label
                      htmlFor="tab2"
                      onClick={() => handleClickTab(STATUS_ACTIVE)}
                    >
                      <i className="icon-picture"></i>
                      <h6>{STATUS_ACTIVE}</h6>
                    </label>

                    <input
                      type="radio"
                      name="pcss3t"
                      id="tab3"
                      className="tab-content-3"
                    />
                    <label
                      htmlFor="tab3"
                      onClick={() => handleClickTab(STATUS_COMPLETE)}
                    >
                      <i className="icon-cogs"></i>
                      <h6>{STATUS_COMPLETE}</h6>
                    </label>

                    <input
                      type="radio"
                      name="pcss3t"
                      id="tab5"
                      className="tab-content-last"
                    />
                    <label
                      htmlFor="tab5"
                      onClick={() => handleClickTab(STATUS_CANCLE)}
                    >
                      <i className="icon-globe"></i>
                      <h6>{STATUS_CANCLE}</h6>
                    </label>
                    <ul>{renderContenTabs()}</ul>
                  </div>
                </div>
              </div>
            ) : (
              <h1>Loading...</h1>
            )}
          </div>
        </div>
      </div>
      {/* {Campaign   ( */}
    </div>
  );
};

export default Campaign;
