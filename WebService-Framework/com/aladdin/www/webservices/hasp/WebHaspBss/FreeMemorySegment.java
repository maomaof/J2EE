/**
 * FreeMemorySegment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public class FreeMemorySegment  implements java.io.Serializable {
    private int ID;

    private com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemoryType type;

    private int offset;

    private int size;

    private java.lang.String name;

    private java.lang.String description;

    private com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySubSegment[] subSegments;

    public FreeMemorySegment() {
    }

    public FreeMemorySegment(
           int ID,
           com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemoryType type,
           int offset,
           int size,
           java.lang.String name,
           java.lang.String description,
           com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySubSegment[] subSegments) {
           this.ID = ID;
           this.type = type;
           this.offset = offset;
           this.size = size;
           this.name = name;
           this.description = description;
           this.subSegments = subSegments;
    }


    /**
     * Gets the ID value for this FreeMemorySegment.
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }


    /**
     * Sets the ID value for this FreeMemorySegment.
     * 
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }


    /**
     * Gets the type value for this FreeMemorySegment.
     * 
     * @return type
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemoryType getType() {
        return type;
    }


    /**
     * Sets the type value for this FreeMemorySegment.
     * 
     * @param type
     */
    public void setType(com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemoryType type) {
        this.type = type;
    }


    /**
     * Gets the offset value for this FreeMemorySegment.
     * 
     * @return offset
     */
    public int getOffset() {
        return offset;
    }


    /**
     * Sets the offset value for this FreeMemorySegment.
     * 
     * @param offset
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }


    /**
     * Gets the size value for this FreeMemorySegment.
     * 
     * @return size
     */
    public int getSize() {
        return size;
    }


    /**
     * Sets the size value for this FreeMemorySegment.
     * 
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }


    /**
     * Gets the name value for this FreeMemorySegment.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this FreeMemorySegment.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the description value for this FreeMemorySegment.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this FreeMemorySegment.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the subSegments value for this FreeMemorySegment.
     * 
     * @return subSegments
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySubSegment[] getSubSegments() {
        return subSegments;
    }


    /**
     * Sets the subSegments value for this FreeMemorySegment.
     * 
     * @param subSegments
     */
    public void setSubSegments(com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySubSegment[] subSegments) {
        this.subSegments = subSegments;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FreeMemorySegment)) return false;
        FreeMemorySegment other = (FreeMemorySegment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ID == other.getID() &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            this.offset == other.getOffset() &&
            this.size == other.getSize() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.subSegments==null && other.getSubSegments()==null) || 
             (this.subSegments!=null &&
              java.util.Arrays.equals(this.subSegments, other.getSubSegments())));
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
        _hashCode += getID();
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        _hashCode += getOffset();
        _hashCode += getSize();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getSubSegments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSubSegments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSubSegments(), i);
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
        new org.apache.axis.description.TypeDesc(FreeMemorySegment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemorySegment"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemoryType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Offset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("size");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Size"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subSegments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "SubSegments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemorySubSegment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "FreeMemorySubSegment"));
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
