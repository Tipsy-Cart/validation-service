package com.covoro.validationservice.bean.ublxmlbeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.covoro.validationservice.constant.Namespaces;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * <h1>Invoice Entity</h1>
 * This class represents an invoice entity in the system.
 * It contains fields for various details of an invoice, such as ID, issue date, issue time, currency codes, etc.
 * Additionally, it includes nested objects for representing related entities like billing references, invoice period,
 * invoice line, accounting customer party, accounting supplier party, etc.
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "Invoice", namespace = Namespaces.INVOICE_2)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Invoice", namespace = Namespaces.INVOICE_2)
public class Invoice {

    @XmlAttribute(name = "schemaLocation", namespace = Namespaces.XSI)
    private final String schemaLocation = Namespaces.INVOICE_2 + Namespaces.SCHEMA_LOCATION;

    @JacksonXmlProperty(localName = "CustomizationID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "CustomizationID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String customizationID;

    @JacksonXmlProperty(localName = "ProfileID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ProfileID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String profileID;

    @JacksonXmlProperty(localName = "ProfileExecutionID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ProfileExecutionID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String profileExecutionID;
    
    @JacksonXmlProperty(localName = "ID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "ID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String id;

    @JacksonXmlProperty(localName = "UUID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "UUID", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String uuid;

    @JacksonXmlProperty(localName = "IssueDate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "IssueDate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String issueDate;

    @JacksonXmlProperty(localName = "IssueTime", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "IssueTime", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String issueTime;

    @JacksonXmlProperty(localName = "DueDate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "DueDate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String dueDate;

    @JacksonXmlProperty(localName = "InvoiceTypeCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "InvoiceTypeCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String invoiceTypeCode;

    @JacksonXmlProperty(localName = "Note", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "Note", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String note;

    @JacksonXmlProperty(localName = "TaxPointDate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "TaxPointDate", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String taxPointDate;

    @JacksonXmlProperty(localName = "DocumentCurrencyCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "DocumentCurrencyCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String documentCurrencyCode;

    @JacksonXmlProperty(localName = "TaxCurrencyCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "TaxCurrencyCode", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String taxCurrencyCode;

    @JacksonXmlProperty(localName = "TaxExchangeRate", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "TaxExchangeRate", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private TaxExchangeRate taxExchangeRate;

    @JacksonXmlProperty(localName = "AccountingCost", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "AccountingCost", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String accountingCost;

    @JacksonXmlProperty(localName = "BuyerReference", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    @XmlElement(name = "BuyerReference", namespace = Namespaces.COMMON_BASIC_COMPONENT_2)
    private String buyerReference;

    @JacksonXmlProperty(localName = "InvoicePeriod", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "InvoicePeriod", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private InvoicePeriod invoicePeriod;

    @JacksonXmlProperty(localName = "DiscrepancyResponse", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "DiscrepancyResponse", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private DiscrepancyResponse discrepancyResponse;

    @JacksonXmlProperty(localName = "OrderReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "OrderReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private OrderReference orderReference;

    @JacksonXmlProperty(localName = "BillingReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "BillingReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private BillingReference billingReference;

    @JacksonXmlProperty(localName = "DespatchDocumentReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "DespatchDocumentReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private DespatchDocumentReference despatchDocumentReference;

    @JacksonXmlProperty(localName = "ReceiptDocumentReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "ReceiptDocumentReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private ReceiptDocumentReference receiptDocumentReference;

    @JacksonXmlProperty(localName = "OriginatorDocumentReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "OriginatorDocumentReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private OriginatorDocumentReference originatorDocumentReference;

    @JacksonXmlProperty(localName = "ContractDocumentReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "ContractDocumentReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private ContractDocumentReference contractDocumentReference;

    @JacksonXmlProperty(localName = "AdditionalDocumentReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "AdditionalDocumentReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<AdditionalDocumentReference> additionalDocumentReference;

    @JacksonXmlProperty(localName = "ProjectReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "ProjectReference", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private ProjectReference projectReference;

    @JacksonXmlProperty(localName = "AccountingSupplierParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "AccountingSupplierParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private AccountingSupplierParty accountingSupplierParty;

    @JacksonXmlProperty(localName = "AccountingCustomerParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "AccountingCustomerParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private AccountingCustomerParty accountingCustomerParty;

    @JacksonXmlProperty(localName = "PayeeParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PayeeParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PayeeParty payeeParty;

    @JacksonXmlProperty(localName = "SellerSupplierParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "SellerSupplierParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private SellerSupplierParty sellerSupplierParty;

    @JacksonXmlProperty(localName = "BuyerCustomerParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "BuyerCustomerParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private BuyerCustomerParty buyerCustomerParty;

    @JacksonXmlProperty(localName = "TaxRepresentativeParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "TaxRepresentativeParty", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private TaxRepresentativeParty taxRepresentativeParty;

    @JacksonXmlProperty(localName = "Delivery", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "Delivery", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private Delivery delivery;

    @JacksonXmlProperty(localName = "PaymentMeans", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PaymentMeans", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PaymentMeans paymentMeans;

    @JacksonXmlProperty(localName = "PaymentTerms", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "PaymentTerms", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private PaymentTerms paymentTerms;

    @JacksonXmlProperty(localName = "AllowanceCharge", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "AllowanceCharge", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<AllowanceCharge> allowanceCharges;

    @JacksonXmlProperty(localName = "TaxTotal", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "TaxTotal", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private TaxTotal taxTotal;

    @JacksonXmlProperty(localName = "LegalMonetaryTotal", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "LegalMonetaryTotal", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    private LegalMonetaryTotal legalMonetaryTotal;

    @JacksonXmlProperty(localName = "InvoiceLine", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @XmlElement(name = "InvoiceLine", namespace = Namespaces.COMMON_AGGREGATE_COMPONENT_2)
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<InvoiceLine> invoiceLine;

}
