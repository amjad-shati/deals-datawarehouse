package com.progresssoft.deals.repository;

import com.progresssoft.deals.entity.DealEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface DealsRepository {
    DealEntity getByDealId(Long dealId);
    Page<DealEntity> getNewerThan(Date date, Pageable pageable);
    void add(DealEntity deal);
    void addAll(List<DealEntity> deals);
}
