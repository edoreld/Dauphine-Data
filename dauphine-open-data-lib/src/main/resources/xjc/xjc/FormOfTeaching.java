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
 *       &lt;attribute name="org" type="{}formOfTeachingOrgValueType" /&gt;
 *       &lt;attribute name="method" type="{}formOfTeachingMethodValueType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "formOfTeaching")
public class FormOfTeaching
    extends InfoBlockType
{

    @XmlAttribute(name = "org")
    protected FormOfTeachingOrgValueType org;
    @XmlAttribute(name = "method")
    protected FormOfTeachingMethodValueType method;

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
     * Obtient la valeur de la propriété method.
     * 
     * @return
     *     possible object is
     *     {@link FormOfTeachingMethodValueType }
     *     
     */
    public FormOfTeachingMethodValueType getMethod() {
        return method;
    }

    /**
     * Définit la valeur de la propriété method.
     * 
     * @param value
     *     allowed object is
     *     {@link FormOfTeachingMethodValueType }
     *     
     */
    public void setMethod(FormOfTeachingMethodValueType value) {
        this.method = value;
    }

}
