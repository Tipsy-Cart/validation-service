package com.covoro.validationservice.bean.ublxmlbeans;

import com.covoro.validationservice.constant.Namespaces;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * <h1>SELLER INVOICING REPRESENTATIVE PARTY</h1>
 * A group of business terms providing information about the Seller’s representative.
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
@XmlRootElement(name = "TaxRepresentativeParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class TaxRepresentativeParty {

    @JacksonXmlProperty(localName = "PartyName", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PartyName", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PartyName partyName;

    @JacksonXmlProperty(localName = "PostalAddress", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PostalAddress", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PostalAddress postalAddress;

    @JacksonXmlProperty(localName = "PartyTaxScheme", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PartyTaxScheme", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PartyTaxScheme partyTaxScheme;

}
