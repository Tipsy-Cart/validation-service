package com.covoro.validationservice.bean.ublxmlbeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.covoro.validationservice.constant.Namespaces;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TaxSubtotal", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class TaxSubtotal {

    @JacksonXmlProperty(localName = "TaxableAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "TaxableAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount taxableAmount;

    @JacksonXmlProperty(localName = "TaxAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "TaxAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount taxAmount;

    @JacksonXmlProperty(localName = "TaxCategory", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "TaxCategory", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private TaxCategory taxCategory;

}