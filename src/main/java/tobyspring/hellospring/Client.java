package tobyspring.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);

        Payment payment = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
        System.out.println("---------------\n");
        Payment payment2 = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment2);

        TimeUnit.SECONDS.sleep(1);

        System.out.println("---------------\n");
        Payment payment3 = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment3);

        TimeUnit.SECONDS.sleep(2);

        System.out.println("---------------\n");
        Payment payment4 = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment4);
        System.out.println("---------------\n");
        Payment payment5 = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment5);

    }
}
