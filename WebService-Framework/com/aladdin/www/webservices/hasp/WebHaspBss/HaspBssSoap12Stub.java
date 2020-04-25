/**
 * HaspBssSoap12Stub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public class HaspBssSoap12Stub extends org.apache.axis.client.Stub implements com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[68];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
        _initOperationDesc6();
        _initOperationDesc7();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Initialize");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inUserName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inPassword"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inServer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inPort"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "InitializeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetVersion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetVersionResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "majorVersion"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "minorVersion"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "buildVersion"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "revisionVersion"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "serverVersion"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "serverDBVersion"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetNewOrders");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inBatchID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inReference"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetNewOrdersResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfOrder"), com.aladdin.www.webservices.hasp.WebHaspBss.Order[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Order"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAllOrders");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inBatchID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inReference"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetAllOrdersResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfOrder"), com.aladdin.www.webservices.hasp.WebHaspBss.Order[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Order"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProductionOrders");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inBatchID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inReference"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductionOrdersResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfOrder"), com.aladdin.www.webservices.hasp.WebHaspBss.Order[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Order"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProvisionalOrders");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inBatchID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inReference"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProvisionalOrdersResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfOrder"), com.aladdin.www.webservices.hasp.WebHaspBss.Order[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Order"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetBatches");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetBatchesResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outBatches"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfBatch"), com.aladdin.www.webservices.hasp.WebHaspBss.Batch[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Batch"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProducts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inBatchID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inReference"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductsResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProducts"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfProduct"), com.aladdin.www.webservices.hasp.WebHaspBss.Product[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Product"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProvisionalProducts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inBatchID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inReference"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProvisionalProductsResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProducts"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfProduct"), com.aladdin.www.webservices.hasp.WebHaspBss.Product[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Product"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOrderProducts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inBatchID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderProductsResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProducts"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfProduct"), com.aladdin.www.webservices.hasp.WebHaspBss.Product[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Product"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddProductsToOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inBatchID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inProducts"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfProduct"), com.aladdin.www.webservices.hasp.WebHaspBss.Product[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Product"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "AddProductsToOrderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("InsertOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inBatchID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrder"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Order"), com.aladdin.www.webservices.hasp.WebHaspBss.Order.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "InsertOrderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "DeleteOrderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FinalizeOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FinalizeOrderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UnfinalizeOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "UnfinalizeOrderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ProduceOrderByHaspID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inHaspID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedLong"), org.apache.axis.types.UnsignedLong.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByHaspIDResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ProduceProvisionalOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceProvisionalOrderResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CleanAndProduceOrderByHaspID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inHaspID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedLong"), org.apache.axis.types.UnsignedLong.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CleanAndProduceOrderByHaspIDResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ProduceOrderByC2V");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByC2VResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ProduceOrderByHaspIDFromC2V");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByHaspIDFromC2VResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ProduceOrderByC2VAndRemovePendingOrders");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByC2VAndRemovePendingOrdersResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetPendingOrders");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetPendingOrdersResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outPendingOrders"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfPendingOrder"), com.aladdin.www.webservices.hasp.WebHaspBss.PendingOrder[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "PendingOrder"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GenerateProductKeys");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GenerateProductKeysResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProductKeys");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductKeysResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProductKeys"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOrderFreeParameters");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderFreeParametersResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFreeParameters"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFreeParameter"), com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeParameter"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetOrderFreeParameters");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inFreeParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFreeParameter"), com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeParameter"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SetOrderFreeParametersResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOrderFreeMemorySegments");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderFreeMemorySegmentsResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFreeMemorySegments"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFreeMemorySegment"), com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemorySegment"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetOrderFreeMemorySegments");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inFreeMemorySegments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFreeMemorySegment"), com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemorySegment"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SetOrderFreeMemorySegmentsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddKeysToOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inKeys"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfKey"), com.aladdin.www.webservices.hasp.WebHaspBss.Key[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Key"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "AddKeysToOrderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("LocateC2VKey");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2v"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "vendorID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LocateC2VKeyResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKey"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Key"), com.aladdin.www.webservices.hasp.WebHaspBss.Key.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RemoveKeysFromOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inKeys"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfKey"), com.aladdin.www.webservices.hasp.WebHaspBss.Key[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Key"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "RemoveKeysFromOrderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CheckInC2V");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CheckInC2VResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CheckInC2VGetKeyInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CheckInC2VGetKeyInfoResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyInfo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyInfo"), com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SynchronizeDatabaseUsingKeyInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SynchronizeDatabaseUsingKeyInfoResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyInfo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyInfo"), com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetKeysByProductKey");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inProductKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeysByProductKeyResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeys"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfKey"), com.aladdin.www.webservices.hasp.WebHaspBss.Key[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Key"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetFingerprintByC2V");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetFingerprintByC2VResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFingerprint"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFingerprintDevice"), com.aladdin.www.webservices.hasp.WebHaspBss.FingerprintDevice[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FingerprintDevice"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetFingerprintByKeyID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inKeyID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetFingerprintByKeyIDResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFingerprint"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFingerprintDevice"), com.aladdin.www.webservices.hasp.WebHaspBss.FingerprintDevice[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FingerprintDevice"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ClearClonedHaspSLKey");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ClearClonedHaspSLKeyResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetKeyHistoryByKeyID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inKeyID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedLong"), org.apache.axis.types.UnsignedLong.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyHistoryByKeyIDResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyInfo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyInfo"), com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetKeyHistoryByC2V");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyHistoryByC2VResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyInfo"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyInfo"), com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetKeyOrdersByKeyID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inKeyID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedLong"), org.apache.axis.types.UnsignedLong.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyOrdersByKeyIDResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyOrders"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyOrders"), com.aladdin.www.webservices.hasp.WebHaspBss.KeyOrders.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetKeyOrdersByC2V");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyOrdersByC2VResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyOrders"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyOrders"), com.aladdin.www.webservices.hasp.WebHaspBss.KeyOrders.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetKeysByOrderID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeysByOrderIDResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeys"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfKey"), com.aladdin.www.webservices.hasp.WebHaspBss.Key[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Key"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAvailableKeyTypesByOrderID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetAvailableKeyTypesByOrderIDResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyTypes"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "string"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProductByID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inProductID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductByIDResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProduct"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Product"), com.aladdin.www.webservices.hasp.WebHaspBss.Product.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[44] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProductByName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inProductName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inBatchID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inBaseProductID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductByNameResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProduct"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Product"), com.aladdin.www.webservices.hasp.WebHaspBss.Product.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[45] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GenerateFormatUpdateFile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GenerateFormatUpdateFileResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[46] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCustomers");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inBatchID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inReference"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetCustomersResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomers"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfCustomer"), com.aladdin.www.webservices.hasp.WebHaspBss.Customer[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Customer"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[47] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCustomerByID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inCustomerID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetCustomerByIDResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomer"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Customer"), com.aladdin.www.webservices.hasp.WebHaspBss.Customer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[48] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("InsertCustomer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inBatchID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inCustomer"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Customer"), com.aladdin.www.webservices.hasp.WebHaspBss.Customer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "InsertCustomerResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[49] = oper;

    }

    private static void _initOperationDesc6(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateCustomer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inCustomer"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Customer"), com.aladdin.www.webservices.hasp.WebHaspBss.Customer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "UpdateCustomerResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[50] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObsoleteCustomer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inCustomerID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ObsoleteCustomerResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomer"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Customer"), com.aladdin.www.webservices.hasp.WebHaspBss.Customer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[51] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RestoreCustomer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inCustomerID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "RestoreCustomerResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomer"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Customer"), com.aladdin.www.webservices.hasp.WebHaspBss.Customer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[52] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddCustomerToOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inCustomerID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "AddCustomerToOrderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[53] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCustomerByOrderID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetCustomerByOrderIDResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomer"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Customer"), com.aladdin.www.webservices.hasp.WebHaspBss.Customer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[54] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetExecutableFromV2C");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inV2C"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetExecutableFromV2CResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outExe"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[55] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProductDataByID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inProductID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductDataByIDResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProductData"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProductData"), com.aladdin.www.webservices.hasp.WebHaspBss.ProductData.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[56] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOrderExcludableFeatures");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderExcludableFeaturesResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outExcludeFeatures"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfExcludeFeature"), com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ExcludeFeature"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[57] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExcludeFeaturesFromOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inExcludeFeatures"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfExcludeFeature"), com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ExcludeFeature"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ExcludeFeaturesFromOrderResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[58] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetProductKeyProperties");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inProductKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductKeyPropertiesResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outEnabled"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outMaxActivations"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outActivationsLeft"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrderID"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomerID"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[59] = oper;

    }

    private static void _initOperationDesc7(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("IncreaseProductKeyActivations");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inProductKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "IncreaseProductKeyActivationsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[60] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EnableProductKey");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inProductKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "EnableProductKeyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[61] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DisableProductKey");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inProductKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "DisableProductKeyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[62] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Activate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inProductKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ActivateResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[63] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOrdersByCustomerID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inCustomerID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrdersByCustomerIDResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfOrder"), com.aladdin.www.webservices.hasp.WebHaspBss.Order[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Order"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[64] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetOrderFreeData");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderFreeDataResult"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFreeParameters"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFreeParameter"), com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeParameter"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFreeMemorySegments"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFreeMemorySegment"), com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemorySegment"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outExcludeFeatures"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfExcludeFeature"), com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ExcludeFeature"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[65] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetOrderFreeData");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrderID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inFreeParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFreeParameter"), com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeParameter"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inFreeMemorySegments"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFreeMemorySegment"), com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemorySegment"));
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inExcludeFeatures"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfExcludeFeature"), com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ExcludeFeature"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SetOrderFreeDataResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[66] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RemovePendingOrders");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inC2V"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus"));
        oper.setReturnClass(com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "RemovePendingOrdersResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[67] = oper;

    }

    public HaspBssSoap12Stub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public HaspBssSoap12Stub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public HaspBssSoap12Stub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfBatch");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.Batch[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Batch");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Batch");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfCustomer");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.Customer[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Customer");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Customer");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfExcludeFeature");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ExcludeFeature");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ExcludeFeature");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFeature");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.Feature[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Feature");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Feature");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFingerprintDevice");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.FingerprintDevice[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FingerprintDevice");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FingerprintDevice");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFreeMemorySegment");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemorySegment");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemorySegment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFreeMemorySubSegment");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySubSegment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemorySubSegment");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemorySubSegment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfFreeParameter");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeParameter");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeParameter");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfKey");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.Key[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Key");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Key");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfKeyFeature");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.KeyFeature[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyFeature");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyFeature");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfMemorySegment");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.MemorySegment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "MemorySegment");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "MemorySegment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfOrder");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.Order[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Order");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Order");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfPendingOrder");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.PendingOrder[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "PendingOrder");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "PendingOrder");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfProduct");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.Product[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Product");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Product");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ArrayOfString");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Batch");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.Batch.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ConcurrencyInstanceType");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.ConcurrencyInstanceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Customer");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.Customer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CustomerStatus");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.CustomerStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ExcludeFeature");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Feature");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.Feature.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FingerprintDevice");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.FingerprintDevice.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemorySegment");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemorySubSegment");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySubSegment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemoryType");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemoryType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeParameter");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeParameterStatus");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameterStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeParameterType");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameterType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspBssStatus");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Key");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.Key.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyFeature");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.KeyFeature.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyFormatType");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.KeyFormatType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyInfo");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyOrders");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.KeyOrders.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LicenseProperties");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.LicenseProperties.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LicenseType");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.LicenseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "MemorySegment");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.MemorySegment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Order");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.Order.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "OrderStatus");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.OrderStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "OrderType");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.OrderType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "PendingOrder");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.PendingOrder.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Product");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.Product.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProductData");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.ProductData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProductLockType");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.ProductLockType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProductStatus");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.ProductStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProductType");
            cachedSerQNames.add(qName);
            cls = com.aladdin.www.webservices.hasp.WebHaspBss.ProductType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus initialize(java.lang.String inUserName, java.lang.String inPassword, java.lang.String inServer, java.lang.String inPort) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/Initialize");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Initialize"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inUserName, inPassword, inServer, inPort});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getVersion(com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getVersionResult, javax.xml.rpc.holders.IntHolder majorVersion, javax.xml.rpc.holders.IntHolder minorVersion, javax.xml.rpc.holders.IntHolder buildVersion, javax.xml.rpc.holders.IntHolder revisionVersion, javax.xml.rpc.holders.StringHolder serverVersion, javax.xml.rpc.holders.StringHolder serverDBVersion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetVersion");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetVersion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getVersionResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetVersionResult"));
            } catch (java.lang.Exception _exception) {
                getVersionResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetVersionResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                majorVersion.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "majorVersion"))).intValue();
            } catch (java.lang.Exception _exception) {
                majorVersion.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "majorVersion")), int.class)).intValue();
            }
            try {
                minorVersion.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "minorVersion"))).intValue();
            } catch (java.lang.Exception _exception) {
                minorVersion.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "minorVersion")), int.class)).intValue();
            }
            try {
                buildVersion.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "buildVersion"))).intValue();
            } catch (java.lang.Exception _exception) {
                buildVersion.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "buildVersion")), int.class)).intValue();
            }
            try {
                revisionVersion.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "revisionVersion"))).intValue();
            } catch (java.lang.Exception _exception) {
                revisionVersion.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "revisionVersion")), int.class)).intValue();
            }
            try {
                serverVersion.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "serverVersion"));
            } catch (java.lang.Exception _exception) {
                serverVersion.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "serverVersion")), java.lang.String.class);
            }
            try {
                serverDBVersion.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "serverDBVersion"));
            } catch (java.lang.Exception _exception) {
                serverDBVersion.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "serverDBVersion")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getNewOrders(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getNewOrdersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfOrderHolder outOrders) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetNewOrders");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetNewOrders"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inBatchID), inReference});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getNewOrdersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetNewOrdersResult"));
            } catch (java.lang.Exception _exception) {
                getNewOrdersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetNewOrdersResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Order[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders"));
            } catch (java.lang.Exception _exception) {
                outOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Order[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders")), com.aladdin.www.webservices.hasp.WebHaspBss.Order[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getAllOrders(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getAllOrdersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfOrderHolder outOrders) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetAllOrders");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetAllOrders"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inBatchID), inReference});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getAllOrdersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetAllOrdersResult"));
            } catch (java.lang.Exception _exception) {
                getAllOrdersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetAllOrdersResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Order[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders"));
            } catch (java.lang.Exception _exception) {
                outOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Order[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders")), com.aladdin.www.webservices.hasp.WebHaspBss.Order[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getProductionOrders(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductionOrdersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfOrderHolder outOrders) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetProductionOrders");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductionOrders"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inBatchID), inReference});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getProductionOrdersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductionOrdersResult"));
            } catch (java.lang.Exception _exception) {
                getProductionOrdersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductionOrdersResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Order[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders"));
            } catch (java.lang.Exception _exception) {
                outOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Order[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders")), com.aladdin.www.webservices.hasp.WebHaspBss.Order[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getProvisionalOrders(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProvisionalOrdersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfOrderHolder outOrders) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetProvisionalOrders");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProvisionalOrders"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inBatchID), inReference});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getProvisionalOrdersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProvisionalOrdersResult"));
            } catch (java.lang.Exception _exception) {
                getProvisionalOrdersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProvisionalOrdersResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Order[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders"));
            } catch (java.lang.Exception _exception) {
                outOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Order[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders")), com.aladdin.www.webservices.hasp.WebHaspBss.Order[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getBatches(com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getBatchesResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfBatchHolder outBatches) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetBatches");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetBatches"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getBatchesResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetBatchesResult"));
            } catch (java.lang.Exception _exception) {
                getBatchesResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetBatchesResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outBatches.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Batch[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outBatches"));
            } catch (java.lang.Exception _exception) {
                outBatches.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Batch[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outBatches")), com.aladdin.www.webservices.hasp.WebHaspBss.Batch[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getProducts(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductsResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfProductHolder outProducts) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetProducts");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProducts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inBatchID), inReference});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getProductsResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductsResult"));
            } catch (java.lang.Exception _exception) {
                getProductsResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductsResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outProducts.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Product[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProducts"));
            } catch (java.lang.Exception _exception) {
                outProducts.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Product[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProducts")), com.aladdin.www.webservices.hasp.WebHaspBss.Product[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getProvisionalProducts(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProvisionalProductsResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfProductHolder outProducts) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetProvisionalProducts");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProvisionalProducts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inBatchID), inReference});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getProvisionalProductsResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProvisionalProductsResult"));
            } catch (java.lang.Exception _exception) {
                getProvisionalProductsResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProvisionalProductsResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outProducts.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Product[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProducts"));
            } catch (java.lang.Exception _exception) {
                outProducts.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Product[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProducts")), com.aladdin.www.webservices.hasp.WebHaspBss.Product[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getOrderProducts(int inOrderID, int inBatchID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getOrderProductsResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfProductHolder outProducts) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetOrderProducts");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderProducts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), new java.lang.Integer(inBatchID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getOrderProductsResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderProductsResult"));
            } catch (java.lang.Exception _exception) {
                getOrderProductsResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderProductsResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outProducts.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Product[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProducts"));
            } catch (java.lang.Exception _exception) {
                outProducts.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Product[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProducts")), com.aladdin.www.webservices.hasp.WebHaspBss.Product[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus addProductsToOrder(int inOrderID, int inBatchID, com.aladdin.www.webservices.hasp.WebHaspBss.Product[] inProducts) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/AddProductsToOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "AddProductsToOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), new java.lang.Integer(inBatchID), inProducts});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus insertOrder(int inBatchID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.OrderHolder inOrder) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/InsertOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "InsertOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inBatchID), inOrder.value});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                inOrder.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Order) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrder"));
            } catch (java.lang.Exception _exception) {
                inOrder.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Order) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inOrder")), com.aladdin.www.webservices.hasp.WebHaspBss.Order.class);
            }
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus deleteOrder(int inOrderID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/DeleteOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "DeleteOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus finalizeOrder(int inOrderID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/FinalizeOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FinalizeOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus unfinalizeOrder(int inOrderID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/UnfinalizeOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "UnfinalizeOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void produceOrderByHaspID(int inOrderID, org.apache.axis.types.UnsignedLong inHaspID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder produceOrderByHaspIDResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/ProduceOrderByHaspID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByHaspID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), inHaspID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                produceOrderByHaspIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByHaspIDResult"));
            } catch (java.lang.Exception _exception) {
                produceOrderByHaspIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByHaspIDResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outV2C.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"));
            } catch (java.lang.Exception _exception) {
                outV2C.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void produceProvisionalOrder(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder produceProvisionalOrderResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/ProduceProvisionalOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceProvisionalOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                produceProvisionalOrderResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceProvisionalOrderResult"));
            } catch (java.lang.Exception _exception) {
                produceProvisionalOrderResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceProvisionalOrderResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outV2C.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"));
            } catch (java.lang.Exception _exception) {
                outV2C.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void cleanAndProduceOrderByHaspID(int inOrderID, org.apache.axis.types.UnsignedLong inHaspID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder cleanAndProduceOrderByHaspIDResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/CleanAndProduceOrderByHaspID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CleanAndProduceOrderByHaspID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), inHaspID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                cleanAndProduceOrderByHaspIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CleanAndProduceOrderByHaspIDResult"));
            } catch (java.lang.Exception _exception) {
                cleanAndProduceOrderByHaspIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CleanAndProduceOrderByHaspIDResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outV2C.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"));
            } catch (java.lang.Exception _exception) {
                outV2C.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void produceOrderByC2V(int inOrderID, java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder produceOrderByC2VResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/ProduceOrderByC2V");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByC2V"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), inC2V});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                produceOrderByC2VResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByC2VResult"));
            } catch (java.lang.Exception _exception) {
                produceOrderByC2VResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByC2VResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outV2C.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"));
            } catch (java.lang.Exception _exception) {
                outV2C.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void produceOrderByHaspIDFromC2V(int inOrderID, java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder produceOrderByHaspIDFromC2VResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/ProduceOrderByHaspIDFromC2V");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByHaspIDFromC2V"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), inC2V});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                produceOrderByHaspIDFromC2VResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByHaspIDFromC2VResult"));
            } catch (java.lang.Exception _exception) {
                produceOrderByHaspIDFromC2VResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByHaspIDFromC2VResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outV2C.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"));
            } catch (java.lang.Exception _exception) {
                outV2C.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void produceOrderByC2VAndRemovePendingOrders(int inOrderID, java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder produceOrderByC2VAndRemovePendingOrdersResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/ProduceOrderByC2VAndRemovePendingOrders");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByC2VAndRemovePendingOrders"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), inC2V});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                produceOrderByC2VAndRemovePendingOrdersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByC2VAndRemovePendingOrdersResult"));
            } catch (java.lang.Exception _exception) {
                produceOrderByC2VAndRemovePendingOrdersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProduceOrderByC2VAndRemovePendingOrdersResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outV2C.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"));
            } catch (java.lang.Exception _exception) {
                outV2C.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getPendingOrders(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getPendingOrdersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfPendingOrderHolder outPendingOrders) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetPendingOrders");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetPendingOrders"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inC2V});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getPendingOrdersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetPendingOrdersResult"));
            } catch (java.lang.Exception _exception) {
                getPendingOrdersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetPendingOrdersResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outPendingOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.PendingOrder[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outPendingOrders"));
            } catch (java.lang.Exception _exception) {
                outPendingOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.PendingOrder[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outPendingOrders")), com.aladdin.www.webservices.hasp.WebHaspBss.PendingOrder[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus generateProductKeys(int inOrderID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GenerateProductKeys");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GenerateProductKeys"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getProductKeys(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductKeysResult, javax.xml.rpc.holders.StringHolder outProductKeys) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetProductKeys");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductKeys"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getProductKeysResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductKeysResult"));
            } catch (java.lang.Exception _exception) {
                getProductKeysResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductKeysResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outProductKeys.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProductKeys"));
            } catch (java.lang.Exception _exception) {
                outProductKeys.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProductKeys")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getOrderFreeParameters(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getOrderFreeParametersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfFreeParameterHolder outFreeParameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetOrderFreeParameters");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderFreeParameters"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getOrderFreeParametersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderFreeParametersResult"));
            } catch (java.lang.Exception _exception) {
                getOrderFreeParametersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderFreeParametersResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outFreeParameters.value = (com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFreeParameters"));
            } catch (java.lang.Exception _exception) {
                outFreeParameters.value = (com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFreeParameters")), com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus setOrderFreeParameters(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[] inFreeParameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/SetOrderFreeParameters");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SetOrderFreeParameters"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), inFreeParameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getOrderFreeMemorySegments(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getOrderFreeMemorySegmentsResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfFreeMemorySegmentHolder outFreeMemorySegments) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetOrderFreeMemorySegments");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderFreeMemorySegments"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getOrderFreeMemorySegmentsResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderFreeMemorySegmentsResult"));
            } catch (java.lang.Exception _exception) {
                getOrderFreeMemorySegmentsResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderFreeMemorySegmentsResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outFreeMemorySegments.value = (com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFreeMemorySegments"));
            } catch (java.lang.Exception _exception) {
                outFreeMemorySegments.value = (com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFreeMemorySegments")), com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus setOrderFreeMemorySegments(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[] inFreeMemorySegments) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/SetOrderFreeMemorySegments");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SetOrderFreeMemorySegments"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), inFreeMemorySegments});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus addKeysToOrder(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.Key[] inKeys) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/AddKeysToOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "AddKeysToOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), inKeys});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void locateC2VKey(java.lang.String inC2V, int vendorID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder locateC2VKeyResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyHolder outKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/LocateC2VKey");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LocateC2VKey"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inC2V, new java.lang.Integer(vendorID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                locateC2VKeyResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LocateC2VKeyResult"));
            } catch (java.lang.Exception _exception) {
                locateC2VKeyResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LocateC2VKeyResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outKey.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Key) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKey"));
            } catch (java.lang.Exception _exception) {
                outKey.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Key) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKey")), com.aladdin.www.webservices.hasp.WebHaspBss.Key.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus removeKeysFromOrder(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.Key[] inKeys) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/RemoveKeysFromOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "RemoveKeysFromOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), inKeys});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus checkInC2V(java.lang.String inC2V) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/CheckInC2V");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CheckInC2V"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inC2V});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void checkInC2VGetKeyInfo(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder checkInC2VGetKeyInfoResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyInfoHolder outKeyInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/CheckInC2VGetKeyInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CheckInC2VGetKeyInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inC2V});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                checkInC2VGetKeyInfoResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CheckInC2VGetKeyInfoResult"));
            } catch (java.lang.Exception _exception) {
                checkInC2VGetKeyInfoResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CheckInC2VGetKeyInfoResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outKeyInfo.value = (com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyInfo"));
            } catch (java.lang.Exception _exception) {
                outKeyInfo.value = (com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyInfo")), com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void synchronizeDatabaseUsingKeyInfo(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder synchronizeDatabaseUsingKeyInfoResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyInfoHolder outKeyInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/SynchronizeDatabaseUsingKeyInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SynchronizeDatabaseUsingKeyInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inC2V});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                synchronizeDatabaseUsingKeyInfoResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SynchronizeDatabaseUsingKeyInfoResult"));
            } catch (java.lang.Exception _exception) {
                synchronizeDatabaseUsingKeyInfoResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SynchronizeDatabaseUsingKeyInfoResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outKeyInfo.value = (com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyInfo"));
            } catch (java.lang.Exception _exception) {
                outKeyInfo.value = (com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyInfo")), com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getKeysByProductKey(java.lang.String inProductKey, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getKeysByProductKeyResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfKeyHolder outKeys) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetKeysByProductKey");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeysByProductKey"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inProductKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getKeysByProductKeyResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeysByProductKeyResult"));
            } catch (java.lang.Exception _exception) {
                getKeysByProductKeyResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeysByProductKeyResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outKeys.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Key[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeys"));
            } catch (java.lang.Exception _exception) {
                outKeys.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Key[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeys")), com.aladdin.www.webservices.hasp.WebHaspBss.Key[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getFingerprintByC2V(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getFingerprintByC2VResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfFingerprintDeviceHolder outFingerprint) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetFingerprintByC2V");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetFingerprintByC2V"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inC2V});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getFingerprintByC2VResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetFingerprintByC2VResult"));
            } catch (java.lang.Exception _exception) {
                getFingerprintByC2VResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetFingerprintByC2VResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outFingerprint.value = (com.aladdin.www.webservices.hasp.WebHaspBss.FingerprintDevice[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFingerprint"));
            } catch (java.lang.Exception _exception) {
                outFingerprint.value = (com.aladdin.www.webservices.hasp.WebHaspBss.FingerprintDevice[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFingerprint")), com.aladdin.www.webservices.hasp.WebHaspBss.FingerprintDevice[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getFingerprintByKeyID(java.lang.String inKeyID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getFingerprintByKeyIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfFingerprintDeviceHolder outFingerprint) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetFingerprintByKeyID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetFingerprintByKeyID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inKeyID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getFingerprintByKeyIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetFingerprintByKeyIDResult"));
            } catch (java.lang.Exception _exception) {
                getFingerprintByKeyIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetFingerprintByKeyIDResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outFingerprint.value = (com.aladdin.www.webservices.hasp.WebHaspBss.FingerprintDevice[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFingerprint"));
            } catch (java.lang.Exception _exception) {
                outFingerprint.value = (com.aladdin.www.webservices.hasp.WebHaspBss.FingerprintDevice[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFingerprint")), com.aladdin.www.webservices.hasp.WebHaspBss.FingerprintDevice[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void clearClonedHaspSLKey(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder clearClonedHaspSLKeyResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/ClearClonedHaspSLKey");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ClearClonedHaspSLKey"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inC2V});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                clearClonedHaspSLKeyResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ClearClonedHaspSLKeyResult"));
            } catch (java.lang.Exception _exception) {
                clearClonedHaspSLKeyResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ClearClonedHaspSLKeyResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outV2C.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"));
            } catch (java.lang.Exception _exception) {
                outV2C.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getKeyHistoryByKeyID(org.apache.axis.types.UnsignedLong inKeyID, int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getKeyHistoryByKeyIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyInfoHolder outKeyInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetKeyHistoryByKeyID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyHistoryByKeyID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inKeyID, new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getKeyHistoryByKeyIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyHistoryByKeyIDResult"));
            } catch (java.lang.Exception _exception) {
                getKeyHistoryByKeyIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyHistoryByKeyIDResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outKeyInfo.value = (com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyInfo"));
            } catch (java.lang.Exception _exception) {
                outKeyInfo.value = (com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyInfo")), com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getKeyHistoryByC2V(java.lang.String inC2V, int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getKeyHistoryByC2VResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyInfoHolder outKeyInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetKeyHistoryByC2V");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyHistoryByC2V"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inC2V, new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getKeyHistoryByC2VResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyHistoryByC2VResult"));
            } catch (java.lang.Exception _exception) {
                getKeyHistoryByC2VResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyHistoryByC2VResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outKeyInfo.value = (com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyInfo"));
            } catch (java.lang.Exception _exception) {
                outKeyInfo.value = (com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyInfo")), com.aladdin.www.webservices.hasp.WebHaspBss.KeyInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getKeyOrdersByKeyID(org.apache.axis.types.UnsignedLong inKeyID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getKeyOrdersByKeyIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyOrdersHolder outKeyOrders) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetKeyOrdersByKeyID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyOrdersByKeyID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inKeyID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getKeyOrdersByKeyIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyOrdersByKeyIDResult"));
            } catch (java.lang.Exception _exception) {
                getKeyOrdersByKeyIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyOrdersByKeyIDResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outKeyOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.KeyOrders) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyOrders"));
            } catch (java.lang.Exception _exception) {
                outKeyOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.KeyOrders) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyOrders")), com.aladdin.www.webservices.hasp.WebHaspBss.KeyOrders.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getKeyOrdersByC2V(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getKeyOrdersByC2VResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyOrdersHolder outKeyOrders) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetKeyOrdersByC2V");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyOrdersByC2V"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inC2V});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getKeyOrdersByC2VResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyOrdersByC2VResult"));
            } catch (java.lang.Exception _exception) {
                getKeyOrdersByC2VResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeyOrdersByC2VResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outKeyOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.KeyOrders) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyOrders"));
            } catch (java.lang.Exception _exception) {
                outKeyOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.KeyOrders) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyOrders")), com.aladdin.www.webservices.hasp.WebHaspBss.KeyOrders.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getKeysByOrderID(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getKeysByOrderIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfKeyHolder outKeys) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetKeysByOrderID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeysByOrderID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getKeysByOrderIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeysByOrderIDResult"));
            } catch (java.lang.Exception _exception) {
                getKeysByOrderIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetKeysByOrderIDResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outKeys.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Key[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeys"));
            } catch (java.lang.Exception _exception) {
                outKeys.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Key[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeys")), com.aladdin.www.webservices.hasp.WebHaspBss.Key[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getAvailableKeyTypesByOrderID(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getAvailableKeyTypesByOrderIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfStringHolder outKeyTypes) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetAvailableKeyTypesByOrderID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetAvailableKeyTypesByOrderID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getAvailableKeyTypesByOrderIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetAvailableKeyTypesByOrderIDResult"));
            } catch (java.lang.Exception _exception) {
                getAvailableKeyTypesByOrderIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetAvailableKeyTypesByOrderIDResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outKeyTypes.value = (java.lang.String[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyTypes"));
            } catch (java.lang.Exception _exception) {
                outKeyTypes.value = (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outKeyTypes")), java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getProductByID(int inProductID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductByIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ProductHolder outProduct) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetProductByID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductByID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inProductID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getProductByIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductByIDResult"));
            } catch (java.lang.Exception _exception) {
                getProductByIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductByIDResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outProduct.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Product) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProduct"));
            } catch (java.lang.Exception _exception) {
                outProduct.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Product) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProduct")), com.aladdin.www.webservices.hasp.WebHaspBss.Product.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getProductByName(java.lang.String inProductName, int inBatchID, int inBaseProductID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductByNameResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ProductHolder outProduct) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[45]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetProductByName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductByName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inProductName, new java.lang.Integer(inBatchID), new java.lang.Integer(inBaseProductID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getProductByNameResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductByNameResult"));
            } catch (java.lang.Exception _exception) {
                getProductByNameResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductByNameResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outProduct.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Product) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProduct"));
            } catch (java.lang.Exception _exception) {
                outProduct.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Product) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProduct")), com.aladdin.www.webservices.hasp.WebHaspBss.Product.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void generateFormatUpdateFile(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder generateFormatUpdateFileResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[46]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GenerateFormatUpdateFile");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GenerateFormatUpdateFile"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inC2V});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                generateFormatUpdateFileResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GenerateFormatUpdateFileResult"));
            } catch (java.lang.Exception _exception) {
                generateFormatUpdateFileResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GenerateFormatUpdateFileResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outV2C.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"));
            } catch (java.lang.Exception _exception) {
                outV2C.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getCustomers(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getCustomersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfCustomerHolder outCustomers) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[47]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetCustomers");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetCustomers"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inBatchID), inReference});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getCustomersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetCustomersResult"));
            } catch (java.lang.Exception _exception) {
                getCustomersResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetCustomersResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outCustomers.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomers"));
            } catch (java.lang.Exception _exception) {
                outCustomers.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomers")), com.aladdin.www.webservices.hasp.WebHaspBss.Customer[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getCustomerByID(int inCustomerID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getCustomerByIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.CustomerHolder outCustomer) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[48]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetCustomerByID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetCustomerByID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inCustomerID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getCustomerByIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetCustomerByIDResult"));
            } catch (java.lang.Exception _exception) {
                getCustomerByIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetCustomerByIDResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outCustomer.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomer"));
            } catch (java.lang.Exception _exception) {
                outCustomer.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomer")), com.aladdin.www.webservices.hasp.WebHaspBss.Customer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus insertCustomer(int inBatchID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.CustomerHolder inCustomer) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[49]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/InsertCustomer");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "InsertCustomer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inBatchID), inCustomer.value});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                inCustomer.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inCustomer"));
            } catch (java.lang.Exception _exception) {
                inCustomer.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inCustomer")), com.aladdin.www.webservices.hasp.WebHaspBss.Customer.class);
            }
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus updateCustomer(com.aladdin.www.webservices.hasp.WebHaspBss.holders.CustomerHolder inCustomer) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[50]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/UpdateCustomer");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "UpdateCustomer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inCustomer.value});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                inCustomer.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inCustomer"));
            } catch (java.lang.Exception _exception) {
                inCustomer.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "inCustomer")), com.aladdin.www.webservices.hasp.WebHaspBss.Customer.class);
            }
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void obsoleteCustomer(int inCustomerID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder obsoleteCustomerResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.CustomerHolder outCustomer) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[51]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/ObsoleteCustomer");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ObsoleteCustomer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inCustomerID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                obsoleteCustomerResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ObsoleteCustomerResult"));
            } catch (java.lang.Exception _exception) {
                obsoleteCustomerResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ObsoleteCustomerResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outCustomer.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomer"));
            } catch (java.lang.Exception _exception) {
                outCustomer.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomer")), com.aladdin.www.webservices.hasp.WebHaspBss.Customer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void restoreCustomer(int inCustomerID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder restoreCustomerResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.CustomerHolder outCustomer) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[52]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/RestoreCustomer");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "RestoreCustomer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inCustomerID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                restoreCustomerResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "RestoreCustomerResult"));
            } catch (java.lang.Exception _exception) {
                restoreCustomerResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "RestoreCustomerResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outCustomer.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomer"));
            } catch (java.lang.Exception _exception) {
                outCustomer.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomer")), com.aladdin.www.webservices.hasp.WebHaspBss.Customer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus addCustomerToOrder(int inOrderID, int inCustomerID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[53]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/AddCustomerToOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "AddCustomerToOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), new java.lang.Integer(inCustomerID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getCustomerByOrderID(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getCustomerByOrderIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.CustomerHolder outCustomer) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[54]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetCustomerByOrderID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetCustomerByOrderID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getCustomerByOrderIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetCustomerByOrderIDResult"));
            } catch (java.lang.Exception _exception) {
                getCustomerByOrderIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetCustomerByOrderIDResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outCustomer.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomer"));
            } catch (java.lang.Exception _exception) {
                outCustomer.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Customer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomer")), com.aladdin.www.webservices.hasp.WebHaspBss.Customer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getExecutableFromV2C(java.lang.String inV2C, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getExecutableFromV2CResult, javax.xml.rpc.holders.ByteArrayHolder outExe) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[55]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetExecutableFromV2C");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetExecutableFromV2C"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inV2C});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getExecutableFromV2CResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetExecutableFromV2CResult"));
            } catch (java.lang.Exception _exception) {
                getExecutableFromV2CResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetExecutableFromV2CResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outExe.value = (byte[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outExe"));
            } catch (java.lang.Exception _exception) {
                outExe.value = (byte[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outExe")), byte[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getProductDataByID(int inProductID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductDataByIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ProductDataHolder outProductData) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[56]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetProductDataByID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductDataByID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inProductID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getProductDataByIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductDataByIDResult"));
            } catch (java.lang.Exception _exception) {
                getProductDataByIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductDataByIDResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outProductData.value = (com.aladdin.www.webservices.hasp.WebHaspBss.ProductData) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProductData"));
            } catch (java.lang.Exception _exception) {
                outProductData.value = (com.aladdin.www.webservices.hasp.WebHaspBss.ProductData) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outProductData")), com.aladdin.www.webservices.hasp.WebHaspBss.ProductData.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getOrderExcludableFeatures(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getOrderExcludableFeaturesResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfExcludeFeatureHolder outExcludeFeatures) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[57]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetOrderExcludableFeatures");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderExcludableFeatures"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getOrderExcludableFeaturesResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderExcludableFeaturesResult"));
            } catch (java.lang.Exception _exception) {
                getOrderExcludableFeaturesResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderExcludableFeaturesResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outExcludeFeatures.value = (com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outExcludeFeatures"));
            } catch (java.lang.Exception _exception) {
                outExcludeFeatures.value = (com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outExcludeFeatures")), com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus excludeFeaturesFromOrder(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[] inExcludeFeatures) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[58]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/ExcludeFeaturesFromOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ExcludeFeaturesFromOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), inExcludeFeatures});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getProductKeyProperties(java.lang.String inProductKey, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductKeyPropertiesResult, javax.xml.rpc.holders.BooleanHolder outEnabled, javax.xml.rpc.holders.IntHolder outMaxActivations, javax.xml.rpc.holders.IntHolder outActivationsLeft, javax.xml.rpc.holders.IntHolder outOrderID, javax.xml.rpc.holders.IntHolder outCustomerID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[59]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetProductKeyProperties");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductKeyProperties"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inProductKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getProductKeyPropertiesResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductKeyPropertiesResult"));
            } catch (java.lang.Exception _exception) {
                getProductKeyPropertiesResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetProductKeyPropertiesResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outEnabled.value = ((java.lang.Boolean) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outEnabled"))).booleanValue();
            } catch (java.lang.Exception _exception) {
                outEnabled.value = ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outEnabled")), boolean.class)).booleanValue();
            }
            try {
                outMaxActivations.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outMaxActivations"))).intValue();
            } catch (java.lang.Exception _exception) {
                outMaxActivations.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outMaxActivations")), int.class)).intValue();
            }
            try {
                outActivationsLeft.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outActivationsLeft"))).intValue();
            } catch (java.lang.Exception _exception) {
                outActivationsLeft.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outActivationsLeft")), int.class)).intValue();
            }
            try {
                outOrderID.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrderID"))).intValue();
            } catch (java.lang.Exception _exception) {
                outOrderID.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrderID")), int.class)).intValue();
            }
            try {
                outCustomerID.value = ((java.lang.Integer) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomerID"))).intValue();
            } catch (java.lang.Exception _exception) {
                outCustomerID.value = ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outCustomerID")), int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus increaseProductKeyActivations(java.lang.String inProductKey) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[60]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/IncreaseProductKeyActivations");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "IncreaseProductKeyActivations"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inProductKey});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus enableProductKey(java.lang.String inProductKey, int inOrderID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[61]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/EnableProductKey");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "EnableProductKey"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inProductKey, new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus disableProductKey(java.lang.String inProductKey, int inOrderID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[62]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/DisableProductKey");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "DisableProductKey"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inProductKey, new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void activate(java.lang.String inProductKey, java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder activateResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[63]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/Activate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Activate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inProductKey, inC2V});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                activateResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ActivateResult"));
            } catch (java.lang.Exception _exception) {
                activateResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ActivateResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outV2C.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C"));
            } catch (java.lang.Exception _exception) {
                outV2C.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outV2C")), java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getOrdersByCustomerID(int inCustomerID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getOrdersByCustomerIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfOrderHolder outOrders) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[64]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetOrdersByCustomerID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrdersByCustomerID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inCustomerID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getOrdersByCustomerIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrdersByCustomerIDResult"));
            } catch (java.lang.Exception _exception) {
                getOrdersByCustomerIDResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrdersByCustomerIDResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Order[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders"));
            } catch (java.lang.Exception _exception) {
                outOrders.value = (com.aladdin.www.webservices.hasp.WebHaspBss.Order[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outOrders")), com.aladdin.www.webservices.hasp.WebHaspBss.Order[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void getOrderFreeData(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getOrderFreeDataResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfFreeParameterHolder outFreeParameters, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfFreeMemorySegmentHolder outFreeMemorySegments, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfExcludeFeatureHolder outExcludeFeatures) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[65]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/GetOrderFreeData");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderFreeData"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                getOrderFreeDataResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderFreeDataResult"));
            } catch (java.lang.Exception _exception) {
                getOrderFreeDataResult.value = (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "GetOrderFreeDataResult")), com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
            try {
                outFreeParameters.value = (com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFreeParameters"));
            } catch (java.lang.Exception _exception) {
                outFreeParameters.value = (com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFreeParameters")), com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[].class);
            }
            try {
                outFreeMemorySegments.value = (com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFreeMemorySegments"));
            } catch (java.lang.Exception _exception) {
                outFreeMemorySegments.value = (com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outFreeMemorySegments")), com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[].class);
            }
            try {
                outExcludeFeatures.value = (com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[]) _output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outExcludeFeatures"));
            } catch (java.lang.Exception _exception) {
                outExcludeFeatures.value = (com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[]) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "outExcludeFeatures")), com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus setOrderFreeData(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[] inFreeParameters, com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[] inFreeMemorySegments, com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[] inExcludeFeatures) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[66]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/SetOrderFreeData");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SetOrderFreeData"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(inOrderID), inFreeParameters, inFreeMemorySegments, inExcludeFeatures});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus removePendingOrders(java.lang.String inC2V) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[67]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.aladdin.com/webservices/hasp/WebHaspBss/RemovePendingOrders");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "RemovePendingOrders"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inC2V});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
