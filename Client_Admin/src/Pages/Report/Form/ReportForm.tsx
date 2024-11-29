import React from "react";
import { useForm } from "react-hook-form";
import { toast } from "react-toastify";
import * as Yup from "yup"; // Import Yup
import { yupResolver } from "@hookform/resolvers/yup"; // Import Yup Resolver
import { CreateReport } from "../../../Models/Report";

type Props = {
  handle : (data:CreateReport)=>void
}
const ReportForm = ({handle}:Props) => {
  // Schema validation với Yup
  const schema = Yup.object().shape({
    campaignId: Yup.string()
      .required("Campaign ID is required")
      .matches(/^\d+$/, "Campaign ID must be a number"),
    total_donations: Yup.number()
      .typeError("Total donations must be a number")
      .required("Total donations are required"),
    total_recipients: Yup.number()
      .typeError("Total recipients must be a number")
      .required("Total recipients are required"),
    results_summary: Yup.string().required("Results summary is required"),
    lessons_learned: Yup.string().required("Lessons learned is required"),
  });

  // React Hook Form với Yup Resolver
  const {
    register,
    handleSubmit,
    formState: { errors },
    getValues
  } = useForm({
    resolver: yupResolver(schema), // Sử dụng schema Yup
    defaultValues: {
      campaignId: "",
      total_donations: 0,
      total_recipients: 0,
      results_summary: "",
      lessons_learned: "",
    },
  });

  const onSubmit = () => {
    const currentDate = new Date().toISOString().split("T")[0]; 
    const enrichedData = new CreateReport(Number(getValues("campaignId")),getValues("total_donations"),getValues("total_recipients"),getValues("results_summary"),getValues("lessons_learned"),currentDate,currentDate,currentDate)
    handle(enrichedData);
  };
  

  return (
    <div>
      <div className="container-fluid pt-4 px-4">
        <h1 className="py-3">
          <b>Create Report</b>
        </h1>
        <form onSubmit={handleSubmit(onSubmit)}>
          <div className="col-12">
            <div className="shadow rounded bg-light custom-container h-100 p-4">
              <div className="col-sm-12 col-xl-12">
                <div className="bg-light rounded h-100 p-4">
                  <h6 className="mb-4">Report Form</h6>
                  {/* Campaign ID */}
                  <div className="form-floating m-2">
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Campaign Id"
                      {...register("campaignId")}
                    />
                    <label>Campaign Id</label>
                    {errors.campaignId && (
                      <p className="text-danger">{errors.campaignId.message}</p>
                    )}
                  </div>
                  {/* Total Donations */}
                  <div className="form-floating m-2">
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Total Donations"
                      {...register("total_donations")}
                    />
                    <label>Total Donations</label>
                    {errors.total_donations && (
                      <p className="text-danger">{errors.total_donations.message}</p>
                    )}
                  </div>
                  {/* Total Recipients */}
                  <div className="form-floating m-2">
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Total Recipients"
                      {...register("total_recipients")}
                    />
                    <label>Total Recipients</label>
                    {errors.total_recipients && (
                      <p className="text-danger">{errors.total_recipients.message}</p>
                    )}
                  </div>
                  {/* Results Summary */}
                  <div className="form-floating m-2">
                    <textarea
                      className="form-control"
                      placeholder="Results Summary"
                      style={{ height: 150 }}
                      {...register("results_summary")}
                    ></textarea>
                    <label>Results Summary</label>
                    {errors.results_summary && (
                      <p className="text-danger">{errors.results_summary.message}</p>
                    )}
                  </div>
                  {/* Lessons Learned */}
                  <div className="form-floating m-2">
                    <textarea
                      className="form-control"
                      placeholder="Lessons Learned"
                      style={{ height: 150 }}
                      {...register("lessons_learned")}
                    ></textarea>
                    <label>Lessons Learned</label>
                    {errors.lessons_learned && (
                      <p className="text-danger">{errors.lessons_learned.message}</p>
                    )}
                  </div>
                  {/* Submit Button */}
                  <div>
                    <input
                      type="submit"
                      className="btn btn-primary"
                      value={"Create"}
                    />
                  </div>
                </div>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
};

export default ReportForm;
