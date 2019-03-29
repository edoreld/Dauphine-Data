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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * An element of type orgUnitType represents an organisational unit that
 * 				organises or provides study programs and courses. In general, a given program or
 * 				course may be organised/provided by multiple organisational units. An organisational
 * 				unit can have a hierarchical structure with subordinate organisational units (e.g.
 * 				university, faculty, institute). The concept of organisational unit is supposed to
 * 				encompass all organisational structures with educational offerings from a
 * 				traditional university to a loosely defined consortium. 
 * 
 * <p>Classe Java pour orgUnitType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="orgUnitType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="orgUnitID" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="orgUnitName" type="{}textType"/&gt;
 *         &lt;element name="orgUnitAcronym" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="orgUnitCode" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
 *                 &lt;attribute name="codeSet" type="{}orgUnitCodeValueSet" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="orgUnitKind" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{}infoBlockType"&gt;
 *                 &lt;attribute name="orgType" type="{}orgUnitKindValueType" /&gt;
 *                 &lt;attribute name="responsibleBody"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *                       &lt;enumeration value="publicEducationNationale"/&gt;
 *                       &lt;enumeration value="publicAgriculture"/&gt;
 *                       &lt;enumeration value="publicIndustrie"/&gt;
 *                       &lt;enumeration value="publicAffairesSociales"/&gt;
 *                       &lt;enumeration value="publicDefense"/&gt;
 *                       &lt;enumeration value="publicCulture"/&gt;
 *                       &lt;enumeration value="prive"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{}webLink" minOccurs="0"/&gt;
 *         &lt;element name="orgUnitDescription" type="{}infoBlockType" minOccurs="0"/&gt;
 *         &lt;element ref="{}admissionInfo" minOccurs="0"/&gt;
 *         &lt;element ref="{}regulations" minOccurs="0"/&gt;
 *         &lt;element ref="{}expenses" minOccurs="0"/&gt;
 *         &lt;element ref="{}studentFacilities" minOccurs="0"/&gt;
 *         &lt;element ref="{}universalAdjustment" minOccurs="0"/&gt;
 *         &lt;element ref="{}contacts" minOccurs="0"/&gt;
 *         &lt;element ref="{}infoBlock" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{}program"/&gt;
 *           &lt;element ref="{}refProgram"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{}course"/&gt;
 *           &lt;element ref="{}refCourse"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{}person"/&gt;
 *           &lt;element ref="{}refPerson"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{}orgUnit"/&gt;
 *           &lt;element ref="{}refOrgUnit"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{}searchword" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "orgUnitType", propOrder = {
    "orgUnitID",
    "orgUnitName",
    "orgUnitAcronym",
    "orgUnitCode",
    "orgUnitKind",
    "webLink",
    "orgUnitDescription",
    "admissionInfo",
    "regulations",
    "expenses",
    "studentFacilities",
    "universalAdjustment",
    "contacts",
    "infoBlock",
    "programOrRefProgram",
    "courseOrRefCourse",
    "personOrRefPerson",
    "orgUnitOrRefOrgUnit",
    "searchword"
})
public class OrgUnitType {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String orgUnitID;
    @XmlElement(required = true)
    protected TextType orgUnitName;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String orgUnitAcronym;
    protected List<OrgUnitType.OrgUnitCode> orgUnitCode;
    protected OrgUnitType.OrgUnitKind orgUnitKind;
    protected WebLink webLink;
    protected InfoBlockType orgUnitDescription;
    protected AdmissionInfo admissionInfo;
    protected InfoBlockType regulations;
    protected Expenses expenses;
    protected InfoBlockType studentFacilities;
    protected InfoBlockType universalAdjustment;
    protected Contacts contacts;
    protected InfoBlockType infoBlock;
    @XmlElements({
        @XmlElement(name = "program", type = Program.class),
        @XmlElement(name = "refProgram", type = RefProgram.class)
    })
    protected List<Object> programOrRefProgram;
    @XmlElements({
        @XmlElement(name = "course", type = Course.class),
        @XmlElement(name = "refCourse", type = RefCourse.class)
    })
    protected List<Object> courseOrRefCourse;
    @XmlElements({
        @XmlElement(name = "person", type = Person.class),
        @XmlElement(name = "refPerson", type = RefPerson.class)
    })
    protected List<Object> personOrRefPerson;
    @XmlElements({
        @XmlElement(name = "orgUnit", type = OrgUnitType.class),
        @XmlElement(name = "refOrgUnit", type = RefOrgUnit.class)
    })
    protected List<Object> orgUnitOrRefOrgUnit;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> searchword;
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
     * Obtient la valeur de la propriété orgUnitID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgUnitID() {
        return orgUnitID;
    }

