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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Description of an entry in a time table
 * 
 * <p>Classe Java pour timetableType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="timetableType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="reoccurringEvents"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="occurrenceRule" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{}infoBlockType"&gt;
 *                             &lt;attribute name="weekday" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="dateFrom" type="{}CDMdate" minOccurs="0"/&gt;
 *                     &lt;element name="dateTo" type="{}CDMdate" minOccurs="0"/&gt;
 *                     &lt;element name="timeFrom" type="{}CDMtime" minOccurs="0"/&gt;
 *                     &lt;element name="timeTo" type="{}CDMtime" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="singleEvent"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="start" type="{}CDMdateTime" minOccurs="0"/&gt;
 *                     &lt;element name="end" type="{}CDMdateTime" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{}teachingPlace" minOccurs="0"/&gt;
 *         &lt;element ref="{}contacts" minOccurs="0"/&gt;
 *         &lt;element ref="{}infoBlock" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timetableType", propOrder = {
    "reoccurringEvents",
    "singleEvent",
    "teachingPlace",
    "contacts",
    "infoBlock"
})
public class TimetableType {

    protected TimetableType.ReoccurringEvents reoccurringEvents;
    protected TimetableType.SingleEvent singleEvent;
    protected TeachingPlace teachingPlace;
    protected Contacts contacts;
    protected InfoBlockType infoBlock;

    /**
     * Obtient la valeur de la propriété reoccurringEvents.
     * 
     * @return
     *     possible object is
     *     {@link TimetableType.ReoccurringEvents }
     *     
     */
    public TimetableType.ReoccurringEvents getReoccurringEvents() {
        return reoccurringEvents;
    }

    /**
     * Définit la valeur de la propriété reoccurringEvents.
     * 
     * @param value
     *     allowed object is
     *     {@link TimetableType.ReoccurringEvents }
     *     
     */
    public void setReoccurringEvents(TimetableType.ReoccurringEvents value) {
        this.reoccurringEvents = value;
    }

    /**
     * Obtient la valeur de la propriété singleEvent.
     * 
     * @return
     *     possible object is
     *     {@link TimetableType.SingleEvent }
     *     
     */
    public TimetableType.SingleEvent getSingleEvent() {
        return singleEvent;
    }

    /**
     * Définit la valeur de la propriété singleEvent.
     * 
     * @param value
     *     allowed object is
     *     {@link TimetableType.SingleEvent }
     *     
     */
    public void setSingleEvent(TimetableType.SingleEvent value) {
        this.singleEvent = value;
    }

    /**
     * Obtient la valeur de la propriété teachingPlace.
     * 
     * @return
     *     possible object is
     *     {@link TeachingPlace }
     *     
     */
    public TeachingPlace getTeachingPlace() {
        return teachingPlace;
    }

    /**
     * Définit la valeur de la propriété teachingPlace.
     * 
     * @param value
     *     allowed object is
     *     {@link TeachingPlace }
     *     
     */
    public void setTeachingPlace(TeachingPlace value) {
        this.teachingPlace = value;
    }

    /**
     * Obtient la valeur de la propriété contacts.
     * 
     * @return
     *     possible object is
     *     {@link Contacts }
     *     
     */
    public Contacts getContacts() {
        return contacts;
    }

