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
 * <h1>Postal Address Entity</h1>
 * This class represents a postal address associated with an entity in an invoice.
 * It contains fields for the address line, postal zone, city name, country sub-identity code,
 * country code, party legal entity, party identification, and contact details.
 * The country code field is validated using the @ValidateCountryCode custom annotation.
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PostalAddress", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class PostalAddress {

    @JacksonXmlProperty(localName = "AddressLine", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "AddressLine", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<AddressLine> addressLine;

    @JacksonXmlProperty(localName = "StreetName", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "StreetName", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String streetName;

    @JacksonXmlProperty(localName = "AdditionalStreetName", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "AdditionalStreetName", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String additionalStreetName;

    @JacksonXmlProperty(localName = "CityName", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "CityName", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String cityName;

    @JacksonXmlProperty(localName = "PostalZone", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "PostalZone", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String postalZone;

    @JacksonXmlProperty(localName = "CountrySubentity", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "CountrySubentity", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String countrySubentity;

    @JacksonXmlProperty(localName = "Country", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "Country", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Country country;

}
