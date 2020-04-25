/**
 * HaspBss.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public interface HaspBss extends javax.xml.rpc.Service {

/**
 * The Sentinel HASP Business Studio Server API is designed to enable
 * you to integrate the order and production functionality of Sentinel
 * HASP Business Studio in your organizational management software (for
 * example, ERP or CRM).
 */
    public java.lang.String getHaspBssSoapAddress();

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap getHaspBssSoap() throws javax.xml.rpc.ServiceException;

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap getHaspBssSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getHaspBssSoap12Address();

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap getHaspBssSoap12() throws javax.xml.rpc.ServiceException;

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap getHaspBssSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
