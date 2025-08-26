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
 * <h1>Payment Terms Entity</h1>
 * This class represents the payment terms associated with an invoice.
 * It contains a field for the instruction note.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PaymentTerms", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class PaymentTerms {

    @JacksonXmlProperty(localName = "Note", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "Note", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String note;

}
