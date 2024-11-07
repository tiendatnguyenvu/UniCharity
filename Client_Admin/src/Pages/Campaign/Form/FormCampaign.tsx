/* eslint-disable @typescript-eslint/no-explicit-any */
/* eslint-disable @typescript-eslint/no-unused-vars */
import { Editor } from "@tinymce/tinymce-react";
import React, { useEffect, useState } from "react";
import * as yup from "yup";
import {
  CampaignDto,
  CampaignPolicyDto,
  CampaignPostAdminAPI,
} from "../../../Models/Campaign";
import "../Campaign.scss";
import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import {
  TAB_CREATE_CAMPAIGN,
  TAB_CREATE_POLICIES,
  TABS_CREATE_CAMPAIGN,
} from "../../../Utils/CampaignConstant";
import CreateCampaign from "./CreateCampaign";
import InputCampaign from "./InputCampaign";
import InputPolicy from "./InputPolicy";
// Props
type Props = {
  handleCampaign: (
    _formInput: CampaignPostAdminAPI,
    _images: FileList | null,
    _Policies: CampaignPolicyDto[] | null
  ) => void;
  initData?: CampaignPostAdminAPI | null;
  isUpdate: boolean;
  id?: string | null;
};
const FormCampaign = ({ handleCampaign, initData, isUpdate, id }: Props) => {
  // console.log("initDataCampaignForm:", initData);
  const [selectedImages, setSelectedImages] = useState<FileList | null>(null);
  const [tab, setTab] = useState(TAB_CREATE_CAMPAIGN);
  const [tabs, setTabs] = useState(TABS_CREATE_CAMPAIGN);
 
  const {
    register,
    handleSubmit,
    formState: { errors },
    setValue,
    getValues,
  } = useForm<CampaignPostAdminAPI>({
    // resolver: yupResolver(schema), // Sử dụng schema đơn giản
    defaultValues: initData || {
      title: "",
      description: "",
      targetAmount: 0,
      currentAmount: 0,
      startDate: Date(),
      endDate: Date(),
      status: "Pending",
      createdBy: 0,
    },
  });

  // console.log(initData);

  // Hàm submit
  const handlePOST = (data: any) => {
    console.log("submit");
    console.log(data);
    console.log(selectedImages);
    // handleCampaign(data, selectedImages);
  };

  // Hàm thay đổi hình ảnh
  const handleImageChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSelectedImages(event.target.files);
  };

  // Hàm thay đổi Editor
  const handleEditorChange = (content: string) => {
    setValue("description", content);
  };

  const handleClickTab = (tab: string) => {
    setTab(tab);
  };

  // handle create policy
  const handleCreatePolicy = () => {};

  const renderLabel = () => {
    const render = tabs.map((item: any, index: number) => {
      return (
        <React.Fragment key={item.title}>
          <input
            type="radio"
            name="pcss3t"
            id={`tab${
              index + 1 === 1
                ? "first"
                : index + 1 === tabs.length
                ? "last"
                : index
            }`}
            className={`tab-content-${
              index + 1 === 1
                ? "first"
                : index + 1 === tabs.length
                ? "last"
                : index
            }`}
            checked={item.title === tab}
          />
          <label
            htmlFor={`tab${
              index + 1 === 1
                ? "first"
                : index + 1 === tabs.length
                ? "last"
                : index
            }`}
            onClick={() => handleClickTab(item.title)}
          >
            <i className="icon-picture"></i>
            <h6>{item.title}</h6>
          </label>
        </React.Fragment>
      );
    });
    render.join("");
    return render;
  };

  const renderContentTabs = () => {
    const render = tabs.map((item: any, _index: number) => {
      return (
        <li
          key={item.id}
          className={` form-create tab-content tab-content-${
            _index == 0
              ? "first"
              : _index == tabs.length - 1
              ? "last"
              : _index + 1
          } typography`}
        >
          <form onSubmit={handleSubmit(handlePOST)}>
            {item.title == TAB_CREATE_CAMPAIGN && (
              // <div className="">campaign</div>
              <InputCampaign
                errors={errors}
                register={register}
                isUpdate={isUpdate}
                getValues={getValues}
                setValue={setValue}
              />
            )}

            <button
              style={{ marginTop: "1.25rem" }}
              type="submit"
              className="btn btn-primary"
            >
              Submit
            </button>
          </form>
          {item.title == TAB_CREATE_POLICIES && (
            <InputPolicy
              isUpdate={isUpdate}
              initData={initData?.policies || []}
            />
          )}
        </li>
      );
    });

    render.join(" ");
    return render;
  };

  return (
    // <div></div>
    <div className=" my-tab">
      <div className=" pcss3t pcss3t-effect-scale pcss3t-theme-4">
        {renderLabel()}
        <ul>{renderContentTabs()}</ul>
      </div>
    </div>
  );
};

export default FormCampaign;
