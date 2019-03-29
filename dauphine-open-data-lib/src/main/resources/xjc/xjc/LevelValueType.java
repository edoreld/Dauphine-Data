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
 * <p>Classe Java pour levelValueType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="levelValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="baccalaureat"/&gt;
 *     &lt;enumeration value="licence1"/&gt;
 *     &lt;enumeration value="licence2"/&gt;
 *     &lt;enumeration value="licence3"/&gt;
 *     &lt;enumeration value="master1"/&gt;
 *     &lt;enumeration value="master2"/&gt;
 *     &lt;enumeration value="doctorat"/&gt;
 *     &lt;enumeration value="bts"/&gt;
 *     &lt;enumeration value="dut"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "levelValueType")
@XmlEnum
public enum LevelValueType {

    @XmlEnumValue("baccalaureat")
    BACCALAUREAT("baccalaureat"),
    @XmlEnumValue("licence1")
    LICENCE_1("licence1"),
    @XmlEnumValue("licence2")
    LICENCE_2("licence2"),
    @XmlEnumValue("licence3")
    LICENCE_3("licence3"),
    @XmlEnumValue("master1")
    MASTER_1("master1"),
    @XmlEnumValue("master2")
    MASTER_2("master2"),
    @XmlEnumValue("doctorat")
    DOCTORAT("doctorat"),
    @XmlEnumValue("bts")
    BTS("bts"),
    @XmlEnumValue("dut")
    DUT("dut");
    private final String value;

    LevelValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LevelValueType fromValue(String v) {
        for (LevelValueType c: LevelValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
