/**
 * KeyOrders.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public class KeyOrders  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedLong haspID;

    private com.aladdin.www.webservices.hasp.WebHaspBss.KeyFormatType formatType;

    private java.lang.String formatDate;

    private com.aladdin.www.webservices.hasp.WebHaspBss.Order[] orders;

    public KeyOrders() {
    }

    public KeyOrders(
           org.apache.axis.types.UnsignedLong haspID,
           com.aladdin.www.webservices.hasp.WebHaspBss.KeyFormatType formatType,
           java.lang.String formatDate,
           com.aladdin.www.webservices.hasp.WebHaspBss.Order[] orders) {
           this.haspID = haspID;
           this.formatType = formatType;
           this.formatDate = formatDate;
           this.orders = orders;
    }


    /**
     * Gets the haspID value for this KeyOrders.
     * 
     * @return haspID
     */
    public org.apache.axis.types.UnsignedLong getHaspID() {
        return haspID;
    }


    /**
     * Sets the haspID value for this KeyOrders.
     * 
     * @param haspID
     */
    public void setHaspID(org.apache.axis.types.UnsignedLong haspID) {
        this.haspID = haspID;
    }


    /**
     * Gets the formatType value for this KeyOrders.
     * 
     * @return formatType
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.KeyFormatType getFormatType() {
        return formatType;
    }


    /**
     * Sets the formatType value for this KeyOrders.
     * 
     * @param formatType
     */
    public void setFormatType(com.aladdin.www.webservices.hasp.WebHaspBss.KeyFormatType formatType) {
        this.formatType = formatType;
    }


    /**
     * Gets the formatDate value for this KeyOrders.
     * 
     * @return formatDate
     */
    public java.lang.String getFormatDate() {
        return formatDate;
    }


    /**
     * Sets the formatDate value for this KeyOrders.
     * 
     * @param formatDate
     */
    public void setFormatDate(java.lang.String formatDate) {
        this.formatDate = formatDate;
    }


    /**
     * Gets the orders value for this KeyOrders.
     * 
     * @return orders
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.Order[] getOrders() {
        return orders;
    }


    /**
     * Sets the orders value for this KeyOrders.
     * 
     * @param orders
     */
    public void setOrders(com.aladdin.www.webservices.hasp.WebHaspBss.Order[] orders) {
        this.orders = orders;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KeyOrders)) return false;
        KeyOrders other = (KeyOrders) obj;
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
            ((this.formatType==null && other.getFormatType()==null) || 
             (this.formatType!=null &&
              this.formatType.equals(other.getFormatType()))) &&
            ((this.formatDate==null && other.getFormatDate()==null) || 
             (this.formatDate!=null &&
              this.formatDate.equals(other.getFormatDate()))) &&
            ((this.orders==null && other.getOrders()==null) || 
             (this.orders!=null &&
              java.util.Arrays.equals(this.orders, other.getOrders())));
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
        if (getFormatType() != null) {
            _hashCode += getFormatType().hashCode();
        }
        if (getFormatDate() != null) {
            _hashCode += getFormatDate().hashCode();
        }
        if (getOrders() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrders());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrders(), i);
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
        new org.apache.axis.description.TypeDesc(KeyOrders.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyOrders"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("haspID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "HaspID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedLong"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formatType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FormatType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "KeyFormatType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formatDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FormatDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orders");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Orders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Order"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Order"));
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
