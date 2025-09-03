package com.covoro.validationservice.bean.ublxmlbeans;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import com.covoro.validationservice.constant.Namespaces;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * <h1>TaxExclusiveAmount</h1>
 * Represents the tax-exclusive amount associated with an item or service in an invoice.
 * It includes the currency ID and the tax-exclusive amount value.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TaxAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
public class Amount {

    @JacksonXmlProperty(localName = "currencyID", isAttribute = true)
    @XmlAttribute(name = "currencyID")
    private String currencyID;

    @JacksonXmlText
    @XmlValue
    private BigDecimal amount;


}
