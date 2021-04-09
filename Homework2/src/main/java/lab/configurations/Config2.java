package lab.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Config1.class)
public class Config2 {
}
