package com.alog.logistica.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Customer customer;
    @Embedded
    private Recipient recipient;
    private BigDecimal tax;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    private LocalDateTime orderDate;
    private LocalDateTime deliveredDate;


}
