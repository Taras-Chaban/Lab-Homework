package lab.beans;


public class BeanF {
    private String name;
    private int value;

    @Override
    public String toString() {
        return "This is " + name + "with value: " + value;
    }

    public BeanF(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
