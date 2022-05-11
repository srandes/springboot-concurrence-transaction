package com.example.tx.service;

import java.util.concurrent.TimeUnit;

import com.example.tx.domain.Invoice;
import com.example.tx.domain.InvoiceQueue;
import com.example.tx.repository.InvoiceQueueRepository;
import com.example.tx.repository.InvoiceRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceQueueRepository invoiceQueueRepository;

    public Invoice generateInvoice(String identifier) {
        InvoiceQueue queue = saveQueue();        
        return saveInvoice(identifier, queue);
    }

    @Transactional
    public Invoice saveInvoice(String identifier, InvoiceQueue invoiceQueue) {                               
        sleep(); // simula um request a um sistema externo que demora um minuto para responder
        udpateQueue(invoiceQueue);              
        Invoice invoice = Invoice.builder()
          .number(invoiceQueue.getNumber())
          .identifier(identifier)
          .build();
        invoiceRepository.save(invoice);
        return invoice;      
    }
    
    private void sleep() {
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {            
            e.printStackTrace();
        }
    }

    private InvoiceQueue saveQueue() {
        Integer max = invoiceQueueRepository.getMaxNumberWaiting();
        if (max.equals(0)) {
            max = invoiceRepository.getMaxNumber();
        }      
        return invoiceQueueRepository.save(InvoiceQueue.builder().number(++max).build());
    }

    private void udpateQueue(InvoiceQueue invoiceQueue) {
        invoiceQueue.setStatus("returned");
        invoiceQueueRepository.save(invoiceQueue);
    }
    
}
