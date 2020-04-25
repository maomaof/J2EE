/**
 * ProductData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public class ProductData  implements java.io.Serializable {
    private com.aladdin.www.webservices.hasp.WebHaspBss.Product productProperties;

    private com.aladdin.www.webservices.hasp.WebHaspBss.Feature[] features;

    private com.aladdin.www.webservices.hasp.WebHaspBss.MemorySegment[] secureMemoryRW;

    private com.aladdin.www.webservices.hasp.WebHaspBss.MemorySegment[] secureMemoryRO;

    public ProductData() {
    }

    public ProductData(
           com.aladdin.www.webservices.hasp.WebHaspBss.Product productProperties,
           com.aladdin.www.webservices.hasp.WebHaspBss.Feature[] features,
           com.aladdin.www.webservices.hasp.WebHaspBss.MemorySegment[] secureMemoryRW,
           com.aladdin.www.webservices.hasp.WebHaspBss.MemorySegment[] secureMemoryRO) {
           this.productProperties = productProperties;
           this.features = features;
           this.secureMemoryRW = secureMemoryRW;
           this.secureMemoryRO = secureMemoryRO;
    }


    /**
     * Gets the productProperties value for this ProductData.
     * 
     * @return productProperties
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.Product getProductProperties() {
        return productProperties;
    }


    /**
     * Sets the productProperties value for this ProductData.
     * 
     * @param productProperties
     */
    public void setProductProperties(com.aladdin.www.webservices.hasp.WebHaspBss.Product productProperties) {
        this.productProperties = productProperties;
    }


    /**
     * Gets the features value for this ProductData.
     * 
     * @return features
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.Feature[] getFeatures() {
        return features;
    }


    /**
     * Sets the features value for this ProductData.
     * 
     * @param features
     */
    public void setFeatures(com.aladdin.www.webservices.hasp.WebHaspBss.Feature[] features) {
        this.features = features;
    }


    /**
     * Gets the secureMemoryRW value for this ProductData.
     * 
     * @return secureMemoryRW
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.MemorySegment[] getSecureMemoryRW() {
        return secureMemoryRW;
    }


    /**
     * Sets the secureMemoryRW value for this ProductData.
     * 
     * @param secureMemoryRW
     */
    public void setSecureMemoryRW(com.aladdin.www.webservices.hasp.WebHaspBss.MemorySegment[] secureMemoryRW) {
        this.secureMemoryRW = secureMemoryRW;
    }


    /**
     * Gets the secureMemoryRO value for this ProductData.
     * 
     * @return secureMemoryRO
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.MemorySegment[] getSecureMemoryRO() {
        return secureMemoryRO;
    }


    /**
     * Sets the secureMemoryRO value for this ProductData.
     * 
     * @param secureMemoryRO
     */
    public void setSecureMemoryRO(com.aladdin.www.webservices.hasp.WebHaspBss.MemorySegment[] secureMemoryRO) {
        this.secureMemoryRO = secureMemoryRO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductData)) return false;
        ProductData other = (ProductData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.productProperties==null && other.getProductProperties()==null) || 
             (this.productProperties!=null &&
              this.productProperties.equals(other.getProductProperties()))) &&
            ((this.features==null && other.getFeatures()==null) || 
             (this.features!=null &&
              java.util.Arrays.equals(this.features, other.getFeatures()))) &&
            ((this.secureMemoryRW==null && other.getSecureMemoryRW()==null) || 
             (this.secureMemoryRW!=null &&
              java.util.Arrays.equals(this.secureMemoryRW, other.getSecureMemoryRW()))) &&
            ((this.secureMemoryRO==null && other.getSecureMemoryRO()==null) || 
             (this.secureMemoryRO!=null &&
              java.util.Arrays.equals(this.secureMemoryRO, other.getSecureMemoryRO())));
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
        if (getProductProperties() != null) {
            _hashCode += getProductProperties().hashCode();
        }
        if (getFeatures() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFeatures());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFeatures(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSecureMemoryRW() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSecureMemoryRW());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSecureMemoryRW(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSecureMemoryRO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSecureMemoryRO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSecureMemoryRO(), i);
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
        new org.apache.axis.description.TypeDesc(ProductData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProductData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productProperties");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProductProperties"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Product"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("features");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Features"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Feature"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Feature"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secureMemoryRW");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SecureMemoryRW"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "MemorySegment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "MemorySegment"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secureMemoryRO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SecureMemoryRO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "MemorySegment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "MemorySegment"));
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
