import { createBrowserRouter } from "react-router-dom";
import AdminLayout from "../layouts/AdminLayout/AdminLayout";
import Campaign from "../pages/admin/Campaign/Campaign";
import Department from "../pages/admin/Department/Department";
import FormCampaign from "../pages/admin/Campaign/FormCampaign";
import EditCampaign from "../pages/admin/Campaign/EditCampaign";


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
      {
        path:"campaigns/update/:id",
        element:<EditCampaign/>
      }
    ],
  },
]);
export default Router;
