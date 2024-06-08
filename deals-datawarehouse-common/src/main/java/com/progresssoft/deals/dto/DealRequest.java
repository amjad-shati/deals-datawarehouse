package com.progresssoft.deals.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DealRequest {
    private Long dealId;
    private String fromCurrencyIsocode;
    private String toCurrencyIsocode;
    private BigDecimal amount;
}
