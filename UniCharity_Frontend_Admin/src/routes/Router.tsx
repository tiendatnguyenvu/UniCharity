import { createBrowserRouter } from "react-router-dom";
import AdminLayout from "../layouts/AdminLayout/AdminLayout";
import Campaign from "../pages/admin/Campaign/Campaign";
import FormCampaign from "../pages/admin/Campaign/FormCampaign";
import Department from "../pages/admin/Department/Department";

const Router = createBrowserRouter([
  {
    path: "/admin",
    element: <AdminLayout />,
    children: [
      {
        path: "campaigns",
        element: <Campaign />,
      },
      {
        path: "departments",
        element: <Department />,
      },
      {
        path: "campaigns/create",
        element: <FormCampaign />,
      },
    ],
  },
]);
export default Router;
