import axios from "axios";
import { handleError } from "../Helpers/ErrorHandler";
import { RootImageGet } from "../models/Image";

const api = "http://localhost:8080/UniCharity/images";
export const UploadListImagesPostAPI = async (
  id: number,
  images: FileList | null
) => {
  try {
    if (images && images.length > 0) {
      const formData = new FormData();

      // Append images to FormData
      for (let i = 0; i < images.length; i++) {
        formData.append("image", images[i]);
      }

      const imageUploadResponse = await axios.post(
        api + `/upload-list/illustration/${id}`,
        formData,
        {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        }
      );
      return imageUploadResponse;
    }
  } catch (error) {
    console.log("lỗi", error);
    handleError(error);
  }
};


export const DowloadImageByCampaignId = async (campaignId :number)=>{
  try {
    const response  = await axios.get<RootImageGet>(`${api}/dowload-by-campaignId/${campaignId}`)
    console.log("result",response.data)
    return response.data;
  } catch (error) {
    console.log("error:",error)
    handleError(error)
  }
}

export const DeleteCampaignImageAPI =  async (imageId:number)=>{
  try {
    const response = axios.delete(`${api}/delete-image/${imageId}`)
    return response;
  } catch (error) {
    
    console.log("error",error)
    handleError(error)
  }

}