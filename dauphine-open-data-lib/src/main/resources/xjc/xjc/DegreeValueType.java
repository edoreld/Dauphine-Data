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
 * <p>Classe Java pour degreeValueType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="degreeValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="diplomeUniversitaire"/&gt;
 *     &lt;enumeration value="licence"/&gt;
 *     &lt;enumeration value="licencePro"/&gt;
 *     &lt;enumeration value="master"/&gt;
 *     &lt;enumeration value="doctorat"/&gt;
 *     &lt;enumeration value="bts"/&gt;
 *     &lt;enumeration value="dut"/&gt;
 *     &lt;enumeration value="maitrise"/&gt;
 *     &lt;enumeration value="daeu"/&gt;
 *     &lt;enumeration value="deust"/&gt;
 *     &lt;enumeration value="deug"/&gt;
 *     &lt;enumeration value="hdr"/&gt;
 *     &lt;enumeration value="ingenieur"/&gt;
 *     &lt;enumeration value="certificat"/&gt;
 *     &lt;enumeration value="attestation"/&gt;
 *     &lt;enumeration value="capacite"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "degreeValueType")
@XmlEnum
public enum DegreeValueType {

    @XmlEnumValue("diplomeUniversitaire")
    DIPLOME_UNIVERSITAIRE("diplomeUniversitaire"),
    @XmlEnumValue("licence")
    LICENCE("licence"),
    @XmlEnumValue("licencePro")
    LICENCE_PRO("licencePro"),
    @XmlEnumValue("master")
    MASTER("master"),
    @XmlEnumValue("doctorat")
    DOCTORAT("doctorat"),
    @XmlEnumValue("bts")
    BTS("bts"),
    @XmlEnumValue("dut")
    DUT("dut"),
    @XmlEnumValue("maitrise")
    MAITRISE("maitrise"),
    @XmlEnumValue("daeu")
    DAEU("daeu"),
    @XmlEnumValue("deust")
    DEUST("deust"),
    @XmlEnumValue("deug")
    DEUG("deug"),
    @XmlEnumValue("hdr")
    HDR("hdr"),
    @XmlEnumValue("ingenieur")
    INGENIEUR("ingenieur"),
    @XmlEnumValue("certificat")
    CERTIFICAT("certificat"),
    @XmlEnumValue("attestation")
    ATTESTATION("attestation"),
    @XmlEnumValue("capacite")
    CAPACITE("capacite");
    private final String value;

    DegreeValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DegreeValueType fromValue(String v) {
        for (DegreeValueType c: DegreeValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
