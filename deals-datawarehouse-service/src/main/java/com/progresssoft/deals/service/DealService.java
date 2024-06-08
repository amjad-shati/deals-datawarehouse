package com.progresssoft.deals.service;

import com.progresssoft.deals.dto.DealRequest;
import com.progresssoft.deals.dto.DealResponse;
import com.progresssoft.deals.dto.DealsListResponse;

import java.util.Date;

public interface DealService {
    void create(DealRequest request);
    DealResponse get(Long dealId);
    DealsListResponse getCreatedAfter(Date date, int pageNumber, int pageSize);
}
