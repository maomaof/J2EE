/**
 * KeyInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public class KeyInfo  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedLong haspID;

    private boolean cloneDetected;

    private boolean acknowledged;

    private java.lang.String secureMemoryRW;

    private java.lang.String secureMemoryRO;

    private com.aladdin.www.webservices.hasp.WebHaspBss.KeyFeature[] keyFeatures;

    private com.aladdin.www.webservices.hasp.WebHaspBss.PendingOrder[] pendingOrders;

    public KeyInfo() {
    }

    public KeyInfo(
           org.apache.axis.types.UnsignedLong haspID,
           boolean cloneDetected,
           boolean acknowledged,
           java.lang.String secureMemoryRW,
           java.lang.String secureMemoryRO,
           com.aladdin.www.webservices.hasp.WebHaspBss.KeyFeature[] keyFeatures,
           com.aladdin.www.webservices.hasp.WebHaspBss.PendingOrder[] pendingOrders) {
           this.haspID = haspID;
           this.cloneDetected = cloneDetected;
           this.acknowledged = acknowledged;
           this.secureMemoryRW = secureMemoryRW;
           this.secureMemoryRO = secureMemoryRO;
           this.keyFeatures = keyFeatures;
           this.pendingOrders = pendingOrders;
    }


    /**
     * Gets the haspID value for this KeyInfo.
     * 
     * @return haspID
     */
    public org.apache.axis.types.UnsignedLong getHaspID() {
        return haspID;
    }


    /**
     * Sets the haspID value for this KeyInfo.
     * 
     * @param haspID
     */
    public void setHaspID(org.apache.axis.types.UnsignedLong haspID) {
        this.haspID = haspID;
    }


    /**
     * Gets the cloneDetected value for this KeyInfo.
     * 
     * @return cloneDetected
     */
    public boolean isCloneDetected() {
        return cloneDetected;
    }


    /**
     * Sets the cloneDetected value for this KeyInfo.
     * 
     * @param cloneDetected
     */
    public void setCloneDetected(boolean cloneDetected) {
        this.cloneDetected = cloneDetected;
    }


    /**
     * Gets the acknowledged value for this KeyInfo.
     * 
     * @return acknowledged
     */
    public boolean isAcknowledged() {
        return acknowledged;
    }


    /**
     * Sets the acknowledged value for this KeyInfo.
     * 
     * @param acknowledged
     */
    public void setAcknowledged(boolean acknowledged) {
        this.acknowledged = acknowledged;
    }


    /**
     * Gets the secureMemoryRW value for this KeyInfo.
     * 
     * @return secureMemoryRW
     */
    public java.lang.String getSecureMemoryRW() {
        return secureMemoryRW;
    }


    /**
     * Sets the secureMemoryRW value for this KeyInfo.
     * 
     * @param secureMemoryRW
     */
    public void setSecureMemoryRW(java.lang.String secureMemoryRW) {
        this.secureMemoryRW = secureMemoryRW;
    }


    /**
     * Gets the secureMemoryRO value for this KeyInfo.
     * 
     * @return secureMemoryRO
     */
    public java.lang.String getSecureMemoryRO() {
        return secureMemoryRO;
    }


    /**
     * Sets the secureMemoryRO value for this KeyInfo.
     * 
     * @param secureMemoryRO
     */
    public void setSecureMemoryRO(java.lang.String secureMemoryRO) {
        this.secureMemoryRO = secureMemoryRO;
    }


    /**
     * Gets the keyFeatures value for this KeyInfo.
     * 
     * @return keyFeatures
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.KeyFeature[] getKeyFeatures() {
        return keyFeatures;
    }


    /**
     * Sets the keyFeatures value for this KeyInfo.
     * 
     * @param keyFeatures
     */
    public void setKeyFeatures(com.aladdin.www.webservices.hasp.WebHaspBss.KeyFeature[] keyFeatures) {
        this.keyFeatures = keyFeatures;
    }


    /**
     * Gets the pendingOrders value for this KeyInfo.
     * 
     * @return pendingOrders
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.PendingOrder[] getPendingOrders() {
        return pendingOrders;
    }


    /**
     * Sets the pendingOrders value for this KeyInfo.
     * 
     * @param pendingOrders
     */
    public void setPendingOrders(com.aladdin.www.webservices.hasp.WebHaspBss.PendingOrder[] pendingOrders) {
        this.pendingOrders = pendingOrders;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KeyInfo)) return false;
        KeyInfo other = (KeyInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.haspID==null && other.getHaspID()==null) || 
             (this.haspID!=null &&
              this.haspID.equals(other.getHaspID()))) &&
            this.cloneDetected == other.isCloneDetected() &&
            this.acknowledged == other.isAcknowledged() &&
            ((this.secureMemoryRW==null && other.getSecureMemoryRW()==null) || 
             (this.secureMemoryRW!=null &&
              this.secureMemoryRW.equals(other.getSecureMemoryRW()))) &&
            ((this.secureMemoryRO==null && other.getSecureMemoryRO()==null) || 
             (this.secureMemoryRO!=null &&
              this.secureMemoryRO.equals(other.getSecureMemoryRO()))) &&
            ((this.keyFeatures==null && other.getKeyFeatures()==null) || 
             (this.keyFeatures!=null &&
              java.util.Arrays.equals(this.keyFeatures, other.getKeyFeatures()))) &&
            ((this.pendingOrders==null && other.getPendingOrders()==null) || 
             (this.pendingOrders!=null &&
              java.util.Arrays.equals(this.pendingOrders, other.getPendingOrders())));
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
        if (getHaspID() != null) {
            _hashCode += getHaspID().hashCode();
        }
        _hashCode += (isCloneDetected() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAcknowledged() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSecureMemoryRW() != null) {
            _hashCode += getSecureMemoryRW().hashCode();
        }
        if (getSecureMemoryRO() != null) {
            _hashCode += getSecureMemoryRO().hashCode();
        }
        if (getKeyFeatures() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKeyFeatures());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKeyFeatures(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPendingOrders() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPendingOrders());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPendingOrders(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(KeyInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("haspID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedLong"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cloneDetected");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CloneDetected"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acknowledged");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Acknowledged"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secureMemoryRW");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SecureMemoryRW"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secureMemoryRO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SecureMemoryRO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keyFeatures");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyFeatures"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyFeature"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyFeature"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pendingOrders");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "PendingOrders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "PendingOrder"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "PendingOrder"));
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
