import React from "react";

const ReportForm = () => {


  
  const {
    register,
    handleSubmit,
    formState: { errors },
    setValue,
    getValues,
  } = useForm({
    // resolver: yupResolver(schema), // Sử dụng schema đơn giản
    defaultValues: {
      filter: "",
    },
  });

  return (
    <div>
      <div className="container-fluid pt-4 px-4">
        <h1 className="py-3">
          <b>Create Report</b>
        </h1>
        <div className="col-12">
          <div className="shadow rounded bg-light custom-container  h-100 p-4">
            <div>
              <div className="col-sm-12 col-xl-12">
                <div className="bg-light rounded h-100 p-4">
                  <h6 className="mb-4">Floating Label</h6>

                  {/* campaign id */}
                  <div className="form-floating m-2">
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Leave a comment here"
                      id="floatinginput"
                    ></input>
                    <label htmlFor="floatingTextarea">Campaign Id</label>
                  </div>

                  {/* total donation */}
                  <div className="form-floating m-2">
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Leave a comment here"
                      id="floatinginput"
                    ></input>
                    <label htmlFor="floatingTextarea"> total donation</label>
                  </div>

                  {/* total_recipients */}
                  <div className="form-floating m-2">
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Leave a comment here"
                      id="floatinginput"
                    ></input>
                    <label htmlFor="floatingTextarea">total_recipients</label>
                  </div>

                  <div className="form-floating m-2">
                    <textarea
                      className="form-control"
                      placeholder="Leave a comment here"
                      id="floatingTextarea"
                      style={{ height: 150 }}
                    ></textarea>
                    <label htmlFor="floatingTextarea">results_summary</label>
                  </div>

                  <div className="form-floating m-2">
                    <textarea
                      className="form-control"
                      placeholder="Leave a comment here"
                      id="floatingTextarea"
                      style={{ height: 150 }}
                    ></textarea>
                    <label htmlFor="floatingTextarea">lessons_learned</label>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ReportForm;
