package com.progresssoft.deals.repository.impl;

import com.progresssoft.deals.entity.DealEntity;
import com.progresssoft.deals.exception.DealAlreadyExistsException;
import com.progresssoft.deals.exception.DealNotFoundException;
import com.progresssoft.deals.exception.UnknownException;
import com.progresssoft.deals.jpa.DealsJpaRepository;
import com.progresssoft.deals.repository.DealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class DealsRepositoryImpl implements DealsRepository {
    private static final String DEAL_NOT_FOUND = "No deal was found for ID: ";
    private static final String DEAL_ALREADY_EXISTS = "Deal already exists, duplicate ID: ";
    private static final String UNEXPECTED_ERROR = "An unexpected error occurred";
    @Autowired
    private DealsJpaRepository dealsJpaRepository;

    @Override
    public DealEntity getByDealId(Long dealId) {
        try{
            final Optional<DealEntity> result = dealsJpaRepository.findByDealId(dealId);
            if(result.isPresent()){
                return result.get();
            }
        }
        catch (Exception e){
            throw new UnknownException(UNEXPECTED_ERROR, e);
        }
        throw new DealNotFoundException(DEAL_NOT_FOUND + dealId);
    }

    @Override
    public Page<DealEntity> getNewerThan(Date date, Pageable pageable) {
        try{
            final Page<DealEntity> result = dealsJpaRepository.findAllByCreatedAtAfter(date, pageable);
            return result;
        }
        catch (Exception e){
            throw new UnknownException(UNEXPECTED_ERROR, e);
        }
    }

    @Override
    public void add(DealEntity deal) {
        try{
            final Optional<DealEntity> result = dealsJpaRepository.findByDealId(deal.getDealId());
            if(result.isEmpty()){
                dealsJpaRepository.save(deal);
            }
            else{
                throw new DealAlreadyExistsException(DEAL_ALREADY_EXISTS + deal.getDealId());
            }
        }
        catch (DealAlreadyExistsException e){
            throw e;
        }
        catch (Exception e){
            throw new UnknownException(UNEXPECTED_ERROR, e);
        }
    }

    @Override
    public void addAll(List<DealEntity> deals) {
        deals.forEach(this::add);
    }
}
