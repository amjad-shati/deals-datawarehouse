package com.progresssoft.deals.mapper;

import com.progresssoft.deals.dto.DealRequest;
import com.progresssoft.deals.dto.DealResponse;
import com.progresssoft.deals.entity.DealEntity;

import java.util.List;

public interface DealMapper {
    DealResponse map(DealEntity entity);
    DealEntity map(DealRequest request);
    List<DealResponse> mapAll(List<DealEntity> entities);
}
