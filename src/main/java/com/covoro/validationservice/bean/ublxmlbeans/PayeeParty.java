package com.covoro.validationservice.bean.ublxmlbeans;

import com.covoro.validationservice.constant.Namespaces;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * <h1>Payee</h1>
 * A group of business terms providing information about the Payee, i.e. the role that receives the payment.
 *
 * @Author Sayali.Wagh
 * @Version 1.0
 * @Since 2025-03-19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PayeeParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
public class PayeeParty {

    @JacksonXmlProperty(localName = "PartyIdentification", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PartyIdentification", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PartyIdentification partyIdentification;

    @JacksonXmlProperty(localName = "PartyName", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PartyName", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PartyName partyName;

    @JacksonXmlProperty(localName = "PartyLegalEntity", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PartyLegalEntity", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PartyLegalEntity partyLegalEntity;

}
