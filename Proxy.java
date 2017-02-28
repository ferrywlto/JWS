package DefaultNamespace;

public class COMP5527JWSProxy implements DefaultNamespace.COMP5527JWS {
  private String _endpoint = null;
  private DefaultNamespace.COMP5527JWS cOMP5527JWS = null;
  
  public COMP5527JWSProxy() {
    _initCOMP5527JWSProxy();
  }
  
  public COMP5527JWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initCOMP5527JWSProxy();
  }
  
  private void _initCOMP5527JWSProxy() {
    try {
      cOMP5527JWS = (new DefaultNamespace.COMP5527JWSServiceLocator()).getCOMP5527JWS();
      if (cOMP5527JWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cOMP5527JWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cOMP5527JWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cOMP5527JWS != null)
      ((javax.xml.rpc.Stub)cOMP5527JWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.COMP5527JWS getCOMP5527JWS() {
    if (cOMP5527JWS == null)
      _initCOMP5527JWSProxy();
    return cOMP5527JWS;
  }
  
  public java.lang.String getMessage(java.lang.String uid, java.lang.String pw, java.lang.String loc) throws java.rmi.RemoteException{
    if (cOMP5527JWS == null)
      _initCOMP5527JWSProxy();
    return cOMP5527JWS.getMessage(uid, pw, loc);
  }
  
  public boolean postMessage(java.lang.String uid, java.lang.String pw, java.lang.String loc, java.lang.String msg) throws java.rmi.RemoteException{
    if (cOMP5527JWS == null)
      _initCOMP5527JWSProxy();
    return cOMP5527JWS.postMessage(uid, pw, loc, msg);
  }
  
  
}