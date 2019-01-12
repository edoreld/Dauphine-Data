package io.github.oliviercailloux.y2018.opendata.entity;

import com.google.common.base.Strings;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Triple is the atomic data entity for RDF data model. <br/>
 *
 * A triple stores a relationship between two objects.
 * The type of the relationship and the objects can be resources identified by URIs or URLs.
 * It's a generic model to store various kind of information on top of existing resources available from different places
 * in the web. <br/>
 *
 * This is the first-iteration implementation of such RDF triples. It is purposely simplified to keep it clear.
 * As we'll better understand the RDF model and identify potential usages in this project we'll rework this entity. <br/>
 *
 * For the moment it is an extra simple id -> (subject, predicate, object).
 *
 * @author Barthelemy Delemotte
 */
@Entity
@Table(
        // triples should be unique within the database
        uniqueConstraints=@UniqueConstraint(columnNames={"subject", "predicate", "object"})
)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Triple extends AbstractEntity {
    
    /*
     * Set a fixed max size for RDF triple values.
     * The default varchar size is 255, and this is potentially not long enough for long URLs
     * We keep it private for the moment as this is not yet a stable api.
     */
    private static final int MAX_VALUE_SIZE = 1023;
    
    @Id @GeneratedValue
    @XmlElement
    Long id;
    
    @Column(length = MAX_VALUE_SIZE, nullable = false)
    @XmlElement
    String subject = "";
    
    @Column(length = MAX_VALUE_SIZE, nullable = false)
    @XmlElement
    String predicate = "";
    
    @Column(length = MAX_VALUE_SIZE, nullable = false)
    @XmlElement
    String object = "";
    
    /**
     * Default constructor to be used by JPA
     */
    public Triple() {}
    
    /**
     * Construct a triple
     * @param subject the source object identification
     * @param predicate the type of relationship
     * @param object the target object identification or any value
     */
    public Triple(final String subject, final String predicate, final String object) {
        this.subject = Strings.nullToEmpty(subject);
        this.predicate = Strings.nullToEmpty(predicate);
        this.object = Strings.nullToEmpty(object);
    }
    
    @Override
    public Long getId() {
        return id;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = Strings.nullToEmpty(subject);
    }
    
    public String getPredicate() {
        return predicate;
    }
    
    public void setPredicate(String predicate) {
        this.predicate = Strings.nullToEmpty(predicate);
    }
    
    public String getObject() {
        return object;
    }
    
    public void setObject(String object) {
        this.object = Strings.nullToEmpty(object);
    }
}
