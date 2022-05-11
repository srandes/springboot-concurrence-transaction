package com.example.tx.repository;

import com.example.tx.domain.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    @Query("SELECT coalesce(max(iv.number), 0) FROM Invoice iv")
    Integer getMaxNumber();    
}
