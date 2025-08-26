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
 * <h1>Party Entity</h1>
 * This class represents a party associated with an invoice.
 * It contains fields for the postal address, registration name, party identification, and contact details.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Party", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class Party {

    @JacksonXmlProperty(localName = "EndpointID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "EndpointID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private EndpointID endpointID;

    @JacksonXmlProperty(localName = "PartyName", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PartyName", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PartyName partyName;

    @JacksonXmlProperty(localName = "PostalAddress", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PostalAddress", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PostalAddress postalAddress;

    @JacksonXmlProperty(localName = "PartyTaxScheme", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PartyTaxScheme", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PartyTaxScheme partyTaxScheme;

    @JacksonXmlProperty(localName = "PartyLegalEntity", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PartyLegalEntity", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PartyLegalEntity partyLegalEntity;

    @JacksonXmlProperty(localName = "Contact", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "Contact", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private Contact contact;
    
}
