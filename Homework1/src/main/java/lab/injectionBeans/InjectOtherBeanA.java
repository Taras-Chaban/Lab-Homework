package lab.injectionBeans;

import lab.otherBeans.OtherBeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class InjectOtherBeanA {
    @Autowired
    @Qualifier("otherBeanA")
    private OtherBeanA otherBeanA;
}
