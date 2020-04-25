/**
 * HaspBssLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public class HaspBssLocator extends org.apache.axis.client.Service implements com.aladdin.www.webservices.hasp.WebHaspBss.HaspBss {

/**
 * The Sentinel HASP Business Studio Server API is designed to enable
 * you to integrate the order and production functionality of Sentinel
 * HASP Business Studio in your organizational management software (for
 * example, ERP or CRM).
 */

    public HaspBssLocator() {
    }


    public HaspBssLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HaspBssLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HaspBssSoap
    private java.lang.String HaspBssSoap_address = "http://192.168.139.128/BusinessAPI/BusinessAPIService.asmx";

    public java.lang.String getHaspBssSoapAddress() {
        return HaspBssSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HaspBssSoapWSDDServiceName = "HaspBssSoap";

    public java.lang.String getHaspBssSoapWSDDServiceName() {
        return HaspBssSoapWSDDServiceName;
    }

    public void setHaspBssSoapWSDDServiceName(java.lang.String name) {
        HaspBssSoapWSDDServiceName = name;
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap getHaspBssSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HaspBssSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHaspBssSoap(endpoint);
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap getHaspBssSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoapStub _stub = new com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoapStub(portAddress, this);
            _stub.setPortName(getHaspBssSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHaspBssSoapEndpointAddress(java.lang.String address) {
        HaspBssSoap_address = address;
    }


    // Use to get a proxy class for HaspBssSoap12
    private java.lang.String HaspBssSoap12_address = "http://192.168.139.128/BusinessAPI/BusinessAPIService.asmx";

    public java.lang.String getHaspBssSoap12Address() {
        return HaspBssSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HaspBssSoap12WSDDServiceName = "HaspBssSoap12";

    public java.lang.String getHaspBssSoap12WSDDServiceName() {
        return HaspBssSoap12WSDDServiceName;
    }

    public void setHaspBssSoap12WSDDServiceName(java.lang.String name) {
        HaspBssSoap12WSDDServiceName = name;
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap getHaspBssSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HaspBssSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHaspBssSoap12(endpoint);
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap getHaspBssSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap12Stub _stub = new com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap12Stub(portAddress, this);
            _stub.setPortName(getHaspBssSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHaspBssSoap12EndpointAddress(java.lang.String address) {
        HaspBssSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoapStub _stub = new com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoapStub(new java.net.URL(HaspBssSoap_address), this);
                _stub.setPortName(getHaspBssSoapWSDDServiceName());
                return _stub;
            }
            if (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap12Stub _stub = new com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap12Stub(new java.net.URL(HaspBssSoap12_address), this);
                _stub.setPortName(getHaspBssSoap12WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("HaspBssSoap".equals(inputPortName)) {
            return getHaspBssSoap();
        }
        else if ("HaspBssSoap12".equals(inputPortName)) {
            return getHaspBssSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBss");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssSoap"));
            ports.add(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HaspBssSoap".equals(portName)) {
            setHaspBssSoapEndpointAddress(address);
        }
        else 
if ("HaspBssSoap12".equals(portName)) {
            setHaspBssSoap12EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
