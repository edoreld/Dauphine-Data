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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element ref="{}contactData" minOccurs="0"/&gt;
 *         &lt;element ref="{}person" minOccurs="0"/&gt;
 *         &lt;element ref="{}refPerson" minOccurs="0"/&gt;
 *         &lt;element ref="{}refOrgUnit" minOccurs="0"/&gt;
 *         &lt;element ref="{}infoBlock" minOccurs="0"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "contactDataOrPersonOrRefPerson"
})
@XmlRootElement(name = "contacts")
public class Contacts {

    @XmlElements({
        @XmlElement(name = "contactData", type = ContactDataType.class),
        @XmlElement(name = "person", type = Person.class),
        @XmlElement(name = "refPerson", type = RefPerson.class),
        @XmlElement(name = "refOrgUnit", type = RefOrgUnit.class),
        @XmlElement(name = "infoBlock", type = InfoBlockType.class)
    })
    protected List<Object> contactDataOrPersonOrRefPerson;

    /**
     * Gets the value of the contactDataOrPersonOrRefPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactDataOrPersonOrRefPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactDataOrPersonOrRefPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactDataType }
     * {@link Person }
     * {@link RefPerson }
     * {@link RefOrgUnit }
     * {@link InfoBlockType }
     * 
     * 
     */
    public List<Object> getContactDataOrPersonOrRefPerson() {
        if (contactDataOrPersonOrRefPerson == null) {
            contactDataOrPersonOrRefPerson = new ArrayList<Object>();
        }
        return this.contactDataOrPersonOrRefPerson;
    }

}
