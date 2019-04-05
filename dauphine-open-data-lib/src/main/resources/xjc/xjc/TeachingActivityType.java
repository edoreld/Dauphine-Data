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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.Duration;


/**
 * Information on how the teaching activity is organised, ex lecture,
 * 				seminar, research seminar, exercise course, practical, laboratory work, guided
 * 				personal study, tutorial, independent studies, internship, placement or ‘stage’,
 * 				fieldwork, project work etc.
 * 
 * <p>Classe Java pour teachingActivityType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="teachingActivityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="teachingActivityID" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="teachingActivityName" type="{}textType" minOccurs="0"/&gt;
 *         &lt;element ref="{}admissionInfo" minOccurs="0"/&gt;
 *         &lt;element ref="{}timetableElement" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{}instructionLanguage" minOccurs="0"/&gt;
 *         &lt;element ref="{}contacts" minOccurs="0"/&gt;
 *         &lt;element ref="{}infoBlock" minOccurs="0"/&gt;
 *         &lt;element name="teachingActivityStructure" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="partStructure" type="{}infoBlockType" minOccurs="0"/&gt;
 *                   &lt;element name="activityParts" type="{}teachingActivityType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="activityPartStructure" type="{}partStructureValueType" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="method" type="{}teachingActivityValueType" /&gt;
 *       &lt;attribute name="org" type="{}formOfTeachingOrgValueType" /&gt;
 *       &lt;attribute name="timeOfDay" type="{}timeOfDayValueType" /&gt;
 *       &lt;attribute name="userDefined" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *       &lt;attribute name="duration" type="{http://www.w3.org/2001/XMLSchema}duration" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "teachingActivityType", propOrder = {
    "teachingActivityID",
    "teachingActivityName",
    "admissionInfo",
    "timetableElement",
    "instructionLanguage",
    "contacts",
    "infoBlock",
    "teachingActivityStructure"
})
@XmlSeeAlso({
    xjc.CourseType.TeachingActivity.class
})
public class TeachingActivityType {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String teachingActivityID;
    protected TextType teachingActivityName;
    protected AdmissionInfo admissionInfo;
    protected List<TimetableType> timetableElement;
    protected InstructionLanguage instructionLanguage;
    protected Contacts contacts;
    protected InfoBlockType infoBlock;
    protected TeachingActivityType.TeachingActivityStructure teachingActivityStructure;
    @XmlAttribute(name = "method")
    protected TeachingActivityValueType method;
    @XmlAttribute(name = "org")
    protected FormOfTeachingOrgValueType org;
    @XmlAttribute(name = "timeOfDay")
    protected TimeOfDayValueType timeOfDay;
    @XmlAttribute(name = "userDefined")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String userDefined;
    @XmlAttribute(name = "duration")
    protected Duration duration;

    /**
     * Obtient la valeur de la propriété teachingActivityID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeachingActivityID() {
        return teachingActivityID;
    }

    /**
     * Définit la valeur de la propriété teachingActivityID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeachingActivityID(String value) {
        this.teachingActivityID = value;
    }

    /**
     * Obtient la valeur de la propriété teachingActivityName.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getTeachingActivityName() {
        return teachingActivityName;
    }

    /**
     * Définit la valeur de la propriété teachingActivityName.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setTeachingActivityName(TextType value) {
        this.teachingActivityName = value;
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
     * Gets the value of the timetableElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timetableElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimetableElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TimetableType }
     * 
     * 
     */
    public List<TimetableType> getTimetableElement() {
        if (timetableElement == null) {
            timetableElement = new ArrayList<TimetableType>();
        }
        return this.timetableElement;
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
     * Obtient la valeur de la propriété teachingActivityStructure.
     * 
     * @return
     *     possible object is
     *     {@link TeachingActivityType.TeachingActivityStructure }
     *     
     */
    public TeachingActivityType.TeachingActivityStructure getTeachingActivityStructure() {
        return teachingActivityStructure;
    }

    /**
     * Définit la valeur de la propriété teachingActivityStructure.
     * 
     * @param value
     *     allowed object is
     *     {@link TeachingActivityType.TeachingActivityStructure }
     *     
     */
    public void setTeachingActivityStructure(TeachingActivityType.TeachingActivityStructure value) {
        this.teachingActivityStructure = value;
    }

    /**
     * Obtient la valeur de la propriété method.
     * 
     * @return
     *     possible object is
     *     {@link TeachingActivityValueType }
     *     
     */
    public TeachingActivityValueType getMethod() {
        return method;
    }

    /**
     * Définit la valeur de la propriété method.
     * 
     * @param value
     *     allowed object is
     *     {@link TeachingActivityValueType }
     *     
     */
    public void setMethod(TeachingActivityValueType value) {
        this.method = value;
    }

    /**
     * Obtient la valeur de la propriété org.
     * 
     * @return
     *     possible object is
     *     {@link FormOfTeachingOrgValueType }
     *     
     */
    public FormOfTeachingOrgValueType getOrg() {
        return org;
    }

    /**
     * Définit la valeur de la propriété org.
     * 
     * @param value
     *     allowed object is
     *     {@link FormOfTeachingOrgValueType }
     *     
     */
    public void setOrg(FormOfTeachingOrgValueType value) {
        this.org = value;
    }

    /**
     * Obtient la valeur de la propriété timeOfDay.
     * 
     * @return
     *     possible object is
     *     {@link TimeOfDayValueType }
     *     
     */
    public TimeOfDayValueType getTimeOfDay() {
        return timeOfDay;
    }

    /**
     * Définit la valeur de la propriété timeOfDay.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeOfDayValueType }
     *     
     */
    public void setTimeOfDay(TimeOfDayValueType value) {
        this.timeOfDay = value;
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
     * Obtient la valeur de la propriété duration.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Définit la valeur de la propriété duration.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDuration(Duration value) {
        this.duration = value;
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
     *         &lt;element name="partStructure" type="{}infoBlockType" minOccurs="0"/&gt;
     *         &lt;element name="activityParts" type="{}teachingActivityType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="activityPartStructure" type="{}partStructureValueType" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "partStructure",
        "activityParts"
    })
    public static class TeachingActivityStructure {

        protected InfoBlockType partStructure;
        protected List<TeachingActivityType> activityParts;
        @XmlAttribute(name = "activityPartStructure")
        protected PartStructureValueType activityPartStructure;

        /**
         * Obtient la valeur de la propriété partStructure.
         * 
         * @return
         *     possible object is
         *     {@link InfoBlockType }
         *     
         */
        public InfoBlockType getPartStructure() {
            return partStructure;
        }

        /**
         * Définit la valeur de la propriété partStructure.
         * 
         * @param value
         *     allowed object is
         *     {@link InfoBlockType }
         *     
         */
        public void setPartStructure(InfoBlockType value) {
            this.partStructure = value;
        }

        /**
         * Gets the value of the activityParts property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the activityParts property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getActivityParts().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TeachingActivityType }
         * 
         * 
         */
        public List<TeachingActivityType> getActivityParts() {
            if (activityParts == null) {
                activityParts = new ArrayList<TeachingActivityType>();
            }
            return this.activityParts;
        }

        /**
         * Obtient la valeur de la propriété activityPartStructure.
         * 
         * @return
         *     possible object is
         *     {@link PartStructureValueType }
         *     
         */
        public PartStructureValueType getActivityPartStructure() {
            return activityPartStructure;
        }

        /**
         * Définit la valeur de la propriété activityPartStructure.
         * 
         * @param value
         *     allowed object is
         *     {@link PartStructureValueType }
         *     
         */
        public void setActivityPartStructure(PartStructureValueType value) {
            this.activityPartStructure = value;
        }

    }

}
