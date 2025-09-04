package com.covoro.validationservice.bean.ublxmlbeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.covoro.validationservice.constant.Namespaces;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * <h1>Tax Total Entity</h1>
 * This class represents the total tax amount for an invoice.
 * The tax amount field is validated to ensure that it is not empty, null, or blank.
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TaxTotal", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class TaxTotal {

    @JacksonXmlProperty(localName = "TaxAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "TaxAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount taxAmount;

    @JacksonXmlProperty(localName = "TaxIncludedIndicator", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "TaxIncludedIndicator", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Boolean taxIncludedIndicator;

    @JacksonXmlProperty(localName = "TaxSubtotal", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "TaxSubtotal", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<TaxSubtotal> taxSubtotal;

}
