//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.04.05 à 06:20:23 PM CEST 
//


package xjc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xjc package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _OrgUnit_QNAME = new QName("", "orgUnit");
    private final static QName _Href_QNAME = new QName("", "href");
    private final static QName _Searchword_QNAME = new QName("", "searchword");
    private final static QName _Profession_QNAME = new QName("", "profession");
    private final static QName _StudyQualification_QNAME = new QName("", "studyQualification");
    private final static QName _LearningObjectives_QNAME = new QName("", "learningObjectives");
    private final static QName _TeachingStart_QNAME = new QName("", "teachingStart");
    private final static QName _RegistrationDeadline_QNAME = new QName("", "registrationDeadline");
    private final static QName _CancelDeadline_QNAME = new QName("", "cancelDeadline");
    private final static QName _RecommendedPrerequisites_QNAME = new QName("", "recommendedPrerequisites");
    private final static QName _FormalPrerequisites_QNAME = new QName("", "formalPrerequisites");
    private final static QName _InfoBlock_QNAME = new QName("", "infoBlock");
    private final static QName _TargetGroup_QNAME = new QName("", "targetGroup");
    private final static QName _ProgramStructure_QNAME = new QName("", "programStructure");
    private final static QName _Regulations_QNAME = new QName("", "regulations");
    private final static QName _StudyAbroad_QNAME = new QName("", "studyAbroad");
    private final static QName _UniversalAdjustment_QNAME = new QName("", "universalAdjustment");
    private final static QName _ContactData_QNAME = new QName("", "contactData");
    private final static QName _FormOfAssessment_QNAME = new QName("", "formOfAssessment");
    private final static QName _Syllabus_QNAME = new QName("", "syllabus");
    private final static QName _StudentFacilities_QNAME = new QName("", "studentFacilities");
    private final static QName _ProgramDescription_QNAME = new QName("", "programDescription");
    private final static QName _EvaluationDeadline_QNAME = new QName("", "evaluationDeadline");
    private final static QName _ExamStart_QNAME = new QName("", "examStart");
    private final static QName _ExamEnd_QNAME = new QName("", "examEnd");
    private final static QName _ExamLocation_QNAME = new QName("", "examLocation");
    private final static QName _TimetableElement_QNAME = new QName("", "timetableElement");
    private final static QName _Email_QNAME = new QName("", "email");
    private final static QName _InfoBlockTypeHeader_QNAME = new QName("", "header");
    private final static QName _InfoBlockTypeBold_QNAME = new QName("", "bold");
    private final static QName _InfoBlockTypeItalic_QNAME = new QName("", "italic");
    private final static QName _InfoBlockTypeList_QNAME = new QName("", "list");
    private final static QName _InfoBlockTypeStrong_QNAME = new QName("", "strong");
    private final static QName _InfoBlockTypeEmphasis_QNAME = new QName("", "emphasis");
    private final static QName _InfoBlockTypeSuperscript_QNAME = new QName("", "superscript");
    private final static QName _InfoBlockTypeSubscript_QNAME = new QName("", "subscript");
    private final static QName _InfoBlockTypePicture_QNAME = new QName("", "picture");
    private final static QName _InfoBlockTypeExtension_QNAME = new QName("", "extension");
    private final static QName _InfoBlockTypeSubBlock_QNAME = new QName("", "subBlock");
    private final static QName _InfoBlockTypeAltLangBlock_QNAME = new QName("", "altLangBlock");
    private final static QName _TextTypeText_QNAME = new QName("", "text");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xjc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CDM }
     * 
     */
    public CDM createCDM() {
        return new CDM();
    }

    /**
     * Create an instance of {@link ProgramType }
     * 
     */
    public ProgramType createProgramType() {
        return new ProgramType();
    }

    /**
     * Create an instance of {@link InfoBlockType }
     * 
     */
    public InfoBlockType createInfoBlockType() {
        return new InfoBlockType();
    }

    /**
     * Create an instance of {@link Adr }
     * 
     */
    public Adr createAdr() {
        return new Adr();
    }

    /**
     * Create an instance of {@link PersonType }
     * 
     */
    public PersonType createPersonType() {
        return new PersonType();
    }

    /**
     * Create an instance of {@link CourseType }
     * 
     */
    public CourseType createCourseType() {
        return new CourseType();
    }

    /**
     * Create an instance of {@link TeachingActivityType }
     * 
     */
    public TeachingActivityType createTeachingActivityType() {
        return new TeachingActivityType();
    }

    /**
     * Create an instance of {@link TimetableType }
     * 
     */
    public TimetableType createTimetableType() {
        return new TimetableType();
    }

    /**
     * Create an instance of {@link TimetableType.ReoccurringEvents }
     * 
     */
    public TimetableType.ReoccurringEvents createTimetableTypeReoccurringEvents() {
        return new TimetableType.ReoccurringEvents();
    }

    /**
     * Create an instance of {@link ExamType }
     * 
     */
    public ExamType createExamType() {
        return new ExamType();
    }

    /**
     * Create an instance of {@link ContactDataType }
     * 
     */
    public ContactDataType createContactDataType() {
        return new ContactDataType();
    }

    /**
     * Create an instance of {@link TextType }
     * 
     */
    public TextType createTextType() {
        return new TextType();
    }

    /**
     * Create an instance of {@link OrgUnitType }
     * 
     */
    public OrgUnitType createOrgUnitType() {
        return new OrgUnitType();
    }

    /**
     * Create an instance of {@link CDM.Properties }
     * 
     */
    public CDM.Properties createCDMProperties() {
        return new CDM.Properties();
    }

    /**
     * Create an instance of {@link Program }
     * 
     */
    public Program createProgram() {
        return new Program();
    }

    /**
     * Create an instance of {@link ProgramType.ProgramCode }
     * 
     */
    public ProgramType.ProgramCode createProgramTypeProgramCode() {
        return new ProgramType.ProgramCode();
    }

    /**
     * Create an instance of {@link WebLink }
     * 
     */
    public WebLink createWebLink() {
        return new WebLink();
    }

    /**
     * Create an instance of {@link Qualification }
     * 
     */
    public Qualification createQualification() {
        return new Qualification();
    }

    /**
     * Create an instance of {@link Credits }
     * 
     */
    public Credits createCredits() {
        return new Credits();
    }

    /**
     * Create an instance of {@link Br }
     * 
     */
    public Br createBr() {
        return new Br();
    }

    /**
     * Create an instance of {@link InfoBlockType.List }
     * 
     */
    public InfoBlockType.List createInfoBlockTypeList() {
        return new InfoBlockType.List();
    }

    /**
     * Create an instance of {@link RefOrgUnit }
     * 
     */
    public RefOrgUnit createRefOrgUnit() {
        return new RefOrgUnit();
    }

    /**
     * Create an instance of {@link RefProgram }
     * 
     */
    public RefProgram createRefProgram() {
        return new RefProgram();
    }

    /**
     * Create an instance of {@link RefCourse }
     * 
     */
    public RefCourse createRefCourse() {
        return new RefCourse();
    }

    /**
     * Create an instance of {@link RefPerson }
     * 
     */
    public RefPerson createRefPerson() {
        return new RefPerson();
    }

    /**
     * Create an instance of {@link Degree }
     * 
     */
    public Degree createDegree() {
        return new Degree();
    }

    /**
     * Create an instance of {@link Level }
     * 
     */
    public Level createLevel() {
        return new Level();
    }

    /**
     * Create an instance of {@link AdmissionInfo }
     * 
     */
    public AdmissionInfo createAdmissionInfo() {
        return new AdmissionInfo();
    }

    /**
     * Create an instance of {@link StudentPlaces }
     * 
     */
    public StudentPlaces createStudentPlaces() {
        return new StudentPlaces();
    }

    /**
     * Create an instance of {@link CDMdateTime }
     * 
     */
    public CDMdateTime createCDMdateTime() {
        return new CDMdateTime();
    }

    /**
     * Create an instance of {@link TeachingPlace }
     * 
     */
    public TeachingPlace createTeachingPlace() {
        return new TeachingPlace();
    }

    /**
     * Create an instance of {@link CDMlocation }
     * 
     */
    public CDMlocation createCDMlocation() {
        return new CDMlocation();
    }

    /**
     * Create an instance of {@link Adr.Locality }
     * 
     */
    public Adr.Locality createAdrLocality() {
        return new Adr.Locality();
    }

    /**
     * Create an instance of {@link FormOfTeaching }
     * 
     */
    public FormOfTeaching createFormOfTeaching() {
        return new FormOfTeaching();
    }

    /**
     * Create an instance of {@link ProgramDuration }
     * 
     */
    public ProgramDuration createProgramDuration() {
        return new ProgramDuration();
    }

    /**
     * Create an instance of {@link Expenses }
     * 
     */
    public Expenses createExpenses() {
        return new Expenses();
    }

    /**
     * Create an instance of {@link Contacts }
     * 
     */
    public Contacts createContacts() {
        return new Contacts();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link PersonType.Name }
     * 
     */
    public PersonType.Name createPersonTypeName() {
        return new PersonType.Name();
    }

    /**
     * Create an instance of {@link SubProgram }
     * 
     */
    public SubProgram createSubProgram() {
        return new SubProgram();
    }

    /**
     * Create an instance of {@link Course }
     * 
     */
    public Course createCourse() {
        return new Course();
    }

    /**
     * Create an instance of {@link CourseType.CourseCode }
     * 
     */
    public CourseType.CourseCode createCourseTypeCourseCode() {
        return new CourseType.CourseCode();
    }

    /**
     * Create an instance of {@link TeachingTerm }
     * 
     */
    public TeachingTerm createTeachingTerm() {
        return new TeachingTerm();
    }

    /**
     * Create an instance of {@link InstructionLanguage }
     * 
     */
    public InstructionLanguage createInstructionLanguage() {
        return new InstructionLanguage();
    }

    /**
     * Create an instance of {@link CourseType.TeachingActivity }
     * 
     */
    public CourseType.TeachingActivity createCourseTypeTeachingActivity() {
        return new CourseType.TeachingActivity();
    }

    /**
     * Create an instance of {@link CDMdate }
     * 
     */
    public CDMdate createCDMdate() {
        return new CDMdate();
    }

    /**
     * Create an instance of {@link CDMtime }
     * 
     */
    public CDMtime createCDMtime() {
        return new CDMtime();
    }

    /**
     * Create an instance of {@link TeachingActivityType.TeachingActivityStructure }
     * 
     */
    public TeachingActivityType.TeachingActivityStructure createTeachingActivityTypeTeachingActivityStructure() {
        return new TeachingActivityType.TeachingActivityStructure();
    }

    /**
     * Create an instance of {@link TimetableType.SingleEvent }
     * 
     */
    public TimetableType.SingleEvent createTimetableTypeSingleEvent() {
        return new TimetableType.SingleEvent();
    }

    /**
     * Create an instance of {@link TimetableType.ReoccurringEvents.OccurrenceRule }
     * 
     */
    public TimetableType.ReoccurringEvents.OccurrenceRule createTimetableTypeReoccurringEventsOccurrenceRule() {
        return new TimetableType.ReoccurringEvents.OccurrenceRule();
    }

    /**
     * Create an instance of {@link ExamType.ExamKind }
     * 
     */
    public ExamType.ExamKind createExamTypeExamKind() {
        return new ExamType.ExamKind();
    }

    /**
     * Create an instance of {@link ExamType.ExamDuration }
     * 
     */
    public ExamType.ExamDuration createExamTypeExamDuration() {
        return new ExamType.ExamDuration();
    }

    /**
     * Create an instance of {@link ExamType.ExamStructure }
     * 
     */
    public ExamType.ExamStructure createExamTypeExamStructure() {
        return new ExamType.ExamStructure();
    }

    /**
     * Create an instance of {@link ContactDataType.ContactName }
     * 
     */
    public ContactDataType.ContactName createContactDataTypeContactName() {
        return new ContactDataType.ContactName();
    }

    /**
     * Create an instance of {@link ContactDataType.Telephone }
     * 
     */
    public ContactDataType.Telephone createContactDataTypeTelephone() {
        return new ContactDataType.Telephone();
    }

    /**
     * Create an instance of {@link TextType.Text }
     * 
     */
    public TextType.Text createTextTypeText() {
        return new TextType.Text();
    }

    /**
     * Create an instance of {@link OrgUnitType.OrgUnitCode }
     * 
     */
    public OrgUnitType.OrgUnitCode createOrgUnitTypeOrgUnitCode() {
        return new OrgUnitType.OrgUnitCode();
    }

    /**
     * Create an instance of {@link OrgUnitType.OrgUnitKind }
     * 
     */
    public OrgUnitType.OrgUnitKind createOrgUnitTypeOrgUnitKind() {
        return new OrgUnitType.OrgUnitKind();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrgUnitType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrgUnitType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "orgUnit")
    public JAXBElement<OrgUnitType> createOrgUnit(OrgUnitType value) {
        return new JAXBElement<OrgUnitType>(_OrgUnit_QNAME, OrgUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "href")
    public JAXBElement<String> createHref(String value) {
        return new JAXBElement<String>(_Href_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "searchword")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createSearchword(String value) {
        return new JAXBElement<String>(_Searchword_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "profession")
    public JAXBElement<InfoBlockType> createProfession(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_Profession_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "studyQualification")
    public JAXBElement<InfoBlockType> createStudyQualification(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_StudyQualification_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "learningObjectives")
    public JAXBElement<InfoBlockType> createLearningObjectives(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_LearningObjectives_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CDMdateTime }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CDMdateTime }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "teachingStart")
    public JAXBElement<CDMdateTime> createTeachingStart(CDMdateTime value) {
        return new JAXBElement<CDMdateTime>(_TeachingStart_QNAME, CDMdateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CDMdateTime }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CDMdateTime }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "registrationDeadline")
    public JAXBElement<CDMdateTime> createRegistrationDeadline(CDMdateTime value) {
        return new JAXBElement<CDMdateTime>(_RegistrationDeadline_QNAME, CDMdateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CDMdateTime }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CDMdateTime }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "cancelDeadline")
    public JAXBElement<CDMdateTime> createCancelDeadline(CDMdateTime value) {
        return new JAXBElement<CDMdateTime>(_CancelDeadline_QNAME, CDMdateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "recommendedPrerequisites")
    public JAXBElement<InfoBlockType> createRecommendedPrerequisites(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_RecommendedPrerequisites_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "formalPrerequisites")
    public JAXBElement<InfoBlockType> createFormalPrerequisites(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_FormalPrerequisites_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "infoBlock")
    public JAXBElement<InfoBlockType> createInfoBlock(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_InfoBlock_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "targetGroup")
    public JAXBElement<InfoBlockType> createTargetGroup(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_TargetGroup_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "programStructure")
    public JAXBElement<InfoBlockType> createProgramStructure(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_ProgramStructure_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "regulations")
    public JAXBElement<InfoBlockType> createRegulations(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_Regulations_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "studyAbroad")
    public JAXBElement<InfoBlockType> createStudyAbroad(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_StudyAbroad_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "universalAdjustment")
    public JAXBElement<InfoBlockType> createUniversalAdjustment(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_UniversalAdjustment_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContactDataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ContactDataType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "contactData")
    public JAXBElement<ContactDataType> createContactData(ContactDataType value) {
        return new JAXBElement<ContactDataType>(_ContactData_QNAME, ContactDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "formOfAssessment")
    public JAXBElement<InfoBlockType> createFormOfAssessment(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_FormOfAssessment_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "syllabus")
    public JAXBElement<InfoBlockType> createSyllabus(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_Syllabus_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "studentFacilities")
    public JAXBElement<InfoBlockType> createStudentFacilities(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_StudentFacilities_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "programDescription")
    public JAXBElement<InfoBlockType> createProgramDescription(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_ProgramDescription_QNAME, InfoBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CDMdateTime }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CDMdateTime }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "evaluationDeadline")
    public JAXBElement<CDMdateTime> createEvaluationDeadline(CDMdateTime value) {
        return new JAXBElement<CDMdateTime>(_EvaluationDeadline_QNAME, CDMdateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CDMdateTime }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CDMdateTime }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "examStart")
    public JAXBElement<CDMdateTime> createExamStart(CDMdateTime value) {
        return new JAXBElement<CDMdateTime>(_ExamStart_QNAME, CDMdateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CDMdateTime }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CDMdateTime }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "examEnd")
    public JAXBElement<CDMdateTime> createExamEnd(CDMdateTime value) {
        return new JAXBElement<CDMdateTime>(_ExamEnd_QNAME, CDMdateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CDMlocation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CDMlocation }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "examLocation")
    public JAXBElement<CDMlocation> createExamLocation(CDMlocation value) {
        return new JAXBElement<CDMlocation>(_ExamLocation_QNAME, CDMlocation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimetableType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimetableType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "timetableElement")
    public JAXBElement<TimetableType> createTimetableElement(TimetableType value) {
        return new JAXBElement<TimetableType>(_TimetableElement_QNAME, TimetableType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "email")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createEmail(String value) {
        return new JAXBElement<String>(_Email_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "header", scope = InfoBlockType.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createInfoBlockTypeHeader(String value) {
        return new JAXBElement<String>(_InfoBlockTypeHeader_QNAME, String.class, InfoBlockType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "bold", scope = InfoBlockType.class)
    public JAXBElement<String> createInfoBlockTypeBold(String value) {
        return new JAXBElement<String>(_InfoBlockTypeBold_QNAME, String.class, InfoBlockType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "italic", scope = InfoBlockType.class)
    public JAXBElement<String> createInfoBlockTypeItalic(String value) {
        return new JAXBElement<String>(_InfoBlockTypeItalic_QNAME, String.class, InfoBlockType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType.List }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType.List }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "list", scope = InfoBlockType.class)
    public JAXBElement<InfoBlockType.List> createInfoBlockTypeList(InfoBlockType.List value) {
        return new JAXBElement<InfoBlockType.List>(_InfoBlockTypeList_QNAME, InfoBlockType.List.class, InfoBlockType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "strong", scope = InfoBlockType.class)
    public JAXBElement<String> createInfoBlockTypeStrong(String value) {
        return new JAXBElement<String>(_InfoBlockTypeStrong_QNAME, String.class, InfoBlockType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "emphasis", scope = InfoBlockType.class)
    public JAXBElement<String> createInfoBlockTypeEmphasis(String value) {
        return new JAXBElement<String>(_InfoBlockTypeEmphasis_QNAME, String.class, InfoBlockType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "superscript", scope = InfoBlockType.class)
    public JAXBElement<String> createInfoBlockTypeSuperscript(String value) {
        return new JAXBElement<String>(_InfoBlockTypeSuperscript_QNAME, String.class, InfoBlockType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "subscript", scope = InfoBlockType.class)
    public JAXBElement<String> createInfoBlockTypeSubscript(String value) {
        return new JAXBElement<String>(_InfoBlockTypeSubscript_QNAME, String.class, InfoBlockType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "email", scope = InfoBlockType.class)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createInfoBlockTypeEmail(String value) {
        return new JAXBElement<String>(_Email_QNAME, String.class, InfoBlockType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "picture", scope = InfoBlockType.class)
    public JAXBElement<InfoBlockType> createInfoBlockTypePicture(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_InfoBlockTypePicture_QNAME, InfoBlockType.class, InfoBlockType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "extension", scope = InfoBlockType.class)
    public JAXBElement<Object> createInfoBlockTypeExtension(Object value) {
        return new JAXBElement<Object>(_InfoBlockTypeExtension_QNAME, Object.class, InfoBlockType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "subBlock", scope = InfoBlockType.class)
    public JAXBElement<InfoBlockType> createInfoBlockTypeSubBlock(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_InfoBlockTypeSubBlock_QNAME, InfoBlockType.class, InfoBlockType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "altLangBlock", scope = InfoBlockType.class)
    public JAXBElement<InfoBlockType> createInfoBlockTypeAltLangBlock(InfoBlockType value) {
        return new JAXBElement<InfoBlockType>(_InfoBlockTypeAltLangBlock_QNAME, InfoBlockType.class, InfoBlockType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType.Text }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType.Text }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "text", scope = TextType.class)
    public JAXBElement<TextType.Text> createTextTypeText(TextType.Text value) {
        return new JAXBElement<TextType.Text>(_TextTypeText_QNAME, TextType.Text.class, TextType.class, value);
    }

}
