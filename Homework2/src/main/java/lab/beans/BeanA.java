package lab.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanA implements InitializingBean, DisposableBean, Validating {
    private String name;
    private int value;

    @Override
    public void validate() {
        if (name == null) {
            name = "It is default name from validation";
        }
        if (value < 1) {
            value = 1;
        }
    }

    @Override
    public String toString() {
        return "This is " + name + " with value: " + value;
    }

    @Override
    public void destroy() {
        System.out.println("This is BeanA destroy method");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("This is BeanA init method");
    }
}
