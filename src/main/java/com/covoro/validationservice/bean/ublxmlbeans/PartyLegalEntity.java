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
 * <h1>Party Legal Entity Entity</h1>
 * This class represents a legal entity associated with a party in an invoice.
 * It contains a field for the registration name.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PartyLegalEntity", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class PartyLegalEntity {

    @JacksonXmlProperty(localName = "RegistrationName", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "RegistrationName", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String registrationName;

    @JacksonXmlProperty(localName = "CompanyID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "CompanyID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private CompanyID companyID;

    @JacksonXmlProperty(localName = "CompanyLegalForm", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "CompanyLegalForm", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String companyLegalForm;

}
