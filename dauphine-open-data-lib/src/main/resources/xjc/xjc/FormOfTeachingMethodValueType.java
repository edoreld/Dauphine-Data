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
 * <p>Classe Java pour formOfTeachingMethodValueType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="formOfTeachingMethodValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="faceAFace"/&gt;
 *     &lt;enumeration value="presentielEnrichi"/&gt;
 *     &lt;enumeration value="presentielAmeliore"/&gt;
 *     &lt;enumeration value="presentielAllege"/&gt;
 *     &lt;enumeration value="presentielReduit"/&gt;
 *     &lt;enumeration value="presentielQuasiInexistant"/&gt;
 *     &lt;enumeration value="aDistance"/&gt;
 *     &lt;enumeration value="parCorrespondance"/&gt;
 *     &lt;enumeration value="paLeWeb"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "formOfTeachingMethodValueType")
@XmlEnum
public enum FormOfTeachingMethodValueType {

    @XmlEnumValue("faceAFace")
    FACE_A_FACE("faceAFace"),
    @XmlEnumValue("presentielEnrichi")
    PRESENTIEL_ENRICHI("presentielEnrichi"),
    @XmlEnumValue("presentielAmeliore")
    PRESENTIEL_AMELIORE("presentielAmeliore"),
    @XmlEnumValue("presentielAllege")
    PRESENTIEL_ALLEGE("presentielAllege"),
    @XmlEnumValue("presentielReduit")
    PRESENTIEL_REDUIT("presentielReduit"),
    @XmlEnumValue("presentielQuasiInexistant")
    PRESENTIEL_QUASI_INEXISTANT("presentielQuasiInexistant"),
    @XmlEnumValue("aDistance")
    A_DISTANCE("aDistance"),
    @XmlEnumValue("parCorrespondance")
    PAR_CORRESPONDANCE("parCorrespondance"),
    @XmlEnumValue("paLeWeb")
    PA_LE_WEB("paLeWeb");
    private final String value;

    FormOfTeachingMethodValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FormOfTeachingMethodValueType fromValue(String v) {
        for (FormOfTeachingMethodValueType c: FormOfTeachingMethodValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
