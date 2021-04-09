package lab.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanA implements InitializingBean, DisposableBean {
    private final String name;
    private final int value;

    @Override
    public String toString() {
        return "This is " + name + "with value: " + value;
    }

    public BeanA(String name, int value) {
        this.name = name;
        this.value = value;
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
