package lab.injectionBeans;

import lab.otherBeans.OtherBeanB;
import org.springframework.beans.factory.annotation.Autowired;

public class InjectOtherBeanB {
    @Autowired
    private OtherBeanB otherBeanB;

    @Autowired
    public void setOtherBeanB(OtherBeanB otherBeanB) {
        this.otherBeanB = otherBeanB;
    }

    @Autowired
    public InjectOtherBeanB(OtherBeanB otherBeanB) {
        this.otherBeanB = otherBeanB;
    }
}
