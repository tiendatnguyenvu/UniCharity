import React, { useState } from "react";
import { useNavigate } from "react-router";
import * as yup from "yup";
import { CampaignPostAdmin } from "../../../models/Campaign";
import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { Editor } from "@tinymce/tinymce-react";

type Props = {
  handleCampaign: (data: CampaignPostAdmin, images: FileList | null) => void;
  initData?: CampaignPostAdmin | null;
};

// Định nghĩa schema xác thực với yup
export const campaignPostSchema = yup.object().shape({
  title: yup.string().required("Title is required"),
  description: yup.string().required("Description is required"),
  targetAmount: yup
    .number()
    .required("Target amount is required")
    .positive("Target amount must be positive"),
  startDate: yup
    .date()
    .required("Start date is required")
    .nullable()
    .min(new Date(), "Start date must be in the future"),
  endDate: yup
    .date()
    .required("End date is required")
    .nullable()
    .min(yup.ref("startDate"), "End date must be after start date"),
  createdBy: yup
    .number()
    .required("Created by is required")
    .positive("Created by must be a positive number"),
  status: yup.string().required("Status is required"),
});

const InputCampaign = ({ handleCampaign, initData }: Props) => {
  const [selectedImages, setSelectedImages] = useState<FileList | null>(null);
  const {
    register,
    handleSubmit,
    formState: { errors },
    setValue, // Để cập nhật giá trị cho description từ Editor
  } = useForm<CampaignPostAdmin>({
    resolver: yupResolver(campaignPostSchema),
    defaultValues: initData || {
      title: "",
      description: "",
      targetAmount: 0,
      startDate: null,
      endDate: null,
      createdBy: 0,
      status: "Pending",
    },
  });

  // hàm submit
  const onSubmit = (data: CampaignPostAdmin) => {
    // const formattedData = {
    //   ...data,
    //   startDate: data.startDate ? new Date(data.startDate).toISOString().split("T")[0] : null,
    //   endDate: data.endDate ? new Date(data.endDate).toISOString().split("T")[0] : null,
    // };
  
    console.log("xử lý");
    console.log(data)
    handleCampaign(data, selectedImages);
    
  };

  const handleImageChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSelectedImages(event.target.files);
  };

  const handleEditorChange = (content: string) => {
    setValue("description", content); // Cập nhật giá trị cho description
  };

  return (
    <form onSubmit={handleSubmit((onSubmit))}>
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
              className={`form-control ${errors.targetAmount ? "is-invalid" : ""}`}
              id="targetAmount"
              placeholder="Target amount"
              {...register("targetAmount")}
            />
            <label htmlFor="targetAmount">Target amount</label>
            {errors.targetAmount && (
              <div className="invalid-feedback">{errors.targetAmount.message}</div>
            )}
          </div>

          {/* Created By */}
          <div className="form-floating mb-3">
            <input
              type="number"
              className={`form-control ${errors.createdBy ? "is-invalid" : ""}`}
              id="createBy"
              placeholder="Created by"
              {...register("createdBy")}
            />
            <label htmlFor="createBy">Created by</label>
            {errors.createdBy && (
              <div className="invalid-feedback">{errors.createdBy.message}</div>
            )}
          </div>

          {/* Start Date */}
          <div className="form-floating mb-3">
            <input
              type="date"
              className={`form-control ${errors.startDate ? "is-invalid" : ""}`}
              id="startDate"
              placeholder="Start date"
              {...register("startDate")}
            />
            <label htmlFor="startDate">Start date</label>
            {errors.startDate && (
              <div className="invalid-feedback">{errors.startDate.message}</div>
            )}
          </div>

          {/* End Date */}
          <div className="form-floating mb-3">
            <input
              type="date"
              className={`form-control ${errors.endDate ? "is-invalid" : ""}`}
              id="endDate"
              placeholder="End date"
              {...register("endDate")}
            />
            <label htmlFor="endDate">End date</label>
            {errors.endDate && (
              <div className="invalid-feedback">{errors.endDate.message}</div>
            )}
          </div>

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
                plugins: [
                  "advlist autolink lists link image charmap print preview anchor",
                  "searchreplace visualblocks code fullscreen",
                  "insertdatetime media table paste code help wordcount",
                ],
                toolbar:
                  "undo redo | formatselect | bold italic backcolor | " +
                  "alignleft aligncenter alignright alignjustify | " +
                  "bullist numlist outdent indent | removeformat | help",
              }}
              onEditorChange={handleEditorChange} // Cập nhật giá trị mô tả khi thay đổi
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
