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
 * <h1>Payee Financial Account Entity</h1>
 * This class represents the financial account of the payee associated with an invoice.
 * It contains a field for the account ID.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PayeeFinancialAccount", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class PayeeFinancialAccount {

    @JacksonXmlProperty(localName = "ID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private ID id;

    @JacksonXmlProperty(localName = "Name", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "Name", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String name;

    @JacksonXmlProperty(localName = "FinancialInstitutionBranch", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "FinancialInstitutionBranch", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private FinancialInstitutionBranch financialInstitutionBranch;

}
