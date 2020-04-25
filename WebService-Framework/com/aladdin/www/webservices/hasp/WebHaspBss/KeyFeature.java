/**
 * KeyFeature.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public class KeyFeature  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedInt featureID;

    private java.lang.String featureName;

    private java.lang.String license;

    private com.aladdin.www.webservices.hasp.WebHaspBss.LicenseProperties licenseProperties;

    private int baseProductID;

    private java.lang.String baseProductName;

    private boolean cloneProtection;

    private boolean cloneDetected;

    public KeyFeature() {
    }

    public KeyFeature(
           org.apache.axis.types.UnsignedInt featureID,
           java.lang.String featureName,
           java.lang.String license,
           com.aladdin.www.webservices.hasp.WebHaspBss.LicenseProperties licenseProperties,
           int baseProductID,
           java.lang.String baseProductName,
           boolean cloneProtection,
           boolean cloneDetected) {
           this.featureID = featureID;
           this.featureName = featureName;
           this.license = license;
           this.licenseProperties = licenseProperties;
           this.baseProductID = baseProductID;
           this.baseProductName = baseProductName;
           this.cloneProtection = cloneProtection;
           this.cloneDetected = cloneDetected;
    }


    /**
     * Gets the featureID value for this KeyFeature.
     * 
     * @return featureID
     */
    public org.apache.axis.types.UnsignedInt getFeatureID() {
        return featureID;
    }


    /**
     * Sets the featureID value for this KeyFeature.
     * 
     * @param featureID
     */
    public void setFeatureID(org.apache.axis.types.UnsignedInt featureID) {
        this.featureID = featureID;
    }


    /**
     * Gets the featureName value for this KeyFeature.
     * 
     * @return featureName
     */
    public java.lang.String getFeatureName() {
        return featureName;
    }


    /**
     * Sets the featureName value for this KeyFeature.
     * 
     * @param featureName
     */
    public void setFeatureName(java.lang.String featureName) {
        this.featureName = featureName;
    }


    /**
     * Gets the license value for this KeyFeature.
     * 
     * @return license
     */
    public java.lang.String getLicense() {
        return license;
    }


    /**
     * Sets the license value for this KeyFeature.
     * 
     * @param license
     */
    public void setLicense(java.lang.String license) {
        this.license = license;
    }


    /**
     * Gets the licenseProperties value for this KeyFeature.
     * 
     * @return licenseProperties
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.LicenseProperties getLicenseProperties() {
        return licenseProperties;
    }


    /**
     * Sets the licenseProperties value for this KeyFeature.
     * 
     * @param licenseProperties
     */
    public void setLicenseProperties(com.aladdin.www.webservices.hasp.WebHaspBss.LicenseProperties licenseProperties) {
        this.licenseProperties = licenseProperties;
    }


    /**
     * Gets the baseProductID value for this KeyFeature.
     * 
     * @return baseProductID
     */
    public int getBaseProductID() {
        return baseProductID;
    }


    /**
     * Sets the baseProductID value for this KeyFeature.
     * 
     * @param baseProductID
     */
    public void setBaseProductID(int baseProductID) {
        this.baseProductID = baseProductID;
    }


    /**
     * Gets the baseProductName value for this KeyFeature.
     * 
     * @return baseProductName
     */
    public java.lang.String getBaseProductName() {
        return baseProductName;
    }


    /**
     * Sets the baseProductName value for this KeyFeature.
     * 
     * @param baseProductName
     */
    public void setBaseProductName(java.lang.String baseProductName) {
        this.baseProductName = baseProductName;
    }


    /**
     * Gets the cloneProtection value for this KeyFeature.
     * 
     * @return cloneProtection
     */
    public boolean isCloneProtection() {
        return cloneProtection;
    }


    /**
     * Sets the cloneProtection value for this KeyFeature.
     * 
     * @param cloneProtection
     */
    public void setCloneProtection(boolean cloneProtection) {
        this.cloneProtection = cloneProtection;
    }


    /**
     * Gets the cloneDetected value for this KeyFeature.
     * 
     * @return cloneDetected
     */
    public boolean isCloneDetected() {
        return cloneDetected;
    }


    /**
     * Sets the cloneDetected value for this KeyFeature.
     * 
     * @param cloneDetected
     */
    public void setCloneDetected(boolean cloneDetected) {
        this.cloneDetected = cloneDetected;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KeyFeature)) return false;
        KeyFeature other = (KeyFeature) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.featureID==null && other.getFeatureID()==null) || 
             (this.featureID!=null &&
              this.featureID.equals(other.getFeatureID()))) &&
            ((this.featureName==null && other.getFeatureName()==null) || 
             (this.featureName!=null &&
              this.featureName.equals(other.getFeatureName()))) &&
            ((this.license==null && other.getLicense()==null) || 
             (this.license!=null &&
              this.license.equals(other.getLicense()))) &&
            ((this.licenseProperties==null && other.getLicenseProperties()==null) || 
             (this.licenseProperties!=null &&
              this.licenseProperties.equals(other.getLicenseProperties()))) &&
            this.baseProductID == other.getBaseProductID() &&
            ((this.baseProductName==null && other.getBaseProductName()==null) || 
             (this.baseProductName!=null &&
              this.baseProductName.equals(other.getBaseProductName()))) &&
            this.cloneProtection == other.isCloneProtection() &&
            this.cloneDetected == other.isCloneDetected();
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
        if (getFeatureID() != null) {
            _hashCode += getFeatureID().hashCode();
        }
        if (getFeatureName() != null) {
            _hashCode += getFeatureName().hashCode();
        }
        if (getLicense() != null) {
            _hashCode += getLicense().hashCode();
        }
        if (getLicenseProperties() != null) {
            _hashCode += getLicenseProperties().hashCode();
        }
        _hashCode += getBaseProductID();
        if (getBaseProductName() != null) {
            _hashCode += getBaseProductName().hashCode();
        }
        _hashCode += (isCloneProtection() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCloneDetected() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(KeyFeature.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyFeature"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("featureID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FeatureID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedInt"));
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
        elemField.setFieldName("license");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "License"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("licenseProperties");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LicenseProperties"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LicenseProperties"));
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
        elemField.setFieldName("cloneProtection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CloneProtection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cloneDetected");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CloneDetected"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
