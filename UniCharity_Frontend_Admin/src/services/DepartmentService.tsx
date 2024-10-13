import axios from "axios";
import { handleError } from "../Helpers/ErrorHandler";
import { DepartmentGet } from "../models/Department";

const api = "http://localhost:8080/UniCharity/departments";
export const DepartmentGetAPI = async () => {
  try {
    const data = await axios.get<DepartmentGet[]>(api);
    console.log("data",data);
    return data.data;
  } catch (error) {
    handleError(error);
  }
};
