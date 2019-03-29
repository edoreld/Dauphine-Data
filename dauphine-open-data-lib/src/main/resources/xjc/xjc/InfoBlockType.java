//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.03.29 à 03:56:28 AM WET 
//


package xjc;

import java.util.ArrayList;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * General type for various kind of information
 * 
 * <p>Classe Java pour infoBlockType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="infoBlockType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="header" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element name="bold" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="italic" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element ref="{}br"/&gt;
 *           &lt;element name="list"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;element name="listItem" type="{}infoBlockType"/&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;attribute name="listType" default="bulleted"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *                         &lt;enumeration value="bulleted"/&gt;
 *                         &lt;enumeration value="numbered"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/attribute&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="strong" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="emphasis" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="superscript" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="subscript" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *           &lt;element ref="{}webLink"/&gt;
 *           &lt;choice&gt;
 *             &lt;element ref="{}refOrgUnit"/&gt;
 *             &lt;element ref="{}refProgram"/&gt;
 *             &lt;element ref="{}refCourse"/&gt;
 *             &lt;element ref="{}refPerson"/&gt;
 *           &lt;/choice&gt;
 *           &lt;element name="picture" type="{}infoBlockType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="subBlock" type="{}infoBlockType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="altLangBlock" type="{}infoBlockType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{}searchword" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="blockLang" type="{http://www.w3.org/2001/XMLSchema}language" /&gt;
 *       &lt;attribute name="userDefined" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infoBlockType", propOrder = {
    "content"
})
@XmlSeeAlso({
    xjc.OrgUnitType.OrgUnitKind.class,
    CDMdateTime.class,
    xjc.ExamType.ExamKind.class,
    xjc.ExamType.ExamDuration.class,
    xjc.TimetableType.ReoccurringEvents.OccurrenceRule.class,
    CDMdate.class,
    CDMtime.class,
    InstructionLanguage.class,
    TeachingTerm.class,
    Expenses.class,
    ProgramDuration.class,
    FormOfTeaching.class,
    StudentPlaces.class,
    Level.class,
    Degree.class,
    Credits.class
})
public class InfoBlockType {

    @XmlElementRefs({
        @XmlElementRef(name = "header", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bold", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "italic", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "br", type = Br.class, required = false),
        @XmlElementRef(name = "list", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "strong", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "emphasis", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "superscript", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "subscript", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "email", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "webLink", type = WebLink.class, required = false),
        @XmlElementRef(name = "refOrgUnit", type = RefOrgUnit.class, required = false),
        @XmlElementRef(name = "refProgram", type = RefProgram.class, required = false),
        @XmlElementRef(name = "refCourse", type = RefCourse.class, required = false),
        @XmlElementRef(name = "refPerson", type = RefPerson.class, required = false),
        @XmlElementRef(name = "picture", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "extension", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "subBlock", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "altLangBlock", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "searchword", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected java.util.List<Object> content;
    @XmlAttribute(name = "blockLang")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String blockLang;
    @XmlAttribute(name = "userDefined")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String userDefined;

    /**
     * General type for various kind of information Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link Br }
     * {@link JAXBElement }{@code <}{@link InfoBlockType.List }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link WebLink }
     * {@link RefOrgUnit }
     * {@link RefProgram }
     * {@link RefCourse }
     * {@link RefPerson }
     * {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link String }
     * 
     * 
     */
    public java.util.List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

    /**
     * Obtient la valeur de la propriété blockLang.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockLang() {
        return blockLang;
    }

    /**
     * Définit la valeur de la propriété blockLang.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockLang(String value) {
        this.blockLang = value;
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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
     *         &lt;element name="listItem" type="{}infoBlockType"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="listType" default="bulleted"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
     *             &lt;enumeration value="bulleted"/&gt;
     *             &lt;enumeration value="numbered"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "listItem"
    })
    public static class List {

        protected java.util.List<InfoBlockType> listItem;
        @XmlAttribute(name = "listType")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String listType;

        /**
         * Gets the value of the listItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the listItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getListItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InfoBlockType }
         * 
         * 
         */
        public java.util.List<InfoBlockType> getListItem() {
            if (listItem == null) {
                listItem = new ArrayList<InfoBlockType>();
            }
            return this.listItem;
        }

        /**
         * Obtient la valeur de la propriété listType.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getListType() {
            if (listType == null) {
                return "bulleted";
            } else {
                return listType;
            }
        }

        /**
         * Définit la valeur de la propriété listType.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setListType(String value) {
            this.listType = value;
        }

    }

}
