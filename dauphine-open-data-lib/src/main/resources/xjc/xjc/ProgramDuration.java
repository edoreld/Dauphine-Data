//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.04.05 à 06:20:23 PM CEST 
//


package xjc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{}infoBlockType"&gt;
 *       &lt;attribute name="start" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *       &lt;attribute name="duration" type="{http://www.w3.org/2001/XMLSchema}duration" /&gt;
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
@XmlRootElement(name = "programDuration")
public class ProgramDuration
    extends InfoBlockType
{

    @XmlAttribute(name = "start")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "duration")
    protected Duration duration;
    @XmlAttribute(name = "studyPace")
    protected StudyPaceValueType studyPace;
    @XmlAttribute(name = "timeOfDay")
    protected TimeOfDayValueType timeOfDay;

    /**
     * Obtient la valeur de la propriété start.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStart() {
        return start;
    }

    /**
     * Définit la valeur de la propriété start.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStart(XMLGregorianCalendar value) {
        this.start = value;
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
