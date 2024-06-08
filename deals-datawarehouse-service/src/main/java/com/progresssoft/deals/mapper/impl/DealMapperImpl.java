package com.progresssoft.deals.mapper.impl;

import com.progresssoft.deals.dto.DealRequest;
import com.progresssoft.deals.dto.DealResponse;
import com.progresssoft.deals.entity.DealEntity;
import com.progresssoft.deals.mapper.DealMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DealMapperImpl implements DealMapper {
    @Override
    public DealResponse map(DealEntity entity) {
        return DealResponse.builder()
                .dealId(entity.getDealId())
                .fromCurrencyIsocode(entity.getOrderingCurrencyIsocode())
                .toCurrencyIsocode(entity.getDestinationCurrencyIsocode())
                .amount(entity.getAmount())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    @Override
    public DealEntity map(DealRequest request) {
        return DealEntity.builder()
                .dealId(request.getDealId())
                .orderingCurrencyIsocode(request.getFromCurrencyIsocode())
                .destinationCurrencyIsocode(request.getToCurrencyIsocode())
                .amount(request.getAmount())
                .build();
    }

    @Override
    public List<DealResponse> mapAll(List<DealEntity> entities) {
        return entities.stream().map(this::map).collect(Collectors.toList());
    }
}
