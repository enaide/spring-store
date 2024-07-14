package com.ecfcode.springstore.infrastructure.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "shippers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipper {
    @Id
    @Column(name = "shipper_id", nullable = false)
    private Long shipper_id;

    @Column(name = "company_name", nullable = false, length = 40)
    private String companyName;

    @Column(name = "phone", length = 24)
    private String phone;

    /*
    @OneToMany(mappedBy = "shipVia")
    private Set<Order> orders = new LinkedHashSet<>();
    */

}