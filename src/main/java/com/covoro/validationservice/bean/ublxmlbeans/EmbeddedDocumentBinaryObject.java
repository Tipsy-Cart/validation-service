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
 * <h1>Embedded Document Binary Object</h1>
 * Represents an embedded document binary object associated with an invoice or document.
 * It includes the MIME code and the binary content.
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
@XmlRootElement(name = "EmbeddedDocumentBinaryObject", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
public class EmbeddedDocumentBinaryObject {

    @JacksonXmlProperty(localName = "mimeCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlAttribute(name = "mimeCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String mimeCode;

    @JacksonXmlProperty(localName = "content", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @JacksonXmlText()
    @XmlElement(name = "content", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String embeddedDocumentBinaryObject;
    
}
