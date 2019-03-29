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
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * Exam information
 * 
 * <p>Classe Java pour examType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="examType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="examName" type="{}textType" minOccurs="0"/&gt;
 *         &lt;element name="examKind" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{}infoBlockType"&gt;
 *                 &lt;attribute name="examKind" type="{}examKindValueType" /&gt;
 *                 &lt;attribute name="examForm" type="{}examFormValueType" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{}registrationDeadline" minOccurs="0"/&gt;
 *         &lt;element ref="{}cancelDeadline" minOccurs="0"/&gt;
 *         &lt;element ref="{}evaluationDeadline" minOccurs="0"/&gt;
 *         &lt;element ref="{}examStart" minOccurs="0"/&gt;
 *         &lt;element ref="{}examEnd" minOccurs="0"/&gt;
 *         &lt;element name="examDuration" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{}infoBlockType"&gt;
 *                 &lt;attribute name="duration" type="{http://www.w3.org/2001/XMLSchema}duration" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{}examLocation" minOccurs="0"/&gt;
 *         &lt;element ref="{}contacts" minOccurs="0"/&gt;
 *         &lt;element ref="{}infoBlock" minOccurs="0"/&gt;
 *         &lt;element name="examStructure" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="partStructure" type="{}infoBlockType" minOccurs="0"/&gt;
 *                   &lt;element name="examParts" type="{}examType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="examPartStructure" type="{}partStructureValueType" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "examType", propOrder = {
    "examName",
    "examKind",
    "registrationDeadline",
    "cancelDeadline",
    "evaluationDeadline",
    "examStart",
    "examEnd",
    "examDuration",
    "examLocation",
    "contacts",
    "infoBlock",
    "examStructure"
})
public class ExamType {

    protected TextType examName;
    protected ExamType.ExamKind examKind;
    protected CDMdateTime registrationDeadline;
    protected CDMdateTime cancelDeadline;
    protected CDMdateTime evaluationDeadline;
    protected CDMdateTime examStart;
    protected CDMdateTime examEnd;
    protected ExamType.ExamDuration examDuration;
    protected CDMlocation examLocation;
    protected Contacts contacts;
    protected InfoBlockType infoBlock;
    protected ExamType.ExamStructure examStructure;

    /**
     * Obtient la valeur de la propriété examName.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getExamName() {
        return examName;
    }

    /**
     * Définit la valeur de la propriété examName.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setExamName(TextType value) {
        this.examName = value;
    }

    /**
     * Obtient la valeur de la propriété examKind.
     * 
     * @return
     *     possible object is
     *     {@link ExamType.ExamKind }
     *     
     */
    public ExamType.ExamKind getExamKind() {
        return examKind;
    }

    /**
     * Définit la valeur de la propriété examKind.
     * 
     * @param value
     *     allowed object is
     *     {@link ExamType.ExamKind }
     *     
     */
    public void setExamKind(ExamType.ExamKind value) {
        this.examKind = value;
    }

    /**
     * Obtient la valeur de la propriété registrationDeadline.
     * 
     * @return
     *     possible object is
     *     {@link CDMdateTime }
     *     
     */
    public CDMdateTime getRegistrationDeadline() {
        return registrationDeadline;
    }

    /**
     * Définit la valeur de la propriété registrationDeadline.
     * 
     * @param value
     *     allowed object is
     *     {@link CDMdateTime }
     *     
     */
    public void setRegistrationDeadline(CDMdateTime value) {
        this.registrationDeadline = value;
    }

    /**
     * Obtient la valeur de la propriété cancelDeadline.
     * 
     * @return
     *     possible object is
     *     {@link CDMdateTime }
     *     
     */
    public CDMdateTime getCancelDeadline() {
        return cancelDeadline;
    }

    /**
     * Définit la valeur de la propriété cancelDeadline.
     * 
     * @param value
     *     allowed object is
     *     {@link CDMdateTime }
     *     
     */
    public void setCancelDeadline(CDMdateTime value) {
        this.cancelDeadline = value;
    }

    /**
     * Obtient la valeur de la propriété evaluationDeadline.
     * 
     * @return
     *     possible object is
     *     {@link CDMdateTime }
     *     
     */
    public CDMdateTime getEvaluationDeadline() {
        return evaluationDeadline;
    }

    /**
     * Définit la valeur de la propriété evaluationDeadline.
     * 
     * @param value
     *     allowed object is
     *     {@link CDMdateTime }
     *     
     */
    public void setEvaluationDeadline(CDMdateTime value) {
        this.evaluationDeadline = value;
    }

    /**
     * Obtient la valeur de la propriété examStart.
     * 
     * @return
     *     possible object is
     *     {@link CDMdateTime }
     *     
     */
    public CDMdateTime getExamStart() {
        return examStart;
    }

