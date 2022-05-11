package com.example.tx.repository;

import com.example.tx.domain.InvoiceQueue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceQueueRepository extends JpaRepository<InvoiceQueue, Integer> {
    @Query("SELECT coalesce(max(iq.number), 0) FROM InvoiceQueue iq WHERE iq.status = 'waiting'")
    Integer getMaxNumberWaiting();
}
