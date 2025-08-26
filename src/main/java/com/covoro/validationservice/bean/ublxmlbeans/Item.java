package com.covoro.validationservice.bean.ublxmlbeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
 * <h1>Item Entity</h1>
 * This class represents an item in an invoice.
 * It contains fields for the commodity classification, description, and origin country.
 * The origin country field is validated using the @ValidateCountryCode custom annotation.
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Item", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class Item {

    @JacksonXmlProperty(localName = "Description", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "Description", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String description;

    @JacksonXmlProperty(localName = "Name", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "Name", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String name;

    @JacksonXmlProperty(localName = "BuyersItemIdentification", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "BuyersItemIdentification", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private BuyersItemIdentification buyersItemIdentification;

    @JacksonXmlProperty(localName = "SellersItemIdentification", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "SellersItemIdentification", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private SellersItemIdentification sellersItemIdentification;

    @JacksonXmlProperty(localName = "StandardItemIdentification", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "StandardItemIdentification", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private StandardItemIdentification standardItemIdentification;

    @JacksonXmlProperty(localName = "OriginCountry", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "OriginCountry", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private OriginCountry originCountry;

    @JacksonXmlProperty(localName = "CommodityClassification", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "CommodityClassification", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private CommodityClassification commodityClassification;

    @JacksonXmlProperty(localName = "ClassifiedTaxCategory", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "ClassifiedTaxCategory", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private ClassifiedTaxCategory classifiedTaxCategory;

    @JacksonXmlProperty(localName = "AdditionalItemProperty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "AdditionalItemProperty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private AdditionalItemProperty additionalItemProperty;

}