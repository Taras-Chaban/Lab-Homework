package lab.customBeans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order()
public class Warehouse implements Building {
}
