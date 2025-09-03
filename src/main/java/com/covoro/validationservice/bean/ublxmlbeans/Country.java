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
 * <h1>Country</h1>
 * This class represents identification code of country.
 * It contains fields for IdentificationCode.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Country", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class Country {

    @JacksonXmlProperty(localName = "IdentificationCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "IdentificationCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String identificationCode;

}
