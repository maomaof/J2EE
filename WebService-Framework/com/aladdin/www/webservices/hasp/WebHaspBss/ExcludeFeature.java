/**
 * ExcludeFeature.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public class ExcludeFeature  implements java.io.Serializable {
    private int productID;

    private int featureID;

    private java.lang.String productName;

    private java.lang.String featureName;

    private boolean isExcluded;

    private com.aladdin.www.webservices.hasp.WebHaspBss.LicenseProperties license;

    public ExcludeFeature() {
    }

    public ExcludeFeature(
           int productID,
           int featureID,
           java.lang.String productName,
           java.lang.String featureName,
           boolean isExcluded,
           com.aladdin.www.webservices.hasp.WebHaspBss.LicenseProperties license) {
           this.productID = productID;
           this.featureID = featureID;
           this.productName = productName;
           this.featureName = featureName;
           this.isExcluded = isExcluded;
           this.license = license;
    }


    /**
     * Gets the productID value for this ExcludeFeature.
     * 
     * @return productID
     */
    public int getProductID() {
        return productID;
    }


    /**
     * Sets the productID value for this ExcludeFeature.
     * 
     * @param productID
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }


    /**
     * Gets the featureID value for this ExcludeFeature.
     * 
     * @return featureID
     */
    public int getFeatureID() {
        return featureID;
    }


    /**
     * Sets the featureID value for this ExcludeFeature.
     * 
     * @param featureID
     */
    public void setFeatureID(int featureID) {
        this.featureID = featureID;
    }


    /**
     * Gets the productName value for this ExcludeFeature.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this ExcludeFeature.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the featureName value for this ExcludeFeature.
     * 
     * @return featureName
     */
    public java.lang.String getFeatureName() {
        return featureName;
    }


    /**
     * Sets the featureName value for this ExcludeFeature.
     * 
     * @param featureName
     */
    public void setFeatureName(java.lang.String featureName) {
        this.featureName = featureName;
    }


    /**
     * Gets the isExcluded value for this ExcludeFeature.
     * 
     * @return isExcluded
     */
    public boolean isIsExcluded() {
        return isExcluded;
    }


    /**
     * Sets the isExcluded value for this ExcludeFeature.
     * 
     * @param isExcluded
     */
    public void setIsExcluded(boolean isExcluded) {
        this.isExcluded = isExcluded;
    }


    /**
     * Gets the license value for this ExcludeFeature.
     * 
     * @return license
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.LicenseProperties getLicense() {
        return license;
    }


    /**
     * Sets the license value for this ExcludeFeature.
     * 
     * @param license
     */
    public void setLicense(com.aladdin.www.webservices.hasp.WebHaspBss.LicenseProperties license) {
        this.license = license;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExcludeFeature)) return false;
        ExcludeFeature other = (ExcludeFeature) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.productID == other.getProductID() &&
            this.featureID == other.getFeatureID() &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.featureName==null && other.getFeatureName()==null) || 
             (this.featureName!=null &&
              this.featureName.equals(other.getFeatureName()))) &&
            this.isExcluded == other.isIsExcluded() &&
            ((this.license==null && other.getLicense()==null) || 
             (this.license!=null &&
              this.license.equals(other.getLicense())));
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
        _hashCode += getProductID();
        _hashCode += getFeatureID();
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getFeatureName() != null) {
            _hashCode += getFeatureName().hashCode();
        }
        _hashCode += (isIsExcluded() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getLicense() != null) {
            _hashCode += getLicense().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExcludeFeature.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ExcludeFeature"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProductName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("isExcluded");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "IsExcluded"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("license");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "License"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LicenseProperties"));
        elemField.setMinOccurs(0);
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
