package lab.beans;

public class BeanC {
    private final String name;
    private final int value;

    @Override
    public String toString() {
        return "This is " + name + "with value: " + value;
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
