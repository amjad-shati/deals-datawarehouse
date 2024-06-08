package com.progresssoft.deals.validation.impl;

import com.progresssoft.deals.dto.DealRequest;
import com.progresssoft.deals.exception.MissingOrInvalidMandatoryFieldsException;
import com.progresssoft.deals.validation.Validator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.math.BigDecimal;
import java.util.Currency;

@Component("dealRequestValidator")
public class DealRequestValidatorImpl implements Validator<DealRequest> {
    private static final String INVALID_DEAL_ID = "Invalid dealId";
    private static final String INVALID_FROM_CURRENCY = "Invalid fromCurrency";
    private static final String INVALID_TO_CURRENCY = "Invalid fromCurrency";
    private static final String INVALID_AMOUNT = "Invalid amount";

    @Override
    public void validate(DealRequest request) {
        if(request.getDealId() == null){
            throw new MissingOrInvalidMandatoryFieldsException(INVALID_DEAL_ID);
        }
        if(request.getAmount() == null || BigDecimal.ZERO.compareTo(request.getAmount()) > -1){
            throw new MissingOrInvalidMandatoryFieldsException(INVALID_AMOUNT);
        }
        if(!StringUtils.hasText(request.getFromCurrencyIsocode()) || !isValidCurrencyCode(request.getFromCurrencyIsocode())){
            throw new MissingOrInvalidMandatoryFieldsException(INVALID_FROM_CURRENCY);
        }
        if(!StringUtils.hasText(request.getToCurrencyIsocode()) || !isValidCurrencyCode(request.getToCurrencyIsocode())){
            throw new MissingOrInvalidMandatoryFieldsException(INVALID_TO_CURRENCY);
        }
    }

    public static boolean isValidCurrencyCode(String currencyCode) {
        try {
            Currency.getInstance(currencyCode);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
