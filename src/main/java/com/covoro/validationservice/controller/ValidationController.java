package com.covoro.validationservice.controller;

import com.covoro.validationservice.bean.ApiResponse;
import com.covoro.validationservice.bean.ublxmlbeans.Invoice;
import com.covoro.validationservice.config.UBLNamespacePrefixMapper;
import com.covoro.validationservice.constant.AppConstant;
import com.covoro.validationservice.constant.ValidationServiceError;
import com.covoro.validationservice.exception.ValidationServiceException;
import com.covoro.validationservice.handler.ValidationHandler;
import com.covoro.validationservice.logging.Logger;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
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

    @PostMapping("${api.validation-service.validation.validate-xml.POST.uri}")
    public ResponseEntity<ApiResponse> validateXML(@PathVariable String id,
                                                   @RequestBody String xml) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        XmlMapper xmlMapper = new XmlMapper();
        Invoice ublInvoice = null;
        try {
            ublInvoice = xmlMapper.readValue(xml, Invoice.class);
        } catch (JsonProcessingException e) {
            logger.trace("Exception While Converting XML to POJO ", e);
            throw new ValidationServiceException(ValidationServiceError.VALIDATION_SERVICE_EXCEPTION, e.getMessage());

        }
        //this.convertToXml(ublInvoice);
        System.out.println(mapper.writeValueAsString(ublInvoice));
        Map<String, String> errors = validationHandler.validateJson(id, mapper.writeValueAsString(ublInvoice));
        if (errors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse().setStatus(AppConstant.STATUS_SUCCESS).setPayload("Validation Successful"));
        } else {
            if(errors.containsKey("AccountingSupplierParty.Party.PartyLegalEntity.CompanyID.schemeAgencyName")){
                String message = errors.get("AccountingSupplierParty.Party.PartyLegalEntity.CompanyID.schemeAgencyName");
                String a = null;
                String b= null;
                switch (ublInvoice.getAccountingSupplierParty().getParty().getPartyLegalEntity().getCompanyID().getSchemeAgencyID())
                {
                    case "TL":
                        a = "Trade Licsence issuing Authority name";
                        b = "TL";
                        break;
                    case "PAS":
                        a = "Passport issuing Country";
                        b = "PAS";
                        break;
                }
                message = String.format(message, a,b);
                errors.put("AccountingSupplierParty.Party.PartyLegalEntity.CompanyID.schemeAgencyName", message);
            }
            throw new ValidationServiceException(ValidationServiceError.JSON_VALIDATION_ERROR, errors);
        }
    }

    private void convertToXml(Invoice invoice) {
        try {
            JAXBContext context = JAXBContext.newInstance(Invoice.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Use namespace prefix mapper
            marshaller.setProperty("org.glassfish.jaxb.namespacePrefixMapper", new UBLNamespacePrefixMapper());

            marshaller.marshal(invoice, System.out);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("${api.validation-service.validation.validate-drool.POST.uri}")
    public ResponseEntity<ApiResponse> validateDrool(@PathVariable String id,
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

    @PostMapping(value = "/json/{id}")
    public ResponseEntity<ApiResponse> relaodJsonSchema(@PathVariable String id) {
        this.validationHandler.reloadJsonSchema(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse().setStatus(AppConstant.STATUS_SUCCESS));
    }
}
