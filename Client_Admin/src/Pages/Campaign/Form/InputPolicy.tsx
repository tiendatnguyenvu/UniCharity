/* eslint-disable @typescript-eslint/no-unused-vars */
/* eslint-disable @typescript-eslint/no-explicit-any */
import React, { useEffect, useRef, useState } from "react";
import Table from "../../../Components/Table/Table";
import {
  CampaignPolicyDto,
  CampaignPostAdminAPI,
} from "../../../Models/Campaign";
import { UseFormGetValues, UseFormSetValue } from "react-hook-form";

type Props = {
  initData: CampaignPolicyDto[];
  isUpdate: boolean;
};
const InputPolicy = ({
  isUpdate,
  initData,
}: Props) => {
  // const [policies, setPolicies] = useState<CampaignPolicyDto[]|[]>(()=>[]);

  // ref
  const descriptionRef = useRef<HTMLTextAreaElement | null>(null);
  const eligibilityCriteriaRef = useRef<HTMLTextAreaElement | null>(null);

  useEffect(() => {
  }, [initData]);

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
      render: (policy: CampaignPolicyDto) => <h1>Action</h1>,
    },
  ];

  // console.log("policiesInitData:--------------------", initData);
  // console.log("policies:--------------------------", policies);
  return (
    <div>
      <div className=" rounded h-100 p-4">
        <div className="form-floating mb-3">
          <textarea
            className="form-control"
              placeholder="Write Description"
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
              placeholder="Write Eligibility Criteria "
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

        {isUpdate && initData && <Table data={initData} configs={configs} />}
        {isUpdate ||  <Table data={initData} configs={configs} />}
      </div>
    </div>
  );
};

export default InputPolicy;