    /**
     * Définit la valeur de la propriété orgUnitID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgUnitID(String value) {
        this.orgUnitID = value;
    }

    /**
     * Obtient la valeur de la propriété orgUnitName.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getOrgUnitName() {
        return orgUnitName;
    }

    /**
     * Définit la valeur de la propriété orgUnitName.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setOrgUnitName(TextType value) {
        this.orgUnitName = value;
    }

    /**
     * Obtient la valeur de la propriété orgUnitAcronym.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgUnitAcronym() {
        return orgUnitAcronym;
    }

    /**
     * Définit la valeur de la propriété orgUnitAcronym.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgUnitAcronym(String value) {
        this.orgUnitAcronym = value;
    }

    /**
     * Gets the value of the orgUnitCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgUnitCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrgUnitCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrgUnitType.OrgUnitCode }
     * 
     * 
     */
    public List<OrgUnitType.OrgUnitCode> getOrgUnitCode() {
        if (orgUnitCode == null) {
            orgUnitCode = new ArrayList<OrgUnitType.OrgUnitCode>();
        }
        return this.orgUnitCode;
    }

    /**
     * Obtient la valeur de la propriété orgUnitKind.
     * 
     * @return
     *     possible object is
     *     {@link OrgUnitType.OrgUnitKind }
     *     
     */
    public OrgUnitType.OrgUnitKind getOrgUnitKind() {
        return orgUnitKind;
    }

