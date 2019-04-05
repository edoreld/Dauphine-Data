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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="properties" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="datasource" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *                   &lt;element name="target" type="{http://www.w3.org/2001/XMLSchema}token" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *                   &lt;element name="datetime" type="{}CDMdateTime" minOccurs="0"/&gt;
 *                   &lt;element ref="{}infoBlock" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}language" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;choice maxOccurs="unbounded"&gt;
 *           &lt;element ref="{}orgUnit"/&gt;
 *           &lt;element ref="{}program"/&gt;
 *           &lt;element ref="{}course"/&gt;
 *           &lt;element ref="{}person"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}language" /&gt;
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *       &lt;attribute name="profile" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "properties",
    "orgUnitOrProgramOrCourse"
})
@XmlRootElement(name = "CDM")
public class CDM {

    protected CDM.Properties properties;
    @XmlElements({
        @XmlElement(name = "orgUnit", type = OrgUnitType.class),
        @XmlElement(name = "program", type = Program.class),
        @XmlElement(name = "course", type = Course.class),
        @XmlElement(name = "person", type = Person.class)
    })
    protected List<Object> orgUnitOrProgramOrCourse;
    @XmlAttribute(name = "language")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String language;
    @XmlAttribute(name = "version")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String version;
    @XmlAttribute(name = "profile")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String profile;

    /**
     * Obtient la valeur de la propriété properties.
     * 
     * @return
     *     possible object is
     *     {@link CDM.Properties }
     *     
     */
    public CDM.Properties getProperties() {
        return properties;
    }

    /**
     * Définit la valeur de la propriété properties.
     * 
     * @param value
     *     allowed object is
     *     {@link CDM.Properties }
     *     
     */
    public void setProperties(CDM.Properties value) {
        this.properties = value;
    }

    /**
     * Gets the value of the orgUnitOrProgramOrCourse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgUnitOrProgramOrCourse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrgUnitOrProgramOrCourse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrgUnitType }
     * {@link Program }
     * {@link Course }
     * {@link Person }
     * 
     * 
     */
    public List<Object> getOrgUnitOrProgramOrCourse() {
        if (orgUnitOrProgramOrCourse == null) {
            orgUnitOrProgramOrCourse = new ArrayList<Object>();
        }
        return this.orgUnitOrProgramOrCourse;
    }

    /**
     * Obtient la valeur de la propriété language.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Définit la valeur de la propriété language.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Obtient la valeur de la propriété version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Définit la valeur de la propriété version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Obtient la valeur de la propriété profile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Définit la valeur de la propriété profile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfile(String value) {
        this.profile = value;
    }


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
     *         &lt;element name="datasource" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
     *         &lt;element name="target" type="{http://www.w3.org/2001/XMLSchema}token" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
     *         &lt;element name="datetime" type="{}CDMdateTime" minOccurs="0"/&gt;
     *         &lt;element ref="{}infoBlock" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}language" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "datasource",
        "target",
        "type",
        "datetime",
        "infoBlock"
    })
    public static class Properties {

        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String datasource;
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected List<String> target;
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String type;
        protected CDMdateTime datetime;
        protected InfoBlockType infoBlock;
        @XmlAttribute(name = "language")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "language")
        protected String language;

        /**
         * Obtient la valeur de la propriété datasource.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDatasource() {
            return datasource;
        }

        /**
         * Définit la valeur de la propriété datasource.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDatasource(String value) {
            this.datasource = value;
        }

        /**
         * Gets the value of the target property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the target property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTarget().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getTarget() {
            if (target == null) {
                target = new ArrayList<String>();
            }
            return this.target;
        }

        /**
         * Obtient la valeur de la propriété type.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Définit la valeur de la propriété type.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * Obtient la valeur de la propriété datetime.
         * 
         * @return
         *     possible object is
         *     {@link CDMdateTime }
         *     
         */
        public CDMdateTime getDatetime() {
            return datetime;
        }

        /**
         * Définit la valeur de la propriété datetime.
         * 
         * @param value
         *     allowed object is
         *     {@link CDMdateTime }
         *     
         */
        public void setDatetime(CDMdateTime value) {
            this.datetime = value;
        }

        /**
         * Obtient la valeur de la propriété infoBlock.
         * 
         * @return
         *     possible object is
         *     {@link InfoBlockType }
         *     
         */
        public InfoBlockType getInfoBlock() {
            return infoBlock;
        }

        /**
         * Définit la valeur de la propriété infoBlock.
         * 
         * @param value
         *     allowed object is
         *     {@link InfoBlockType }
         *     
         */
        public void setInfoBlock(InfoBlockType value) {
            this.infoBlock = value;
        }

        /**
         * Obtient la valeur de la propriété language.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLanguage() {
            return language;
        }

        /**
         * Définit la valeur de la propriété language.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLanguage(String value) {
            this.language = value;
        }

    }

}
