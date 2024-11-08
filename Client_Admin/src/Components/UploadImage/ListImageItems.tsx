import React from 'react'
import VariantImage from './ButtonUpload'

type Props = {
    images: ImageGet[]
    handleDelete: (idImgae: number) => void
}

const VariantImages = ({ images, handleDelete }: Props) => {
    return (
        <>
            {images.map((image, index) => (
                <VariantImage
                    handleDelete={handleDelete}
                    key={image.imageId}
                    image={image}
                    index={index + 1}
                />
            ))}
        </>
    )
}

export default VariantImages
