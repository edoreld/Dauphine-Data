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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{}infoBlockType"&gt;
 *       &lt;attribute name="degree" type="{}degreeValueType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "degree")
public class Degree
    extends InfoBlockType
{

    @XmlAttribute(name = "degree")
    protected DegreeValueType degree;

    /**
     * Obtient la valeur de la propriété degree.
     * 
     * @return
     *     possible object is
     *     {@link DegreeValueType }
     *     
     */
    public DegreeValueType getDegree() {
        return degree;
    }

    /**
     * Définit la valeur de la propriété degree.
     * 
     * @param value
     *     allowed object is
     *     {@link DegreeValueType }
     *     
     */
    public void setDegree(DegreeValueType value) {
        this.degree = value;
    }

}
