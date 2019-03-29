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
 * <p>Classe Java pour levelCompetenceYieldingValueType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="levelCompetenceYieldingValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="academic"/&gt;
 *     &lt;enumeration value="nonAcademic"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "levelCompetenceYieldingValueType")
@XmlEnum
public enum LevelCompetenceYieldingValueType {

    @XmlEnumValue("academic")
    ACADEMIC("academic"),
    @XmlEnumValue("nonAcademic")
    NON_ACADEMIC("nonAcademic");
    private final String value;

    LevelCompetenceYieldingValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LevelCompetenceYieldingValueType fromValue(String v) {
        for (LevelCompetenceYieldingValueType c: LevelCompetenceYieldingValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
