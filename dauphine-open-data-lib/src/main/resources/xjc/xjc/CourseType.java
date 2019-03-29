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
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Description of a course unit with curriculum, time schedule, teaching
 * 				activities and exam.
 * 
 * <p>Classe Java pour courseType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="courseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="courseID" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="courseName" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *         &lt;element name="courseCode" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
 *                 &lt;attribute name="codeSet" type="{}courseCodeValueSet" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{}webLink" minOccurs="0"/&gt;
 *         &lt;element name="courseDescription" type="{}infoBlockType"/&gt;
 *         &lt;element ref="{}level" minOccurs="0"/&gt;
 *         &lt;element ref="{}teachingTerm" minOccurs="0"/&gt;
 *         &lt;element ref="{}credits" minOccurs="0"/&gt;
 *         &lt;element ref="{}learningObjectives" minOccurs="0"/&gt;
 *         &lt;element ref="{}admissionInfo" minOccurs="0"/&gt;
 *         &lt;element ref="{}recommendedPrerequisites" minOccurs="0"/&gt;
 *         &lt;element ref="{}formalPrerequisites" minOccurs="0"/&gt;
 *         &lt;element ref="{}teachingPlace" minOccurs="0"/&gt;
 *         &lt;element ref="{}targetGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{}formOfTeaching" minOccurs="0"/&gt;
 *         &lt;element ref="{}formOfAssessment" minOccurs="0"/&gt;
 *         &lt;element name="benefits" type="{}infoBlockType" minOccurs="0"/&gt;
 *         &lt;element ref="{}instructionLanguage"/&gt;
 *         &lt;element name="overlap" type="{}infoBlockType" minOccurs="0"/&gt;
 *         &lt;element ref="{}syllabus" minOccurs="0"/&gt;
 *         &lt;element ref="{}expenses" minOccurs="0"/&gt;
 *         &lt;element ref="{}universalAdjustment" minOccurs="0"/&gt;
 *         &lt;element name="exam" type="{}examType" minOccurs="0"/&gt;
 *         &lt;element name="teachingActivity" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{}teachingActivityType"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{}contacts" minOccurs="0"/&gt;
 *         &lt;element ref="{}infoBlock" minOccurs="0"/&gt;
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
@XmlType(name = "courseType", propOrder = {
    "courseID",
    "courseName",
    "courseCode",
    "webLink",
    "courseDescription",
    "level",
    "teachingTerm",
    "credits",
    "learningObjectives",
    "admissionInfo",
    "recommendedPrerequisites",
    "formalPrerequisites",
    "teachingPlace",
    "targetGroup",
    "formOfTeaching",
    "formOfAssessment",
    "benefits",
    "instructionLanguage",
    "overlap",
    "syllabus",
    "expenses",
    "universalAdjustment",
    "exam",
    "teachingActivity",
    "contacts",
    "infoBlock",
    "searchword"
})
@XmlSeeAlso({
    Course.class
})
public class CourseType {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String courseID;
    @XmlElement(required = true)
    protected Object courseName;
    protected List<CourseType.CourseCode> courseCode;
    protected WebLink webLink;
    @XmlElement(required = true)
    protected InfoBlockType courseDescription;
    protected Level level;
    protected TeachingTerm teachingTerm;
    protected Credits credits;
    protected InfoBlockType learningObjectives;
    protected AdmissionInfo admissionInfo;
    protected InfoBlockType recommendedPrerequisites;
    protected InfoBlockType formalPrerequisites;
    protected TeachingPlace teachingPlace;
    protected InfoBlockType targetGroup;
    protected FormOfTeaching formOfTeaching;
    protected InfoBlockType formOfAssessment;
    protected InfoBlockType benefits;
    @XmlElement(required = true)
    protected InstructionLanguage instructionLanguage;
    protected InfoBlockType overlap;
    protected InfoBlockType syllabus;
    protected Expenses expenses;
    protected InfoBlockType universalAdjustment;
    protected ExamType exam;
    protected CourseType.TeachingActivity teachingActivity;
    protected Contacts contacts;
    protected InfoBlockType infoBlock;
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
     * Obtient la valeur de la propriété courseID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Définit la valeur de la propriété courseID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourseID(String value) {
        this.courseID = value;
    }

