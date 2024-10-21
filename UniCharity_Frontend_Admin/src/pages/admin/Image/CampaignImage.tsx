import React from 'react'
import { ImageGet } from '../../../models/Image'

type Props = {
    image:ImageGet;
    index:number;
    handleDelete: (imageId:number) => void;
}

const CampaignImage = ({image,index,handleDelete}:Props) => {
    return (
        <div className="rounded col m-2 bg-secondary  col-md-6 col-lg-4 col-xl-3 wow fadeInUp" data-wow-delay="0.1s">
            <div className="service-item rounded">
                <div className="service-img p-1 rounded-top">
                    <img src={image.imagePath} className="img-fluid rounded-top w-100" alt="" />
                </div>
                <div className="service-content rounded-bottom p-4">
                    <div className="service-content-inner">
                        <h5 className="mb-4">Module {index}</h5>
                        <button 
                            id={image.id.toString()}
                            onClick={() => handleDelete(image.id)}
                        className="btn btn-danger rounded-pill text-white py-2 px-4 mb-2">Delete</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default CampaignImage
