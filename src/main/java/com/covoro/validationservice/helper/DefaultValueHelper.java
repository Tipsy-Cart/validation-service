package com.covoro.validationservice.helper;

import com.covoro.validationservice.bean.ublxmlbeans.*;
import org.springframework.stereotype.Component;

@Component
public class DefaultValueHelper {

    public Invoice add(Invoice invoice) {
        String documentCurrencyCode = invoice.getDocumentCurrencyCode();
        if (!"AED".equals(documentCurrencyCode))
            invoice.setTaxCurrencyCode("AED");
        LegalMonetaryTotal legalMonetaryTotal = invoice.getLegalMonetaryTotal();
        this.addCurrencyCode(documentCurrencyCode, legalMonetaryTotal.getLineExtensionAmount());
        this.addCurrencyCode(documentCurrencyCode, legalMonetaryTotal.getTaxExclusiveAmount());
        this.addCurrencyCode(documentCurrencyCode, legalMonetaryTotal.getTaxInclusiveAmount());
        this.addCurrencyCode(documentCurrencyCode, legalMonetaryTotal.getAllowanceTotalAmount());
        this.addCurrencyCode(documentCurrencyCode, legalMonetaryTotal.getChargeTotalAmount());
        this.addCurrencyCode(documentCurrencyCode, legalMonetaryTotal.getPrepaidAmount());
        this.addCurrencyCode(documentCurrencyCode, legalMonetaryTotal.getPayableRoundingAmount());
        this.addCurrencyCode(documentCurrencyCode, legalMonetaryTotal.getPayableAmount());
        invoice.setLegalMonetaryTotal(legalMonetaryTotal);

        TaxTotal taxTotal = invoice.getTaxTotal();
        this.addCurrencyCode(documentCurrencyCode, taxTotal.getTaxAmount());
        taxTotal.setTaxSubtotal(taxTotal.getTaxSubtotal().stream().map(taxSubtotal -> this.addCurrencyCode(documentCurrencyCode, taxSubtotal)).toList());

        invoice.setInvoiceLine(invoice.getInvoiceLine().stream().map(invoiceLine -> this.addCurrencyCode(documentCurrencyCode, invoiceLine)).toList());
        this.addTaxScheme(invoice);
        //TODO Change based upon Document Type
        invoice.setProfileID("urn:peppol:bis:billing");
        invoice.setCustomizationID("urn:peppol:pint:billing- 1@ae-1");
        return invoice;
    }

    private TaxSubtotal addCurrencyCode(String documentCurrencyCode, TaxSubtotal taxSubtotal) {
        this.addCurrencyCode(documentCurrencyCode, taxSubtotal.getTaxAmount());
        this.addCurrencyCode(documentCurrencyCode,taxSubtotal.getTaxableAmount());
        return taxSubtotal;
    }

    private InvoiceLine addCurrencyCode(String documentCurrencyCode, InvoiceLine invoiceLine) {
        this.addCurrencyCode(documentCurrencyCode, invoiceLine.getLineExtensionAmount());
        invoiceLine.setAllowanceCharge(invoiceLine.getAllowanceCharge().stream().map(allowanceCharge -> this.addCurrencyCode(documentCurrencyCode, allowanceCharge)).toList());
        invoiceLine.setPrice(this.addCurrencyCode(documentCurrencyCode, invoiceLine.getPrice()));
        this.addItemClassification(invoiceLine);
        return invoiceLine;
    }

    private AllowanceCharge addCurrencyCode(String documentCurrencyCode, AllowanceCharge allowanceCharge) {
        this.addCurrencyCode(documentCurrencyCode, allowanceCharge.getAmount());
        return allowanceCharge;
    }

    private Price addCurrencyCode(String documentCurrencyCode, Price price) {
        this.addCurrencyCode(documentCurrencyCode, price.getPriceAmount());
        AllowanceCharge allowanceCharge = price.getAllowanceCharge();
        if (null != allowanceCharge) {
            this.addCurrencyCode(documentCurrencyCode, allowanceCharge.getBaseAmount());
            this.addCurrencyCode(documentCurrencyCode, allowanceCharge.getAmount());
            allowanceCharge.setChargeIndicator(false);
            price.setAllowanceCharge(allowanceCharge);
        }
        return price;
    }

    private void addCurrencyCode(String documentCurrencyCode, Amount amount) {
        if(null != amount)
            amount.setCurrencyID(documentCurrencyCode);
    }

    private void addTaxScheme(Invoice invoice) {
        if(null != invoice
                && null != invoice.getAccountingSupplierParty()
                && null != invoice.getAccountingSupplierParty().getParty()
                && null != invoice.getAccountingSupplierParty().getParty().getPartyTaxScheme()
                && null != invoice.getAccountingSupplierParty().getParty().getPartyTaxScheme().getTaxScheme())
            invoice.getAccountingSupplierParty().getParty().getPartyTaxScheme().getTaxScheme().setId("VAT");

        if(null != invoice
                && null != invoice.getAccountingCustomerParty()
                && null != invoice.getAccountingCustomerParty().getParty()
                && null != invoice.getAccountingCustomerParty().getParty().getPartyTaxScheme()
                && null != invoice.getAccountingCustomerParty().getParty().getPartyTaxScheme().getTaxScheme())
            invoice.getAccountingCustomerParty().getParty().getPartyTaxScheme().getTaxScheme().setId("VAT");
    }

    private void addItemClassification(InvoiceLine invoiceLine) {
        if(null != invoiceLine
                && null != invoiceLine.getItem()
                && null != invoiceLine.getItem().getStandardItemIdentification()
                && null != invoiceLine.getItem().getStandardItemIdentification().getId())
            invoiceLine.getItem().getStandardItemIdentification().getId().setSchemeId("0160");

        if(null != invoiceLine
                && null != invoiceLine.getItem()
                && null != invoiceLine.getItem().getCommodityClassification()
                && null != invoiceLine.getItem().getCommodityClassification().getItemClassificationCode())
            invoiceLine.getItem().getCommodityClassification().getItemClassificationCode().setListID("HS");

        if(null != invoiceLine
                && null != invoiceLine.getItem()
                && null != invoiceLine.getItem().getAdditionalItemIdentification()
                && null != invoiceLine.getItem().getAdditionalItemIdentification().getId())
            invoiceLine.getItem().getAdditionalItemIdentification().getId().setSchemeId("SAC");
    }

}