    /**
     * Définit la valeur de la propriété orgUnitKind.
     * 
     * @param value
     *     allowed object is
     *     {@link OrgUnitType.OrgUnitKind }
     *     
     */
    public void setOrgUnitKind(OrgUnitType.OrgUnitKind value) {
        this.orgUnitKind = value;
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
     * Obtient la valeur de la propriété orgUnitDescription.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getOrgUnitDescription() {
        return orgUnitDescription;
    }

    /**
     * Définit la valeur de la propriété orgUnitDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setOrgUnitDescription(InfoBlockType value) {
        this.orgUnitDescription = value;
    }

    /**
     * Obtient la valeur de la propriété admissionInfo.
     * 
     * @return
     *     possible object is
     *     {@link AdmissionInfo }
     *     
     */
    public AdmissionInfo getAdmissionInfo() {
        return admissionInfo;
    }

    /**
     * Définit la valeur de la propriété admissionInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link AdmissionInfo }
     *     
     */
    public void setAdmissionInfo(AdmissionInfo value) {
        this.admissionInfo = value;
    }

    /**
     * Obtient la valeur de la propriété regulations.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getRegulations() {
        return regulations;
    }

    /**
     * Définit la valeur de la propriété regulations.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setRegulations(InfoBlockType value) {
        this.regulations = value;
    }

    /**
     * Obtient la valeur de la propriété expenses.
     * 
     * @return
     *     possible object is
     *     {@link Expenses }
     *     
     */
    public Expenses getExpenses() {
        return expenses;
    }

    /**
     * Définit la valeur de la propriété expenses.
     * 
     * @param value
     *     allowed object is
     *     {@link Expenses }
     *     
     */
    public void setExpenses(Expenses value) {
        this.expenses = value;
    }

    /**
     * Obtient la valeur de la propriété studentFacilities.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getStudentFacilities() {
        return studentFacilities;
    }

    /**
     * Définit la valeur de la propriété studentFacilities.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setStudentFacilities(InfoBlockType value) {
        this.studentFacilities = value;
    }

    /**
     * Obtient la valeur de la propriété universalAdjustment.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getUniversalAdjustment() {
        return universalAdjustment;
    }

    /**
     * Définit la valeur de la propriété universalAdjustment.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setUniversalAdjustment(InfoBlockType value) {
        this.universalAdjustment = value;
    }

    /**
     * Obtient la valeur de la propriété contacts.
     * 
     * @return
     *     possible object is
     *     {@link Contacts }
     *     
     */
    public Contacts getContacts() {
        return contacts;
    }

    /**
     * Définit la valeur de la propriété contacts.
     * 
     * @param value
     *     allowed object is
     *     {@link Contacts }
     *     
     */
    public void setContacts(Contacts value) {
        this.contacts = value;
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
     * Gets the value of the programOrRefProgram property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the programOrRefProgram property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProgramOrRefProgram().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Program }
     * {@link RefProgram }
     * 
     * 
     */
    public List<Object> getProgramOrRefProgram() {
        if (programOrRefProgram == null) {
            programOrRefProgram = new ArrayList<Object>();
        }
        return this.programOrRefProgram;
    }

    /**
     * Gets the value of the courseOrRefCourse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the courseOrRefCourse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourseOrRefCourse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Course }
     * {@link RefCourse }
     * 
     * 
     */
    public List<Object> getCourseOrRefCourse() {
        if (courseOrRefCourse == null) {
            courseOrRefCourse = new ArrayList<Object>();
        }
        return this.courseOrRefCourse;
    }

    /**
     * Gets the value of the personOrRefPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personOrRefPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonOrRefPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Person }
     * {@link RefPerson }
     * 
     * 
     */
    public List<Object> getPersonOrRefPerson() {
        if (personOrRefPerson == null) {
            personOrRefPerson = new ArrayList<Object>();
        }
        return this.personOrRefPerson;
    }

    /**
     * Gets the value of the orgUnitOrRefOrgUnit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgUnitOrRefOrgUnit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrgUnitOrRefOrgUnit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrgUnitType }
     * {@link RefOrgUnit }
     * 
     * 
     */
    public List<Object> getOrgUnitOrRefOrgUnit() {
        if (orgUnitOrRefOrgUnit == null) {
            orgUnitOrRefOrgUnit = new ArrayList<Object>();
        }
        return this.orgUnitOrRefOrgUnit;
    }

    /**
     * Gets the value of the searchword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchword().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSearchword() {
        if (searchword == null) {
            searchword = new ArrayList<String>();
        }
        return this.searchword;
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
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
     *       &lt;attribute name="codeSet" type="{}orgUnitCodeValueSet" /&gt;
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
    public static class OrgUnitCode {

        @XmlValue
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String value;
        @XmlAttribute(name = "codeSet")
        protected OrgUnitCodeValueSet codeSet;

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
         * Obtient la valeur de la propriété codeSet.
         * 
         * @return
         *     possible object is
         *     {@link OrgUnitCodeValueSet }
         *     
         */
        public OrgUnitCodeValueSet getCodeSet() {
            return codeSet;
        }

        /**
         * Définit la valeur de la propriété codeSet.
         * 
         * @param value
         *     allowed object is
         *     {@link OrgUnitCodeValueSet }
         *     
         */
        public void setCodeSet(OrgUnitCodeValueSet value) {
            this.codeSet = value;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{}infoBlockType"&gt;
     *       &lt;attribute name="orgType" type="{}orgUnitKindValueType" /&gt;
     *       &lt;attribute name="responsibleBody"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
     *             &lt;enumeration value="publicEducationNationale"/&gt;
     *             &lt;enumeration value="publicAgriculture"/&gt;
     *             &lt;enumeration value="publicIndustrie"/&gt;
     *             &lt;enumeration value="publicAffairesSociales"/&gt;
     *             &lt;enumeration value="publicDefense"/&gt;
     *             &lt;enumeration value="publicCulture"/&gt;
     *             &lt;enumeration value="prive"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OrgUnitKind
        extends InfoBlockType
    {

        @XmlAttribute(name = "orgType")
        protected OrgUnitKindValueType orgType;
        @XmlAttribute(name = "responsibleBody")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String responsibleBody;

        /**
         * Obtient la valeur de la propriété orgType.
         * 
         * @return
         *     possible object is
         *     {@link OrgUnitKindValueType }
         *     
         */
        public OrgUnitKindValueType getOrgType() {
            return orgType;
        }

        /**
         * Définit la valeur de la propriété orgType.
         * 
         * @param value
         *     allowed object is
         *     {@link OrgUnitKindValueType }
         *     
         */
        public void setOrgType(OrgUnitKindValueType value) {
            this.orgType = value;
        }

        /**
         * Obtient la valeur de la propriété responsibleBody.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResponsibleBody() {
            return responsibleBody;
        }

        /**
         * Définit la valeur de la propriété responsibleBody.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResponsibleBody(String value) {
            this.responsibleBody = value;
        }

    }

}
