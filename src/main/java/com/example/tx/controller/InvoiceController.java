package com.example.tx.controller;

import com.example.tx.domain.Invoice;
import com.example.tx.service.InvoiceService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class InvoiceController {

    private final InvoiceService invoiceService; 

    @GetMapping("/generate")
    public ResponseEntity<Invoice> generate(@RequestParam String identifier) {        
        log.info("request executed: {}", identifier);
        return ResponseEntity.ok(invoiceService.generateInvoice(identifier));        
    }
}
