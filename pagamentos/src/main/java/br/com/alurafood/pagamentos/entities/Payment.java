package br.com.alurafood.pagamentos.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @Positive
    private BigDecimal value;

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotBlank
    @Size(min = 3, max = 20)
    private String number;

    @NotBlank
    @Size(max=7)
    private String expiration;

    @NotBlank
    @Size(min=3, max=3)
    private String cvc;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private Long orderedId;

    @NotNull
    private Long paymentFormId;

    public Payment() {

    }

    public Payment(Long id, BigDecimal value, String name, String number, String expiration, String cvc, Status status, Long orderedId, Long paymentFormId) {
        Id = id;
        this.value = value;
        this.name = name;
        this.number = number;
        this.expiration = expiration;
        this.cvc = cvc;
        this.status = status;
        this.orderedId = orderedId;
        this.paymentFormId = paymentFormId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getOrderedId() {
        return orderedId;
    }

    public void setOrderedId(Long orderedId) {
        this.orderedId = orderedId;
    }

    public Long getPaymentFormId() {
        return paymentFormId;
    }

    public void setPaymentFormId(Long paymentFormId) {
        this.paymentFormId = paymentFormId;
    }
}
