package com.covoro.validationservice.bean.ublxmlbeans;

import com.covoro.validationservice.constant.Namespaces;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CompanyID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
public class CompanyID {

    @JacksonXmlText
    @XmlValue
    private String id;

    @JacksonXmlProperty(localName = "schemeAgencyID", isAttribute = true)
    @XmlAttribute(name = "schemeAgencyID")
    private String schemeAgencyID;

    @JacksonXmlProperty(localName = "schemeAgencyName", isAttribute = true)
    @XmlAttribute(name = "schemeAgencyName")
    private String schemeAgencyName;

}
