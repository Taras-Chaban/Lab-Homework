package lab.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanA implements InitializingBean, DisposableBean {
    private String name;
    private int value;

    @Override
    public String toString() {
        return "This is " + name + "with value: " + value;
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
