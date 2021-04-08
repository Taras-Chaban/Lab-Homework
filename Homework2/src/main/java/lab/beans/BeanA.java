package lab.beans;

public class BeanA {
    private String name;
    private String value;

    @Override
    public String toString() {
        return "This is " + name + "with value: " + value;
    }

    public BeanA(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
