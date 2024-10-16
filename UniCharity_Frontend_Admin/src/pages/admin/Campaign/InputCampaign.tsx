import React, { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import * as yup from "yup";
import { Editor } from "@tinymce/tinymce-react";
import { CampaignPostAdmin } from "../../../models/Campaign";

// Props
type Props = {
  handleCampaign: (data: CampaignPostAdmin, images: FileList | null) => void;
  initData?: CampaignPostAdmin | null;
  isUpdate: boolean;
};

// Định nghĩa schema xác thực với yup
const campaignPostSchema = yup.object().shape({
  title: yup.string().required("Title is required"),
  description: yup.string().required("Description is required"),
  targetAmount: yup
    .number()
    .required("Target amount is required")
    .positive("Target amount must be positive"),
  startDate: yup
    .date()
    .required("Start date is required")
    .min(new Date(), "Start date must be in the future")
    .nullable(),
  endDate: yup
    .date()
    .required("End date is required")
    .min(yup.ref("startDate"), "End date must be after start date")
    .nullable(),
  createdBy: yup
    .number()
    .required("Created by is required")
    .positive("Created by must be a positive number"),
  status: yup.string().required("Status is required"),
});

// Component
const InputCampaign = ({ handleCampaign, initData, isUpdate }: Props) => {
  const [selectedImages, setSelectedImages] = useState<FileList | null>(null);
  const schema= isUpdate ?
   yup.object().shape({
    title: yup.string().required("Title is required"),
    description: yup.string().required("Description is required"),
    targetAmount: yup
      .number()
      .required("Target amount is required")
      .positive("Target amount must be positive"),
    startDate: yup
      .date()
      .nullable(),
    endDate: yup
      .date()
      .nullable(),
    createdBy: yup
      .number()
      .required("Created by is required")
      .positive("Created by must be a positive number"),
    status: yup.string().required("Status is required"),
  }) 
  :
  yup.object().shape({
  title: yup.string().required("Title is required"),
  description: yup.string().required("Description is required"),
  targetAmount: yup
    .number()
    .required("Target amount is required")
    .positive("Target amount must be positive"),
  startDate: yup
    .date()
    .required("Start date is required")
    .min(new Date(), "Start date must be in the future")
    .nullable(),
  endDate: yup
    .date()
    .required("End date is required")
    .min(yup.ref("startDate"), "End date must be after start date")
    .nullable(),
  createdBy: yup
    .number()
    .required("Created by is required")
    .positive("Created by must be a positive number"),
  status: yup.string().required("Status is required"),
});
  const {
    register,
    handleSubmit,
    formState: { errors },
    setValue,
    getValues,
  } = useForm<CampaignPostAdmin>({
    resolver: yupResolver(schema), // Sử dụng schema đơn giản
    defaultValues: initData || {
      title: "",
      description: "description",
      targetAmount: 0,
      startDate: null,
      endDate: null,
      createdBy: 0,
      status: "Pending",
    },
  });

  
  // Hàm submit
  const onSubmit = (data: CampaignPostAdmin) => {
    console.log("sent", data);
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

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <div className="col-sm-12 col-xl-12">
        <div className="bg-light rounded h-100 p-">
          {/* Title */}
          <div className="form-floating mb-3">
            <input
              type="text"
              className={`form-control ${errors.title ? "is-invalid" : ""}`}
              id="title"
              placeholder="Title"
              {...register("title")}
            />
            <label htmlFor="floatingInput">Title</label>
            {errors.title && (
              <div className="invalid-feedback">{errors.title.message}</div>
            )}
          </div>

          {/* Target Amount */}
          <div className="form-floating mb-3">
            <input
              type="number"
              className={`form-control ${
                errors.targetAmount ? "is-invalid" : ""
              }`}
              id="targetAmount"
              placeholder="Target amount"
              {...register("targetAmount")}
              disabled={isUpdate}
            />
            <label htmlFor="targetAmount">Target amount</label>
            {errors.targetAmount && (
              <div className="invalid-feedback">
                {errors.targetAmount.message}
              </div>
            )}
          </div>

          {/* Created By */}
          <div className="form-floating mb-3">
            <input
              type="number"
              className={`form-control ${errors.createdBy ? "is-invalid" : ""}`}
              id="createBy"
              placeholder="Created by"
              disabled={isUpdate}
              {...register("createdBy")}
            />
            <label htmlFor="createBy">Created by</label>
            {errors.createdBy && (
              <div className="invalid-feedback">{errors.createdBy.message}</div>
            )}
          </div>

          {/* Start Date */}
          {/* create */}
          {!isUpdate && (
            <div className="form-floating mb-3">
              <input
                type="date"
                className={`form-control ${
                  errors.startDate ? "is-invalid" : ""
                }`}
                // className="form-control"
                id="startDate"
                placeholder="Start date"
                {...register("startDate")}
              />
              <label htmlFor="startDate">Start date</label>
              {errors.startDate && (
                <div className="invalid-feedback">
                  {errors.startDate.message}
                </div>
              )}
            </div>
          )}

          {/* End Date */}
          {!isUpdate && (
            <div className="form-floating mb-3">
              <input
                type="date"
                // className={`form-control ${errors.endDate ? "is-invalid" : ""}`}
                className="form-control"
                id="endDate"
                placeholder="End date"
                {...register("endDate")}
              />
              <label htmlFor="endDate">End date</label>
              {/* {errors.endDate && (
              <div className="invalid-feedback">{errors.endDate.message}</div>
            )} */}
            </div>
          )}

          {/* Input File for Multiple Images */}
          <div className="mb-3">
            <label htmlFor="formFileMultiple" className="form-label">
              Multiple images input
            </label>
            <input
              id="formFileMultiple"
              type="file"
              multiple
              accept="image/*"
              onChange={handleImageChange}
            />
          </div>

          {/* Word Component for Description */}
          <div className="bg-light rounded h-100 p-">
            <label className="form-label">Description</label>
            <Editor
              apiKey="bjvro15xzp578awed76jjd439yuuldwig8ojluroj18stkik"
              init={{
                height: 400,
                menubar: false,
                toolbar_mode: "floating",
                plugins: "image link",
                toolbar: "undo redo | bold italic | image | link",
              }}
              initialValue={initData?.description || ""}
              onEditorChange={handleEditorChange}
            />
          </div>

          {/* Status */}
          <div className="form-floating mb-3">
            <select
              className="form-select"
              id="floatingSelect"
              aria-label="Floating label select example"
              {...register("status")}
            >
              <option value="Cancel" style={{ color: "red" }}>
                Cancel
              </option>
              <option value="Pending">Pending</option>
              <option value="Active">Active</option>
              <option value="Complete">Complete</option>
            </select>
            <label htmlFor="floatingSelect">Status</label>
          </div>

          {/* Submit Button */}
          <button
            style={{ marginTop: "20px" }}
            type="submit"
            className="admin-btn-primary"
          >
            Submit
          </button>
        </div>
      </div>
    </form>
  );
};

export default InputCampaign;
