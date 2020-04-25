/**
 * LicenseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public class LicenseType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected LicenseType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _NONE = "NONE";
    public static final java.lang.String _PERPETUAL = "PERPETUAL";
    public static final java.lang.String _EXECUTIONS = "EXECUTIONS";
    public static final java.lang.String _DAYS = "DAYS";
    public static final java.lang.String _DATE = "DATE";
    public static final java.lang.String _FULL_FREE_PARAMS = "FULL_FREE_PARAMS";
    public static final LicenseType NONE = new LicenseType(_NONE);
    public static final LicenseType PERPETUAL = new LicenseType(_PERPETUAL);
    public static final LicenseType EXECUTIONS = new LicenseType(_EXECUTIONS);
    public static final LicenseType DAYS = new LicenseType(_DAYS);
    public static final LicenseType DATE = new LicenseType(_DATE);
    public static final LicenseType FULL_FREE_PARAMS = new LicenseType(_FULL_FREE_PARAMS);
    public java.lang.String getValue() { return _value_;}
    public static LicenseType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        LicenseType enumeration = (LicenseType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static LicenseType fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(LicenseType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "LicenseType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
