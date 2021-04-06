package lab.injectionBeans;


import lab.otherBeans.*;
import org.springframework.beans.factory.annotation.Autowired;

public class InjectOtherBeanC {
    @Autowired
    private OtherBeanC otherBeanC;

    @Autowired
    public void setOtherBeanC(OtherBeanC otherBeanC) {
        this.otherBeanC = otherBeanC;
    }

    @Autowired
    public InjectOtherBeanC(OtherBeanC otherBeanC) {
        this.otherBeanC = otherBeanC;
    }
}
