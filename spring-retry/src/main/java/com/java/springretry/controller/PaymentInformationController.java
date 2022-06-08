package com.java.springretry.controller;

import com.java.springretry.client.PaymentClient;
import com.java.springretry.model.Payment;
import com.java.springretry.model.PaymentInfomation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentInformationController {
    
    private final PaymentClient paymentClient;

    @GetMapping("/{userId}")
    public Mono<PaymentInfomation> getPaymentInformation(@PathVariable String userId){
        Mono<Payment> payment1 = paymentClient.getPayment(userId);
        Mono<Payment> payment2 = getSpecificPayment();

        Mono<Tuple2<Payment, Payment>> tuple2 = Mono.zip(payment1, payment2);

        return tuple2.map(result -> {
            PaymentInfomation paymentInfomation = new PaymentInfomation();
            paymentInfomation.setCustomerId(userId);

            List<Payment> payments = Arrays.asList(result.getT1(), result.getT2());

            paymentInfomation.setPayments(payments);

            return paymentInfomation;
        });

    }

    private Mono<Payment> getSpecificPayment(){
        return paymentClient.getPayment("2");
    }

}
