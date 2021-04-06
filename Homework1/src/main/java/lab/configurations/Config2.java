package lab.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan({"lab.beans2", "lab.beans3"})
public class Config2 {
}
