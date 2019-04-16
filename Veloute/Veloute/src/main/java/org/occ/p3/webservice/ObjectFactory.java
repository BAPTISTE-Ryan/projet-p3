
package org.occ.p3.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.occ.p3.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Send2_QNAME = new QName("http://webservice.p3.occ.org/", "send2");
    private final static QName _Send1_QNAME = new QName("http://webservice.p3.occ.org/", "send1");
    private final static QName _MailMethodOne_QNAME = new QName("http://webservice.p3.occ.org/", "mailMethodOne");
    private final static QName _SendResponse_QNAME = new QName("http://webservice.p3.occ.org/", "sendResponse");
    private final static QName _MailMethodThree_QNAME = new QName("http://webservice.p3.occ.org/", "mailMethodThree");
    private final static QName _InitResponse_QNAME = new QName("http://webservice.p3.occ.org/", "initResponse");
    private final static QName _Init_QNAME = new QName("http://webservice.p3.occ.org/", "init");
    private final static QName _MailMethodThreeResponse_QNAME = new QName("http://webservice.p3.occ.org/", "mailMethodThreeResponse");
    private final static QName _MailMethodTwoResponse_QNAME = new QName("http://webservice.p3.occ.org/", "mailMethodTwoResponse");
    private final static QName _MailMethodOneResponse_QNAME = new QName("http://webservice.p3.occ.org/", "mailMethodOneResponse");
    private final static QName _Send_QNAME = new QName("http://webservice.p3.occ.org/", "send");
    private final static QName _Send2Response_QNAME = new QName("http://webservice.p3.occ.org/", "send2Response");
    private final static QName _Send1Response_QNAME = new QName("http://webservice.p3.occ.org/", "send1Response");
    private final static QName _MailMethodTwo_QNAME = new QName("http://webservice.p3.occ.org/", "mailMethodTwo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.occ.p3.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MailMethodThreeResponse }
     * 
     */
    public MailMethodThreeResponse createMailMethodThreeResponse() {
        return new MailMethodThreeResponse();
    }

    /**
     * Create an instance of {@link Init }
     * 
     */
    public Init createInit() {
        return new Init();
    }

    /**
     * Create an instance of {@link InitResponse }
     * 
     */
    public InitResponse createInitResponse() {
        return new InitResponse();
    }

    /**
     * Create an instance of {@link MailMethodThree }
     * 
     */
    public MailMethodThree createMailMethodThree() {
        return new MailMethodThree();
    }

    /**
     * Create an instance of {@link MailMethodOne }
     * 
     */
    public MailMethodOne createMailMethodOne() {
        return new MailMethodOne();
    }

    /**
     * Create an instance of {@link SendResponse }
     * 
     */
    public SendResponse createSendResponse() {
        return new SendResponse();
    }

    /**
     * Create an instance of {@link Send1 }
     * 
     */
    public Send1 createSend1() {
        return new Send1();
    }

    /**
     * Create an instance of {@link Send2 }
     * 
     */
    public Send2 createSend2() {
        return new Send2();
    }

    /**
     * Create an instance of {@link MailMethodTwo }
     * 
     */
    public MailMethodTwo createMailMethodTwo() {
        return new MailMethodTwo();
    }

    /**
     * Create an instance of {@link Send1Response }
     * 
     */
    public Send1Response createSend1Response() {
        return new Send1Response();
    }

    /**
     * Create an instance of {@link MailMethodOneResponse }
     * 
     */
    public MailMethodOneResponse createMailMethodOneResponse() {
        return new MailMethodOneResponse();
    }

    /**
     * Create an instance of {@link Send }
     * 
     */
    public Send createSend() {
        return new Send();
    }

    /**
     * Create an instance of {@link Send2Response }
     * 
     */
    public Send2Response createSend2Response() {
        return new Send2Response();
    }

    /**
     * Create an instance of {@link MailMethodTwoResponse }
     * 
     */
    public MailMethodTwoResponse createMailMethodTwoResponse() {
        return new MailMethodTwoResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link PrintStream }
     * 
     */
    public PrintStream createPrintStream() {
        return new PrintStream();
    }

    /**
     * Create an instance of {@link FilterOutputStream }
     * 
     */
    public FilterOutputStream createFilterOutputStream() {
        return new FilterOutputStream();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Send2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "send2")
    public JAXBElement<Send2> createSend2(Send2 value) {
        return new JAXBElement<Send2>(_Send2_QNAME, Send2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Send1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "send1")
    public JAXBElement<Send1> createSend1(Send1 value) {
        return new JAXBElement<Send1>(_Send1_QNAME, Send1 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MailMethodOne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "mailMethodOne")
    public JAXBElement<MailMethodOne> createMailMethodOne(MailMethodOne value) {
        return new JAXBElement<MailMethodOne>(_MailMethodOne_QNAME, MailMethodOne.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "sendResponse")
    public JAXBElement<SendResponse> createSendResponse(SendResponse value) {
        return new JAXBElement<SendResponse>(_SendResponse_QNAME, SendResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MailMethodThree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "mailMethodThree")
    public JAXBElement<MailMethodThree> createMailMethodThree(MailMethodThree value) {
        return new JAXBElement<MailMethodThree>(_MailMethodThree_QNAME, MailMethodThree.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "initResponse")
    public JAXBElement<InitResponse> createInitResponse(InitResponse value) {
        return new JAXBElement<InitResponse>(_InitResponse_QNAME, InitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Init }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "init")
    public JAXBElement<Init> createInit(Init value) {
        return new JAXBElement<Init>(_Init_QNAME, Init.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MailMethodThreeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "mailMethodThreeResponse")
    public JAXBElement<MailMethodThreeResponse> createMailMethodThreeResponse(MailMethodThreeResponse value) {
        return new JAXBElement<MailMethodThreeResponse>(_MailMethodThreeResponse_QNAME, MailMethodThreeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MailMethodTwoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "mailMethodTwoResponse")
    public JAXBElement<MailMethodTwoResponse> createMailMethodTwoResponse(MailMethodTwoResponse value) {
        return new JAXBElement<MailMethodTwoResponse>(_MailMethodTwoResponse_QNAME, MailMethodTwoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MailMethodOneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "mailMethodOneResponse")
    public JAXBElement<MailMethodOneResponse> createMailMethodOneResponse(MailMethodOneResponse value) {
        return new JAXBElement<MailMethodOneResponse>(_MailMethodOneResponse_QNAME, MailMethodOneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Send }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "send")
    public JAXBElement<Send> createSend(Send value) {
        return new JAXBElement<Send>(_Send_QNAME, Send.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Send2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "send2Response")
    public JAXBElement<Send2Response> createSend2Response(Send2Response value) {
        return new JAXBElement<Send2Response>(_Send2Response_QNAME, Send2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Send1Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "send1Response")
    public JAXBElement<Send1Response> createSend1Response(Send1Response value) {
        return new JAXBElement<Send1Response>(_Send1Response_QNAME, Send1Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MailMethodTwo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.p3.occ.org/", name = "mailMethodTwo")
    public JAXBElement<MailMethodTwo> createMailMethodTwo(MailMethodTwo value) {
        return new JAXBElement<MailMethodTwo>(_MailMethodTwo_QNAME, MailMethodTwo.class, null, value);
    }

}
