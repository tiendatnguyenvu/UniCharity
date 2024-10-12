import React from "react";
import { useNavigate } from "react-router";
import { CampaignPost } from "../../../models/Campaign";

const InputCampaign = () => {
  const navigate = useNavigate();

  const handleSubmit = (formInput: CampaignPost) => {
    useNavigate("/campaigns");
  };
  return (
    <div className="col-sm-12 col-xl-12">
      <div className="bg-light rounded h-100 p-">
        <div className="form-floating mb-3">
          <input
            type="text"
            className="form-control"
            id="floatingInput"
            placeholder="Title"
          />
          <label htmlFor="floatingInput">Title</label>
        </div>
        <div className="form-floating mb-3">
          <input
            type="text"
            className="form-control"
            id="floatingPassword"
            placeholder="Create by"
          />
          <label htmlFor="floatingPassword">Create by</label>
        </div>
        <div className="form-floating mb-3">
          <input
            type="text"
            className="form-control"
            id="floatingPassword"
            placeholder="Target amount"
          />
          <label htmlFor="floatingPassword">Target amount</label>
        </div>

        <div className="form-floating mb-3">
          <input
            type="date"
            className="form-control"
            id="floatingPassword"
            placeholder="Target amount"
          />
          <label htmlFor="floatingPassword">Start date</label>
        </div>

        <div className="form-floating">
          <textarea
            className="form-control"
            placeholder="Leave a comment here"
            id="Description"
            style={{ height: "150px" }}
          ></textarea>
          <label htmlFor="floatingTextarea">Description</label>
        </div>

        {/* input file */}
          <div>
            <label htmlFor="formFileLg" className="form-label">
              Image
            </label>
            <input
              className="form-control form-control-lg"
              id="formFileLg"
              type="file"
            />
        </div>

        <button
          style={{ marginTop: "20px" }}
          type="submit"
          className="admin-btn-primary "
        >
          Submit
        </button>
      </div>
    </div>
  );
};

export default InputCampaign;