    /**
     * Définit la valeur de la propriété contacts.
     * 
     * @param value
     *     allowed object is
     *     {@link Contacts }
     *     
     */
    public void setContacts(Contacts value) {
        this.contacts = value;
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
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="occurrenceRule" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{}infoBlockType"&gt;
     *                 &lt;attribute name="weekday" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="dateFrom" type="{}CDMdate" minOccurs="0"/&gt;
     *         &lt;element name="dateTo" type="{}CDMdate" minOccurs="0"/&gt;
     *         &lt;element name="timeFrom" type="{}CDMtime" minOccurs="0"/&gt;
     *         &lt;element name="timeTo" type="{}CDMtime" minOccurs="0"/&gt;
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
        "occurrenceRule",
        "dateFrom",
        "dateTo",
        "timeFrom",
        "timeTo"
    })
    public static class ReoccurringEvents {

        protected TimetableType.ReoccurringEvents.OccurrenceRule occurrenceRule;
        protected CDMdate dateFrom;
        protected CDMdate dateTo;
        protected CDMtime timeFrom;
        protected CDMtime timeTo;

        /**
         * Obtient la valeur de la propriété occurrenceRule.
         * 
         * @return
         *     possible object is
         *     {@link TimetableType.ReoccurringEvents.OccurrenceRule }
         *     
         */
        public TimetableType.ReoccurringEvents.OccurrenceRule getOccurrenceRule() {
            return occurrenceRule;
        }

        /**
         * Définit la valeur de la propriété occurrenceRule.
         * 
         * @param value
         *     allowed object is
         *     {@link TimetableType.ReoccurringEvents.OccurrenceRule }
         *     
         */
        public void setOccurrenceRule(TimetableType.ReoccurringEvents.OccurrenceRule value) {
            this.occurrenceRule = value;
        }

        /**
         * Obtient la valeur de la propriété dateFrom.
         * 
         * @return
         *     possible object is
         *     {@link CDMdate }
         *     
         */
        public CDMdate getDateFrom() {
            return dateFrom;
        }

        /**
         * Définit la valeur de la propriété dateFrom.
         * 
         * @param value
         *     allowed object is
         *     {@link CDMdate }
         *     
         */
        public void setDateFrom(CDMdate value) {
            this.dateFrom = value;
        }

        /**
         * Obtient la valeur de la propriété dateTo.
         * 
         * @return
         *     possible object is
         *     {@link CDMdate }
         *     
         */
        public CDMdate getDateTo() {
            return dateTo;
        }

        /**
         * Définit la valeur de la propriété dateTo.
         * 
         * @param value
         *     allowed object is
         *     {@link CDMdate }
         *     
         */
        public void setDateTo(CDMdate value) {
            this.dateTo = value;
        }

        /**
         * Obtient la valeur de la propriété timeFrom.
         * 
         * @return
         *     possible object is
         *     {@link CDMtime }
         *     
         */
        public CDMtime getTimeFrom() {
            return timeFrom;
        }

        /**
         * Définit la valeur de la propriété timeFrom.
         * 
         * @param value
         *     allowed object is
         *     {@link CDMtime }
         *     
         */
        public void setTimeFrom(CDMtime value) {
            this.timeFrom = value;
        }

        /**
         * Obtient la valeur de la propriété timeTo.
         * 
         * @return
         *     possible object is
         *     {@link CDMtime }
         *     
         */
        public CDMtime getTimeTo() {
            return timeTo;
        }

        /**
         * Définit la valeur de la propriété timeTo.
         * 
         * @param value
         *     allowed object is
         *     {@link CDMtime }
         *     
         */
        public void setTimeTo(CDMtime value) {
            this.timeTo = value;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{}infoBlockType"&gt;
         *       &lt;attribute name="weekday" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class OccurrenceRule
            extends InfoBlockType
        {

            @XmlAttribute(name = "weekday")
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "token")
            protected String weekday;

            /**
             * Obtient la valeur de la propriété weekday.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWeekday() {
                return weekday;
            }

            /**
             * Définit la valeur de la propriété weekday.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWeekday(String value) {
                this.weekday = value;
            }

        }

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
     *         &lt;element name="start" type="{}CDMdateTime" minOccurs="0"/&gt;
     *         &lt;element name="end" type="{}CDMdateTime" minOccurs="0"/&gt;
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
        "start",
        "end"
    })
    public static class SingleEvent {

        protected CDMdateTime start;
        protected CDMdateTime end;

        /**
         * Obtient la valeur de la propriété start.
         * 
         * @return
         *     possible object is
         *     {@link CDMdateTime }
         *     
         */
        public CDMdateTime getStart() {
            return start;
        }

        /**
         * Définit la valeur de la propriété start.
         * 
         * @param value
         *     allowed object is
         *     {@link CDMdateTime }
         *     
         */
        public void setStart(CDMdateTime value) {
            this.start = value;
        }

        /**
         * Obtient la valeur de la propriété end.
         * 
         * @return
         *     possible object is
         *     {@link CDMdateTime }
         *     
         */
        public CDMdateTime getEnd() {
            return end;
        }

        /**
         * Définit la valeur de la propriété end.
         * 
         * @param value
         *     allowed object is
         *     {@link CDMdateTime }
         *     
         */
        public void setEnd(CDMdateTime value) {
            this.end = value;
        }

    }

}