    /**
     * Obtient la valeur de la propriété courseName.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCourseName() {
        return courseName;
    }

    /**
     * Définit la valeur de la propriété courseName.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCourseName(Object value) {
        this.courseName = value;
    }

    /**
     * Gets the value of the courseCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the courseCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourseCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourseType.CourseCode }
     * 
     * 
     */
    public List<CourseType.CourseCode> getCourseCode() {
        if (courseCode == null) {
            courseCode = new ArrayList<CourseType.CourseCode>();
        }
        return this.courseCode;
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
     * Obtient la valeur de la propriété courseDescription.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getCourseDescription() {
        return courseDescription;
    }

    /**
     * Définit la valeur de la propriété courseDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setCourseDescription(InfoBlockType value) {
        this.courseDescription = value;
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
     * Obtient la valeur de la propriété teachingTerm.
     * 
     * @return
     *     possible object is
     *     {@link TeachingTerm }
     *     
     */
    public TeachingTerm getTeachingTerm() {
        return teachingTerm;
    }

    /**
     * Définit la valeur de la propriété teachingTerm.
     * 
     * @param value
     *     allowed object is
     *     {@link TeachingTerm }
     *     
     */
    public void setTeachingTerm(TeachingTerm value) {
        this.teachingTerm = value;
    }

    /**
     * Obtient la valeur de la propriété credits.
     * 
     * @return
     *     possible object is
     *     {@link Credits }
     *     
     */
    public Credits getCredits() {
        return credits;
    }

    /**
     * Définit la valeur de la propriété credits.
     * 
     * @param value
     *     allowed object is
     *     {@link Credits }
     *     
     */
    public void setCredits(Credits value) {
        this.credits = value;
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
     * Obtient la valeur de la propriété formOfAssessment.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getFormOfAssessment() {
        return formOfAssessment;
    }

    /**
     * Définit la valeur de la propriété formOfAssessment.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setFormOfAssessment(InfoBlockType value) {
        this.formOfAssessment = value;
    }

    /**
     * Obtient la valeur de la propriété benefits.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getBenefits() {
        return benefits;
    }

    /**
     * Définit la valeur de la propriété benefits.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setBenefits(InfoBlockType value) {
        this.benefits = value;
    }

    /**
     * Obtient la valeur de la propriété instructionLanguage.
     * 
     * @return
     *     possible object is
     *     {@link InstructionLanguage }
     *     
     */
    public InstructionLanguage getInstructionLanguage() {
        return instructionLanguage;
    }

    /**
     * Définit la valeur de la propriété instructionLanguage.
     * 
     * @param value
     *     allowed object is
     *     {@link InstructionLanguage }
     *     
     */
    public void setInstructionLanguage(InstructionLanguage value) {
        this.instructionLanguage = value;
    }

    /**
     * Obtient la valeur de la propriété overlap.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getOverlap() {
        return overlap;
    }

    /**
     * Définit la valeur de la propriété overlap.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setOverlap(InfoBlockType value) {
        this.overlap = value;
    }

    /**
     * Obtient la valeur de la propriété syllabus.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getSyllabus() {
        return syllabus;
    }

    /**
     * Définit la valeur de la propriété syllabus.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setSyllabus(InfoBlockType value) {
        this.syllabus = value;
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
     * Obtient la valeur de la propriété exam.
     * 
     * @return
     *     possible object is
     *     {@link ExamType }
     *     
     */
    public ExamType getExam() {
        return exam;
    }

    /**
     * Définit la valeur de la propriété exam.
     * 
     * @param value
     *     allowed object is
     *     {@link ExamType }
     *     
     */
    public void setExam(ExamType value) {
        this.exam = value;
    }

    /**
     * Obtient la valeur de la propriété teachingActivity.
     * 
     * @return
     *     possible object is
     *     {@link CourseType.TeachingActivity }
     *     
     */
    public CourseType.TeachingActivity getTeachingActivity() {
        return teachingActivity;
    }

    /**
     * Définit la valeur de la propriété teachingActivity.
     * 
     * @param value
     *     allowed object is
     *     {@link CourseType.TeachingActivity }
     *     
     */
    public void setTeachingActivity(CourseType.TeachingActivity value) {
        this.teachingActivity = value;
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
     *       &lt;attribute name="codeSet" type="{}courseCodeValueSet" /&gt;
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
    public static class CourseCode {

        @XmlValue
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String value;
        @XmlAttribute(name = "codeSet")
        protected CourseCodeValueSet codeSet;

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
         *     {@link CourseCodeValueSet }
         *     
         */
        public CourseCodeValueSet getCodeSet() {
            return codeSet;
        }

        /**
         * Définit la valeur de la propriété codeSet.
         * 
         * @param value
         *     allowed object is
         *     {@link CourseCodeValueSet }
         *     
         */
        public void setCodeSet(CourseCodeValueSet value) {
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
     *     &lt;extension base="{}teachingActivityType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TeachingActivity
        extends TeachingActivityType
    {


    }

}
