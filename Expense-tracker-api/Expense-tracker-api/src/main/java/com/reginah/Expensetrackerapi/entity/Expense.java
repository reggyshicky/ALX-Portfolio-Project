package com.reginah.Expensetrackerapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data  //@Data - Lombok https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.30
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "expense_name")
    private String name;

    private String description;
    @Column(name = "expense_amount")
    private BigDecimal amount;

    private String category;
    private Date date;





}