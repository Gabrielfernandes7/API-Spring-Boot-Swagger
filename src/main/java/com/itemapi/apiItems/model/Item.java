package com.itemapi.apiItems.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id // chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gerar automaticamente a coluna id de uma entidade item
    private Integer id;

    private String name;

}
