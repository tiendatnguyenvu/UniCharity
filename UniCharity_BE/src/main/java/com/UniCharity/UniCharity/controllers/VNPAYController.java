package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.response.ApiResponse;
import com.UniCharity.UniCharity.dto.response.PaymentResponse;
import com.UniCharity.UniCharity.services.VNPAYService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vnpay")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VNPAYController {
    private VNPAYService vnPayService;

    @GetMapping({"", "/"})
    public String home(){
        return "createOrder";
    }

    // Chuyển hướng người dùng đến cổng thanh toán VNPAY
//    @PostMapping("/create_payment")
//    public ApiResponse<String> submidOrder(HttpServletRequest request) {
//        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
//        String vnpayUrl = vnPayService.createOrder(request, orderTotal, orderInfo, baseUrl);
//        return ApiResponse.<String>builder().result(vnpayUrl).build();
//    }

    // Sau khi hoàn tất thanh toán, VNPAY sẽ chuyển hướng trình duyệt về URL này
    @GetMapping("/payment-return")
    public ApiResponse<PaymentResponse> paymentCompleted(HttpServletRequest request){
        int paymentStatus =vnPayService.orderReturn(request);

        String orderInfo = request.getParameter("vnp_OrderInfo");
        String paymentTime = request.getParameter("vnp_PayDate");
        String cardType = request.getParameter("vnp_CardType");
        String transactionId = request.getParameter("vnp_TransactionNo");
        String transactionStatus = request.getParameter("vnp_TransactionStatus");
        String totalPrice = request.getParameter("vnp_Amount");

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPaymentStatus(paymentStatus);
        paymentResponse.setOrderInfo(orderInfo);
        paymentResponse.setPaymentTime(paymentTime);
        paymentResponse.setCardType(cardType);
        paymentResponse.setTransactionId(transactionId);
        paymentResponse.setTransactionStatus(transactionStatus);
        paymentResponse.setTotalPrice(totalPrice);

        return ApiResponse.<PaymentResponse>builder().result(paymentResponse).build();
    }
}
