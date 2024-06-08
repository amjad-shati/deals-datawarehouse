package com.progresssoft.deals.controller;

import com.progresssoft.deals.dto.DealRequest;
import com.progresssoft.deals.dto.DealResponse;
import com.progresssoft.deals.dto.DealsListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@RequestMapping(value = "/deals")
public interface DealsDataWarehouseController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(method = "Method to create a new deal record.", description = "This method used when you want to create a new deal record in the date warehouse.")
    void create(DealRequest request);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{dealId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(method = "Method to retrieve a certain deal record.", description = "This method is used when you want to retrieve a certain deal record by deal ID.")
    @Parameter(description = "Deal ID of the deal you want to retrieve", name = "dealId")
    DealResponse getByDealId(Long dealId);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(method = "Method to retrieve deal records created after a certain date.", description = "This method is used when you want to retrieve deal records created after a certain date.")
    @Parameter(description = "Example: 2000-10-31T01:30:00.000-05:00", name = "date")
    @Parameter(description = "The page you want to retrieve", name = "pageNumber")
    @Parameter(description = "The number of maximum deals retrieved in the page.", name = "pageSize")
    DealsListResponse getDealsCreatedAfter(Date date, int pageNumber, int pageSize);
}
