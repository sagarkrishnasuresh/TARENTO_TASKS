package com.example.Entity_Audit;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepo repo;

    public Order addOrder(Order order) {
        return repo.save(order);

    }

    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    public Order getOrderById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Order updateOrder(Order order) {
        Optional<Order> existingOrderOpt = repo.findById(order.getId());
        if (existingOrderOpt.isPresent()) {
            Order existingOrder = existingOrderOpt.get();
            // Update fields
            existingOrder.setOrderDate(order.getOrderDate()); // Update orderDate
            existingOrder.setStatus(order.getStatus()); // Update status
            // Do not modify createdDate
            existingOrder.setLastModifiedDate(LocalDateTime.now()); // Update lastModifiedDate

            return repo.save(existingOrder);
        } else {
            // Handle the case where the order does not exist
            return null;
        }


    }
}
