package com.yalco.estore.entity.customer;

import com.yalco.estore.entity.Cart;
import com.yalco.estore.entity.customer.contacts.CustomerContacts;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name= "id",updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "contact_id",nullable = false)
    private CustomerContacts contacts;

    @OneToOne
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cart;
}
