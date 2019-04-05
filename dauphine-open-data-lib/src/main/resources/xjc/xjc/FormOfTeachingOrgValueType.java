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
 * <p>Classe Java pour formOfTeachingOrgValueType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="formOfTeachingOrgValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="aDistance"/&gt;
 *     &lt;enumeration value="presentiel"/&gt;
 *     &lt;enumeration value="mixte"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "formOfTeachingOrgValueType")
@XmlEnum
public enum FormOfTeachingOrgValueType {

    @XmlEnumValue("aDistance")
    A_DISTANCE("aDistance"),
    @XmlEnumValue("presentiel")
    PRESENTIEL("presentiel"),
    @XmlEnumValue("mixte")
    MIXTE("mixte");
    private final String value;

    FormOfTeachingOrgValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FormOfTeachingOrgValueType fromValue(String v) {
        for (FormOfTeachingOrgValueType c: FormOfTeachingOrgValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
