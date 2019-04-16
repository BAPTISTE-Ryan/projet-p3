
package org.occ.p3.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour session complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="session">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="debug" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="debugOut" type="{http://webservice.p3.occ.org/}printStream" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "session", propOrder = {
    "debug",
    "debugOut"
})
public class Session {

    protected boolean debug;
    protected PrintStream debugOut;

    /**
     * Obtient la valeur de la propriété debug.
     * 
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * Définit la valeur de la propriété debug.
     * 
     */
    public void setDebug(boolean value) {
        this.debug = value;
    }

    /**
     * Obtient la valeur de la propriété debugOut.
     * 
     * @return
     *     possible object is
     *     {@link PrintStream }
     *     
     */
    public PrintStream getDebugOut() {
        return debugOut;
    }

    /**
     * Définit la valeur de la propriété debugOut.
     * 
     * @param value
     *     allowed object is
     *     {@link PrintStream }
     *     
     */
    public void setDebugOut(PrintStream value) {
        this.debugOut = value;
    }

}
