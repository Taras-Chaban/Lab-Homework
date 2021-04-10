package lab.beans;

public class BeanC implements Validating {
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

    public BeanC(String name, String value) {
        this.name = name;
        this.value = Integer.parseInt(value);
    }

    public void init() {
        System.out.println("This is an BeanC init method");
    }

    public void destroy() {
        System.out.println("This is an BeanC destroy method");
    }
}
