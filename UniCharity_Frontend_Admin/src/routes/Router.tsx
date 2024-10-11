import { createBrowserRouter } from "react-router-dom"
import AdminLayout from "../layouts/AdminLayout/AdminLayout"
import Campaign from "../pages/admin/Campaign/Campaign"

const Router = createBrowserRouter([
    {
        path:"/admin",
        element:<AdminLayout/>,
        children:[
            {
                path:"campaigns",
                element:<Campaign/>
            }
        ]
    }
])
export default Router;