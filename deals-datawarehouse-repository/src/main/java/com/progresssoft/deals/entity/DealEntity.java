package com.progresssoft.deals.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "DEALS")
public class DealEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "DEAL_ID", nullable = false, unique = true)
    private Long dealId;

    @Column(name = "ORDERING_CURRENCY", nullable = false, unique = false)
    private String orderingCurrencyIsocode;

    @Column(name = "DESTINATION_CURRENCY", nullable = false, unique = false)
    private String destinationCurrencyIsocode;

    @Column(name = "AMOUNT", nullable = false, unique = false)
    private BigDecimal amount;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name = "UPDATED_AT", nullable = true, updatable = false)
    @LastModifiedDate
    private Date updatedAt;
}
