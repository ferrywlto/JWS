/**
 * COMP5527JWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface COMP5527JWS extends java.rmi.Remote {
    public java.lang.String getMessage(java.lang.String uid, java.lang.String pw, java.lang.String loc) throws java.rmi.RemoteException;
    public boolean postMessage(java.lang.String uid, java.lang.String pw, java.lang.String loc, java.lang.String msg) throws java.rmi.RemoteException;
}
