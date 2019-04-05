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
import javax.xml.bind.annotation.XmlValue;
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
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pobox" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="extadr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="locality" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
 *                 &lt;attribute name="countyCode" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="pcode" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
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
    "pobox",
    "extadr",
    "street",
    "locality",
    "region",
    "pcode",
    "country"
})
@XmlRootElement(name = "adr")
public class Adr {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String pobox;
    protected String extadr;
    protected String street;
    protected Adr.Locality locality;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String region;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String pcode;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String country;

    /**
     * Obtient la valeur de la propriété pobox.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPobox() {
        return pobox;
    }

    /**
     * Définit la valeur de la propriété pobox.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPobox(String value) {
        this.pobox = value;
    }

    /**
     * Obtient la valeur de la propriété extadr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtadr() {
        return extadr;
    }

    /**
     * Définit la valeur de la propriété extadr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtadr(String value) {
        this.extadr = value;
    }

    /**
     * Obtient la valeur de la propriété street.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet() {
        return street;
    }

    /**
     * Définit la valeur de la propriété street.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Obtient la valeur de la propriété locality.
     * 
     * @return
     *     possible object is
     *     {@link Adr.Locality }
     *     
     */
    public Adr.Locality getLocality() {
        return locality;
    }

    /**
     * Définit la valeur de la propriété locality.
     * 
     * @param value
     *     allowed object is
     *     {@link Adr.Locality }
     *     
     */
    public void setLocality(Adr.Locality value) {
        this.locality = value;
    }

    /**
     * Obtient la valeur de la propriété region.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Définit la valeur de la propriété region.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Obtient la valeur de la propriété pcode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPcode() {
        return pcode;
    }

    /**
     * Définit la valeur de la propriété pcode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPcode(String value) {
        this.pcode = value;
    }

    /**
     * Obtient la valeur de la propriété country.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Définit la valeur de la propriété country.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;token"&gt;
     *       &lt;attribute name="countyCode" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Locality {

        @XmlValue
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String value;
        @XmlAttribute(name = "countyCode")
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger countyCode;

        /**
         * Obtient la valeur de la propriété value.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Définit la valeur de la propriété value.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Obtient la valeur de la propriété countyCode.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getCountyCode() {
            return countyCode;
        }

        /**
         * Définit la valeur de la propriété countyCode.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setCountyCode(BigInteger value) {
            this.countyCode = value;
        }

    }

}
