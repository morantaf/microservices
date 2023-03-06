package com.microservices.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order_lines_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItems {

    @Id
    @SequenceGenerator(name = "order_lines_items_sequence", allocationSize = 1, sequenceName = "order_lines_items_sequence")
    @GeneratedValue(generator = "order_lines_items_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
