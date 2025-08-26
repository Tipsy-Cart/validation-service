package com.covoro.validationservice.bean.ublxmlbeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.covoro.validationservice.constant.Namespaces;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * <h1>Invoice Line Entity</h1>
 * This class represents a line item in an invoice.
 * It contains fields for the price, item, tax total, item price extension, line extension amount, invoiced quantity, and allowance charge.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "InvoiceLine", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class InvoiceLine {

    @JacksonXmlProperty(localName = "ID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String id;

    @JacksonXmlProperty(localName = "Note", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "Note", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String note;

    @JacksonXmlProperty(localName = "InvoicedQuantity", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "InvoicedQuantity", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private InvoicedQuantity invoicedQuantity;

    @JacksonXmlProperty(localName = "LineExtensionAmount ", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "LineExtensionAmount ", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount lineExtensionAmount ;

    @JacksonXmlProperty(localName = "AccountingCost", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "AccountingCost", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private String accountingCost;

    @JacksonXmlProperty(localName = "InvoicePeriod", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "InvoicePeriod", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private InvoicePeriod invoicePeriod;

    @JacksonXmlProperty(localName = "OrderLineReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "OrderLineReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private OrderLineReference orderLineReference;

    @JacksonXmlProperty(localName = "AllowanceCharge", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "AllowanceCharge", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<AllowanceCharge> allowanceChargeList;

    @JacksonXmlProperty(localName = "Item", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "Item", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private Item item;

    @JacksonXmlProperty(localName = "Price", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "Price", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private Price price;

    @JacksonXmlProperty(localName = "ItemPriceExtension", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "ItemPriceExtension", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private ItemPriceExtension itemPriceExtension;

}
