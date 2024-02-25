package com.reginah.Expensetrackerapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data  //@Data - Lombok https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.30
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_expenses")
@Builder
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "expense_name")
    @NotBlank(message = "Expense name must not be null")
    @Size(min=3, message = "Expense name must be atleast 3 characters")
    private String name;

    private String description;

    @Column(name = "expense_amount")
    @NotNull(message = "Expense amount should not be null")
    private BigDecimal amount;

    @NotBlank(message = "Category should not be null")
    private String category;

    @NotNull(message = "Date must not be null")
    private Date date;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false, updatable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //fetch attributes defines how the associated entity shld  be loaded from the database and FetchType.LAZY means that the associated entity will be loaded Lazily(i.e only when accessed
    //optional -association is mandatory and the field can't be null
    //JoinColumn specifies the foreign key column (user_id) in the current entity's table that references the primary key of the associated Entity (User).
    //OnDelete - annotaton specifies the action to be taken by the db when the associated User entity is deleted.OnDeleteAction = CASCADE  indicates that if the referenced User entity is deleted, then all the associated entities should be deleted
    //JsonIgnore - is used to ignore the user field when fetching expenses from the db
}