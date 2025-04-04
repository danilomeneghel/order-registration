package order.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import order.dto.OrderCreateDTO;

@Component
public class OrderProducer {
    
    private final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(OrderCreateDTO orderCreateDTO) {
        try {
            rabbitTemplate.convertAndSend("orders", orderCreateDTO);
            System.out.println("Produced order message: " + orderCreateDTO);
        } catch (Exception e) {
            System.err.println("Unexpected error while sending message: " + e.getMessage());
        }
    }
}
