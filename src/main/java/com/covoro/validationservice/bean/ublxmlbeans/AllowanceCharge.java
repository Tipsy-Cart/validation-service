package com.covoro.validationservice.bean.ublxmlbeans;

import com.covoro.validationservice.constant.Namespaces;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * <h1>Allowance Charge</h1>
 * This class represents an allowance or charge associated with an invoice or document.
 * It contains fields for the charge indicator, amount, and multiplier factor numeric.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AllowanceCharge", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class AllowanceCharge {

    @JacksonXmlProperty(localName = "ChargeIndicator", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ChargeIndicator", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Boolean chargeIndicator;

    @JacksonXmlProperty(localName = "AllowanceChargeReasonCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "AllowanceChargeReasonCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String AllowanceChargeReasonCode;

    @JacksonXmlProperty(localName = "AllowanceChargeReason", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "AllowanceChargeReason", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String AllowanceChargeReason;

    @JacksonXmlProperty(localName = "MultiplierFactorNumeric", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "MultiplierFactorNumeric", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String MultiplierFactorNumeric;

    @JacksonXmlProperty(localName = "Amount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "Amount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount amount;

    @JacksonXmlProperty(localName = "BaseAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "BaseAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount baseAmount ;

    @JacksonXmlProperty(localName = "TaxCategory", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "TaxCategory", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private TaxCategory taxCategory ;


}
