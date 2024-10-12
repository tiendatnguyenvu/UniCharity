import { createBrowserRouter } from "react-router-dom";
import AdminLayout from "../layouts/AdminLayout/AdminLayout";
import Campaign from "../pages/admin/Campaign/Campaign";
import FormCampaign from "../pages/admin/Campaign/FormCampaign";

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
        path: "campaigns/create",
        element: <FormCampaign />,
      },
    ],
  },
]);
export default Router;
