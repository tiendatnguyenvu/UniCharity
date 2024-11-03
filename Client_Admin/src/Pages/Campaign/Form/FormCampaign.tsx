/* eslint-disable @typescript-eslint/no-explicit-any */
/* eslint-disable @typescript-eslint/no-unused-vars */
import { Editor } from "@tinymce/tinymce-react";
import React, { useState } from "react";
import * as yup from "yup";
import { CampaignDto, CampaignPostAdminAPI } from "../../../Models/Campaign";
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
  handleCampaign: (data: CampaignPostAdminAPI, images: FileList | null) => void;
  initData?: CampaignPostAdminAPI | null;
  isUpdate: boolean;
  id?: string | null;
};
const FormCampaign = ({ handleCampaign, initData, isUpdate, id }: Props) => {
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

  // Hàm submit
  const onSubmit = (data: CampaignPostAdminAPI) => {
    console.log("sent", data);
    // console.log("submit");
    handleCampaign(data, selectedImages);
  };

  // Hàm thay đổi hình ảnh
  const handleImageChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSelectedImages(event.target.files);
  };

  // Hàm thay đổi Editor
  const handleEditorChange = (content: string) => {
    setValue("description", content);
    console.log(getValues());
  };
  // console.log("imageList:", selectedImages);

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
          className={`shadow rounded form-create tab-content tab-content-${
            _index == 0
              ? "first"
              : _index == tabs.length - 1
              ? "last"
              : _index + 1
          } typography`}
        >
           <form onSubmit={handleSubmit(()=>{console.log(1)})}>
          {item.title == TAB_CREATE_CAMPAIGN &&(
            // <div className="">campaign</div>
            <InputCampaign
              errors={errors}
              register={register}
              initData={initData!}
              isUpdate={isUpdate}
              getValues={getValues}
              setValue={setValue}
            />
          
            
          ) 

          
        }

<button
            style={{ marginTop: "1.25rem" }}
            type="submit"
            className="btn btn-primary"
          >
            Submit
          </button>

</form>
          
{item.title == TAB_CREATE_POLICIES &&(
            // <div>policies</div>
            <InputPolicy
              errors={errors}
              register={register}
              isUpdate={false}
              getValues={getValues}
              setValue={setValue}
              initData={initData!}
            />
          )}
        </li>
      );
    });

    render.join(" ");
    console.log(render);
    return render;
  };


  console.dir("register:",{...register("title")})
  return (
    // <div></div>
    <form onSubmit={handleSubmit(onSubmit)}>
      <div className=" my-tab">
        <div className=" pcss3t pcss3t-effect-scale pcss3t-theme-4">
          {renderLabel()}
          <div></div>
          <ul>{renderContentTabs()}</ul>
         
        </div>
      </div>
    </form>
  );
};



export default FormCampaign;
