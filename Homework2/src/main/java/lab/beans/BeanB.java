package lab.beans;


public class BeanB {
    private final String name;
    private final int value;

    @Override
    public String toString() {
        return "This is " + name + "with value: " + value;
    }

    public BeanB(String name, String value) {
        this.name = name;
        this.value = Integer.parseInt(value);
    }

    public void init() {
        System.out.println("It is an BeanB init method");
    }

    public void destroy() {
        System.out.println("It is an BeanB init method");
    }
}
