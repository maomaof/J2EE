/**
 * LicenseProperties.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public class LicenseProperties  implements java.io.Serializable {
    private com.aladdin.www.webservices.hasp.WebHaspBss.LicenseType type;

    private java.lang.String value;

    private boolean isConcurrencyEnabled;

    private java.lang.String concurrencyCount;

    private com.aladdin.www.webservices.hasp.WebHaspBss.ConcurrencyInstanceType concurrencyType;

    private boolean isDetachingAllowed;

    private boolean isAccessibilityRemoteDesktop;

    private boolean isAccessibilityNetwork;

    private boolean isAccessibilityVirtualMachine;

    public LicenseProperties() {
    }

    public LicenseProperties(
           com.aladdin.www.webservices.hasp.WebHaspBss.LicenseType type,
           java.lang.String value,
           boolean isConcurrencyEnabled,
           java.lang.String concurrencyCount,
           com.aladdin.www.webservices.hasp.WebHaspBss.ConcurrencyInstanceType concurrencyType,
           boolean isDetachingAllowed,
           boolean isAccessibilityRemoteDesktop,
           boolean isAccessibilityNetwork,
           boolean isAccessibilityVirtualMachine) {
           this.type = type;
           this.value = value;
           this.isConcurrencyEnabled = isConcurrencyEnabled;
           this.concurrencyCount = concurrencyCount;
           this.concurrencyType = concurrencyType;
           this.isDetachingAllowed = isDetachingAllowed;
           this.isAccessibilityRemoteDesktop = isAccessibilityRemoteDesktop;
           this.isAccessibilityNetwork = isAccessibilityNetwork;
           this.isAccessibilityVirtualMachine = isAccessibilityVirtualMachine;
    }


    /**
     * Gets the type value for this LicenseProperties.
     * 
     * @return type
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.LicenseType getType() {
        return type;
    }


    /**
     * Sets the type value for this LicenseProperties.
     * 
     * @param type
     */
    public void setType(com.aladdin.www.webservices.hasp.WebHaspBss.LicenseType type) {
        this.type = type;
    }


    /**
     * Gets the value value for this LicenseProperties.
     * 
     * @return value
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this LicenseProperties.
     * 
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }


    /**
     * Gets the isConcurrencyEnabled value for this LicenseProperties.
     * 
     * @return isConcurrencyEnabled
     */
    public boolean isIsConcurrencyEnabled() {
        return isConcurrencyEnabled;
    }


    /**
     * Sets the isConcurrencyEnabled value for this LicenseProperties.
     * 
     * @param isConcurrencyEnabled
     */
    public void setIsConcurrencyEnabled(boolean isConcurrencyEnabled) {
        this.isConcurrencyEnabled = isConcurrencyEnabled;
    }


    /**
     * Gets the concurrencyCount value for this LicenseProperties.
     * 
     * @return concurrencyCount
     */
    public java.lang.String getConcurrencyCount() {
        return concurrencyCount;
    }


    /**
     * Sets the concurrencyCount value for this LicenseProperties.
     * 
     * @param concurrencyCount
     */
    public void setConcurrencyCount(java.lang.String concurrencyCount) {
        this.concurrencyCount = concurrencyCount;
    }


    /**
     * Gets the concurrencyType value for this LicenseProperties.
     * 
     * @return concurrencyType
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.ConcurrencyInstanceType getConcurrencyType() {
        return concurrencyType;
    }


    /**
     * Sets the concurrencyType value for this LicenseProperties.
     * 
     * @param concurrencyType
     */
    public void setConcurrencyType(com.aladdin.www.webservices.hasp.WebHaspBss.ConcurrencyInstanceType concurrencyType) {
        this.concurrencyType = concurrencyType;
    }


    /**
     * Gets the isDetachingAllowed value for this LicenseProperties.
     * 
     * @return isDetachingAllowed
     */
    public boolean isIsDetachingAllowed() {
        return isDetachingAllowed;
    }


    /**
     * Sets the isDetachingAllowed value for this LicenseProperties.
     * 
     * @param isDetachingAllowed
     */
    public void setIsDetachingAllowed(boolean isDetachingAllowed) {
        this.isDetachingAllowed = isDetachingAllowed;
    }


    /**
     * Gets the isAccessibilityRemoteDesktop value for this LicenseProperties.
     * 
     * @return isAccessibilityRemoteDesktop
     */
    public boolean isIsAccessibilityRemoteDesktop() {
        return isAccessibilityRemoteDesktop;
    }


    /**
     * Sets the isAccessibilityRemoteDesktop value for this LicenseProperties.
     * 
     * @param isAccessibilityRemoteDesktop
     */
    public void setIsAccessibilityRemoteDesktop(boolean isAccessibilityRemoteDesktop) {
        this.isAccessibilityRemoteDesktop = isAccessibilityRemoteDesktop;
    }


    /**
     * Gets the isAccessibilityNetwork value for this LicenseProperties.
     * 
     * @return isAccessibilityNetwork
     */
    public boolean isIsAccessibilityNetwork() {
        return isAccessibilityNetwork;
    }


    /**
     * Sets the isAccessibilityNetwork value for this LicenseProperties.
     * 
     * @param isAccessibilityNetwork
     */
    public void setIsAccessibilityNetwork(boolean isAccessibilityNetwork) {
        this.isAccessibilityNetwork = isAccessibilityNetwork;
    }


    /**
     * Gets the isAccessibilityVirtualMachine value for this LicenseProperties.
     * 
     * @return isAccessibilityVirtualMachine
     */
    public boolean isIsAccessibilityVirtualMachine() {
        return isAccessibilityVirtualMachine;
    }


    /**
     * Sets the isAccessibilityVirtualMachine value for this LicenseProperties.
     * 
     * @param isAccessibilityVirtualMachine
     */
    public void setIsAccessibilityVirtualMachine(boolean isAccessibilityVirtualMachine) {
        this.isAccessibilityVirtualMachine = isAccessibilityVirtualMachine;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LicenseProperties)) return false;
        LicenseProperties other = (LicenseProperties) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue()))) &&
            this.isConcurrencyEnabled == other.isIsConcurrencyEnabled() &&
            ((this.concurrencyCount==null && other.getConcurrencyCount()==null) || 
             (this.concurrencyCount!=null &&
              this.concurrencyCount.equals(other.getConcurrencyCount()))) &&
            ((this.concurrencyType==null && other.getConcurrencyType()==null) || 
             (this.concurrencyType!=null &&
              this.concurrencyType.equals(other.getConcurrencyType()))) &&
            this.isDetachingAllowed == other.isIsDetachingAllowed() &&
            this.isAccessibilityRemoteDesktop == other.isIsAccessibilityRemoteDesktop() &&
            this.isAccessibilityNetwork == other.isIsAccessibilityNetwork() &&
            this.isAccessibilityVirtualMachine == other.isIsAccessibilityVirtualMachine();
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
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        _hashCode += (isIsConcurrencyEnabled() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getConcurrencyCount() != null) {
            _hashCode += getConcurrencyCount().hashCode();
        }
        if (getConcurrencyType() != null) {
            _hashCode += getConcurrencyType().hashCode();
        }
        _hashCode += (isIsDetachingAllowed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAccessibilityRemoteDesktop() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAccessibilityNetwork() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsAccessibilityVirtualMachine() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LicenseProperties.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LicenseProperties"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LicenseType"));
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
        elemField.setFieldName("isConcurrencyEnabled");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "IsConcurrencyEnabled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("concurrencyCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ConcurrencyCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("concurrencyType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ConcurrencyType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ConcurrencyInstanceType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isDetachingAllowed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "IsDetachingAllowed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAccessibilityRemoteDesktop");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "IsAccessibilityRemoteDesktop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAccessibilityNetwork");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "IsAccessibilityNetwork"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAccessibilityVirtualMachine");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "IsAccessibilityVirtualMachine"));
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
