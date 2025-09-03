package com.covoro.validationservice.bean.ublxmlbeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.covoro.validationservice.constant.Namespaces;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "LegalMonetaryTotal", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class LegalMonetaryTotal {

    @JacksonXmlProperty(localName = "LineExtensionAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "LineExtensionAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount lineExtensionAmount;

    @JacksonXmlProperty(localName = "TaxExclusiveAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "TaxExclusiveAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount taxExclusiveAmount;

    @JacksonXmlProperty(localName = "TaxInclusiveAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "TaxInclusiveAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount taxInclusiveAmount;

    @JacksonXmlProperty(localName = "AllowanceTotalAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "AllowanceTotalAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount allowanceTotalAmount;

    @JacksonXmlProperty(localName = "ChargeTotalAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ChargeTotalAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount chargeTotalAmount;

    @JacksonXmlProperty(localName = "PrepaidAmount ", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "PrepaidAmount ", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount prepaidAmount ;

    @JacksonXmlProperty(localName = "PayableRoundingAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "PayableRoundingAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount payableRoundingAmount;

    @JacksonXmlProperty(localName = "PayableAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "PayableAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount payableAmount;

}
