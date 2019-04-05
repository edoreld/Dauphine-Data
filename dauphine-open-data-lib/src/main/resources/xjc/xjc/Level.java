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
 *       &lt;attribute name="level" type="{}levelValueType" /&gt;
 *       &lt;attribute name="competenceYielding" type="{}levelCompetenceYieldingValueType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "level")
public class Level
    extends InfoBlockType
{

    @XmlAttribute(name = "level")
    protected LevelValueType level;
    @XmlAttribute(name = "competenceYielding")
    protected LevelCompetenceYieldingValueType competenceYielding;

    /**
     * Obtient la valeur de la propriété level.
     * 
     * @return
     *     possible object is
     *     {@link LevelValueType }
     *     
     */
    public LevelValueType getLevel() {
        return level;
    }

    /**
     * Définit la valeur de la propriété level.
     * 
     * @param value
     *     allowed object is
     *     {@link LevelValueType }
     *     
     */
    public void setLevel(LevelValueType value) {
        this.level = value;
    }

    /**
     * Obtient la valeur de la propriété competenceYielding.
     * 
     * @return
     *     possible object is
     *     {@link LevelCompetenceYieldingValueType }
     *     
     */
    public LevelCompetenceYieldingValueType getCompetenceYielding() {
        return competenceYielding;
    }

    /**
     * Définit la valeur de la propriété competenceYielding.
     * 
     * @param value
     *     allowed object is
     *     {@link LevelCompetenceYieldingValueType }
     *     
     */
    public void setCompetenceYielding(LevelCompetenceYieldingValueType value) {
        this.competenceYielding = value;
    }

}
