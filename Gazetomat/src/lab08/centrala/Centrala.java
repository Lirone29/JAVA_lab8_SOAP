
package lab08.centrala;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Centrala", targetNamespace = "http://centrala.lab08/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Centrala {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "unregisterAutomat", targetNamespace = "http://centrala.lab08/", className = "lab08.centrala.UnregisterAutomat")
    @ResponseWrapper(localName = "unregisterAutomatResponse", targetNamespace = "http://centrala.lab08/", className = "lab08.centrala.UnregisterAutomatResponse")
    @Action(input = "http://centrala.lab08/Centrala/unregisterAutomatRequest", output = "http://centrala.lab08/Centrala/unregisterAutomatResponse")
    public void unregisterAutomat(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "updateRequest", targetNamespace = "http://centrala.lab08/", className = "lab08.centrala.UpdateRequest")
    @ResponseWrapper(localName = "updateRequestResponse", targetNamespace = "http://centrala.lab08/", className = "lab08.centrala.UpdateRequestResponse")
    @Action(input = "http://centrala.lab08/Centrala/updateRequestRequest", output = "http://centrala.lab08/Centrala/updateRequestResponse")
    public void updateRequest(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getFreePort", targetNamespace = "http://centrala.lab08/", className = "lab08.centrala.GetFreePort")
    @ResponseWrapper(localName = "getFreePortResponse", targetNamespace = "http://centrala.lab08/", className = "lab08.centrala.GetFreePortResponse")
    @Action(input = "http://centrala.lab08/Centrala/getFreePortRequest", output = "http://centrala.lab08/Centrala/getFreePortResponse")
    public int getFreePort();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "registerAutomat", targetNamespace = "http://centrala.lab08/", className = "lab08.centrala.RegisterAutomat")
    @ResponseWrapper(localName = "registerAutomatResponse", targetNamespace = "http://centrala.lab08/", className = "lab08.centrala.RegisterAutomatResponse")
    @Action(input = "http://centrala.lab08/Centrala/registerAutomatRequest", output = "http://centrala.lab08/Centrala/registerAutomatResponse")
    public void registerAutomat(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}