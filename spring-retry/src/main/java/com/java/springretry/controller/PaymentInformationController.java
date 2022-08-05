package com.java.springretry.controller;

import com.java.springretry.client.BackBClient;
import com.java.springretry.client.PaymentClient;
import com.java.springretry.model.Payment;
import com.java.springretry.model.PaymentInfomation;
import com.java.springretry.strategy.InvestmentsStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentInformationController {
    
    private final PaymentClient paymentClient;
    //private final BackBClient backBClient;
    private final InvestmentsStrategy investmentsStrategy;

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
//    @GetMapping("/backb")
//    public Mono<String> getBackB(){
//        return backBClient.getBackB()
//                .doOnNext(i -> log.info("request processed!!!"))
//                .flatMap(a -> backBClient.getBackB())
//                .doOnNext(i -> log.info("request processed!!!"))
//                .subscribeOn(Schedulers.boundedElastic());
//    }

    @GetMapping("/backb")
    public Flux<String> getBackB(){
        List<String> investments = new ArrayList<>();
        investments.add("Fundos");
        investments.add("CDB");
        return Flux.fromIterable(investments)
                .flatMap(investmentsStrategy::strategies)
                .doOnNext(next -> log.info("request processed {}", next))
                .subscribeOn(Schedulers.boundedElastic());
    }

    private Mono<Payment> getSpecificPayment(){
        return paymentClient.getPayment("2");
    }

}
