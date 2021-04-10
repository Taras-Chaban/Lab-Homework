package lab.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE implements Validating {
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

    @PostConstruct
    public void init() {
        System.out.println("This is BeanE init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("This is BeanE destroy method");
    }
}
