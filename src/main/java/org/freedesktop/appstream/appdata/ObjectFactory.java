//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.06 at 06:51:53 AM CET 
//


package org.freedesktop.appstream.appdata;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.freedesktop.appstream.appdata package. 
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

    private final static QName _P_QNAME = new QName("", "p");
    private final static QName _Kudo_QNAME = new QName("", "kudo");
    private final static QName _Binary_QNAME = new QName("", "binary");
    private final static QName _DeveloperName_QNAME = new QName("", "developer_name");
    private final static QName _Description_QNAME = new QName("", "description");
    private final static QName _Mimetype_QNAME = new QName("", "mimetype");
    private final static QName _Id_QNAME = new QName("", "id");
    private final static QName _Category_QNAME = new QName("", "category");
    private final static QName _ProjectGroup_QNAME = new QName("", "project_group");
    private final static QName _Li_QNAME = new QName("", "li");
    private final static QName _ProjectLicense_QNAME = new QName("", "project_license");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.freedesktop.appstream.appdata
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Metadata }
     * 
     */
    public Metadata createMetadata() {
        return new Metadata();
    }

    /**
     * Create an instance of {@link Value }
     * 
     */
    public Value createValue() {
        return new Value();
    }

    /**
     * Create an instance of {@link Components }
     * 
     */
    public Components createComponents() {
        return new Components();
    }

    /**
     * Create an instance of {@link Component }
     * 
     */
    public Component createComponent() {
        return new Component();
    }

    /**
     * Create an instance of {@link Translation }
     * 
     */
    public Translation createTranslation() {
        return new Translation();
    }

    /**
     * Create an instance of {@link Name }
     * 
     */
    public Name createName() {
        return new Name();
    }

    /**
     * Create an instance of {@link Summary }
     * 
     */
    public Summary createSummary() {
        return new Summary();
    }

    /**
     * Create an instance of {@link Description }
     * 
     */
    public Description createDescription() {
        return new Description();
    }

    /**
     * Create an instance of {@link Icon }
     * 
     */
    public Icon createIcon() {
        return new Icon();
    }

    /**
     * Create an instance of {@link Categories }
     * 
     */
    public Categories createCategories() {
        return new Categories();
    }

    /**
     * Create an instance of {@link Keywords }
     * 
     */
    public Keywords createKeywords() {
        return new Keywords();
    }

    /**
     * Create an instance of {@link Keyword }
     * 
     */
    public Keyword createKeyword() {
        return new Keyword();
    }

    /**
     * Create an instance of {@link Kudos }
     * 
     */
    public Kudos createKudos() {
        return new Kudos();
    }

    /**
     * Create an instance of {@link Mimetypes }
     * 
     */
    public Mimetypes createMimetypes() {
        return new Mimetypes();
    }

    /**
     * Create an instance of {@link Url }
     * 
     */
    public Url createUrl() {
        return new Url();
    }

    /**
     * Create an instance of {@link Screenshots }
     * 
     */
    public Screenshots createScreenshots() {
        return new Screenshots();
    }

    /**
     * Create an instance of {@link Screenshot }
     * 
     */
    public Screenshot createScreenshot() {
        return new Screenshot();
    }

    /**
     * Create an instance of {@link Image }
     * 
     */
    public Image createImage() {
        return new Image();
    }

    /**
     * Create an instance of {@link ContentRating }
     * 
     */
    public ContentRating createContentRating() {
        return new ContentRating();
    }

    /**
     * Create an instance of {@link ContentAttribute }
     * 
     */
    public ContentAttribute createContentAttribute() {
        return new ContentAttribute();
    }

    /**
     * Create an instance of {@link Releases }
     * 
     */
    public Releases createReleases() {
        return new Releases();
    }

    /**
     * Create an instance of {@link Release }
     * 
     */
    public Release createRelease() {
        return new Release();
    }

    /**
     * Create an instance of {@link Languages }
     * 
     */
    public Languages createLanguages() {
        return new Languages();
    }

    /**
     * Create an instance of {@link Lang }
     * 
     */
    public Lang createLang() {
        return new Lang();
    }

    /**
     * Create an instance of {@link Provides }
     * 
     */
    public Provides createProvides() {
        return new Provides();
    }

    /**
     * Create an instance of {@link Bundle }
     * 
     */
    public Bundle createBundle() {
        return new Bundle();
    }

    /**
     * Create an instance of {@link Ul }
     * 
     */
    public Ul createUl() {
        return new Ul();
    }

    /**
     * Create an instance of {@link Ol }
     * 
     */
    public Ol createOl() {
        return new Ol();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "p")
    public JAXBElement<String> createP(String value) {
        return new JAXBElement<String>(_P_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "kudo")
    public JAXBElement<String> createKudo(String value) {
        return new JAXBElement<String>(_Kudo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "binary")
    public JAXBElement<String> createBinary(String value) {
        return new JAXBElement<String>(_Binary_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "developer_name")
    public JAXBElement<String> createDeveloperName(String value) {
        return new JAXBElement<String>(_DeveloperName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Description }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "description")
    public JAXBElement<Description> createDescription(Description value) {
        return new JAXBElement<Description>(_Description_QNAME, Description.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mimetype")
    public JAXBElement<String> createMimetype(String value) {
        return new JAXBElement<String>(_Mimetype_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id")
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "category")
    public JAXBElement<String> createCategory(String value) {
        return new JAXBElement<String>(_Category_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "project_group")
    public JAXBElement<String> createProjectGroup(String value) {
        return new JAXBElement<String>(_ProjectGroup_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "li")
    public JAXBElement<String> createLi(String value) {
        return new JAXBElement<String>(_Li_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "project_license")
    public JAXBElement<String> createProjectLicense(String value) {
        return new JAXBElement<String>(_ProjectLicense_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "p", scope = Description.class)
    public JAXBElement<String> createDescriptionP(String value) {
        return new JAXBElement<String>(_P_QNAME, String.class, Description.class, value);
    }

}
