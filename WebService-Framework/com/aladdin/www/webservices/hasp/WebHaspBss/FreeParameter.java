/**
 * FreeParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public class FreeParameter  implements java.io.Serializable {
    private com.aladdin.www.webservices.hasp.WebHaspBss.LicenseProperties license;

    private com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameterType type;

    private java.lang.String value;

    private com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameterStatus status;

    private int productID;

    private int featureID;

    private java.lang.String featureName;

    private int baseProductID;

    private java.lang.String baseProductName;

    private com.aladdin.www.webservices.hasp.WebHaspBss.ProductLockType lockType;

    public FreeParameter() {
    }

    public FreeParameter(
           com.aladdin.www.webservices.hasp.WebHaspBss.LicenseProperties license,
           com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameterType type,
           java.lang.String value,
           com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameterStatus status,
           int productID,
           int featureID,
           java.lang.String featureName,
           int baseProductID,
           java.lang.String baseProductName,
           com.aladdin.www.webservices.hasp.WebHaspBss.ProductLockType lockType) {
           this.license = license;
           this.type = type;
           this.value = value;
           this.status = status;
           this.productID = productID;
           this.featureID = featureID;
           this.featureName = featureName;
           this.baseProductID = baseProductID;
           this.baseProductName = baseProductName;
           this.lockType = lockType;
    }


    /**
     * Gets the license value for this FreeParameter.
     * 
     * @return license
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.LicenseProperties getLicense() {
        return license;
    }


    /**
     * Sets the license value for this FreeParameter.
     * 
     * @param license
     */
    public void setLicense(com.aladdin.www.webservices.hasp.WebHaspBss.LicenseProperties license) {
        this.license = license;
    }


    /**
     * Gets the type value for this FreeParameter.
     * 
     * @return type
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameterType getType() {
        return type;
    }


    /**
     * Sets the type value for this FreeParameter.
     * 
     * @param type
     */
    public void setType(com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameterType type) {
        this.type = type;
    }


    /**
     * Gets the value value for this FreeParameter.
     * 
     * @return value
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this FreeParameter.
     * 
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }


    /**
     * Gets the status value for this FreeParameter.
     * 
     * @return status
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameterStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this FreeParameter.
     * 
     * @param status
     */
    public void setStatus(com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameterStatus status) {
        this.status = status;
    }


    /**
     * Gets the productID value for this FreeParameter.
     * 
     * @return productID
     */
    public int getProductID() {
        return productID;
    }


    /**
     * Sets the productID value for this FreeParameter.
     * 
     * @param productID
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }


    /**
     * Gets the featureID value for this FreeParameter.
     * 
     * @return featureID
     */
    public int getFeatureID() {
        return featureID;
    }


    /**
     * Sets the featureID value for this FreeParameter.
     * 
     * @param featureID
     */
    public void setFeatureID(int featureID) {
        this.featureID = featureID;
    }


    /**
     * Gets the featureName value for this FreeParameter.
     * 
     * @return featureName
     */
    public java.lang.String getFeatureName() {
        return featureName;
    }


    /**
     * Sets the featureName value for this FreeParameter.
     * 
     * @param featureName
     */
    public void setFeatureName(java.lang.String featureName) {
        this.featureName = featureName;
    }


    /**
     * Gets the baseProductID value for this FreeParameter.
     * 
     * @return baseProductID
     */
    public int getBaseProductID() {
        return baseProductID;
    }


    /**
     * Sets the baseProductID value for this FreeParameter.
     * 
     * @param baseProductID
     */
    public void setBaseProductID(int baseProductID) {
        this.baseProductID = baseProductID;
    }


    /**
     * Gets the baseProductName value for this FreeParameter.
     * 
     * @return baseProductName
     */
    public java.lang.String getBaseProductName() {
        return baseProductName;
    }


    /**
     * Sets the baseProductName value for this FreeParameter.
     * 
     * @param baseProductName
     */
    public void setBaseProductName(java.lang.String baseProductName) {
        this.baseProductName = baseProductName;
    }


    /**
     * Gets the lockType value for this FreeParameter.
     * 
     * @return lockType
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.ProductLockType getLockType() {
        return lockType;
    }


    /**
     * Sets the lockType value for this FreeParameter.
     * 
     * @param lockType
     */
    public void setLockType(com.aladdin.www.webservices.hasp.WebHaspBss.ProductLockType lockType) {
        this.lockType = lockType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FreeParameter)) return false;
        FreeParameter other = (FreeParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.license==null && other.getLicense()==null) || 
             (this.license!=null &&
              this.license.equals(other.getLicense()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            this.productID == other.getProductID() &&
            this.featureID == other.getFeatureID() &&
            ((this.featureName==null && other.getFeatureName()==null) || 
             (this.featureName!=null &&
              this.featureName.equals(other.getFeatureName()))) &&
            this.baseProductID == other.getBaseProductID() &&
            ((this.baseProductName==null && other.getBaseProductName()==null) || 
             (this.baseProductName!=null &&
              this.baseProductName.equals(other.getBaseProductName()))) &&
            ((this.lockType==null && other.getLockType()==null) || 
             (this.lockType!=null &&
              this.lockType.equals(other.getLockType())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getLicense() != null) {
            _hashCode += getLicense().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        _hashCode += getProductID();
        _hashCode += getFeatureID();
        if (getFeatureName() != null) {
            _hashCode += getFeatureName().hashCode();
        }
        _hashCode += getBaseProductID();
        if (getBaseProductName() != null) {
            _hashCode += getBaseProductName().hashCode();
        }
        if (getLockType() != null) {
            _hashCode += getLockType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FreeParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("license");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "License"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LicenseProperties"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeParameterType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeParameterStatus"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProductID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("featureID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FeatureID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("featureName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FeatureName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baseProductID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "BaseProductID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baseProductName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "BaseProductName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lockType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LockType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProductLockType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
