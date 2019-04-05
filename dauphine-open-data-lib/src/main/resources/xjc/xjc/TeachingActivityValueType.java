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
 * <p>Classe Java pour teachingActivityValueType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="teachingActivityValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="coursMagistral"/&gt;
 *     &lt;enumeration value="seminaire"/&gt;
 *     &lt;enumeration value="colloque"/&gt;
 *     &lt;enumeration value="travauxDiriges"/&gt;
 *     &lt;enumeration value="travauxPratiques"/&gt;
 *     &lt;enumeration value="projetIndividuel"/&gt;
 *     &lt;enumeration value="projetEnGroupe"/&gt;
 *     &lt;enumeration value="travauxDeLaboratoire"/&gt;
 *     &lt;enumeration value="etudeBibliographique"/&gt;
 *     &lt;enumeration value="exercices"/&gt;
 *     &lt;enumeration value="devoir"/&gt;
 *     &lt;enumeration value="stage"/&gt;
 *     &lt;enumeration value="correspondance"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "teachingActivityValueType")
@XmlEnum
public enum TeachingActivityValueType {

    @XmlEnumValue("coursMagistral")
    COURS_MAGISTRAL("coursMagistral"),
    @XmlEnumValue("seminaire")
    SEMINAIRE("seminaire"),
    @XmlEnumValue("colloque")
    COLLOQUE("colloque"),
    @XmlEnumValue("travauxDiriges")
    TRAVAUX_DIRIGES("travauxDiriges"),
    @XmlEnumValue("travauxPratiques")
    TRAVAUX_PRATIQUES("travauxPratiques"),
    @XmlEnumValue("projetIndividuel")
    PROJET_INDIVIDUEL("projetIndividuel"),
    @XmlEnumValue("projetEnGroupe")
    PROJET_EN_GROUPE("projetEnGroupe"),
    @XmlEnumValue("travauxDeLaboratoire")
    TRAVAUX_DE_LABORATOIRE("travauxDeLaboratoire"),
    @XmlEnumValue("etudeBibliographique")
    ETUDE_BIBLIOGRAPHIQUE("etudeBibliographique"),
    @XmlEnumValue("exercices")
    EXERCICES("exercices"),
    @XmlEnumValue("devoir")
    DEVOIR("devoir"),
    @XmlEnumValue("stage")
    STAGE("stage"),
    @XmlEnumValue("correspondance")
    CORRESPONDANCE("correspondance");
    private final String value;

    TeachingActivityValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TeachingActivityValueType fromValue(String v) {
        for (TeachingActivityValueType c: TeachingActivityValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
