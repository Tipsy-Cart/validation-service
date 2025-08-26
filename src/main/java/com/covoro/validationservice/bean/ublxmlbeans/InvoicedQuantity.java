package com.covoro.validationservice.bean.ublxmlbeans;

import com.covoro.validationservice.constant.Namespaces;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "InvoicedQuantity", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
public class InvoicedQuantity {

    @JacksonXmlProperty(localName = "unitCode", isAttribute = true)
    @XmlAttribute(name = "unitCode")
    private String unitCode;

    @JacksonXmlText
    @XmlValue
    private String quantity;

}
