package com.covoro.validationservice.bean.ublxmlbeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.covoro.validationservice.constant.Namespaces;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * <h1>Price Entity</h1>
 * This class represents the price associated with a product or service in an invoice.
 * It contains a field for the price amount.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Price", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class
Price {

    @JacksonXmlProperty(localName = "PriceAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "PriceAmount", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private Amount priceAmount;

    @JacksonXmlProperty(localName = "BaseQuantity", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "BaseQuantity", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private BaseQuantity baseQuantity;

    @JacksonXmlProperty(localName = "AllowanceCharge", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "AllowanceCharge", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private AllowanceCharge allowanceCharge;
    
}
