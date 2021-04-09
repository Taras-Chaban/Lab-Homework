package lab.configurations;

import lab.beans.BeanB;
import lab.beans.BeanC;
import lab.beans.BeanD;
import lab.beans.BeanF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("lab.beans")
@PropertySource("classpath:/Beans.properties")
public class Config1 {
    @Autowired
    private Environment env;

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Order(2)
    public BeanB beanB() {
        return new BeanB(env.getProperty("BeanB.name"), env.getProperty("BeanB.value"));
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Order(3)
    public BeanC beanC() {
        return new BeanC(env.getProperty("BeanC.name"), env.getProperty("BeanC.value"));
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Order(1)
    public BeanD beanD() {
        return new BeanD(env.getProperty("BeanD.name"), env.getProperty("BeanD.value"));
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);

        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s);
        }
    }

}
