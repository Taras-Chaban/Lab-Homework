package lab.beans;


public class BeanF implements Validating {
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

}
