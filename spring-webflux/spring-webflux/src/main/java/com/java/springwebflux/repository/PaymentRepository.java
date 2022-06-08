package com.java.springwebflux.repository;

import com.java.springwebflux.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PaymentRepository {

    private final Database database;

    public Mono<Payment> createPayment(final String userId){
        final Payment payment = Payment.builder()
                .id(UUID.randomUUID().toString())
                .userId(userId)
                .status(Payment.PaymentStatus.PENDING)
                .build();

        return Mono.fromCallable(() -> {
            log.info("salvando pagamento do usuario {}", userId);
            return this.database.save(userId, payment);
        })
                .subscribeOn(Schedulers.parallel())
                .doOnNext(next -> log.info("Pagamento recebi {}", payment.getUserId()));

        //Schedulers.parallel() pra quando for tarefa nao bloqueante
        //Schedulers.boundedElastic() pra quando for tarefa bloquante
    }

    public Mono<Payment> getPayment(final String userId){
        return Mono.defer(() -> {
            final Optional<Payment> payment = this.database.get(userId, Payment.class);
            return Mono.justOrEmpty(payment);
        })
                .subscribeOn(Schedulers.parallel())
                .doOnEach(it -> log.info("Pagamento recuperado - {}", userId));

//                Mono.fromCallable(() -> {
//                    log.info("salvando pagamento do usuario {}", userId);
//                    return this.database.get(userId, Payment.class);
//                })
//                .subscribeOn(Schedulers.parallel())
//                .doOnNext(next -> log.info("Pagamento recebi {}", userId));
    }
}
