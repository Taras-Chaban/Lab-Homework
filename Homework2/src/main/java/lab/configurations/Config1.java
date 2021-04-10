package lab.configurations;

import lab.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("lab.beans")
@PropertySource("classpath:/Beans.properties")
public class Config1 {
    private Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanD")
    public BeanB beanB() {
        return new BeanB(env.getProperty("BeanB.name"), env.getProperty("BeanB.value"));
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanB")
    public BeanC beanC() {
        return new BeanC(env.getProperty("BeanC.name"), env.getProperty("BeanC.value"));
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanD beanD() {
        return new BeanD(env.getProperty("BeanD.name"), env.getProperty("BeanD.value"));
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }

}
