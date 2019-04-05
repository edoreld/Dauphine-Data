//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.04.05 à 06:20:23 PM CEST 
//


package xjc;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *       &lt;attribute name="ECTScredits" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="hoursPerWeek" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "credits")
public class Credits
    extends InfoBlockType
{

    @XmlAttribute(name = "ECTScredits")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger ectScredits;
    @XmlAttribute(name = "hoursPerWeek")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger hoursPerWeek;

    /**
     * Obtient la valeur de la propriété ectScredits.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getECTScredits() {
        return ectScredits;
    }

    /**
     * Définit la valeur de la propriété ectScredits.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setECTScredits(BigInteger value) {
        this.ectScredits = value;
    }

    /**
     * Obtient la valeur de la propriété hoursPerWeek.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHoursPerWeek() {
        return hoursPerWeek;
    }

    /**
     * Définit la valeur de la propriété hoursPerWeek.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHoursPerWeek(BigInteger value) {
        this.hoursPerWeek = value;
    }

}
