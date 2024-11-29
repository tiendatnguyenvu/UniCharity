import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { useFormik } from "formik";
import * as Yup from "yup";
import { CampaignGetByIDAPI } from "../../Service/CampaignService";
import { Slide, toast } from "react-toastify";
import { CampaignGet, DonationGet } from "../../Models/Campaign";
import Slider from "./Slider";
import Campaign from "../../Component/Campaign/Campaign";
import Table from "../../Component/Table/Table";
import No1Icon from "./Ranking/No1Component.svg";
import No2Icon from "./Ranking/No2Component.svg";
import No3Icon from "./Ranking/No3Component.svg";
import Modal from "react-modal";
import { processHtml } from "../../Utils/HelperMethod";
import { DonationPost } from "../../Service/AuthService";
import { donateAPI } from "../../Service/DonateService";
import axios from "axios";

const DetailCampaignPage = () => {
  const { id } = useParams();
  const [campaignDT, setCampaignDT] = useState<CampaignGet>();
  const [isModalOpen, setIsModalOpen] = useState(false);
  const navigate = useNavigate();

  // Fetch campaign details
  useEffect(() => {
    const fetchCampaign = async () => {
      try {
        if (id) {
          const res = await CampaignGetByIDAPI(Number(id));
          if (res?.data.code === 1000) {
            setCampaignDT(res?.data.result);
          }
        }
      } catch (error) {
        toast.error("Không thể tải thông tin chiến dịch.");
      }
    };
    fetchCampaign();
  }, [id]);

  const handleDonate = async (values: any) => {
    if (!id) return;

    const data: DonationPost = {
      campaign: id,
      name: values.name,
      email: values.email,
      amount: values.amount,
    };

    try {
      const response = await donateAPI(data);
      if (response?.data.code === 1000) {
        toast.success("Quyên góp thành công! Cảm ơn bạn đã đóng góp.");
        setIsModalOpen(false);

        // Lấy URL thanh toán từ API
        const paymentUrl = response?.data.result;
        if (paymentUrl) {
          console.log(paymentUrl);
          
          // Gửi request đến VNPay qua axios
          const paymentResponse = await axios.get(paymentUrl, {
            withCredentials: false, // VNPay không yêu cầu gửi cookies từ client
          });

          // Xử lý phản hồi từ VNPay
          if (paymentResponse?.data.responseCode === "00") {
            toast.success("Thanh toán thành công!");
            // Cập nhật thông tin chiến dịch
            const updatedCampaign = await CampaignGetByIDAPI(Number(id));
            if (updatedCampaign?.data.code === 1000) {
              setCampaignDT(updatedCampaign?.data.result);
            }
          } else {
            toast.error("Thanh toán thất bại. Vui lòng thử lại.");
          }
        } else {
          toast.error("Không tìm thấy URL thanh toán VNPay.");
        }
      } else {
        toast.error("Đã xảy ra lỗi trong quá trình quyên góp.");
      }
    } catch (error) {
      toast.error("Không thể hoàn tất quyên góp. Vui lòng kiểm tra lại thông tin.");
    }
  };


  const formik = useFormik({
    initialValues: {
      name: "",
      email: "",
      amount: "",
    },
    validationSchema: Yup.object({
      name: Yup.string().required("Vui lòng nhập tên của bạn"),
      email: Yup.string()
        .email("Email không hợp lệ")
        .required("Vui lòng nhập email"),
      amount: Yup.number()
        .typeError("Số tiền phải là một số hợp lệ")
        .min(1, "Số tiền phải lớn hơn 0")
        .required("Vui lòng nhập số tiền"),
    }),
    onSubmit: handleDonate,
  });

  const configs = [
    {
      label: "#",
      render: (don: DonationGet, index: number) => {
        if (index + 1 === 1) return <img src={No1Icon} alt="Top 1" width="24" height="24" />;
        if (index + 1 === 2) return <img src={No2Icon} alt="Top 2" width="24" height="24" />;
        if (index + 1 === 3) return <img src={No3Icon} alt="Top 3" width="24" height="24" />;
        return index + 1;
      },
    },
    {
      label: "Tên",
      render: (don: DonationGet) => `${don.user.name}`,
    },
    {
      label: "Đóng góp",
      render: (don: DonationGet) =>
        don.amount.toLocaleString("vi-VN", { style: "currency", currency: "VND" }),
    },
  ];

  return (
    <section className="news-section section-padding">
      <div className="container">
        <Slider
          banners={campaignDT?.images.map((i) => i.imagePath) || []}
          title={campaignDT?.title ?? ""}
        />
        <div className="row">
          <div className="col-lg-7 col-12">
            <blockquote>{campaignDT?.title}</blockquote>
            <div style={{ maxWidth: "100%" }} dangerouslySetInnerHTML={{ __html: processHtml(a) }} />
            <h5 className="mb-3 pt-4" style={{ borderTop: "solid" }}>Nhà hảo tâm hàng đầu</h5>
            {campaignDT?.donations && campaignDT?.donations.length > 0 && (
              <Table configs={configs} data={campaignDT?.donations} />
            )}
          </div>
          <div className="col-lg-4 col-12 mx-auto mt-4 mt-lg-0">
            <div style={{ position: "sticky", top: "20px", right: "0px" }}>
              <h3>Chương trình đang diễn ra</h3>
              {campaignDT && (
                <Campaign
                  handleDonateNowClick={() => setIsModalOpen(true)}
                  campaign={campaignDT}
                />
              )}
            </div>
          </div>
        </div>
      </div>
      <Modal
        isOpen={isModalOpen}
        onRequestClose={() => setIsModalOpen(false)}
        contentLabel="Donate Modal"
        ariaHideApp={false}
        className="modal-content"
        overlayClassName="modal-overlay"
      >
        <form onSubmit={formik.handleSubmit} className="custom-form contact-form">
          <h2>Thông tin của bạn</h2>
          <div>
            <input
              type="text"
              name="name"
              className="form-control"
              placeholder="Tên của bạn"
              {...formik.getFieldProps("name")}
            />
            {formik.touched.name && formik.errors.name && (
              <p className="error text-danger">{formik.errors.name}</p>
            )}
          </div>
          <div>
            <input
              type="email"
              name="email"
              className="form-control"
              placeholder="Jackdoe@gmail.com"
              {...formik.getFieldProps("email")}
            />
            {formik.touched.email && formik.errors.email && (
              <p className="error text-danger">{formik.errors.email}</p>
            )}
          </div>
          <div>
            <input
              type="text"
              name="amount"
              className="form-control"
              placeholder="Số tiền (VND)"
              {...formik.getFieldProps("amount")}
            />
            {formik.touched.amount && formik.errors.amount && (
              <p className="error text-danger">{formik.errors.amount}</p>
            )}
          </div>
          <button type="submit" className="form-control">Quyên góp</button>
        </form>
      </Modal>
    </section>
  );
};

export default DetailCampaignPage;

const a = `<p><strong>Người ta thường ví vùng...</strong></p>`;
