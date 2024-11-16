import { createBrowserRouter } from "react-router-dom";
import AdminLayout from "../Layout/AdminLayout";
import Campaign from "../Pages/Campaign/Campaign";
import CreateCampaign from "../Pages/Campaign/Form/CreateCampaign";
import UpdateCampaign from "../Pages/Campaign/Form/UpdateCampaign";
import CampaignImagesDetail from "../Pages/Campaign/Form/CampaignImagesDetail";

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
        ]
            
        
    }
])

export default Router;