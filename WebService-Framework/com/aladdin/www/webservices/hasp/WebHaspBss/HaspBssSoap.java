/**
 * HaspBssSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladdin.www.webservices.hasp.WebHaspBss;

public interface HaspBssSoap extends java.rmi.Remote {

    /**
     * Initializes and logs in to the Sentinel HASP Business Studio
     * Server API
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus initialize(java.lang.String inUserName, java.lang.String inPassword, java.lang.String inServer, java.lang.String inPort) throws java.rmi.RemoteException;

    /**
     * Retrieves version information about the Sentinel HASP Business
     * Studio Server, the Sentinel HASP Business Studio database, and the
     * Business Studio Server API
     */
    public void getVersion(com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getVersionResult, javax.xml.rpc.holders.IntHolder majorVersion, javax.xml.rpc.holders.IntHolder minorVersion, javax.xml.rpc.holders.IntHolder buildVersion, javax.xml.rpc.holders.IntHolder revisionVersion, javax.xml.rpc.holders.StringHolder serverVersion, javax.xml.rpc.holders.StringHolder serverDBVersion) throws java.rmi.RemoteException;

    /**
     * Retrieves an array of unprocessed orders
     */
    public void getNewOrders(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getNewOrdersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfOrderHolder outOrders) throws java.rmi.RemoteException;

    /**
     * Retrieves a list of all orders in the system
     */
    public void getAllOrders(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getAllOrdersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfOrderHolder outOrders) throws java.rmi.RemoteException;

    /**
     * Retrieves an array of orders that are ready to be burned to
     * a HASP HL key, or for Product Keys or a Vendor-to-Customer (V2C) file
     * to be generated
     */
    public void getProductionOrders(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductionOrdersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfOrderHolder outOrders) throws java.rmi.RemoteException;

    /**
     * Retrieve an array of Provisional orders
     */
    public void getProvisionalOrders(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProvisionalOrdersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfOrderHolder outOrders) throws java.rmi.RemoteException;

    /**
     * Retrieves an array of batches
     */
    public void getBatches(com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getBatchesResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfBatchHolder outBatches) throws java.rmi.RemoteException;

    /**
     * Retrieves an array of Products for a specific vendor
     */
    public void getProducts(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductsResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfProductHolder outProducts) throws java.rmi.RemoteException;

    /**
     * Retrieve an array of Provisional Products
     */
    public void getProvisionalProducts(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProvisionalProductsResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfProductHolder outProducts) throws java.rmi.RemoteException;

    /**
     * Retrieves an array of the Products embedded in an order
     */
    public void getOrderProducts(int inOrderID, int inBatchID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getOrderProductsResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfProductHolder outProducts) throws java.rmi.RemoteException;

    /**
     * Adds a list of Products to an order
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus addProductsToOrder(int inOrderID, int inBatchID, com.aladdin.www.webservices.hasp.WebHaspBss.Product[] inProducts) throws java.rmi.RemoteException;

    /**
     * Creates a new order to which Products can be added
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus insertOrder(int inBatchID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.OrderHolder inOrder) throws java.rmi.RemoteException;

    /**
     * Deletes an order from the Business Studio Server. An order
     * can only be deleted when the order status is On hold or Ready
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus deleteOrder(int inOrderID) throws java.rmi.RemoteException;

    /**
     * Finalizes the order specification process so that the order
     * is ready for burning to a HASP HL key, or for generating a Vendor-to-Customer
     * (V2C) file or Product Key
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus finalizeOrder(int inOrderID) throws java.rmi.RemoteException;

    /**
     * Reopen an order whose status is FINALIZED or PRODUCT_KEY_GENERATED
     * for editing (the status of the order is changed to NEW)
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus unfinalizeOrder(int inOrderID) throws java.rmi.RemoteException;

    /**
     * Produces an order based on a HASP key identifie
     */
    public void produceOrderByHaspID(int inOrderID, org.apache.axis.types.UnsignedLong inHaspID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder produceOrderByHaspIDResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException;

    /**
     * Generate a V2C file for the Provisional Products in the order
     */
    public void produceProvisionalOrder(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder produceProvisionalOrderResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException;

    /**
     * Produces an order, based on a HASP key identifier, that will
     * clean the HASP key and install a new order on it
     */
    public void cleanAndProduceOrderByHaspID(int inOrderID, org.apache.axis.types.UnsignedLong inHaspID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder cleanAndProduceOrderByHaspIDResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException;

    /**
     * Produces an order based on a Customer-to-Vendor (C2V) file
     */
    public void produceOrderByC2V(int inOrderID, java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder produceOrderByC2VResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException;

    /**
     * Produces an order based on a HASP key identifier supplied in
     * a C2V file
     */
    public void produceOrderByHaspIDFromC2V(int inOrderID, java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder produceOrderByHaspIDFromC2VResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException;

    /**
     * Produces an order based on a Customer-to-Vendor (C2V) file
     * and removes any pending orders
     */
    public void produceOrderByC2VAndRemovePendingOrders(int inOrderID, java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder produceOrderByC2VAndRemovePendingOrdersResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException;

    /**
     * Retrieves an array of pending orders related to a specified
     * Customer-to-Vendor (C2V)
     */
    public void getPendingOrders(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getPendingOrdersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfPendingOrderHolder outPendingOrders) throws java.rmi.RemoteException;

    /**
     * Generates a list of Product Keys
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus generateProductKeys(int inOrderID) throws java.rmi.RemoteException;

    /**
     * Retrieves the Product Keys generated by the GenerateProductKeys
     * function
     */
    public void getProductKeys(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductKeysResult, javax.xml.rpc.holders.StringHolder outProductKeys) throws java.rmi.RemoteException;

    /**
     * A free parameter is one whose value can be specified when an
     * order is finalized. Function retrieves the licensing parameters that
     * were specified as 'Specify at order time' (for example, the number
     * of executions), that are required so that an order can be finalized
     */
    public void getOrderFreeParameters(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getOrderFreeParametersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfFreeParameterHolder outFreeParameters) throws java.rmi.RemoteException;

    /**
     * Saves the array of free parameters that were generated using
     * the GetOrderFreeParameters function
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus setOrderFreeParameters(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[] inFreeParameters) throws java.rmi.RemoteException;

    /**
     * A free memory segment is one whose value can be specified when
     * a Product is being created. Function retrieves the free memory segments,
     * including their sub-segments, that were defined as 'Specify at order
     * time' during the Product creation process
     */
    public void getOrderFreeMemorySegments(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getOrderFreeMemorySegmentsResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfFreeMemorySegmentHolder outFreeMemorySegments) throws java.rmi.RemoteException;

    /**
     * Saves the array of free memory segments, together with the
     * free memory sub-segments and the data stored within them, that were
     * either retrieved using the GetOrderFreeMemorySegments function or
     * created dynamically
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus setOrderFreeMemorySegments(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[] inFreeMemorySegments) throws java.rmi.RemoteException;

    /**
     * Adds an array of HASP keys to an update Order
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus addKeysToOrder(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.Key[] inKeys) throws java.rmi.RemoteException;

    /**
     * Searches for a HASP protection key, based on the input Customer
     * to Vendor (C2V) file
     */
    public void locateC2VKey(java.lang.String inC2V, int vendorID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder locateC2VKeyResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyHolder outKey) throws java.rmi.RemoteException;

    /**
     * Removes a list of HASP keys from an update order
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus removeKeysFromOrder(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.Key[] inKeys) throws java.rmi.RemoteException;

    /**
     * Checks a Customer-to-Vendor (C2V) file into the Business Studio
     * server
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus checkInC2V(java.lang.String inC2V) throws java.rmi.RemoteException;

    /**
     * Checks a Customer-to-Vendor (C2V) file into the Business Studio
     * Server, and retrieves information about the HASP protection key to
     * which the C2V relates. The collected data includes the Features stored
     * on the key, pending orders for the key, and the memory that is stored
     * on the key
     */
    public void checkInC2VGetKeyInfo(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder checkInC2VGetKeyInfoResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyInfoHolder outKeyInfo) throws java.rmi.RemoteException;

    /**
     * Checks a Customer-to-Vendor (C2V) file into the Business Studio
     * Server, and synchronizes the Sentinel HASP Business Studio database
     * using key information extracted from the C2V file. The collected data
     * includes the Features stored on the key, pending orders for the key,
     * and the memory that is stored on the key
     */
    public void synchronizeDatabaseUsingKeyInfo(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder synchronizeDatabaseUsingKeyInfoResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyInfoHolder outKeyInfo) throws java.rmi.RemoteException;

    /**
     * Retrieves an array of Sentinel HASP protection keys activated
     * by entering a Product Key
     */
    public void getKeysByProductKey(java.lang.String inProductKey, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getKeysByProductKeyResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfKeyHolder outKeys) throws java.rmi.RemoteException;

    /**
     * Retrieves the fingerprint of the hardware devices from a Customer-to-Vendor
     * (C2V) file
     */
    public void getFingerprintByC2V(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getFingerprintByC2VResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfFingerprintDeviceHolder outFingerprint) throws java.rmi.RemoteException;

    /**
     * Retrieves the fingerprint of the hardware devices from the
     * Sentinel HASP database, according to HASP key ID
     */
    public void getFingerprintByKeyID(java.lang.String inKeyID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getFingerprintByKeyIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfFingerprintDeviceHolder outFingerprint) throws java.rmi.RemoteException;

    /**
     * Generates a Vendor-to-Customer (V2C) file which, when applied
     * to the end-user machine on which cloning was detected, clears the
     * license terms of Products that were locked to the HASP SL key and
     * reinstalls the Provisional Product that was previously on the key
     */
    public void clearClonedHaspSLKey(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder clearClonedHaspSLKeyResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException;

    /**
     * Retrieves the key history related to the key ID. The key history
     * contains all the key information (memory and Features) that exists
     * on the key, up to and including the production of an order
     */
    public void getKeyHistoryByKeyID(org.apache.axis.types.UnsignedLong inKeyID, int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getKeyHistoryByKeyIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyInfoHolder outKeyInfo) throws java.rmi.RemoteException;

    /**
     * Retrieves the key history from a Customer-to-Vendor (C2V) file.
     * The key history contains all the key information (memory and Features)
     * that exists on the key, up to and including the production of an order
     */
    public void getKeyHistoryByC2V(java.lang.String inC2V, int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getKeyHistoryByC2VResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyInfoHolder outKeyInfo) throws java.rmi.RemoteException;

    /**
     * Retrieves an array of Sentinel HASP protection key orders according
     * to the HASP key ID
     */
    public void getKeyOrdersByKeyID(org.apache.axis.types.UnsignedLong inKeyID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getKeyOrdersByKeyIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyOrdersHolder outKeyOrders) throws java.rmi.RemoteException;

    /**
     * Retrieves an array of Sentinel HASP protection key orders from
     * a Customer-to-Vendor (C2V) file
     */
    public void getKeyOrdersByC2V(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getKeyOrdersByC2VResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.KeyOrdersHolder outKeyOrders) throws java.rmi.RemoteException;

    /**
     * Retrieves an array of Sentinel HASP protection keys that all
     * contain the same order, according to the order ID
     */
    public void getKeysByOrderID(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getKeysByOrderIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfKeyHolder outKeys) throws java.rmi.RemoteException;

    /**
     * Retrieves an array of available Sentinel HASP protection key
     * types according to the specified order. For example, Max, NetTime,
     * Time, and so on
     */
    public void getAvailableKeyTypesByOrderID(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getAvailableKeyTypesByOrderIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfStringHolder outKeyTypes) throws java.rmi.RemoteException;

    /**
     * Retrieves Product properties according to the Product ID
     */
    public void getProductByID(int inProductID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductByIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ProductHolder outProduct) throws java.rmi.RemoteException;

    /**
     * Retrieves Product data according to a Product Name, Batch ID,
     * and Base Product ID
     */
    public void getProductByName(java.lang.String inProductName, int inBatchID, int inBaseProductID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductByNameResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ProductHolder outProduct) throws java.rmi.RemoteException;

    /**
     * Generates a Vendor-to-Customer (V2C) file that, when applied
     * to a Sentinel HASP protection key, deletes all license data and memory
     * on the key
     */
    public void generateFormatUpdateFile(java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder generateFormatUpdateFileResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException;

    /**
     * Retrieves array of customer information from the Sentinel HASP
     * database
     */
    public void getCustomers(int inBatchID, java.lang.String inReference, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getCustomersResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfCustomerHolder outCustomers) throws java.rmi.RemoteException;

    /**
     * Retrieves customer contact information, related to a specific
     * customer ID
     */
    public void getCustomerByID(int inCustomerID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getCustomerByIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.CustomerHolder outCustomer) throws java.rmi.RemoteException;

    /**
     * Inserts customer details in the Sentinel HASP database
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus insertCustomer(int inBatchID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.CustomerHolder inCustomer) throws java.rmi.RemoteException;

    /**
     * Updates customer information
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus updateCustomer(com.aladdin.www.webservices.hasp.WebHaspBss.holders.CustomerHolder inCustomer) throws java.rmi.RemoteException;

    /**
     * Inactivates a customer in the database
     */
    public void obsoleteCustomer(int inCustomerID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder obsoleteCustomerResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.CustomerHolder outCustomer) throws java.rmi.RemoteException;

    /**
     * Restores a customer who was previously specified as obsolete
     * to the Sentinel HASP database
     */
    public void restoreCustomer(int inCustomerID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder restoreCustomerResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.CustomerHolder outCustomer) throws java.rmi.RemoteException;

    /**
     * Adds customer details to an existing order
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus addCustomerToOrder(int inOrderID, int inCustomerID) throws java.rmi.RemoteException;

    /**
     * Retrieves customer contact information, related to a specific
     * order
     */
    public void getCustomerByOrderID(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getCustomerByOrderIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.CustomerHolder outCustomer) throws java.rmi.RemoteException;

    /**
     * Converts the Vendor-to-Customer (V2C) file to an executable
     * file, and sends it to the customer
     */
    public void getExecutableFromV2C(java.lang.String inV2C, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getExecutableFromV2CResult, javax.xml.rpc.holders.ByteArrayHolder outExe) throws java.rmi.RemoteException;

    /**
     * Retrieves Product data according to Product ID
     */
    public void getProductDataByID(int inProductID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductDataByIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ProductDataHolder outProductData) throws java.rmi.RemoteException;

    /**
     * Retrieves the list of Features that can be excluded, related
     * to a specific order ID
     */
    public void getOrderExcludableFeatures(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getOrderExcludableFeaturesResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfExcludeFeatureHolder outExcludeFeatures) throws java.rmi.RemoteException;

    /**
     * Excludes a Feature from a Sentinel HASP protection key at order
     * time
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus excludeFeaturesFromOrder(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[] inExcludeFeatures) throws java.rmi.RemoteException;

    /**
     * Retrieve information about a Product key
     */
    public void getProductKeyProperties(java.lang.String inProductKey, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getProductKeyPropertiesResult, javax.xml.rpc.holders.BooleanHolder outEnabled, javax.xml.rpc.holders.IntHolder outMaxActivations, javax.xml.rpc.holders.IntHolder outActivationsLeft, javax.xml.rpc.holders.IntHolder outOrderID, javax.xml.rpc.holders.IntHolder outCustomerID) throws java.rmi.RemoteException;

    /**
     * Increase the total number of activations for the Product key
     * by 1
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus increaseProductKeyActivations(java.lang.String inProductKey) throws java.rmi.RemoteException;

    /**
     * Enable a Product key so that the Product can be activated
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus enableProductKey(java.lang.String inProductKey, int inOrderID) throws java.rmi.RemoteException;

    /**
     * Disable a Product key so that the Product cannot be activated
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus disableProductKey(java.lang.String inProductKey, int inOrderID) throws java.rmi.RemoteException;

    /**
     * Generate a V2C file to send to a customer to manually activate
     * a Product
     */
    public void activate(java.lang.String inProductKey, java.lang.String inC2V, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder activateResult, javax.xml.rpc.holders.StringHolder outV2C) throws java.rmi.RemoteException;

    /**
     * Retrieves an array of all orders issued for a specific customer
     */
    public void getOrdersByCustomerID(int inCustomerID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getOrdersByCustomerIDResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfOrderHolder outOrders) throws java.rmi.RemoteException;

    /**
     * Retrieves free data for a specific order ID. Free data is information
     * for an order that can (or must) be specified when the order is finalized
     */
    public void getOrderFreeData(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.holders.HaspBssStatusHolder getOrderFreeDataResult, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfFreeParameterHolder outFreeParameters, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfFreeMemorySegmentHolder outFreeMemorySegments, com.aladdin.www.webservices.hasp.WebHaspBss.holders.ArrayOfExcludeFeatureHolder outExcludeFeatures) throws java.rmi.RemoteException;

    /**
     * Sets the values for free data for a specific order ID when
     * the order is finalized. Free data is information for the order that
     * can (or must) be specified at the time the order is finalized
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus setOrderFreeData(int inOrderID, com.aladdin.www.webservices.hasp.WebHaspBss.FreeParameter[] inFreeParameters, com.aladdin.www.webservices.hasp.WebHaspBss.FreeMemorySegment[] inFreeMemorySegments, com.aladdin.www.webservices.hasp.WebHaspBss.ExcludeFeature[] inExcludeFeatures) throws java.rmi.RemoteException;

    /**
     * Removes pending orders related to a specified Customer-to-Vendor
     * (C2V) file
     */
    public com.aladdin.www.webservices.hasp.WebHaspBss.HaspBssStatus removePendingOrders(java.lang.String inC2V) throws java.rmi.RemoteException;
}
