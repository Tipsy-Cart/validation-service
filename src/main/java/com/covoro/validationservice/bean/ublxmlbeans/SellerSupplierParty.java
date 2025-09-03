package com.covoro.validationservice.bean.ublxmlbeans;

import com.covoro.validationservice.constant.Namespaces;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Accounting Supplier Party</h1>
 * This class represents the accounting supplier party associated with an invoice.
 * It contains a field for the party details.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class SellerSupplierParty {

    @JacksonXmlProperty(localName = "Party", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "Party", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private Party party;

}
