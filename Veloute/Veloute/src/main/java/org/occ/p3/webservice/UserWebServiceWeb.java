
package org.occ.p3.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "UserWebServiceWeb", targetNamespace = "http://webservice.p3.occ.org/", wsdlLocation = "http://lfr028236:8080/bibliot-webservice-new/ws/UserWebService?wsdl")
public class UserWebServiceWeb
    extends Service
{

    private final static URL USERWEBSERVICEWEB_WSDL_LOCATION;
    private final static WebServiceException USERWEBSERVICEWEB_EXCEPTION;
    private final static QName USERWEBSERVICEWEB_QNAME = new QName("http://webservice.p3.occ.org/", "UserWebServiceWeb");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://lfr028236:8080/bibliot-webservice-new/ws/UserWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        USERWEBSERVICEWEB_WSDL_LOCATION = url;
        USERWEBSERVICEWEB_EXCEPTION = e;
    }

    public UserWebServiceWeb() {
        super(__getWsdlLocation(), USERWEBSERVICEWEB_QNAME);
    }

    public UserWebServiceWeb(WebServiceFeature... features) {
        super(__getWsdlLocation(), USERWEBSERVICEWEB_QNAME, features);
    }

    public UserWebServiceWeb(URL wsdlLocation) {
        super(wsdlLocation, USERWEBSERVICEWEB_QNAME);
    }

    public UserWebServiceWeb(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, USERWEBSERVICEWEB_QNAME, features);
    }

    public UserWebServiceWeb(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserWebServiceWeb(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UserWebService
     */
    @WebEndpoint(name = "UserWebServicePort")
    public UserWebService getUserWebServicePort() {
        return super.getPort(new QName("http://webservice.p3.occ.org/", "UserWebServicePort"), UserWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserWebService
     */
    @WebEndpoint(name = "UserWebServicePort")
    public UserWebService getUserWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.p3.occ.org/", "UserWebServicePort"), UserWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (USERWEBSERVICEWEB_EXCEPTION!= null) {
            throw USERWEBSERVICEWEB_EXCEPTION;
        }
        return USERWEBSERVICEWEB_WSDL_LOCATION;
    }

}