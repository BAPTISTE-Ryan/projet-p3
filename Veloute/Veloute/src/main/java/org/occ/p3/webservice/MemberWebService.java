
package org.occ.p3.webservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MemberWebService", targetNamespace = "http://webservice.p3.occ.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MemberWebService {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "init", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.Init")
    @ResponseWrapper(localName = "initResponse", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.InitResponse")
    @Action(input = "http://webservice.p3.occ.org/MemberWebService/initRequest", output = "http://webservice.p3.occ.org/MemberWebService/initResponse")
    public void init();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<org.occ.p3.webservice.Member>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMemberByName", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.GetMemberByName")
    @ResponseWrapper(localName = "getMemberByNameResponse", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.GetMemberByNameResponse")
    @Action(input = "http://webservice.p3.occ.org/MemberWebService/getMemberByNameRequest", output = "http://webservice.p3.occ.org/MemberWebService/getMemberByNameResponse")
    public List<Member> getMemberByName(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns org.occ.p3.webservice.Member
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMemberById", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.GetMemberById")
    @ResponseWrapper(localName = "getMemberByIdResponse", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.GetMemberByIdResponse")
    @Action(input = "http://webservice.p3.occ.org/MemberWebService/getMemberByIdRequest", output = "http://webservice.p3.occ.org/MemberWebService/getMemberByIdResponse")
    public Member getMemberById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns org.occ.p3.webservice.Member
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "saveNewMember", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.SaveNewMember")
    @ResponseWrapper(localName = "saveNewMemberResponse", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.SaveNewMemberResponse")
    @Action(input = "http://webservice.p3.occ.org/MemberWebService/saveNewMemberRequest", output = "http://webservice.p3.occ.org/MemberWebService/saveNewMemberResponse")
    public Member saveNewMember(
        @WebParam(name = "arg0", targetNamespace = "")
        Member arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<org.occ.p3.webservice.Member>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMemberByBirthdate", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.GetMemberByBirthdate")
    @ResponseWrapper(localName = "getMemberByBirthdateResponse", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.GetMemberByBirthdateResponse")
    @Action(input = "http://webservice.p3.occ.org/MemberWebService/getMemberByBirthdateRequest", output = "http://webservice.p3.occ.org/MemberWebService/getMemberByBirthdateResponse")
    public List<Member> getMemberByBirthdate(
        @WebParam(name = "arg0", targetNamespace = "")
        XMLGregorianCalendar arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<org.occ.p3.webservice.Member>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMemberByAddress", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.GetMemberByAddress")
    @ResponseWrapper(localName = "getMemberByAddressResponse", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.GetMemberByAddressResponse")
    @Action(input = "http://webservice.p3.occ.org/MemberWebService/getMemberByAddressRequest", output = "http://webservice.p3.occ.org/MemberWebService/getMemberByAddressResponse")
    public List<Member> getMemberByAddress(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<org.occ.p3.webservice.Member>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMemberByEmailadress", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.GetMemberByEmailadress")
    @ResponseWrapper(localName = "getMemberByEmailadressResponse", targetNamespace = "http://webservice.p3.occ.org/", className = "org.occ.p3.webservice.GetMemberByEmailadressResponse")
    @Action(input = "http://webservice.p3.occ.org/MemberWebService/getMemberByEmailadressRequest", output = "http://webservice.p3.occ.org/MemberWebService/getMemberByEmailadressResponse")
    public List<Member> getMemberByEmailadress(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
