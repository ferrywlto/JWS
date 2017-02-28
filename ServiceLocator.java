/**
 * COMP5527JWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class COMP5527JWSServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.COMP5527JWSService {

    public COMP5527JWSServiceLocator() {
    }


    public COMP5527JWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public COMP5527JWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for COMP5527JWS
    private java.lang.String COMP5527JWS_address = "http://localhost:8080/COMP5527/services/COMP5527JWS";

    public java.lang.String getCOMP5527JWSAddress() {
        return COMP5527JWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String COMP5527JWSWSDDServiceName = "COMP5527JWS";

    public java.lang.String getCOMP5527JWSWSDDServiceName() {
        return COMP5527JWSWSDDServiceName;
    }

    public void setCOMP5527JWSWSDDServiceName(java.lang.String name) {
        COMP5527JWSWSDDServiceName = name;
    }

    public DefaultNamespace.COMP5527JWS getCOMP5527JWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(COMP5527JWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCOMP5527JWS(endpoint);
    }

    public DefaultNamespace.COMP5527JWS getCOMP5527JWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.COMP5527JWSSoapBindingStub _stub = new DefaultNamespace.COMP5527JWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getCOMP5527JWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCOMP5527JWSEndpointAddress(java.lang.String address) {
        COMP5527JWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.COMP5527JWS.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.COMP5527JWSSoapBindingStub _stub = new DefaultNamespace.COMP5527JWSSoapBindingStub(new java.net.URL(COMP5527JWS_address), this);
                _stub.setPortName(getCOMP5527JWSWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("COMP5527JWS".equals(inputPortName)) {
            return getCOMP5527JWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "COMP5527JWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "COMP5527JWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("COMP5527JWS".equals(portName)) {
            setCOMP5527JWSEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
