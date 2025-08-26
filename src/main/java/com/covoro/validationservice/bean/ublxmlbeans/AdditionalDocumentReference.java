package com.covoro.validationservice.bean.ublxmlbeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.covoro.validationservice.constant.Namespaces;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <h1>Additional Document Reference</h1>
 * This class represents an additional document reference associated with an invoice or document.
 * It contains fields for the ID, document type, document description, and attachment.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AdditionalDocumentReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class AdditionalDocumentReference {

    @JacksonXmlProperty(localName = "ID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String id;

    @JacksonXmlProperty(localName = "DocumentDescription", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "DocumentDescription", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String documentDescription;

    @JacksonXmlProperty(localName = "Attachment", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "Attachment", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private Attachment attachment;


}
