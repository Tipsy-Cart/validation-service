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

/**
 * <h1>Tax Category Entity</h1>
 * This class represents a tax category used in an invoice.
 * It contains fields for the percentage, tax scheme, and tax exemption reason.
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TaxCategory", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class TaxCategory {

    @JacksonXmlProperty(localName = "ID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String id;

    @JacksonXmlProperty(localName = "Percent", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "Percent", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String percent;

    @JacksonXmlProperty(localName = "TaxScheme", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "TaxScheme", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private TaxScheme taxScheme;

}

