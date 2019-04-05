//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.04.05 à 06:20:23 PM CEST 
//


package xjc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="admissionDescription" type="{}infoBlockType" minOccurs="0"/&gt;
 *         &lt;element ref="{}studentPlaces" minOccurs="0"/&gt;
 *         &lt;element ref="{}teachingStart" minOccurs="0"/&gt;
 *         &lt;element ref="{}registrationDeadline" minOccurs="0"/&gt;
 *         &lt;element ref="{}cancelDeadline" minOccurs="0"/&gt;
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
    "admissionDescription",
    "studentPlaces",
    "teachingStart",
    "registrationDeadline",
    "cancelDeadline"
})
@XmlRootElement(name = "admissionInfo")
public class AdmissionInfo {

    protected InfoBlockType admissionDescription;
    protected StudentPlaces studentPlaces;
    protected CDMdateTime teachingStart;
    protected CDMdateTime registrationDeadline;
    protected CDMdateTime cancelDeadline;

    /**
     * Obtient la valeur de la propriété admissionDescription.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getAdmissionDescription() {
        return admissionDescription;
    }

    /**
     * Définit la valeur de la propriété admissionDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setAdmissionDescription(InfoBlockType value) {
        this.admissionDescription = value;
    }

    /**
     * Obtient la valeur de la propriété studentPlaces.
     * 
     * @return
     *     possible object is
     *     {@link StudentPlaces }
     *     
     */
    public StudentPlaces getStudentPlaces() {
        return studentPlaces;
    }

    /**
     * Définit la valeur de la propriété studentPlaces.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentPlaces }
     *     
     */
    public void setStudentPlaces(StudentPlaces value) {
        this.studentPlaces = value;
    }

    /**
     * Obtient la valeur de la propriété teachingStart.
     * 
     * @return
     *     possible object is
     *     {@link CDMdateTime }
     *     
     */
    public CDMdateTime getTeachingStart() {
        return teachingStart;
    }

    /**
     * Définit la valeur de la propriété teachingStart.
     * 
     * @param value
     *     allowed object is
     *     {@link CDMdateTime }
     *     
     */
    public void setTeachingStart(CDMdateTime value) {
        this.teachingStart = value;
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

}
