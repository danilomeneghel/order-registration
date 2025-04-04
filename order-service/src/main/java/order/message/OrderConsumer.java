package order.message;

import order.dto.OrderCreateDTO;
import order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    private final OrderService orderService;

    public OrderConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = "orders")
    public void receiveMessage(OrderCreateDTO orderCreateDTO) {
        try {
            System.out.println("Consumed order message: " + orderCreateDTO);
            orderService.createOrder(orderCreateDTO);
        } catch (Exception e) {
            System.err.println("Unexpected error while processing message: " + e.getMessage());
        }
    }
}
