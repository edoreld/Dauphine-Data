//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.04.05 à 06:20:23 PM CEST 
//


package xjc;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour teachingTermValueType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="teachingTermValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="premierSemestre"/&gt;
 *     &lt;enumeration value="premierSemestreUnAnSurDeux"/&gt;
 *     &lt;enumeration value="secondSemestre"/&gt;
 *     &lt;enumeration value="secondSemestreUnAnSurDeux"/&gt;
 *     &lt;enumeration value="premierEtSecondSemestre"/&gt;
 *     &lt;enumeration value="userDefined"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "teachingTermValueType")
@XmlEnum
public enum TeachingTermValueType {

    @XmlEnumValue("premierSemestre")
    PREMIER_SEMESTRE("premierSemestre"),
    @XmlEnumValue("premierSemestreUnAnSurDeux")
    PREMIER_SEMESTRE_UN_AN_SUR_DEUX("premierSemestreUnAnSurDeux"),
    @XmlEnumValue("secondSemestre")
    SECOND_SEMESTRE("secondSemestre"),
    @XmlEnumValue("secondSemestreUnAnSurDeux")
    SECOND_SEMESTRE_UN_AN_SUR_DEUX("secondSemestreUnAnSurDeux"),
    @XmlEnumValue("premierEtSecondSemestre")
    PREMIER_ET_SECOND_SEMESTRE("premierEtSecondSemestre"),
    @XmlEnumValue("userDefined")
    USER_DEFINED("userDefined");
    private final String value;

    TeachingTermValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TeachingTermValueType fromValue(String v) {
        for (TeachingTermValueType c: TeachingTermValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
