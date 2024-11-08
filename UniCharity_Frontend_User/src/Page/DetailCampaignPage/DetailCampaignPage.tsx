import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import { CampaignGetByIDAPI } from '../../Service/CampaignService';
import { Slide, toast } from 'react-toastify';
import { CampaignGet, DonationGet } from '../../Models/Campaign';
import Slider from './Slider';
import Campaign from '../../Component/Campaign/Campaign';
import Table from '../../Component/Table/Table';
import No1Icon from './Ranking/No1Component.svg';
import No2Icon from './Ranking/No2Component.svg';
import No3Icon from './Ranking/No3Component.svg';


const processHtml = (html: string) => {
  return html
    .replace(/<img /g, '<img style="width: 100%;" c lass="img-fluid" ');
};



const DetailCampaignPage = () => {
  const { id } = useParams()
  const [campaignDT, setCampaignDT] = useState<CampaignGet>()

  useEffect(() => {
    if (id) {
      CampaignGetByIDAPI(Number(id))
        .then(res => {
          console.log("rs", res?.data.result);
          if (res?.data.code === 1000) {
            setCampaignDT(res?.data.result)
          }
        }).catch(err => toast.error(err))
    }
  }, [])

  const configs = [
    {
      label: "#",
      render: (don: DonationGet, index: number) => {
        if (index + 1 === 1) return <img src={No1Icon} alt="My Icon" width="24" height="24" />
        if (index + 1 === 2) return <img src={No2Icon} alt="My Icon" width="24" height="24" />
        if (index + 1 === 3) return <img src={No3Icon} alt="My Icon" width="24" height="24" />
        return index + 1;
      },
      
    },
    {
      label: "Tên",
      render: (don: DonationGet) => `${don.user.name}`,
    },
    {
      label: "Đóng góp",
      render: (don: DonationGet) => don.amount.
        toLocaleString('vi-VN', { style: 'currency', currency: 'VND' }),
    },
    // {
    //     label: "Quantity",
    //     render: (DonationGet: DonationGet) => DonationGet.quantity
    // },
    // {
    //     label: "Total",
    //     render: (DonationGet: DonationGet) => (DonationGet.quantity * DonationGet.price)
    //         .toLocaleString('en-US', { style: 'currency', currency: 'USD' }),
    // },
  ]

  return (
    <section className="news-section section-padding">
      <div className="container">
        <Slider banners={campaignDT?.images.map(i => i.imagePath) || []} title={campaignDT?.title ?? ''} />
        <div className="row">
          <div className="news-block-body">
          </div>

          <div className="col-lg-7 col-12">
            <blockquote>{campaignDT?.title}</blockquote>
            <div style={{ maxWidth: "100%" }} dangerouslySetInnerHTML={{ __html: processHtml(a) }} />

            <h5 className="mb-3 pt-4" style={{ borderTop: "solid" }}>Nhà hảo tâm hàng đầu</h5>
            
            {campaignDT?.donations && campaignDT?.donations.length > 0 &&
              <Table configs={configs} data={campaignDT?.donations} />
            }
          </div>

          <div className="col-lg-4 col-12 mx-auto mt-4 mt-lg-0">
            <div style={{ position: "sticky", top: "20px", right: "0px" }} >
              <h3 className='' > Chương trình đang diễn ra</h3>
              {campaignDT && <Campaign campaign={campaignDT} />}
            </div>
          </div>

        </div>
      </div>
    </section>
  )
}

export default DetailCampaignPage

