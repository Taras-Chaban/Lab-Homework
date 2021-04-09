package lab.configurations;

import lab.beans.BeanA;
import lab.beans.BeanE;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Config1.class)
public class Config2 {

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean
    public BeanE beanE() {
        return new BeanE();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);

        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s);
        }

        context.close();
    }

}
