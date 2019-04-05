//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.04.05 à 06:20:23 PM CEST 
//


package xjc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Information such as address, telephone, fax, email, URL etc. related
 * 				to a given contact.
 * 
 * <p>Classe Java pour contactDataType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="contactDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contactName" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{}textType"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{}adr" minOccurs="0"/&gt;
 *         &lt;element name="visitHour" type="{}infoBlockType" minOccurs="0"/&gt;
 *         &lt;element name="telephone" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
 *                 &lt;attribute name="teltype"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *                       &lt;enumeration value="mobile"/&gt;
 *                       &lt;enumeration value="office"/&gt;
 *                       &lt;enumeration value="home"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element ref="{}email" minOccurs="0"/&gt;
 *         &lt;element ref="{}webLink" minOccurs="0"/&gt;
 *         &lt;element ref="{}infoBlock" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="userDefined" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contactDataType", propOrder = {
    "contactName",
    "adr",
    "visitHour",
    "telephone",
    "fax",
    "email",
    "webLink",
    "infoBlock"
})
public class ContactDataType {

    protected ContactDataType.ContactName contactName;
    protected Adr adr;
    protected InfoBlockType visitHour;
    protected List<ContactDataType.Telephone> telephone;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String fax;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String email;
    protected WebLink webLink;
    protected InfoBlockType infoBlock;
    @XmlAttribute(name = "userDefined")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String userDefined;

    /**
     * Obtient la valeur de la propriété contactName.
     * 
     * @return
     *     possible object is
     *     {@link ContactDataType.ContactName }
     *     
     */
    public ContactDataType.ContactName getContactName() {
        return contactName;
    }

    /**
     * Définit la valeur de la propriété contactName.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactDataType.ContactName }
     *     
     */
    public void setContactName(ContactDataType.ContactName value) {
        this.contactName = value;
    }

    /**
     * Obtient la valeur de la propriété adr.
     * 
     * @return
     *     possible object is
     *     {@link Adr }
     *     
     */
    public Adr getAdr() {
        return adr;
    }

    /**
     * Définit la valeur de la propriété adr.
     * 
     * @param value
     *     allowed object is
     *     {@link Adr }
     *     
     */
    public void setAdr(Adr value) {
        this.adr = value;
    }

    /**
     * Obtient la valeur de la propriété visitHour.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getVisitHour() {
        return visitHour;
    }

    /**
     * Définit la valeur de la propriété visitHour.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setVisitHour(InfoBlockType value) {
        this.visitHour = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the telephone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTelephone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactDataType.Telephone }
     * 
     * 
     */
    public List<ContactDataType.Telephone> getTelephone() {
        if (telephone == null) {
            telephone = new ArrayList<ContactDataType.Telephone>();
        }
        return this.telephone;
    }

    /**
     * Obtient la valeur de la propriété fax.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Définit la valeur de la propriété fax.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Obtient la valeur de la propriété email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit la valeur de la propriété email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtient la valeur de la propriété webLink.
     * 
     * @return
     *     possible object is
     *     {@link WebLink }
     *     
     */
    public WebLink getWebLink() {
        return webLink;
    }

    /**
     * Définit la valeur de la propriété webLink.
     * 
     * @param value
     *     allowed object is
     *     {@link WebLink }
     *     
     */
    public void setWebLink(WebLink value) {
        this.webLink = value;
    }

    /**
     * Obtient la valeur de la propriété infoBlock.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getInfoBlock() {
        return infoBlock;
    }

    /**
     * Définit la valeur de la propriété infoBlock.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setInfoBlock(InfoBlockType value) {
        this.infoBlock = value;
    }

    /**
     * Obtient la valeur de la propriété userDefined.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserDefined() {
        return userDefined;
    }

    /**
     * Définit la valeur de la propriété userDefined.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserDefined(String value) {
        this.userDefined = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{}textType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ContactName
        extends TextType
    {


    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
     *       &lt;attribute name="teltype"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
     *             &lt;enumeration value="mobile"/&gt;
     *             &lt;enumeration value="office"/&gt;
     *             &lt;enumeration value="home"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Telephone {

        @XmlValue
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String value;
        @XmlAttribute(name = "teltype")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String teltype;

        /**
         * Obtient la valeur de la propriété value.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Définit la valeur de la propriété value.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Obtient la valeur de la propriété teltype.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTeltype() {
            return teltype;
        }

        /**
         * Définit la valeur de la propriété teltype.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTeltype(String value) {
            this.teltype = value;
        }

    }

}
