package lab.injectionBeans;

import lab.otherBeans.OtherBeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectOtherBeanA {
    @Autowired
    private OtherBeanA otherBeanA;

    public OtherBeanA getOtherBeanA() {
        return otherBeanA;
    }

    @Autowired
    public void setOtherBeanA(OtherBeanA otherBeanA) {
        this.otherBeanA = otherBeanA;
    }

    @Autowired
    public InjectOtherBeanA(OtherBeanA otherBeanA) {
        this.otherBeanA = otherBeanA;
    }
}
