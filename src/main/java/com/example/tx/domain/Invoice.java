package com.example.tx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Invoice {
    @Id
    private Integer number;    
    private String identifier;
}
