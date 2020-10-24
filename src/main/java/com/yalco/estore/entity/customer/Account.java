package com.yalco.estore.entity.customer;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;


@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name= "id",updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String iban;

    @Column(nullable = false)
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer accountOwner;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Customer getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(Customer accountOwner) {
        this.accountOwner = accountOwner;
    }
}
