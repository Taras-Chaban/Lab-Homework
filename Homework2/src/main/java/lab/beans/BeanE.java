package lab.beans;

public class BeanE {
    private String name;
    private String value;

    @Override
    public String toString() {
        return "This is " + name + "with value: " + value;
    }

    public BeanE(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
