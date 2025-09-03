package com.covoro.validationservice.bean.ublxmlbeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.*;

import jakarta.xml.bind.annotation.*;

/**
 * <h1>InvoiceTypeCode</h1>
 * Represents the type of invoice in the e-invoice system.
 * It includes the list version ID and the invoice type code.
 *
 * @Author Sayali.Wagh
 * @Version 1.0
 * @Since 2024-12-11
 */

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "InvoiceTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvoiceTypeCode {

    @JacksonXmlProperty(localName = "listVersionID", isAttribute = true, namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    @XmlAttribute(name = "listVersionID")
    private String listVersionID;

    @JacksonXmlText()
    @XmlValue
    private String value;

}
