import React from "react";
import { useLocation } from "react-router-dom";

const PaymentReturn: React.FC = () => {
  const location = useLocation();

  const parseQuery = (query: string) => {
    const params = new URLSearchParams(query);
    const result: { [key: string]: string } = {};
    params.forEach((value, key) => {
      result[key] = value;
    });
    return result;
  };

  const queryParams = parseQuery(location.search);
  const orderIF = queryParams['vnp_OrderInfo'];
  const cardType = queryParams['vnp_CardType'];

  // Hiển thị thông tin
  return (
    <div>
      {/* <ul>
        {Object.entries(queryParams).map(([key, value]) => (
          <li key={key}>
            <strong>{key}:</strong> {decodeURIComponent(value)}
          </li>
        ))}
      </ul> */}
      <section className="testimonial-section section-padding section-bg">
        <div className="container">
          <div className="row">

            <div className="col-lg-8 col-12 mx-auto">
              <h2 className="mb-lg-3">Cảm ơn bạn đã đóng góp!</h2>

              <div id="testimonial-carousel" className="carousel carousel-fade slide" data-bs-ride="carousel">

                <div className="carousel-inner">
                  <div className="carousel-item active">
                    <div className="carousel-caption">
                      <h4 className="carousel-title">{decodeURIComponent(orderIF)}</h4>

                      <small className="carousel-name"><span className="carousel-name-title">Ngân hàng</span>,
                        {decodeURIComponent(cardType)}</small>
                    </div>
                  </div>

                  <div className="carousel-item">
                    <div className="carousel-caption">
                      <h4 className="carousel-title">{decodeURIComponent(orderIF)}</h4>

                      <small className="carousel-name"><span className="carousel-name-title">Ngân hàng</span>,
                        {decodeURIComponent(cardType)}</small>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>
      </section>
    </div>
  );
};

export default PaymentReturn;
