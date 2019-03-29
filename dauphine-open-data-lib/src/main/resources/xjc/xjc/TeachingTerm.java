//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.03.29 à 03:56:28 AM WET 
//


package xjc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{}infoBlockType"&gt;
 *       &lt;attribute name="start" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *       &lt;attribute name="term" type="{}teachingTermValueType" /&gt;
 *       &lt;attribute name="studyPace" type="{}studyPaceValueType" /&gt;
 *       &lt;attribute name="timeOfDay" type="{}timeOfDayValueType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "teachingTerm")
public class TeachingTerm
    extends InfoBlockType
{

    @XmlAttribute(name = "start")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String start;
    @XmlAttribute(name = "term")
    protected TeachingTermValueType term;
    @XmlAttribute(name = "studyPace")
    protected StudyPaceValueType studyPace;
    @XmlAttribute(name = "timeOfDay")
    protected TimeOfDayValueType timeOfDay;

    /**
     * Obtient la valeur de la propriété start.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStart() {
        return start;
    }

    /**
     * Définit la valeur de la propriété start.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStart(String value) {
        this.start = value;
    }

    /**
     * Obtient la valeur de la propriété term.
     * 
     * @return
     *     possible object is
     *     {@link TeachingTermValueType }
     *     
     */
    public TeachingTermValueType getTerm() {
        return term;
    }

    /**
     * Définit la valeur de la propriété term.
     * 
     * @param value
     *     allowed object is
     *     {@link TeachingTermValueType }
     *     
     */
    public void setTerm(TeachingTermValueType value) {
        this.term = value;
    }

    /**
     * Obtient la valeur de la propriété studyPace.
     * 
     * @return
     *     possible object is
     *     {@link StudyPaceValueType }
     *     
     */
    public StudyPaceValueType getStudyPace() {
        return studyPace;
    }

    /**
     * Définit la valeur de la propriété studyPace.
     * 
     * @param value
     *     allowed object is
     *     {@link StudyPaceValueType }
     *     
     */
    public void setStudyPace(StudyPaceValueType value) {
        this.studyPace = value;
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

}
