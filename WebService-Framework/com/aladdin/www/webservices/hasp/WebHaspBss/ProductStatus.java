/**
 * ProductStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public class ProductStatus implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ProductStatus(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _NONE = "NONE";
    public static final java.lang.String _READY = "READY";
    public static final java.lang.String _USED = "USED";
    public static final java.lang.String _OBSOLETE = "OBSOLETE";
    public static final ProductStatus NONE = new ProductStatus(_NONE);
    public static final ProductStatus READY = new ProductStatus(_READY);
    public static final ProductStatus USED = new ProductStatus(_USED);
    public static final ProductStatus OBSOLETE = new ProductStatus(_OBSOLETE);
    public java.lang.String getValue() { return _value_;}
    public static ProductStatus fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ProductStatus enumeration = (ProductStatus)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ProductStatus fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProductStatus.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProductStatus"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
