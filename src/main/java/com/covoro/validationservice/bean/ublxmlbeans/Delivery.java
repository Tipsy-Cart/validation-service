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
 * <h1>Delivery</h1>
 * This class represents the delivery details associated with an invoice or shipment.
 * It contains fields for the delivery party and shipment information.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Delivery", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class Delivery {

    @JacksonXmlProperty(localName = "ActualDeliveryDate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ActualDeliveryDate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String actualDeliveryDate;

    @JacksonXmlProperty(localName = "DeliveryLocation", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "DeliveryLocation", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private DeliveryLocation deliveryLocation;

    @JacksonXmlProperty(localName = "DeliveryParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "DeliveryParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private DeliveryParty deliveryParty;
    
}
