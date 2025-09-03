package com.covoro.validationservice.bean.ublxmlbeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
 * <h1>Delivery Party</h1>
 * This class represents a party involved in the delivery process.
 * It contains fields for the legal entity, registration name, postal address, and party identification.
 *
 * @Author Sayali.Wagh
 * @Version 1.0
 * @Since 2025-03-19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DeliveryParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class DeliveryParty {

    @JacksonXmlProperty(localName = "PartyName", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PartyName", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PartyName partyName;

}
