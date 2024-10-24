import React, { useEffect, useState } from "react";
import { DowloadImageByCampaignId } from "../../../../../services/ImageService";
import { useNavigate } from "react-router";
import { ResultImageGet } from "../../../../../models/Image";

type Props = {
  campaignId: number;
};

const ImageTable = ({ campaignId }: Props) => {
  const [images, setImages] = useState<ResultImageGet[]>();
  const navigate = useNavigate();
  console.log("campaignId", campaignId);

  useEffect(() => {
    console.log("dô");
    DowloadImageByCampaignId(campaignId)?.then((res) => {
      setImages(res?.result);
    });
    // console.log("response images: ",response);
    // setImages(response.data.result)
  }, []);

//   console.log(images);
  return (
    <div>
      {images && images!.length > 0 ? (
        images!
          .slice(0, 10)
          .map((item) => (
            <img
              className="rounded-circle img-fluid me-2"
              src={`${item.imagePath}`}
              alt=""
              style={{ width: "40px", height: "40px" }}
            />
          ))
      ) : (
        <h5>No images</h5>
      )}
      <button
        type="button"
        onClick={() => navigate("/admin/campaigns/Images/" + campaignId)}
        className="btn-sm mt-3 btn-secondary p-2 d-flex align-items-center"
      >
        {/* <FaPen className='me-2' /> */}
        Update Images
      </button>
    </div>
  );
};

export default ImageTable;