package lab.injectionBeans;

import lab.otherBeans.OtherBeanB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectOtherBeanB {
    private OtherBeanB otherBeanB;

    @Autowired
    public InjectOtherBeanB(OtherBeanB otherBeanB) {
        this.otherBeanB = otherBeanB;
    }
}
