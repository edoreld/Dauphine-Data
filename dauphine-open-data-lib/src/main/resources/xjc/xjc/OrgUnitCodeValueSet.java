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
 * <p>Classe Java pour orgUnitCodeValueSet.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="orgUnitCodeValueSet"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="codeNationalIdentification"/&gt;
 *     &lt;enumeration value="codeEtablissement"/&gt;
 *     &lt;enumeration value="siret"/&gt;
 *     &lt;enumeration value="userDefined"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "orgUnitCodeValueSet")
@XmlEnum
public enum OrgUnitCodeValueSet {

    @XmlEnumValue("codeNationalIdentification")
    CODE_NATIONAL_IDENTIFICATION("codeNationalIdentification"),
    @XmlEnumValue("codeEtablissement")
    CODE_ETABLISSEMENT("codeEtablissement"),
    @XmlEnumValue("siret")
    SIRET("siret"),
    @XmlEnumValue("userDefined")
    USER_DEFINED("userDefined");
    private final String value;

    OrgUnitCodeValueSet(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OrgUnitCodeValueSet fromValue(String v) {
        for (OrgUnitCodeValueSet c: OrgUnitCodeValueSet.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
