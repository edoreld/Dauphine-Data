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
 * <p>Classe Java pour examFormValueType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="examFormValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="ecrit"/&gt;
 *     &lt;enumeration value="oral"/&gt;
 *     &lt;enumeration value="pratique"/&gt;
 *     &lt;enumeration value="surDossier"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "examFormValueType")
@XmlEnum
public enum ExamFormValueType {

    @XmlEnumValue("ecrit")
    ECRIT("ecrit"),
    @XmlEnumValue("oral")
    ORAL("oral"),
    @XmlEnumValue("pratique")
    PRATIQUE("pratique"),
    @XmlEnumValue("surDossier")
    SUR_DOSSIER("surDossier");
    private final String value;

    ExamFormValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExamFormValueType fromValue(String v) {
        for (ExamFormValueType c: ExamFormValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
