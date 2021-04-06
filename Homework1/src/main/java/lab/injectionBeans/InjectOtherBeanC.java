package lab.injectionBeans;


import lab.otherBeans.OtherBeanC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class InjectOtherBeanC {
    private OtherBeanC otherBeanC;

    @Autowired
    @Qualifier("otherBeanC")
    public void setOtherBeanC(OtherBeanC otherBeanC) {
        this.otherBeanC = otherBeanC;
    }

}
