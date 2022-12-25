package br.com.alurafood.pagamentos.dto;

import br.com.alurafood.pagamentos.entities.Status;

import java.math.BigDecimal;

public class PaymentDto {

        private Long id;
        private BigDecimal value;
        private String name;
        private String number;
        private String expiration;
        private String cvc;
        private Status status;
        private Long orderedId;
        private Long paymentFormId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
