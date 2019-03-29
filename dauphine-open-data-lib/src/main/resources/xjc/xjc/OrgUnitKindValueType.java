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
 * <p>Classe Java pour orgUnitKindValueType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="orgUnitKindValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="universite"/&gt;
 *     &lt;enumeration value="ufr"/&gt;
 *     &lt;enumeration value="ecole"/&gt;
 *     &lt;enumeration value="grandeEcole"/&gt;
 *     &lt;enumeration value="ens"/&gt;
 *     &lt;enumeration value="ecoleIngenieur"/&gt;
 *     &lt;enumeration value="institut"/&gt;
 *     &lt;enumeration value="insa"/&gt;
 *     &lt;enumeration value="iut"/&gt;
 *     &lt;enumeration value="iep"/&gt;
 *     &lt;enumeration value="inp"/&gt;
 *     &lt;enumeration value="iufm"/&gt;
 *     &lt;enumeration value="grandEtablissement"/&gt;
 *     &lt;enumeration value="chCommIndustrie"/&gt;
 *     &lt;enumeration value="chAgriculture"/&gt;
 *     &lt;enumeration value="conservatoire"/&gt;
 *     &lt;enumeration value="lycee"/&gt;
 *     &lt;enumeration value="formationContinue"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "orgUnitKindValueType")
@XmlEnum
public enum OrgUnitKindValueType {

    @XmlEnumValue("universite")
    UNIVERSITE("universite"),
    @XmlEnumValue("ufr")
    UFR("ufr"),
    @XmlEnumValue("ecole")
    ECOLE("ecole"),
    @XmlEnumValue("grandeEcole")
    GRANDE_ECOLE("grandeEcole"),
    @XmlEnumValue("ens")
    ENS("ens"),
    @XmlEnumValue("ecoleIngenieur")
    ECOLE_INGENIEUR("ecoleIngenieur"),
    @XmlEnumValue("institut")
    INSTITUT("institut"),
    @XmlEnumValue("insa")
    INSA("insa"),
    @XmlEnumValue("iut")
    IUT("iut"),
    @XmlEnumValue("iep")
    IEP("iep"),
    @XmlEnumValue("inp")
    INP("inp"),
    @XmlEnumValue("iufm")
    IUFM("iufm"),
    @XmlEnumValue("grandEtablissement")
    GRAND_ETABLISSEMENT("grandEtablissement"),
    @XmlEnumValue("chCommIndustrie")
    CH_COMM_INDUSTRIE("chCommIndustrie"),
    @XmlEnumValue("chAgriculture")
    CH_AGRICULTURE("chAgriculture"),
    @XmlEnumValue("conservatoire")
    CONSERVATOIRE("conservatoire"),
    @XmlEnumValue("lycee")
    LYCEE("lycee"),
    @XmlEnumValue("formationContinue")
    FORMATION_CONTINUE("formationContinue");
    private final String value;

    OrgUnitKindValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OrgUnitKindValueType fromValue(String v) {
        for (OrgUnitKindValueType c: OrgUnitKindValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