const a = `<p><strong>Người ta thường v&iacute; v&ugrave;ng</strong> đất bi&ecirc;n giới Sơn Vĩ, giống như một con ng&otilde; cụt, hẻo l&aacute;nh, bởi địa phương n&agrave;y nằm ở điểm cuối c&ugrave;ng của huyện M&egrave;o Vạc, tỉnh H&agrave; Giang. Bởi v&igrave; từ trung t&acirc;m huyện chỉ c&oacute; một con đường v&agrave;o đ&acirc;y rồi lại trở ra chứ kh&ocirc;ng nối th&ocirc;ng đi bất cứ địa phương n&agrave;o kh&aacute;c. Diện t&iacute;ch của x&atilde; bi&ecirc;n giới n&agrave;y rất khi&ecirc;m tốn, chỉ vẻn vẹn khoảng 54km2, l&agrave; nơi sinh sống của hơn 6.000 người d&acirc;n thuộc nhiều đồng b&agrave;o d&acirc;n tộc thiểu số như: M&ocirc;ng, Xuồng, Gi&aacute;y, T&agrave;y, N&ugrave;ng, Dao, Hoa&hellip;, đ&ocirc;ng nhất l&agrave; đồng b&agrave;o d&acirc;n tộc M&ocirc;ng, chiếm 80% d&acirc;n số. To&agrave;n x&atilde; Sơn Vĩ c&oacute; 19 th&ocirc;n, trong đ&oacute; c&oacute; 9 th&ocirc;n gi&aacute;p bi&ecirc;n, địa h&igrave;nh phức tạp, hiểm trở, bị chia cắt mạnh bởi n&uacute;i cao, vực s&acirc;u. Chưa hết, thời tiết, kh&iacute; hậu ở Sơn Vĩ khắc nghiệt, phần lớn thời gian trong năm c&oacute; sương m&ugrave;, gi&aacute; lạnh, thiếu nước sinh hoạt v&agrave; sản xuất v&agrave;o m&ugrave;a kh&ocirc;. Đời sống của b&agrave; con c&ograve;n rất ngh&egrave;o kh&oacute;.</p>
 <p><img src="https://homepage.momocdn.net/blogscontents/momo-amazone-s3-api-241017132910-638647685500932329.jpg" alt=""></p>
 <p><em>Trường PTDTBT Tiểu học Sơn Vĩ l&agrave; nơi theo học của 572 em học sinh đồng b&agrave;o d&acirc;n tộc x&atilde; Sơn Vĩ</em></p>
 <p>Trường Phổ th&ocirc;ng D&acirc;n tộc b&aacute;n tr&uacute; (PTDTBT) Tiểu học Sơn Vĩ đ&oacute;ng tr&ecirc;n địa b&agrave;n x&atilde; Sơn Vĩ với 99% học sinh l&agrave; đồng b&agrave;o d&acirc;n tộc thiểu số. Nhận thức của cộng đồng nơi đ&acirc;y về c&ocirc;ng t&aacute;c gi&aacute;o dục vẫn c&ograve;n hạn chế n&ecirc;n việc vận động duy tr&igrave; sĩ số học sinh đi học chưa cao; dẫn đến tỷ lệ học sinh nghỉ học, bỏ học giữa chừng cao hơn mặt bằng chung của huyện.&nbsp;&nbsp;</p>
 <p>Cơ sở vật chất của nh&agrave; trường đang dần xuống cấp, đ&aacute;c biệt l&agrave; khu vực nh&agrave; ăn d&agrave;nh cho c&aacute;c em học sinh b&aacute;n tr&uacute;. Hiện nay số lượng học sinh b&aacute;n tr&uacute; đ&ocirc;ng đ&uacute;c nhưng khu vực nh&agrave; ăn kh&ocirc;ng đảm bảo đủ cho nhu cầu vệ sinh v&agrave; an to&agrave;n thực phẩm.<br><img src="https://homepage.momocdn.net/blogscontents/momo-amazone-s3-api-241017132953-638647685931156347.jpg" alt=""></p>
 <p><img src="https://homepage.momocdn.net/blogscontents/momo-amazone-s3-api-241017133003-638647686037931229.jpg" alt=""></p>
 <p><em>Số lượng học sinh b&aacute;n tr&uacute; đ&ocirc;ng đ&uacute;c nhưng khu vực nh&agrave; ăn kh&ocirc;ng đảm bảo đủ cho nhu cầu vệ sinh v&agrave; an to&agrave;n thực phẩm</em></p>
 <p>Ch&uacute;ng t&ocirc;i tin rằng việc đầu tư v&agrave;o việc sửa chữa, n&acirc;ng cấp v&agrave; trang bị th&ecirc;m thiết bị phục vụ cho học sinh sẽ gi&uacute;p cải thiện điều kiện ăn ở v&agrave; sinh hoạt của c&aacute;c em học sinh; tạo ra một m&ocirc;i trường học tập th&acirc;n thiện v&agrave; an to&agrave;n hơn cho c&aacute;c em. Đ&acirc;y cũng l&agrave; điều kiện để c&aacute;c em học sinh cải thiện sức khỏe v&agrave; y&ecirc;n t&acirc;m học tập, đồng thời lan tỏa, thu h&uacute;t sự tham gia của đ&ocirc;ng đảo c&aacute;c nguồn lực x&atilde; hội kh&aacute;c đầu tư đ&uacute;ng hướng cho trẻ em để c&oacute; một m&ocirc;i trường học tập &ldquo;trường học th&acirc;n thiện, học sinh khỏe mạnh&rdquo;.</p>
 <p><img src="https://homepage.momocdn.net/blogscontents/momo-amazone-s3-api-241017133045-638647686454363413.jpg" alt=""></p>
 <p><img src="https://homepage.momocdn.net/blogscontents/momo-amazone-s3-api-241017133054-638647686547459644.jpg" alt=""></p>
 <p><em>Dự &aacute;n dự kiến l&aacute;t lại 300m2 nền khu vực nh&agrave; ăn, bổ sung th&ecirc;m 5 chậu rửa tay, 12 bộ b&agrave;n ăn cho trườ</em>ng</p>
 <p>Ch&iacute;nh v&igrave; những l&yacute; do tr&ecirc;n, Quỹ Hỗ trợ đổi mới gi&aacute;o dục phổ th&ocirc;ng Việt Nam (VIGEF) phối hợp với c&aacute;c đối t&aacute;c, triển khai chương tr&igrave;nh hỗ trợ gi&aacute;o dục cho Trường PTDTBT Tiểu học Sơn Vĩ để cải thiện cơ sở vật chất cho 572 em học sinh b&aacute;n tr&uacute; đang theo học của to&agrave;n trường. Cụ thể l&agrave; dự kiến l&aacute;t lại 300m2 nền khu vực nh&agrave; ăn, bổ sung th&ecirc;m 5 chậu rửa tay v&agrave;o hệ thống v&ograve;i nước phục vụ nhu cầu đảm bảo vệ sinh cho c&aacute;c em trước khi ăn v&agrave; 12 bộ b&agrave;n ăn cho c&aacute;c em c&oacute; th&ecirc;m chỗ ngồi ăn cơm h&agrave;ng ng&agrave;y.</p>
 <p><img src="https://homepage.momocdn.net/blogscontents/momo-amazone-s3-api-241017133117-638647686774656034.jpg" alt=""></p>
 <p><em>Chung tay g&acirc;y quỹ cải thiện cơ sở vật chất cho c&aacute;c em học sinh tại Trường PTDTBT Tiểu học Sơn Vĩ</em></p>
 <p>Để l&agrave;m được điều đ&oacute;, VIGEF k&ecirc;u gọi sự chung tay đ&oacute;ng g&oacute;p của Cộng đồng người d&ugrave;ng Si&ecirc;u ứng dụng MoMo để g&acirc;y quỹ số tiền l&agrave; 150.000.000 đồng để hỗ trợ cải thiện cơ sở vật chất cho nh&agrave; trường. Số tiền tr&ecirc;n sẽ được sử dụng để mua sắm vật liệu, thiết bị, chi ph&iacute; nh&acirc;n c&ocirc;ng v&agrave; c&aacute;c chi ph&iacute; kh&aacute;c như chi ph&iacute; truyền th&ocirc;ng, g&acirc;y quỹ, theo d&otilde;i, gi&aacute;m s&aacute;t v&agrave; quản l&yacute; dự &aacute;n...&nbsp;</p>
 <p>Ch&uacute;ng t&ocirc;i tin rằng, sau khi được hỗ trợ, c&aacute;c em học sinh Trường PTDTBT Tiểu học Sơn Vĩ sẽ được cải thiện sức khỏe v&agrave; y&ecirc;n t&acirc;m học tập hơn, từ đ&oacute; cải thiện chất lượng gi&aacute;o dục của c&aacute;c em v&agrave; cộng đồng.</p>
 <p><u><strong>Về VIGEF:</strong></u><br>L&agrave; tổ chức phi Ch&iacute;nh phủ, hoạt động kh&ocirc;ng v&igrave; lợi nhuận v&agrave; được th&agrave;nh lập theo Quyết định số 2455/QĐ-BNV ng&agrave;y 23/8/2017 của Bộ trưởng Bộ Nội vụ v&agrave; được hoạt động tr&ecirc;n phạm vi l&atilde;nh thổ Việt Nam. VIGEF nỗ lực h&agrave;nh động nhằm th&uacute;c đẩy đổi mới, s&aacute;ng tạo v&agrave; hiệu quả th&ocirc;ng qua qu&aacute; tr&igrave;nh x&atilde; hội h&oacute;a gi&aacute;o dục, tạo kết nối v&agrave; tr&aacute;ch nhiệm giữa c&aacute;c b&ecirc;n c&oacute; li&ecirc;n quan hướng tới một nền gi&aacute;o dục phổ th&ocirc;ng b&igrave;nh đẳng, c&oacute; chất lượng v&agrave; hiệu quả.</p>`