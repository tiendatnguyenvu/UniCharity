import axios from "axios";
import { CampaignGet, CampaignPostAdmin } from "../models/Campaign";
import { handleError } from "../Helpers/ErrorHandler";

const api = "http://localhost:8080/UniCharity/campaigns";

export const CampaignGetAPI = async () => {
  try {
    const data = await axios.get<CampaignGet[]>(api);
    // console.log("data:",data.data)
    return data.data;
  } catch (error) {
    handleError(error)
    
  }
};

export const CampaignUpfateStatusAPI = async (id: number) => {
    try {
        const data = await axios.put(api + "/updateStatus/" + id)
        
        return data;
    }  catch (error) {
        handleError(error);
    }
}

export const CampaignPostAPI = async (formInput: CampaignPostAdmin)=>{
  try{

      const data  = await axios.post<number>(api+"/create",formInput)
      // console.log("dataPost service :",data)
      return data;
  }catch(error)
  {
    handleError(error);
  }
}

export const CampaignUpdateAPI = async (id:string,formInput: CampaignPostAdmin)=>{
  try{
      const data  = await axios.put<number>(api+`/update/${id}`,formInput)
      console.log("dataUpdateService service :",data)
      return data;
  }catch(error)
  {
    handleError(error);
  }
}

export const CampaignGetByIdAPI = async (id: string) => {
  try {
      const response = await axios.get<CampaignGet>(api + "/get-by-id/" + id)
      return response.data
  } catch (error) {
      handleError(error)
  }
}


// export const upLoadImagesAPI = async (images: FileList | null, CampaignId: number) => {
//   console.log(CampaignId);

//   try {
//       if (images && images.length > 0) {
//           const formData = new FormData();

//           // Append images to FormData
//           for (let i = 0; i < images.length; i++) {
//               formData.append('fileImages', images[i]);
//           }

//           // Include Variant ID in the FormData
//           formData.append('CampaignId', CampaignId.toString());

//           // Make the API call to upload images
//           const imageUploadResponse = await axios.post(api + "/upload-images-campaign", formData, {
//               headers: {
//                   'Content-Type': 'multipart/form-data',
//               },
//           });
//           return imageUploadResponse;
//       }
//   } catch (error) {
//       handleError(error)
//   }
// }
  
// export const CampaignPostAPI = async (formInput: CampaignPost)=>{
//   e.preventDefault();
//     try {
//       const response = await axios.post('http://localhost:8080/api/save-content', formInput);
//       if (response.status === 200) {
//         console.log('Content saved successfully');
//       } else {
//         console.log('Failed to save content');
//       }
//     } catch (error) {
//       console.error('Error saving content:', error);
//     }

  
// }
