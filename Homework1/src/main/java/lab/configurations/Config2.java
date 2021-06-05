package lab.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {"lab.beans2", "lab.beans3"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Bean[^DF]")
        }
)
public class Config2 {
}

