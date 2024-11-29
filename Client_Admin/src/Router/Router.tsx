import { createBrowserRouter } from "react-router-dom";
import AdminLayout from "../Layout/AdminLayout";
import Campaign from "../Pages/Campaign/Campaign";
import CreateCampaign from "../Pages/Campaign/Form/CreateCampaign";
import UpdateCampaign from "../Pages/Campaign/Form/UpdateCampaign";
import CampaignImagesDetail from "../Pages/Campaign/Form/CampaignImagesDetail";
import Policy from "../Pages/Policy/Policy";
import Donation from "../Pages/Donation/Donation";
import Report from "../Pages/Report/Report";
import CreateReport from "../Pages/Report/Form/CreateReport";

const Router = createBrowserRouter([
    {
        path:  "Admin",
        element:<AdminLayout/>,
        children:[
            {
                path:"campaigns",
                element: <Campaign/>
            },
            {
                path:"campaigns/create",
                element: <CreateCampaign/>
            },
            {
                path:"campaigns/update/:id",
                element: <UpdateCampaign/>
            },
            {
                path:"campaigns/update-images/:id",
                element: <CampaignImagesDetail/>
            },
            // policy
            {
                path:"policies",
                element: <Policy/>
            },
            {
                path:"donations",
                element: <Donation/>
            },
            {
                path:"reports",
                element: <Report/>
            },
            {
                path:"reports/create",
                element: <CreateReport/>
            },
        ]
            
        
    }
])

export default Router;