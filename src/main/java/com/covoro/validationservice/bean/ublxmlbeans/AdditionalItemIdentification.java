package com.covoro.validationservice.bean.ublxmlbeans;

import com.covoro.validationservice.constant.Namespaces;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * <h1>Address Line</h1>
 * This class represents a line of an address.
 * It contains a field for the address line.
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AdditionalItemIdentification", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class AdditionalItemIdentification {

    @JacksonXmlProperty(localName = "ID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private ID id;

}
