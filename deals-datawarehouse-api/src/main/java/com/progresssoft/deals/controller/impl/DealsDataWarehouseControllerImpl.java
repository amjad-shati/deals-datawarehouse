package com.progresssoft.deals.controller.impl;

import com.progresssoft.deals.controller.DealsDataWarehouseController;
import com.progresssoft.deals.dto.DealRequest;
import com.progresssoft.deals.dto.DealResponse;
import com.progresssoft.deals.dto.DealsListResponse;
import com.progresssoft.deals.service.DealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class DealsDataWarehouseControllerImpl implements DealsDataWarehouseController {

    @Autowired
    private DealService dealService;

    @Override
    public void create(@RequestBody DealRequest request) {
        log.debug("Create a new deal request received: " + request.toString());
        dealService.create(request);
    }

    @Override
    public DealResponse getByDealId(@PathVariable Long dealId) {
        log.debug("Get deal request received, ID: " + dealId);
        return dealService.get(dealId);
    }

    @Override
    public DealsListResponse getDealsCreatedAfter(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date, @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber, @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) {
        return dealService.getCreatedAfter(date, pageNumber, pageSize);
    }
}
