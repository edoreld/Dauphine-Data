//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.03.29 à 03:56:28 AM WET 
//


package xjc;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour courseCodeValueSet.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="courseCodeValueSet"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="cite97"/&gt;
 *     &lt;enumeration value="codeCNU"/&gt;
 *     &lt;enumeration value="erasmus"/&gt;
 *     &lt;enumeration value="natureUE-EC"/&gt;
 *     &lt;enumeration value="userDefined"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "courseCodeValueSet")
@XmlEnum
public enum CourseCodeValueSet {

    @XmlEnumValue("cite97")
    CITE_97("cite97"),
    @XmlEnumValue("codeCNU")
    CODE_CNU("codeCNU"),
    @XmlEnumValue("erasmus")
    ERASMUS("erasmus"),
    @XmlEnumValue("natureUE-EC")
    NATURE_UE_EC("natureUE-EC"),
    @XmlEnumValue("userDefined")
    USER_DEFINED("userDefined");
    private final String value;

    CourseCodeValueSet(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CourseCodeValueSet fromValue(String v) {
        for (CourseCodeValueSet c: CourseCodeValueSet.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
