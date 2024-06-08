package com.progresssoft.deals.jpa;

import com.progresssoft.deals.entity.DealEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface DealsJpaRepository extends JpaRepository<DealEntity, Long> {
    Optional<DealEntity> findByDealId(Long dealId);
    Page<DealEntity> findAllByCreatedAtAfter(Date createdAt, Pageable pageable);
}
