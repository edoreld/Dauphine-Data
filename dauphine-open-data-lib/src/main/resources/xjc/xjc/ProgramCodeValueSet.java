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
 * <p>Classe Java pour programCodeValueSet.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="programCodeValueSet"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="cite97"/&gt;
 *     &lt;enumeration value="erasmus"/&gt;
 *     &lt;enumeration value="disciplineSise"/&gt;
 *     &lt;enumeration value="regimeInscriptionSise"/&gt;
 *     &lt;enumeration value="rome"/&gt;
 *     &lt;enumeration value="rncp"/&gt;
 *     &lt;enumeration value="userDefined"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "programCodeValueSet")
@XmlEnum
public enum ProgramCodeValueSet {

    @XmlEnumValue("cite97")
    CITE_97("cite97"),
    @XmlEnumValue("erasmus")
    ERASMUS("erasmus"),
    @XmlEnumValue("disciplineSise")
    DISCIPLINE_SISE("disciplineSise"),
    @XmlEnumValue("regimeInscriptionSise")
    REGIME_INSCRIPTION_SISE("regimeInscriptionSise"),
    @XmlEnumValue("rome")
    ROME("rome"),
    @XmlEnumValue("rncp")
    RNCP("rncp"),
    @XmlEnumValue("userDefined")
    USER_DEFINED("userDefined");
    private final String value;

    ProgramCodeValueSet(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProgramCodeValueSet fromValue(String v) {
        for (ProgramCodeValueSet c: ProgramCodeValueSet.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
