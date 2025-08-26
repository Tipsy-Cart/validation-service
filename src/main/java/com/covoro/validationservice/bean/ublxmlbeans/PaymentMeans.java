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
 * <h1>Payment Means Entity</h1>
 * This class represents the payment means associated with an invoice.
 * It contains fields for the payment means code and payee financial account.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PaymentMeans", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
public class PaymentMeans {

    @JacksonXmlProperty(localName = "PaymentMeansCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "PaymentMeansCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private PaymentMeansCode paymentMeansCode;

    @JacksonXmlProperty(localName = "CardAccount", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "CardAccount", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private CardAccount cardAccount;

    @JacksonXmlProperty(localName = "PayeeFinancialAccount", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PayeeFinancialAccount", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PayeeFinancialAccount payeeFinancialAccount;

    @JacksonXmlProperty(localName = "PaymentMandate", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PaymentMandate", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PaymentMandate paymentMandate;

}
