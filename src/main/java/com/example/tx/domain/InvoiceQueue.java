package com.example.tx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class InvoiceQueue {
    @Id
    private Integer number; 
    @Default 
    @Setter  
    private String status = "waiting";
}
