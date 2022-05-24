package com.java.springwebflux.controller;

import com.java.springwebflux.model.Payment;
import com.java.springwebflux.repository.PaymentRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/teste")
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentRepository paymentRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Payment> savePayment(@RequestBody NewPaymentInput input){
        String userId = input.getUserId();

        log.info("Pagamento será processado {}", userId);
        return this.paymentRepository.createPayment(userId)
                .doOnNext(next -> log.info("Pagamento processado {}", userId));

//                this.paymentRepository.createPayment(t)
//                .filter(payment -> Payment.PaymentStatus.APPROVED == payment.getStatus())
//                .flatMap( payment -> {
//                    //Se o filter for true, cai aqui...
//                })
//                .switchIfEmpty(Mono.defer(() -> {
//                    aqui não é um tratamento de erro, é um tratamento de um fluxo possível, por exemplo:
//                    Se o filter for false, cai aqui...
//                }))
//                .onErrorContinue(RuntimeException.class, throwable -> {
//                    //Se vier uma RuntimeException, cai aqui...
//                })
//                .onErrorMap(RuntimeException.class, throwable -> {
//                    //Posso mapear de uma exception para outra
//                    return new MinhaException(throwable);
//                })
//                .onErrorResume(RuntimeException.class, tr -> {
//                    //Aqui posso colocar outra cadeia reativa para startar caso eu receba um RuntimeException
//                    return Mono.error(tr);
//                });
    }

    @GetMapping
    public Mono<Payment> getPayment(){
        return Mono.fromCallable(() -> Payment.builder().build());
    }

    @Data
    public static class NewPaymentInput {
        private String userId;
    }
}
