package com.reginah.Expensetrackerapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
    @NotNull(message = "Expense name must not be null")
    @Size(min=3, message = "Expense name must be atleast 3 characters")
    private String name;

    private String description;
    @Column(name = "expense_amount")
    private BigDecimal amount;

    private String category;
    private Date date;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @Column(name = "updated_at", nullable = false, updatable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;
}