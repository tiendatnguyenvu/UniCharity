import axios from "axios";
import { handleError } from "../Helpers/ErrorHandler";

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


export const DowloadImageByCampaignId = (campaignId :number)=>{
  try {
    const respone  = axios.get(`${api}/dowload-by-campaignId/${campaignId}`)
    return respone;
  } catch (error) {
    console.log("error:",error)
    handleError(error)
  }
}