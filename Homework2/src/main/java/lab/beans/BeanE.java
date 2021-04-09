package lab.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE {
    private final String name;
    private final int value;

    @Override
    public String toString() {
        return "This is " + name + "with value: " + value;
    }

    public BeanE(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @PostConstruct
    public void init() {
        System.out.println("This is BeanE init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("This is BeanE destroy method");
    }
}
