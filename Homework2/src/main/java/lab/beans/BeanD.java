package lab.beans;

public class BeanD {
    private String name;
    private String value;

    @Override
    public String toString() {
        return "This is " + name + "with value: " + value;
    }

    public BeanD(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
