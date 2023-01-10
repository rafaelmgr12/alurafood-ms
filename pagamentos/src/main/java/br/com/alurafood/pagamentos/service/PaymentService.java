package br.com.alurafood.pagamentos.service;

import br.com.alurafood.pagamentos.dto.PaymentDto;
import br.com.alurafood.pagamentos.entities.Payment;
import br.com.alurafood.pagamentos.entities.Status;
import br.com.alurafood.pagamentos.http.OrderedClient;
import br.com.alurafood.pagamentos.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private OrderedClient order;

    public Page<PaymentDto> findAll(Pageable pageable) {
        Page<Payment> payments = repository.findAll(pageable);
        return payments.map(payment -> mapper.map(payment, PaymentDto.class));
    }

    public PaymentDto getById(Long id) {
        Payment payment = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return mapper.map(payment, PaymentDto.class);
    }

    public PaymentDto createPayment(PaymentDto dto){
        Payment payment = mapper.map(dto, Payment.class);
        payment.setStatus(Status.CREATED);
        repository.save(payment);

        return mapper.map(payment, PaymentDto.class);

    }

    public PaymentDto updatePayment(Long id, PaymentDto dto){
        Payment payment = mapper.map(dto, Payment.class);
        payment.setId(id);
         repository.save(payment);
        return mapper.map(payment, PaymentDto.class);
    }

    public void deletePayment(Long id){
        repository.deleteById(id);
    }

    public void confirmPayment(Long id){
        Optional<Payment> payment = repository.findById(id);
        if(!payment.isPresent()){
            throw new EntityNotFoundException();
        }
        payment.get().setStatus(Status.APPROVED);
        repository.save(payment.get());
        order.atualizaPagamento(payment.get().getId());
    }

    public void changeStatus(Long id){
        Optional<Payment> payment = repository.findById(id);

        if (!payment.isPresent()){
            throw new EntityNotFoundException();
        }
        payment.get().setStatus(Status.APPROVED_WITHOUT_CONFIRMATION);
        repository.save(payment.get());
    }
}
