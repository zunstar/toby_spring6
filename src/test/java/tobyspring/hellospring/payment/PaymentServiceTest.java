package tobyspring.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tobyspring.hellospring.exrate.WebApiExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


class PaymentServiceTest {

    @Test
    void prepare() throws IOException {
        PaymentService paymentService = new PaymentService(new WebApiExRateProvider());

        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        assertThat(payment.getExRate()).isNotNull();

        assertThat(payment.getConvertedAmount()).isEqualTo(
                        payment.getExRate().multiply(payment.getForeignCurrencyAmount())
        );

        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());

        assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));


    }
}