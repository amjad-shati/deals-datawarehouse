package com.progresssoft.deals.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DealResponse {
    private Long dealId;
    private String fromCurrencyIsocode;
    private String toCurrencyIsocode;
    private BigDecimal amount;
    private Date createdAt;
}
