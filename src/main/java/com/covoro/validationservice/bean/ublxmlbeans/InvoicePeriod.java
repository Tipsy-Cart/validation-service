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

/**
 * <h1>Invoice Period Entity</h1>
 * This class represents the period covered by an invoice.
 * It contains fields for the start date and end date of the invoice period.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "InvoicePeriod", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class InvoicePeriod {

    @JacksonXmlProperty(localName = "StartDate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "StartDate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String startDate;

    @JacksonXmlProperty(localName = "EndDate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "EndDate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String endDate;

    @JacksonXmlProperty(localName = "DescriptionCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "DescriptionCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String descriptionCode;

}
