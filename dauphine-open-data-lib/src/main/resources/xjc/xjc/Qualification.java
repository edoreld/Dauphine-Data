//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.03.29 à 03:56:28 AM WET 
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
 *         &lt;element name="qualificationName" type="{}textType" minOccurs="0"/&gt;
 *         &lt;element name="qualificationDescription" type="{}infoBlockType" minOccurs="0"/&gt;
 *         &lt;element ref="{}credits" minOccurs="0"/&gt;
 *         &lt;element ref="{}degree" minOccurs="0"/&gt;
 *         &lt;element ref="{}profession" minOccurs="0"/&gt;
 *         &lt;element ref="{}studyQualification" minOccurs="0"/&gt;
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
    "qualificationName",
    "qualificationDescription",
    "credits",
    "degree",
    "profession",
    "studyQualification"
})
@XmlRootElement(name = "qualification")
public class Qualification {

    protected TextType qualificationName;
    protected InfoBlockType qualificationDescription;
    protected Credits credits;
    protected Degree degree;
    protected InfoBlockType profession;
    protected InfoBlockType studyQualification;

    /**
     * Obtient la valeur de la propriété qualificationName.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getQualificationName() {
        return qualificationName;
    }

    /**
     * Définit la valeur de la propriété qualificationName.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setQualificationName(TextType value) {
        this.qualificationName = value;
    }

    /**
     * Obtient la valeur de la propriété qualificationDescription.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getQualificationDescription() {
        return qualificationDescription;
    }

    /**
     * Définit la valeur de la propriété qualificationDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setQualificationDescription(InfoBlockType value) {
        this.qualificationDescription = value;
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
     * Obtient la valeur de la propriété degree.
     * 
     * @return
     *     possible object is
     *     {@link Degree }
     *     
     */
    public Degree getDegree() {
        return degree;
    }

    /**
     * Définit la valeur de la propriété degree.
     * 
     * @param value
     *     allowed object is
     *     {@link Degree }
     *     
     */
    public void setDegree(Degree value) {
        this.degree = value;
    }

    /**
     * Obtient la valeur de la propriété profession.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getProfession() {
        return profession;
    }

    /**
     * Définit la valeur de la propriété profession.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setProfession(InfoBlockType value) {
        this.profession = value;
    }

    /**
     * Obtient la valeur de la propriété studyQualification.
     * 
     * @return
     *     possible object is
     *     {@link InfoBlockType }
     *     
     */
    public InfoBlockType getStudyQualification() {
        return studyQualification;
    }

    /**
     * Définit la valeur de la propriété studyQualification.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBlockType }
     *     
     */
    public void setStudyQualification(InfoBlockType value) {
        this.studyQualification = value;
    }

}
