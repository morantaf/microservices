package com.microservice.inventoryservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @SequenceGenerator(name = "inventory_sequence", allocationSize = 1, sequenceName = "inventory_sequence")
    @GeneratedValue(generator = "inventory_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String skuCode;
    private Integer quantity;
}
