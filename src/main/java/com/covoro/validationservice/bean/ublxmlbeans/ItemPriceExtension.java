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
 * <h1>Item Price Extension Entity</h1>
 * This class represents the price extension associated with an item in an invoice.
 * It contains a field for the amount of the price extension.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ItemPriceExtension", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class ItemPriceExtension {

    @JacksonXmlProperty(localName = "Amount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "Amount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount amount;

    @JacksonXmlProperty(localName = "TaxTotal", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "TaxTotal", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private TaxTotal taxTotal;

}
