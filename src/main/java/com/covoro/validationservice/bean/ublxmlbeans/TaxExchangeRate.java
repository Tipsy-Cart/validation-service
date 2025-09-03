package com.covoro.validationservice.bean.ublxmlbeans;

import com.covoro.validationservice.constant.Namespaces;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TaxExchangeRate", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class TaxExchangeRate {

    @JacksonXmlProperty(localName = "CalculationRate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "CalculationRate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Double calculationRate;

}
