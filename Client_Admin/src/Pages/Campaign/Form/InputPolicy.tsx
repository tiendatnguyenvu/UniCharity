/* eslint-disable @typescript-eslint/no-unused-vars */
/* eslint-disable @typescript-eslint/no-explicit-any */
import React, { useRef, useState } from "react";
import Table from "../../../Components/Table/Table";
import {
  CampaignPolicyDto,
  CampaignPostAdminAPI,
} from "../../../Models/Campaign";
import { UseFormGetValues, UseFormSetValue } from "react-hook-form";

type Props = {
  errors: any;
  register: any;
  initData?: CampaignPostAdminAPI ;
  isUpdate: boolean;
  getValues: UseFormGetValues<CampaignPostAdminAPI>;
  setValue:UseFormSetValue<CampaignPostAdminAPI>;

};
const InputPolicy = ({ register, errors, initData }: Props) => {
  const [policies, setPolicies] = useState<CampaignPolicyDto[] | null>();

  // ref
  const descriptionRef = useRef<HTMLTextAreaElement | null>(null);
  const eligibilityCriteriaRef = useRef<HTMLTextAreaElement | null>(null);

  const handleClearForm = () => {
    if (descriptionRef.current) {
      descriptionRef.current.value = "";
    }
    if (eligibilityCriteriaRef.current) {
      eligibilityCriteriaRef.current.value = "";
    }
  };

  const handleCreatePolicy = () => {};
  const configs = [
    {
      label: "#",
      render: (policy: CampaignPolicyDto, index: number) => index + 1,
    },
    {
      label: "Description",
      render: (policy: CampaignPolicyDto) => policy.policyDescription,
    },
    {
      label: "eligibility Criteria",
      render: (policy: CampaignPolicyDto) => policy.eligibilityCriteria,
    },
    {
      label: "Action",
      render: (policy:CampaignPolicyDto) => <h1>Action</h1>
    },
  ];

  return (
      <div>
      <div className=" rounded h-100 p-4">
        <div className="form-floating mb-3">
          <textarea
            className="form-control"
            //   placeholder="Leave a comment here"
            id="floatingDescription"
            style={{ height: `100px` }}
            ref={descriptionRef}
            // {...register()}
          ></textarea>
          <label htmlFor="floatingDescription">Description</label>
        </div>

        <div className="form-floating mb-3">
          <textarea
            ref={eligibilityCriteriaRef}
            className="form-control"
            //   placeholder="Leave a comment here"
            id="floatingEligibilityCriteria"
            style={{ height: `100px` }}
            // {...register("")}
          ></textarea>
          <label htmlFor="floatingEligibilityCriteria">
            Eligibility Criteria
          </label>
        </div>
        <div className="d-flex">
          <button type="button" className="btn btn-primary rounded-pill m-2">
            Insert policy
          </button>
          <button
            type="button"
            onClick={handleClearForm}
            className="btn btn-danger  rounded-pill m-2"
          >
            Clear form
          </button>
        </div>

        <div className="d-flex justify-content-center align-items-center">
          <h1> List Policies</h1>
        </div>
        {initData &&  <Table data={initData?.policyDtos || []} configs={configs} />}
       
      </div>
    </div>
  );
};

export default InputPolicy;
