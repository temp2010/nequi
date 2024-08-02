package com.nequi.franchise_api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "franchise")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Franchise {

    @Id
    private Long id;

    @Column()
    private String name;

}