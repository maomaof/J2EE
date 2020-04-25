/**
 * Order.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public class Order  implements java.io.Serializable {
    private int ID;

    private com.aladdin.www.webservices.hasp.WebHaspBss.OrderStatus status;

    private java.lang.String description;

    private java.lang.String reference;

    private com.aladdin.www.webservices.hasp.WebHaspBss.OrderType type;

    private int numberOfKeys;

    private int maxActivations;

    private boolean needConfirmation;

    private java.lang.String creationDate;

    private java.lang.String productionDate;

    private int customerID;

    public Order() {
    }

    public Order(
           int ID,
           com.aladdin.www.webservices.hasp.WebHaspBss.OrderStatus status,
           java.lang.String description,
           java.lang.String reference,
           com.aladdin.www.webservices.hasp.WebHaspBss.OrderType type,
           int numberOfKeys,
           int maxActivations,
           boolean needConfirmation,
           java.lang.String creationDate,
           java.lang.String productionDate,
           int customerID) {
           this.ID = ID;
           this.status = status;
           this.description = description;
           this.reference = reference;
           this.type = type;
           this.numberOfKeys = numberOfKeys;
           this.maxActivations = maxActivations;
           this.needConfirmation = needConfirmation;
           this.creationDate = creationDate;
           this.productionDate = productionDate;
           this.customerID = customerID;
    }


    /**
     * Gets the ID value for this Order.
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }


    /**
     * Sets the ID value for this Order.
     * 
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }


    /**
     * Gets the status value for this Order.
     * 
     * @return status
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.OrderStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Order.
     * 
     * @param status
     */
    public void setStatus(com.aladdin.www.webservices.hasp.WebHaspBss.OrderStatus status) {
        this.status = status;
    }


    /**
     * Gets the description value for this Order.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Order.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the reference value for this Order.
     * 
     * @return reference
     */
    public java.lang.String getReference() {
        return reference;
    }


    /**
     * Sets the reference value for this Order.
     * 
     * @param reference
     */
    public void setReference(java.lang.String reference) {
        this.reference = reference;
    }


    /**
     * Gets the type value for this Order.
     * 
     * @return type
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.OrderType getType() {
        return type;
    }


    /**
     * Sets the type value for this Order.
     * 
     * @param type
     */
    public void setType(com.aladdin.www.webservices.hasp.WebHaspBss.OrderType type) {
        this.type = type;
    }


    /**
     * Gets the numberOfKeys value for this Order.
     * 
     * @return numberOfKeys
     */
    public int getNumberOfKeys() {
        return numberOfKeys;
    }


    /**
     * Sets the numberOfKeys value for this Order.
     * 
     * @param numberOfKeys
     */
    public void setNumberOfKeys(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }


    /**
     * Gets the maxActivations value for this Order.
     * 
     * @return maxActivations
     */
    public int getMaxActivations() {
        return maxActivations;
    }


    /**
     * Sets the maxActivations value for this Order.
     * 
     * @param maxActivations
     */
    public void setMaxActivations(int maxActivations) {
        this.maxActivations = maxActivations;
    }


    /**
     * Gets the needConfirmation value for this Order.
     * 
     * @return needConfirmation
     */
    public boolean isNeedConfirmation() {
        return needConfirmation;
    }


    /**
     * Sets the needConfirmation value for this Order.
     * 
     * @param needConfirmation
     */
    public void setNeedConfirmation(boolean needConfirmation) {
        this.needConfirmation = needConfirmation;
    }


    /**
     * Gets the creationDate value for this Order.
     * 
     * @return creationDate
     */
    public java.lang.String getCreationDate() {
        return creationDate;
    }


    /**
     * Sets the creationDate value for this Order.
     * 
     * @param creationDate
     */
    public void setCreationDate(java.lang.String creationDate) {
        this.creationDate = creationDate;
    }


    /**
     * Gets the productionDate value for this Order.
     * 
     * @return productionDate
     */
    public java.lang.String getProductionDate() {
        return productionDate;
    }


    /**
     * Sets the productionDate value for this Order.
     * 
     * @param productionDate
     */
    public void setProductionDate(java.lang.String productionDate) {
        this.productionDate = productionDate;
    }


    /**
     * Gets the customerID value for this Order.
     * 
     * @return customerID
     */
    public int getCustomerID() {
        return customerID;
    }


    /**
     * Sets the customerID value for this Order.
     * 
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Order)) return false;
        Order other = (Order) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ID == other.getID() &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.reference==null && other.getReference()==null) || 
             (this.reference!=null &&
              this.reference.equals(other.getReference()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            this.numberOfKeys == other.getNumberOfKeys() &&
            this.maxActivations == other.getMaxActivations() &&
            this.needConfirmation == other.isNeedConfirmation() &&
            ((this.creationDate==null && other.getCreationDate()==null) || 
             (this.creationDate!=null &&
              this.creationDate.equals(other.getCreationDate()))) &&
            ((this.productionDate==null && other.getProductionDate()==null) || 
             (this.productionDate!=null &&
              this.productionDate.equals(other.getProductionDate()))) &&
            this.customerID == other.getCustomerID();
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
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getReference() != null) {
            _hashCode += getReference().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        _hashCode += getNumberOfKeys();
        _hashCode += getMaxActivations();
        _hashCode += (isNeedConfirmation() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCreationDate() != null) {
            _hashCode += getCreationDate().hashCode();
        }
        if (getProductionDate() != null) {
            _hashCode += getProductionDate().hashCode();
        }
        _hashCode += getCustomerID();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Order.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Order"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "OrderStatus"));
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
        elemField.setFieldName("reference");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Reference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "Type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "OrderType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfKeys");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "NumberOfKeys"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxActivations");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "MaxActivations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("needConfirmation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "NeedConfirmation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CreationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "ProductionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aladdin.com/webservices/hasp/WebHaspBss", "CustomerID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
