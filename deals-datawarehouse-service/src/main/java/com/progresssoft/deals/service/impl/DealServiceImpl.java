package com.progresssoft.deals.service.impl;

import com.progresssoft.deals.dto.DealRequest;
import com.progresssoft.deals.dto.DealResponse;
import com.progresssoft.deals.dto.DealsListResponse;
import com.progresssoft.deals.entity.DealEntity;
import com.progresssoft.deals.exception.MissingOrInvalidMandatoryFieldsException;
import com.progresssoft.deals.mapper.DealMapper;
import com.progresssoft.deals.repository.DealsRepository;
import com.progresssoft.deals.service.DealService;
import com.progresssoft.deals.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DealServiceImpl implements DealService {
    private static final String DEAL_ID_IS_NULL = "dealId must not be null";
    private static final String DATE_IS_NULL = "date must not be null";

    @Autowired
    private DealsRepository dealsRepository;
    @Autowired
    private DealMapper dealMapper;
    @Autowired
    private Validator<DealRequest> dealRequestValidator;
    @Override
    public void create(DealRequest request) {
        dealRequestValidator.validate(request);
        dealsRepository.add(dealMapper.map(request));
    }

    @Override
    public DealResponse get(Long dealId) {
        if(dealId == null){
            throw new MissingOrInvalidMandatoryFieldsException(DEAL_ID_IS_NULL);
        }
        return dealMapper.map(dealsRepository.getByDealId(dealId));
    }

    @Override
    public DealsListResponse getCreatedAfter(Date date, int pageNumber, int pageSize) {
        if(date == null){
            throw new MissingOrInvalidMandatoryFieldsException(DATE_IS_NULL);
        }
        final Page<DealEntity> page = dealsRepository.getNewerThan(date, PageRequest.of(Math.max(pageNumber, 0), Math.min(pageSize, 50), Sort.unsorted()));
        return DealsListResponse.builder()
                .currentPage(page.getNumber())
                .pageSize(page.getSize())
                .numberOfPages(page.getTotalPages())
                .result(dealMapper.mapAll(page.getContent()))
                .build();
    }
}
