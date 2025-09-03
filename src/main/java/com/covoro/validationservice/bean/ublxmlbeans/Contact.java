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
 * <h1>Contact</h1>
 * This class represents contact information.
 * It contains fields for telephone and email.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Contact", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class Contact {

    @JacksonXmlProperty(localName = "Name", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "Name", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String name;

    @JacksonXmlProperty(localName = "Telephone", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "Telephone", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String telephone;

    @JacksonXmlProperty(localName = "ElectronicMail", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ElectronicMail", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String eMail;

}
