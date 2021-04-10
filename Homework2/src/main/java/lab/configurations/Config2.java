package lab.configurations;

import lab.beans.*;
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

    @Bean
    public static BeanFactoryPostProcessorImpl beanFactoryPostProcessor() {
        return new BeanFactoryPostProcessorImpl();
    }

    @Bean
    public BeanPostProcessorImpl beanPostProcessorIml() {
        return new BeanPostProcessorImpl();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);

        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s);
        }

        System.out.println("-----------------------");

        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(context.getBeanDefinition(s));
        }

        System.out.println("-----------------------");

        for (String s : context.getBeanDefinitionNames()) {
            Object bean = context.getBean(s);
            if (bean instanceof Validating) {
                System.out.println(bean);
            }
        }

        context.close();
    }

}
