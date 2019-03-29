//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.03.29 à 03:56:28 AM WET 
//


package xjc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Contact information of persons related to the accomplishment of
 * 				courses.
 * 
 * <p>Classe Java pour personType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="personType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="personID" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="name"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="given" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *                   &lt;element name="family" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="title" type="{}textType" minOccurs="0"/&gt;
 *         &lt;element name="role" type="{}textType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{}contactData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{}infoBlock" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *       &lt;attribute name="ident" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *       &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}language" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personType", propOrder = {
    "personID",
    "name",
    "title",
    "role",
    "contactData",
    "infoBlock"
})
@XmlSeeAlso({
    Person.class
})
public class PersonType {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String personID;
    @XmlElement(required = true)
    protected PersonType.Name name;
    protected TextType title;
    protected List<TextType> role;
    protected List<ContactDataType> contactData;
    protected InfoBlockType infoBlock;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "ident")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String ident;
    @XmlAttribute(name = "language")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String language;

    /**
     * Obtient la valeur de la propriété personID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonID() {
        return personID;
    }

    /**
     * Définit la valeur de la propriété personID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonID(String value) {
        this.personID = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link PersonType.Name }
     *     
     */
    public PersonType.Name getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType.Name }
     *     
     */
    public void setName(PersonType.Name value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété title.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getTitle() {
        return title;
    }

    /**
     * Définit la valeur de la propriété title.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setTitle(TextType value) {
        this.title = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the role property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getRole() {
        if (role == null) {
            role = new ArrayList<TextType>();
        }
        return this.role;
    }

    /**
     * Gets the value of the contactData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactDataType }
     * 
     * 
     */
    public List<ContactDataType> getContactData() {
        if (contactData == null) {
            contactData = new ArrayList<ContactDataType>();
        }
        return this.contactData;
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
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété ident.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdent() {
        return ident;
    }

    /**
     * Définit la valeur de la propriété ident.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdent(String value) {
        this.ident = value;
    }

    /**
     * Obtient la valeur de la propriété language.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Définit la valeur de la propriété language.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="given" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
     *         &lt;element name="family" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "given",
        "family"
    })
    public static class Name {

        @XmlElement(required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String given;
        @XmlElement(required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String family;

        /**
         * Obtient la valeur de la propriété given.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGiven() {
            return given;
        }

        /**
         * Définit la valeur de la propriété given.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGiven(String value) {
            this.given = value;
        }

        /**
         * Obtient la valeur de la propriété family.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFamily() {
            return family;
        }

        /**
         * Définit la valeur de la propriété family.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFamily(String value) {
            this.family = value;
        }

    }

}
