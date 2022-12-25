package br.com.alurafood.pagamentos.repository;

import br.com.alurafood.pagamentos.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository  extends JpaRepository<Payment, Long> {

}

