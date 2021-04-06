package lab.main;

import lab.injectionBeans.InjectOtherBeanA;
import lab.otherBeans.OtherBeanA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("lab")
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);


        OtherBeanA otherBeanA = context.getBean(InjectOtherBeanA.class).getOtherBeanA();
        System.out.println(otherBeanA.toString());
    }
}
