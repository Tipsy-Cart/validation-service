package com.covoro.validationservice.bean.ublxmlbeans;

import com.covoro.validationservice.constant.Namespaces;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.*;

/**
 * <h1>ID</h1>
 * Represents an identifier with a scheme ID associated with an invoice or document.
 * It includes the scheme ID and the identifier value.
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "BaseQuantity ", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
public class BaseQuantity {

    @JacksonXmlProperty(localName = "unitCode", isAttribute = true, namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlAttribute(name = "unitCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String unitCode;

    @JacksonXmlText
    @XmlValue
    private Integer quantity;

}
