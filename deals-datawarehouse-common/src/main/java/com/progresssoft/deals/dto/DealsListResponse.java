package com.progresssoft.deals.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DealsListResponse {
    private int currentPage;
    private int numberOfPages;
    private int pageSize;
    private List<DealResponse> result;
}
