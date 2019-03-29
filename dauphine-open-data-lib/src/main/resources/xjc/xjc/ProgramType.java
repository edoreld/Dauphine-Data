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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Description of a program. ECTS: An approved set of course units or
 * 				modules recognised for the award of a specific degree form a study programme and can
 * 				be defined through the set of learning outcomes to be achieved for the award of a
 * 				specified number of credits. (I Norge: på univ. og høgskolenivå tilsvarer det
 * 				studieprogram og studieretninger. I vgs tilsvarer det løp eller deler av løp i vgs.
 * 				(GK, VK1 eller VK2).
 * 
 * <p>Classe Java pour programType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="programType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="programID" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="programName" type="{}textType"/&gt;
 *         &lt;element name="programCode" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
 *                 &lt;attribute name="codeSet" type="{}programCodeValueSet" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{}webLink" minOccurs="0"/&gt;
 *         &lt;element name="programDescription" type="{}infoBlockType" minOccurs="0"/&gt;
 *         &lt;element ref="{}qualification" minOccurs="0"/&gt;
 *         &lt;element ref="{}level" minOccurs="0"/&gt;
 *         &lt;element ref="{}learningObjectives" minOccurs="0"/&gt;
 *         &lt;element ref="{}admissionInfo" minOccurs="0"/&gt;
 *         &lt;element ref="{}recommendedPrerequisites" minOccurs="0"/&gt;
 *         &lt;element ref="{}formalPrerequisites" minOccurs="0"/&gt;
 *         &lt;element ref="{}teachingPlace" minOccurs="0"/&gt;
 *         &lt;element ref="{}targetGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{}formOfTeaching" minOccurs="0"/&gt;
 *         &lt;element ref="{}programDuration" minOccurs="0"/&gt;
 *         &lt;element ref="{}programStructure" minOccurs="0"/&gt;
 *         &lt;element ref="{}regulations" minOccurs="0"/&gt;
 *         &lt;element ref="{}studyAbroad" minOccurs="0"/&gt;
 *         &lt;element ref="{}expenses" minOccurs="0"/&gt;
 *         &lt;element ref="{}universalAdjustment" minOccurs="0"/&gt;
 *         &lt;element ref="{}contacts" minOccurs="0"/&gt;
 *         &lt;element ref="{}infoBlock" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{}subProgram"/&gt;
 *           &lt;element ref="{}refProgram"/&gt;
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
@XmlType(name = "programType", propOrder = {
    "programID",
    "programName",
    "programCode",
    "webLink",
    "programDescription",
    "qualification",
    "level",
    "learningObjectives",
    "admissionInfo",
    "recommendedPrerequisites",
    "formalPrerequisites",
    "teachingPlace",
    "targetGroup",
    "formOfTeaching",
    "programDuration",
    "programStructure",
    "regulations",
    "studyAbroad",
    "expenses",
    "universalAdjustment",
    "contacts",
    "infoBlock",
    "subProgramOrRefProgram",
    "searchword"
})
@XmlSeeAlso({
    Program.class,
    SubProgram.class
})
public class ProgramType {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String programID;
    @XmlElement(required = true)
    protected TextType programName;
    protected List<ProgramType.ProgramCode> programCode;
    protected WebLink webLink;
    protected InfoBlockType programDescription;
    protected Qualification qualification;
    protected Level level;
    protected InfoBlockType learningObjectives;
    protected AdmissionInfo admissionInfo;
    protected InfoBlockType recommendedPrerequisites;
    protected InfoBlockType formalPrerequisites;
    protected TeachingPlace teachingPlace;
    protected InfoBlockType targetGroup;
    protected FormOfTeaching formOfTeaching;
    protected ProgramDuration programDuration;
    protected InfoBlockType programStructure;
    protected InfoBlockType regulations;
    protected InfoBlockType studyAbroad;
    protected Expenses expenses;
    protected InfoBlockType universalAdjustment;
    protected Contacts contacts;
    protected InfoBlockType infoBlock;
    @XmlElements({
        @XmlElement(name = "subProgram", type = SubProgram.class),
        @XmlElement(name = "refProgram", type = RefProgram.class)
    })
    protected List<Object> subProgramOrRefProgram;
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
     * Obtient la valeur de la propriété programID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramID() {
        return programID;
    }

    /**
     * Définit la valeur de la propriété programID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramID(String value) {
        this.programID = value;
    }

    /**
     * Obtient la valeur de la propriété programName.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getProgramName() {
        return programName;
    }

    /**
     * Définit la valeur de la propriété programName.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setProgramName(TextType value) {
        this.programName = value;
    }

    /**
     * Gets the value of the programCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the programCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProgramCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProgramType.ProgramCode }
     * 
     * 
     */
    public List<ProgramType.ProgramCode> getProgramCode() {
        if (programCode == null) {
            programCode = new ArrayList<ProgramType.ProgramCode>();
        }
        return this.programCode;
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
     * Obtient la valeur de la propriété programDescription.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getProgramDescription() {
        return programDescription;
    }

    /**
     * Définit la valeur de la propriété programDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setProgramDescription(InfoBlockType value) {
        this.programDescription = value;
    }

    /**
     * Obtient la valeur de la propriété qualification.
     * 
     * @return
     *     possible object is
     *     {@link Qualification }
     *     
     */
    public Qualification getQualification() {
        return qualification;
    }

    /**
     * Définit la valeur de la propriété qualification.
     * 
     * @param value
     *     allowed object is
     *     {@link Qualification }
     *     
     */
    public void setQualification(Qualification value) {
        this.qualification = value;
    }

    /**
     * Obtient la valeur de la propriété level.
     * 
     * @return
     *     possible object is
     *     {@link Level }
     *     
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Définit la valeur de la propriété level.
     * 
     * @param value
     *     allowed object is
     *     {@link Level }
     *     
     */
    public void setLevel(Level value) {
        this.level = value;
    }

    /**
     * Obtient la valeur de la propriété learningObjectives.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getLearningObjectives() {
        return learningObjectives;
    }

    /**
     * Définit la valeur de la propriété learningObjectives.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setLearningObjectives(InfoBlockType value) {
        this.learningObjectives = value;
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
     * Obtient la valeur de la propriété recommendedPrerequisites.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getRecommendedPrerequisites() {
        return recommendedPrerequisites;
    }

    /**
     * Définit la valeur de la propriété recommendedPrerequisites.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setRecommendedPrerequisites(InfoBlockType value) {
        this.recommendedPrerequisites = value;
    }

    /**
     * Obtient la valeur de la propriété formalPrerequisites.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getFormalPrerequisites() {
        return formalPrerequisites;
    }

    /**
     * Définit la valeur de la propriété formalPrerequisites.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setFormalPrerequisites(InfoBlockType value) {
        this.formalPrerequisites = value;
    }

    /**
     * Obtient la valeur de la propriété teachingPlace.
     * 
     * @return
     *     possible object is
     *     {@link TeachingPlace }
     *     
     */
    public TeachingPlace getTeachingPlace() {
        return teachingPlace;
    }

    /**
     * Définit la valeur de la propriété teachingPlace.
     * 
     * @param value
     *     allowed object is
     *     {@link TeachingPlace }
     *     
     */
    public void setTeachingPlace(TeachingPlace value) {
        this.teachingPlace = value;
    }

    /**
     * Obtient la valeur de la propriété targetGroup.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getTargetGroup() {
        return targetGroup;
    }

    /**
     * Définit la valeur de la propriété targetGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setTargetGroup(InfoBlockType value) {
        this.targetGroup = value;
    }

    /**
     * Obtient la valeur de la propriété formOfTeaching.
     * 
     * @return
     *     possible object is
     *     {@link FormOfTeaching }
     *     
     */
    public FormOfTeaching getFormOfTeaching() {
        return formOfTeaching;
    }

    /**
     * Définit la valeur de la propriété formOfTeaching.
     * 
     * @param value
     *     allowed object is
     *     {@link FormOfTeaching }
     *     
     */
    public void setFormOfTeaching(FormOfTeaching value) {
        this.formOfTeaching = value;
    }

    /**
     * Obtient la valeur de la propriété programDuration.
     * 
     * @return
     *     possible object is
     *     {@link ProgramDuration }
     *     
     */
    public ProgramDuration getProgramDuration() {
        return programDuration;
    }

    /**
     * Définit la valeur de la propriété programDuration.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgramDuration }
     *     
     */
    public void setProgramDuration(ProgramDuration value) {
        this.programDuration = value;
    }

    /**
     * Obtient la valeur de la propriété programStructure.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getProgramStructure() {
        return programStructure;
    }

    /**
     * Définit la valeur de la propriété programStructure.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setProgramStructure(InfoBlockType value) {
        this.programStructure = value;
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
     * Obtient la valeur de la propriété studyAbroad.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getStudyAbroad() {
        return studyAbroad;
    }

    /**
     * Définit la valeur de la propriété studyAbroad.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setStudyAbroad(InfoBlockType value) {
        this.studyAbroad = value;
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
     * Gets the value of the subProgramOrRefProgram property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subProgramOrRefProgram property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubProgramOrRefProgram().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubProgram }
     * {@link RefProgram }
     * 
     * 
     */
    public List<Object> getSubProgramOrRefProgram() {
        if (subProgramOrRefProgram == null) {
            subProgramOrRefProgram = new ArrayList<Object>();
        }
        return this.subProgramOrRefProgram;
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
     *       &lt;attribute name="codeSet" type="{}programCodeValueSet" /&gt;
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
    public static class ProgramCode {

        @XmlValue
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String value;
        @XmlAttribute(name = "codeSet")
        protected ProgramCodeValueSet codeSet;

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
         *     {@link ProgramCodeValueSet }
         *     
         */
        public ProgramCodeValueSet getCodeSet() {
            return codeSet;
        }

        /**
         * Définit la valeur de la propriété codeSet.
         * 
         * @param value
         *     allowed object is
         *     {@link ProgramCodeValueSet }
         *     
         */
        public void setCodeSet(ProgramCodeValueSet value) {
            this.codeSet = value;
        }

    }

}
