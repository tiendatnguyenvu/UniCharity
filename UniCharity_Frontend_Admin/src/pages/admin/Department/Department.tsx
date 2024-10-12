import React, { useEffect, useState } from "react";
import { DepartmentGet } from "../../../models/Department";
import AdminLayout from "~/layouts/AdminLayout/AdminLayout";
import { DepartmentGetAPI } from "../../../services/DepartmentService";
import { toast } from "react-toastify";
import { render } from "react-dom";
import { useNavigate } from "react-router";
import Table from "../../../components/admin/Table/Table";
import Campaign from "../Campaign/Campaign";
// import { DepartmentGet } from '~/models/Department.ts';

const Department = () => {
  const [department, setDepartment] = useState<DepartmentGet[] | null>([]);
  const navigate = useNavigate();

  useEffect(() => {
    getDepartments();
  }, []);

  const getDepartments = () => {
    DepartmentGetAPI()
      .then((res) => {
        if (res?.result) {
          console.log("data", res.result);
          setDepartment(res?.result);
        }
      })
      .catch((erorr) => {
        toast.warning(erorr);
        setDepartment([]);
        console.log("error")
      });
  };
  console.log("data3",department)

  const configs = [
    {
      label: "#",
      render: (department: DepartmentGet, index: number) => index + 1,
    },
    {
      label: "deparment's name",
      render: (department: DepartmentGet) =>
        department.name
    },
    {
      label: "deparment's desciption",
      render: (department: DepartmentGet) =>
        department.description
    }, {
      label: "Action",
      render: (deparment: DepartmentGet) => {
        return (
          <td className="d-flex">
            <button
              type="button"
              className="btn-sm btn-success d-flex align-items-center me-2"
              onClick={() =>
                navigate(`/admin/deparments/edit/${deparment.departmentId}`)
              }
            >
              {/* <FaPen className='me-2' /> */}
              Update
            </button>
          </td>
        );
      },
    },
  ];


  console.log("data2 ",department)
  return (
    <div>
      (deparment) ? (
      <div className="container-fluid pt-4 px-4">
        <h1 className="py-3">deparment Management</h1>
        <div className="col-12">
          <div className="rounded custom-container  h-100 p-4">
            <div className="d-flex py-2">
              <h6 className="mb-4">deparment List</h6>
              <button
                className="admin-btn-primary ms-auto"
                onClick={() => {
                  navigate("/admin/departments/create");
                }}
              >
                Create a new campaign
              </button>
            </div>
            <div className="table-responsive"></div>
            <Table data={department} configs={configs} />
          </div>
        </div>
      </div>
      ): (<>loading...</>)
    </div>
  );
};

export default Department;
