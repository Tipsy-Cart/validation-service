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
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EndpointID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
public class EndpointID {

    @JacksonXmlText
    @XmlValue
    private String id;

    @JacksonXmlProperty(localName = "schemeID", isAttribute = true)
    @XmlAttribute(name = "schemeID")
    private String schemeID;

}