    /**
     * Définit la valeur de la propriété examStart.
     * 
     * @param value
     *     allowed object is
     *     {@link CDMdateTime }
     *     
     */
    public void setExamStart(CDMdateTime value) {
        this.examStart = value;
    }

    /**
     * Obtient la valeur de la propriété examEnd.
     * 
     * @return
     *     possible object is
     *     {@link CDMdateTime }
     *     
     */
    public CDMdateTime getExamEnd() {
        return examEnd;
    }

    /**
     * Définit la valeur de la propriété examEnd.
     * 
     * @param value
     *     allowed object is
     *     {@link CDMdateTime }
     *     
     */
    public void setExamEnd(CDMdateTime value) {
        this.examEnd = value;
    }

    /**
     * Obtient la valeur de la propriété examDuration.
     * 
     * @return
     *     possible object is
     *     {@link ExamType.ExamDuration }
     *     
     */
    public ExamType.ExamDuration getExamDuration() {
        return examDuration;
    }

    /**
     * Définit la valeur de la propriété examDuration.
     * 
     * @param value
     *     allowed object is
     *     {@link ExamType.ExamDuration }
     *     
     */
    public void setExamDuration(ExamType.ExamDuration value) {
        this.examDuration = value;
    }

    /**
     * Obtient la valeur de la propriété examLocation.
     * 
     * @return
     *     possible object is
     *     {@link CDMlocation }
     *     
     */
    public CDMlocation getExamLocation() {
        return examLocation;
    }

    /**
     * Définit la valeur de la propriété examLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link CDMlocation }
     *     
     */
    public void setExamLocation(CDMlocation value) {
        this.examLocation = value;
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
     * Obtient la valeur de la propriété examStructure.
     * 
     * @return
     *     possible object is
     *     {@link ExamType.ExamStructure }
     *     
     */
    public ExamType.ExamStructure getExamStructure() {
        return examStructure;
    }

    /**
     * Définit la valeur de la propriété examStructure.
     * 
     * @param value
     *     allowed object is
     *     {@link ExamType.ExamStructure }
     *     
     */
    public void setExamStructure(ExamType.ExamStructure value) {
        this.examStructure = value;
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
     *       &lt;attribute name="duration" type="{http://www.w3.org/2001/XMLSchema}duration" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ExamDuration
        extends InfoBlockType
    {

        @XmlAttribute(name = "duration")
        protected Duration duration;

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
     *       &lt;attribute name="examKind" type="{}examKindValueType" /&gt;
     *       &lt;attribute name="examForm" type="{}examFormValueType" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ExamKind
        extends InfoBlockType
    {

        @XmlAttribute(name = "examKind")
        protected ExamKindValueType examKind;
        @XmlAttribute(name = "examForm")
        protected ExamFormValueType examForm;

        /**
         * Obtient la valeur de la propriété examKind.
         * 
         * @return
         *     possible object is
         *     {@link ExamKindValueType }
         *     
         */
        public ExamKindValueType getExamKind() {
            return examKind;
        }

        /**
         * Définit la valeur de la propriété examKind.
         * 
         * @param value
         *     allowed object is
         *     {@link ExamKindValueType }
         *     
         */
        public void setExamKind(ExamKindValueType value) {
            this.examKind = value;
        }

        /**
         * Obtient la valeur de la propriété examForm.
         * 
         * @return
         *     possible object is
         *     {@link ExamFormValueType }
         *     
         */
        public ExamFormValueType getExamForm() {
            return examForm;
        }

        /**
         * Définit la valeur de la propriété examForm.
         * 
         * @param value
         *     allowed object is
         *     {@link ExamFormValueType }
         *     
         */
        public void setExamForm(ExamFormValueType value) {
            this.examForm = value;
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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="partStructure" type="{}infoBlockType" minOccurs="0"/&gt;
     *         &lt;element name="examParts" type="{}examType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="examPartStructure" type="{}partStructureValueType" /&gt;
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
        "examParts"
    })
    public static class ExamStructure {

        protected InfoBlockType partStructure;
        protected List<ExamType> examParts;
        @XmlAttribute(name = "examPartStructure")
        protected PartStructureValueType examPartStructure;

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
         * Gets the value of the examParts property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the examParts property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExamParts().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExamType }
         * 
         * 
         */
        public List<ExamType> getExamParts() {
            if (examParts == null) {
                examParts = new ArrayList<ExamType>();
            }
            return this.examParts;
        }

        /**
         * Obtient la valeur de la propriété examPartStructure.
         * 
         * @return
         *     possible object is
         *     {@link PartStructureValueType }
         *     
         */
        public PartStructureValueType getExamPartStructure() {
            return examPartStructure;
        }

        /**
         * Définit la valeur de la propriété examPartStructure.
         * 
         * @param value
         *     allowed object is
         *     {@link PartStructureValueType }
         *     
         */
        public void setExamPartStructure(PartStructureValueType value) {
            this.examPartStructure = value;
        }

    }

}
