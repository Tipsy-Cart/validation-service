package com.covoro.validationservice.controller;

import com.covoro.validationservice.bean.ApiResponse;
import com.covoro.validationservice.bean.ublxmlbeans.Invoice;
import com.covoro.validationservice.constant.AppConstant;
import com.covoro.validationservice.constant.ValidationServiceError;
import com.covoro.validationservice.exception.ValidationServiceException;
import com.covoro.validationservice.handler.ValidationHandler;
import com.covoro.validationservice.logging.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ValidationController {

    private final Logger logger;
    private final ValidationHandler validationHandler;

    public ValidationController(Logger logger, ValidationHandler validationHandler) {
        this.logger = logger;
        this.validationHandler = validationHandler;
    }

    @PostMapping("${api.validation-service.validation.validate-json.POST.uri}")
    public ResponseEntity<ApiResponse> validateJson(@PathVariable String id,
                                                    @RequestBody String json) {
        logger.info("Start JSON Validation");
        Map<String, String> errors = validationHandler.validateJson(id, json);
        if (errors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse().setStatus(AppConstant.STATUS_SUCCESS).setPayload("Validation Successful"));
        } else {
            throw new ValidationServiceException(ValidationServiceError.JSON_VALIDATION_ERROR, errors);
        }
    }

    @SneakyThrows
    @PostMapping("${api.validation-service.validation.validate-xml.POST.uri}")
    public ResponseEntity<ApiResponse> validateXML(@RequestParam String id,
                                                   @RequestBody Invoice invoice) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> errors = validationHandler.validateJson(id, mapper.writeValueAsString(invoice));
        if (errors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse().setStatus(AppConstant.STATUS_SUCCESS).setPayload("Validation Successful"));
        } else {
            throw new ValidationServiceException(ValidationServiceError.JSON_VALIDATION_ERROR, errors);
        }
    }

    @PostMapping("${api.validation-service.validation.validate-drool.POST.uri}")
    public ResponseEntity<ApiResponse> validateDrool(@RequestParam String id,
                                                     @RequestParam(required = false) List<String> groups,
                                                     @RequestBody String json) {
        Map<String, String> errors = validationHandler.validateDrool(id, groups, json);
        if (errors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse().setStatus(AppConstant.STATUS_SUCCESS).setPayload("Validation Successful"));
        } else {
            throw new ValidationServiceException(ValidationServiceError.JSON_VALIDATION_ERROR, errors);
        }
    }

    @PostMapping(value = "/test", consumes = "application/xml")
    public Invoice test(@RequestBody String xml) {
        XmlMapper xmlMapper = new XmlMapper();
        Invoice ublInvoice = null;
        try {
            ublInvoice = xmlMapper.readValue(xml, Invoice.class);
        } catch (JsonProcessingException e) {
            logger.trace("Exception While Converting XML to POJO ", e);
            throw new ValidationServiceException(ValidationServiceError.VALIDATION_SERVICE_EXCEPTION, e.getMessage());

        }
        return ublInvoice;
    }
}
