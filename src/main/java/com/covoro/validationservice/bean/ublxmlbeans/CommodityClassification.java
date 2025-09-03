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

/**
 * <h1>Commodity Classification</h1>
 * This class represents commodity classification information.
 * It contains a field for the item classification code.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CommodityClassification", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)

public class CommodityClassification {

    @JacksonXmlProperty(localName = "CommodityCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "CommodityCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String commodityCode;

    @JacksonXmlProperty(localName = "NatureCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "NatureCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String natureCode;

    @JacksonXmlProperty(localName = "ItemClassificationCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ItemClassificationCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private ItemClassificationCode itemClassificationCode;

}
