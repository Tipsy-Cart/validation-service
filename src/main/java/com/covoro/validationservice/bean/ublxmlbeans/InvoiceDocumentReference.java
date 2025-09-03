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
 * <h1>LHDN Invoice Document Reference Entity</h1>
 * This class represents a document reference associated with an invoice.
 * It contains fields for the ID and IRBM unique identifier number of the document reference.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "InvoiceDocumentReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class InvoiceDocumentReference {

    @JacksonXmlProperty(localName = "ID",  namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String id;

    @JacksonXmlProperty(localName = "IssueDate",  namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "IssueDate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String issueDate;

}
