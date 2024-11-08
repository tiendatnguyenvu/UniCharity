import { toast } from "react-toastify";
import axiosInstance from "./axios_instance";

const api = "/images/";

export const UploadListCampaignImagesAPI = async (
  campaignId: number,
  images: FileList | null
) => {
  if (!images) {
    toast.error("No files to upload");
    return;
  }
  const formData = new FormData();
  Array.from(images).forEach((file) => {
    formData.append("image", file);
  });

  try {
    const response = await axiosInstance.post(
      `${api}upload-list/illustration/${campaignId}`,
      formData,
      {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      }
    );
    console.log("service list images:", response);
    return response.data;
  } catch (error) {
    console.error("Error uploading images:", error);
    throw error;
  }
};
