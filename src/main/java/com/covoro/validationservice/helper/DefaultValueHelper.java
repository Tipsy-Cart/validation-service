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
        legalMonetaryTotal.getLineExtensionAmount().setCurrencyID(documentCurrencyCode);
        legalMonetaryTotal.getTaxExclusiveAmount().setCurrencyID(documentCurrencyCode);
        legalMonetaryTotal.getTaxInclusiveAmount().setCurrencyID(documentCurrencyCode);
        legalMonetaryTotal.getAllowanceTotalAmount().setCurrencyID(documentCurrencyCode);
        legalMonetaryTotal.getChargeTotalAmount().setCurrencyID(documentCurrencyCode);
        legalMonetaryTotal.getPrepaidAmount().setCurrencyID(documentCurrencyCode);
        legalMonetaryTotal.getPayableRoundingAmount().setCurrencyID(documentCurrencyCode);
        legalMonetaryTotal.getPayableAmount().setCurrencyID(documentCurrencyCode);
        invoice.setLegalMonetaryTotal(legalMonetaryTotal);

        TaxTotal taxTotal = invoice.getTaxTotal();
        taxTotal.getTaxAmount().setCurrencyID(documentCurrencyCode);
        taxTotal.setTaxSubtotal(taxTotal.getTaxSubtotal().stream().map(taxSubtotal -> this.addCurrencyCode(documentCurrencyCode, taxSubtotal)).toList());

        invoice.setInvoiceLine(invoice.getInvoiceLine().stream().map(invoiceLine -> this.addCurrencyCode(documentCurrencyCode, invoiceLine)).toList());
        invoice.getAccountingSupplierParty().getParty().getPartyTaxScheme().getTaxScheme().setId("VAT");
        invoice.getAccountingCustomerParty().getParty().getPartyTaxScheme().getTaxScheme().setId("VAT");
        //TODO Change based upon Document Type
        invoice.setProfileID("urn:peppol:bis:billing");
        invoice.setCustomizationID("urn:peppol:pint:billing- 1@ae-1");
        return invoice;
    }

    private TaxSubtotal addCurrencyCode(String documentCurrencyCode, TaxSubtotal taxSubtotal) {
        taxSubtotal.getTaxAmount().setCurrencyID(documentCurrencyCode);
        taxSubtotal.getTaxableAmount().setCurrencyID(documentCurrencyCode);
        return taxSubtotal;
    }

    private InvoiceLine addCurrencyCode(String documentCurrencyCode, InvoiceLine invoiceLine) {
        invoiceLine.getLineExtensionAmount().setCurrencyID(documentCurrencyCode);
        invoiceLine.setAllowanceCharge(invoiceLine.getAllowanceCharge().stream().map(allowanceCharge -> this.addCurrencyCode(documentCurrencyCode, allowanceCharge)).toList());
        invoiceLine.setPrice(this.addCurrencyCode(documentCurrencyCode, invoiceLine.getPrice()));
        invoiceLine.getItem().getStandardItemIdentification().getId().setSchemeId("0160");
        invoiceLine.getItem().getCommodityClassification().getItemClassificationCode().setListID("HS");
        invoiceLine.getItem().getAdditionalItemIdentification().getId().setSchemeId("SAC");
        return invoiceLine;
    }

    private AllowanceCharge addCurrencyCode(String documentCurrencyCode, AllowanceCharge allowanceCharge) {
        allowanceCharge.getAmount().setCurrencyID(documentCurrencyCode);
        return allowanceCharge;
    }

    private Price addCurrencyCode(String documentCurrencyCode, Price price) {
        price.getPriceAmount().setCurrencyID(documentCurrencyCode);
        AllowanceCharge allowanceCharge = price.getAllowanceCharge();
        allowanceCharge.getBaseAmount().setCurrencyID(documentCurrencyCode);
        allowanceCharge.getAmount().setCurrencyID(documentCurrencyCode);
        allowanceCharge.setChargeIndicator(false);
        price.setAllowanceCharge(allowanceCharge);
        return price;
    }

}
