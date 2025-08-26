package com.covoro.validationservice.bean.ublxmlbeans;

import com.covoro.validationservice.constant.Namespaces;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <h1>Attachment</h1>
 * This class represents attachments associated with an invoice or document.
 * It contains a field for the embedded document binary object.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Attachment", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class Attachment {

    @JacksonXmlProperty(localName = "ExternalReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "ExternalReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private ExternalReference externalReference;

    @JacksonXmlProperty(localName = "EmbeddedDocumentBinaryObject", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "EmbeddedDocumentBinaryObject", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private EmbeddedDocumentBinaryObject embeddedDocumentBinaryObject;
}
