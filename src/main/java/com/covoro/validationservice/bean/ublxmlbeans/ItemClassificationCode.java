package com.covoro.validationservice.bean.ublxmlbeans;

import com.covoro.validationservice.constant.Namespaces;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;


/**
 * <h1>ItemClassificationCode</h1>
 * Represents the classification code associated with an item in an invoice.
 * It includes the list ID and the classification code.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ItemClassificationCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
public class ItemClassificationCode {

    @JacksonXmlProperty(localName = "listID", isAttribute = true, namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlAttribute(name = "listID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String listID;

    @JacksonXmlProperty(localName = "listVersionID", isAttribute = true, namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlAttribute(name = "listVersionID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String listVersionID;

    @JacksonXmlText
    @XmlValue
    private String code;

}
