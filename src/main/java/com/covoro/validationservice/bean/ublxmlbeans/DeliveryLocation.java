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
 * <h1>Accounting Customer Party</h1>
 * This class represents the accounting customer party associated with an invoice.
 * It contains a field for the party details, which is validated to ensure it is not empty, null, or blank.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DeliveryLocation", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class DeliveryLocation {

    @JacksonXmlProperty(localName = "ID", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "ID", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private ID id;

    @JacksonXmlProperty(localName = "Address", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "Address", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PostalAddress address;

}
