package org.freedesktop.appstream;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.List;
import org.junit.Test;

public class AppdataParserTest {



  final String APPSTREAM_TYPE_DESKTOP = "desktop";
  final String APPSTREAM_TYPE_RUNTIME = "runtime";
  final String ICON_BASE_RELATIVE_PATH = "/repo/appstream/x86_64/icons/";
  final String SCREENSHOT_TYPE_DEFAULT = "default";
  final String IMAGE_TYPE_THUMBNAIL = "thumbnail";
  final String IMAGE_TYPE_SOURCE = "source";

  final ClassLoader classLoader = getClass().getClassLoader();


  private void printAppdata(AppdataComponent component) {
    printAppdata(component, null);
  }

  private void printAppdata(AppdataComponent component, String lang) {

    System.out.println("Id:             " + component.getId());
    System.out.println("FlatpakId:      " + component.getFlatpakId());
    System.out.println("FlatpakRuntime: " + component.getFlatpakRuntime());

    if (lang != null && !"".equalsIgnoreCase(lang)) {

      System.out.println("Name:           " + component.findNameByLang(lang));
      System.out.println("Summary:        " + component.findSummaryByLang(lang));
      System.out.println("Description:\n" + component.findDescriptionByLang(lang));

    } else {
      System.out.println("Name:           " + component.findDefaultName());
      System.out.println("Summary:        " + component.findDefaultSummary());
      System.out.println("Description:\n" + component.findDefaultDescription());
    }

    //TODO:
    //Categories
    //Icons
    //Keywords (translatable)
    //kudos
    //Screenshots
    //Languages (percentage)
    //<bundle type="flatpak" runtime="org.gnome.Platform/x86_64/3.22" sdk="org.gnome.Sdk/x86_64/3.22">app/org.gnome.Weather/x86_64/stable</bundle>

  }


  @Test
  public void when_ParsingKde_Expect_ComponentInfoObtained() throws Exception {

    final int EXPECTED_COMPONENT_COUNT = 69;
    final int EXPECTED_APP_COUNT = 69;
    final int EXPECTED_RUNTIME_COUNT = 0;

    //Given
    List<AppdataComponent> componentList = null;
    int appCount = 0;
    int runtimeCount = 0;

    //When
    File file = new File(classLoader.getResource("appstream-kdeapps.xml").getFile());
    componentList = AppdataParser.parseAppdataFile(file);

    for (AppdataComponent component : componentList) {
      if (APPSTREAM_TYPE_DESKTOP.equalsIgnoreCase(component.getType())) {
        appCount++;
      } else {
        runtimeCount++;
      }
    }

    //Then
    assertThat(componentList).isNotNull();
    assertThat(componentList.size()).isEqualTo(EXPECTED_COMPONENT_COUNT);
    assertThat(appCount).isEqualTo(EXPECTED_APP_COUNT);
    assertThat(runtimeCount).isEqualTo(EXPECTED_RUNTIME_COUNT);

  }


  @Test
  public void when_ParsingEndlessOS_Expect_ComponentInfoObtained() throws Exception {

    final int EXPECTED_COMPONENT_COUNT = 631;
    final int EXPECTED_APP_COUNT = 631;
    final int EXPECTED_RUNTIME_COUNT = 0;

    //Given
    List<AppdataComponent> componentList = null;
    int appCount = 0;
    int runtimeCount = 0;

    //When
    File file = new File(classLoader.getResource("appstream-eos-apps.xml").getFile());
    componentList = AppdataParser.parseAppdataFile(file);

    for (AppdataComponent component : componentList) {
      if (APPSTREAM_TYPE_DESKTOP.equalsIgnoreCase(component.getType())) {
        appCount++;
      } else {
        runtimeCount++;
      }
    }

    //Then
    assertThat(componentList).isNotNull();
    assertThat(componentList.size()).isEqualTo(EXPECTED_COMPONENT_COUNT);
    assertThat(appCount).isEqualTo(EXPECTED_APP_COUNT);
    assertThat(runtimeCount).isEqualTo(EXPECTED_RUNTIME_COUNT);

  }

  @Test
  public void when_ParsingGnome_Expect_ComponentInfoObtained() throws Exception {

    final int EXPECTED_COMPONENT_COUNT = 24;
    final int EXPECTED_APP_COUNT = 24;
    final int EXPECTED_RUNTIME_COUNT = 0;

    //Given
    List<AppdataComponent> componentList = null;
    int appCount = 0;
    int runtimeCount = 0;

    //When
    File file = new File(classLoader.getResource("appstream-gnome-apps.xml").getFile());
    componentList = AppdataParser.parseAppdataFile(file);

    for (AppdataComponent component : componentList) {
      if (APPSTREAM_TYPE_DESKTOP.equalsIgnoreCase(component.getType())) {
        appCount++;
      } else {
        runtimeCount++;
      }
    }

    //Then
    assertThat(componentList).isNotNull();
    assertThat(componentList.size()).isEqualTo(EXPECTED_COMPONENT_COUNT);
    assertThat(appCount).isEqualTo(EXPECTED_APP_COUNT);
    assertThat(runtimeCount).isEqualTo(EXPECTED_RUNTIME_COUNT);

  }


  @Test
  public void when_ParsingFlathub_Expect_ComponentInfoObtained() throws Exception {

    final int EXPECTED_COMPONENT_COUNT = 252;
    final int EXPECTED_APP_COUNT = 209;
    final int EXPECTED_RUNTIME_COUNT = 43;

    //Given
    List<AppdataComponent> componentList = null;
    int appCount = 0;
    int runtimeCount = 0;

    //When
    File file = new File(classLoader.getResource("appstream-flathub-x86_64-201803.xml").getFile());
    componentList = AppdataParser.parseAppdataFile(file);

    for (AppdataComponent component : componentList) {
      if (APPSTREAM_TYPE_DESKTOP.equalsIgnoreCase(component.getType())) {
        appCount++;
      } else {
        runtimeCount++;
      }
    }

    //Then
    assertThat(componentList).isNotNull();
    assertThat(componentList.size()).isEqualTo(EXPECTED_COMPONENT_COUNT);
    assertThat(appCount).isEqualTo(EXPECTED_APP_COUNT);
    assertThat(runtimeCount).isEqualTo(EXPECTED_RUNTIME_COUNT);

  }


  @Test
  public void when_ParsingBuilder_Expect_ComponentInfoObtained() throws Exception {

    //Given
    String appDataResourceFile = "appstream-test-app-builder.xml";
    List<AppdataComponent> componentList = null;
    AppdataComponent component = null;
    String EXPECTED_FLATPAKID ="org.gnome.Builder";
    String EXPECTED_RUNTIME = "org.gnome.Sdk/x86_64/3.26";
    String EXPECTED_DEFAULT_NAME = "Builder";
    String EXPECTED_DEFAULT_SUMMARY = "An IDE for GNOME";
    String EXPECTED_DEFAULT_DESCRIPTION = "<p>Builder is an actively developed Integrated Development Environment for GNOME. It combines integrated support for essential GNOME technologies such as GTK+, GLib, and GNOME APIs with features that any developer will appreciate, like syntax highlighting and snippets.</p>\n"
      + "<p>You can rely on predictable releases of Builder with each new release of GNOME every six months.</p>\n"
      + "<p>Features:</p>\n"
      + "<ul>\n"
      + "<li>Built in syntax highlighting for many languages</li>\n"
      + "<li>Side-by-side code editors</li>\n"
      + "<li>Integration with Git</li>\n"
      + "<li>Integration with Autotools, Cargo, CMake, Meson, Make, and PHPize</li>\n"
      + "<li>Clang based auto-completion, semantic highlighting, and diagnostics</li>\n"
      + "<li>Python based auto-completion, semantic highlighting, and diagnostics</li>\n"
      + "<li>Vala based auto-completion and diagnostics</li>\n"
      + "<li>Auto indentation support for C, Python, Vala, and XML</li>\n"
      + "<li>HTML, Markdown, and reStructuredText, and Sphinx live preview</li>\n"
      + "<li>Optional Vim-style editing</li>\n"
      + "<li>An integrated software profiler for native applications</li>\n"
      + "<li>An integrated debugger for native applications</li>\n"
      + "<li>Support for building with jhbuild and flatpak runtimes</li>\n"
      + "</ul>\n";

    String EXPECTED_HOMEPAGE_URL = "https://wiki.gnome.org/Apps/Builder";
    String EXPECTED_DONATION_URL = "http://www.gnome.org/friends/";
    String EXPECTED_BUGTRACKER_URL = "https://bugzilla.gnome.org/enter_bug.cgi?product=gnome-builder";


    String EXPECTED_PROJECT_LICENSE = "GPL-3.0+ and GPL-2.0+ and LGPL-3.0+ and LGPL-2.0+ and MIT";

    short EXPECTED_ICONHEIGHT_128 = 128;
    String EXPECTED_ICONURL_128 = "/repo/appstream/x86_64/icons/128x128/org.gnome.Builder.png";
    short EXPECTED_ICONHEIGHT_64 = 64;
    String EXPECTED_ICONURL_64 = "/repo/appstream/x86_64/icons/64x64/org.gnome.Builder.png";
    int EXPECTED_SCREENSHOT_COUNT = 6;
    short EXPECTED_SCHEENSHOT0_HEIGHT = 846;
    String EXPECTED_SCREENSHOT0_URL = "https://flathub.org/repo/screenshots/org.gnome.Builder-stable/1504x846/org.gnome.Builder-3582853b1ad4a82da236a964983cef7c.png";
    short EXPECTED_SCHEENSHOT1_HEIGHT = 351;
    String EXPECTED_SCREENSHOT1_URL = "https://flathub.org/repo/screenshots/org.gnome.Builder-stable/624x351/org.gnome.Builder-19b4818c4fda40f94d8e6ccc1379dc6d.png";

    int EXPECTEC_CATEGORY_COUNT = 2;
    String EXPECTED_CATEGORY_FIRST = "Development";

    String EXPECTED_RELEASE_VERSION = "3.26.4";
    String EXPECTED_RELEASE_DESCRIPTION  = "<p>This new release of Builder contains a number of bug fixes found during the 3.26 cycle. It is recommended that you update.</p>\n"
      + "<ul>\n"
      + "<li>Various memory leak improvements.</li>\n"
      + "<li>Meson plugin no longer uses the legacy \"mesonintrospect\" utility.</li>\n"
      + "<li>Block selection in the terminal has been restored.</li>\n"
      + "<li>The flatpak exporter now properly determines the target application binary from the manifest.</li>\n"
      + "</ul>\n"
      + "\n";
    int EXPECTED_RELEASE_TIMESTAMP = 1517356800;

    //When
    File file = new File(classLoader.getResource(appDataResourceFile).getFile());
    componentList = AppdataParser.parseAppdataFile(file);
    if (componentList != null) {
      component = componentList.get(0);
    }

    //Then
    assertThat(componentList).isNotNull();
    assertThat(componentList.size()).isEqualTo(1);
    assertThat(component.getType()).isEqualToIgnoringCase(APPSTREAM_TYPE_DESKTOP);
    assertThat(component.getFlatpakId()).isEqualToIgnoringCase(EXPECTED_FLATPAKID);
    assertThat(component.getFlatpakRuntime()).isEqualToIgnoringCase(EXPECTED_RUNTIME);
    assertThat(component.findDefaultName()).isEqualToIgnoringCase(EXPECTED_DEFAULT_NAME);
    assertThat(component.findDefaultSummary()).isEqualToIgnoringCase(EXPECTED_DEFAULT_SUMMARY);
    assertThat(component.findDefaultDescription()).isEqualToIgnoringCase(EXPECTED_DEFAULT_DESCRIPTION);
    assertThat(component.getProjectLicense()).isEqualToIgnoringCase(EXPECTED_PROJECT_LICENSE);

    assertThat(component.findHomepageUrl().get()).isEqualToIgnoringCase(EXPECTED_HOMEPAGE_URL);
    assertThat(component.findDonationUrl().get()).isEqualToIgnoringCase(EXPECTED_DONATION_URL);
    assertThat(component.findBugtrackerUrl().get()).isEqualToIgnoringCase(EXPECTED_BUGTRACKER_URL);


    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_128).getHeight()).isEqualTo(EXPECTED_ICONHEIGHT_128);
    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_128).getValue()).isNotNull();
    assertThat(component.findIconUrl(ICON_BASE_RELATIVE_PATH, EXPECTED_ICONHEIGHT_128)).isEqualToIgnoringCase(EXPECTED_ICONURL_128);

    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_64).getHeight()).isEqualTo(EXPECTED_ICONHEIGHT_64);
    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_64).getValue()).isNotNull();
    assertThat(component.findIconUrl(ICON_BASE_RELATIVE_PATH, EXPECTED_ICONHEIGHT_64)).isEqualToIgnoringCase(EXPECTED_ICONURL_64);

    assertThat(component.getScreenshots().size()).isEqualTo(EXPECTED_SCREENSHOT_COUNT);
    assertThat(component.getScreenshots().get(0).findThumbnailUrlByHeight(EXPECTED_SCHEENSHOT0_HEIGHT)).isPresent();
    assertThat(component.getScreenshots().get(0).findThumbnailUrlByHeight(EXPECTED_SCHEENSHOT0_HEIGHT).get()).isEqualToIgnoringCase(EXPECTED_SCREENSHOT0_URL);

    assertThat(component.getCategories()).isNotNull();
    assertThat(component.getCategories().getCategory().size()).isEqualTo(EXPECTEC_CATEGORY_COUNT);
    assertThat(component.getCategories().getCategory().get(0)).isEqualToIgnoringCase(EXPECTED_CATEGORY_FIRST);


    assertThat(component.findReleaseInfoByMostRecent()).isPresent();
    assertThat(component.findReleaseInfoByMostRecent().get().getVersion()).isEqualToIgnoringCase(EXPECTED_RELEASE_VERSION);
    assertThat(component.findReleaseInfoByMostRecent().get().getTimestamp()).isEqualTo(EXPECTED_RELEASE_TIMESTAMP);
    assertThat(component.findReleaseInfoByMostRecent().get().getDescription()).isEqualTo(EXPECTED_RELEASE_DESCRIPTION);

  }

  @Test
  public void when_ParsingBuilderTranslations_Expect_ComponentInfoObtained() throws Exception {

    //Given
    String appDataResourceFile = "appstream-test-app-builder.xml";
    String LANG = "pt";
    List<AppdataComponent> componentList = null;
    AppdataComponent component = null;
    String EXPECTED_DEFAULT_NAME = "Construtor";
    String EXPECTED_DEFAULT_SUMMARY = "Um IDE para o GNOME";
    String EXPECTED_DEFAULT_DESCRIPTION = "<p>Construtor é um Ambiente de Desenvolvimento Integrado (IDE) em desenvolvimentoativo. Combina suporte integrado para tecnologias GNOME essenciais tal como o GTK+, GLib, e as GNOME APIs com características que qualquer programador irá apreciar, como snippets e realce de sintaxe.</p>\n"
      + "<p>Pode contar com novos lançamentos do Construtor a cada novo lançamento do GNOME, cada seis meses.</p>\n"
      + "<p>Características:</p>\n"
      + "<ul>\n"
      + "<li>Crie com realce de sintaxe para muitas linguagens</li>\n"
      + "<li>Editores de código lado-a-lado</li>\n"
      + "<li>Integração com Git</li>\n"
      + "<li>Conclusão automática baseada em Clang, realce semântico, e diagnósticos</li>\n"
      + "<li>Conclusão automática baseada em Python, realce semântico, e diagnósticos</li>\n"
      + "<li>Conclusão automática baseada em Vala e diagnósticos</li>\n"
      + "<li>Suporte de auto indentação para C, Python, Vala e XML</li>\n"
      + "<li>Edição estilo-Vim opcional</li>\n"
      + "<li>Um perfil integrado de programas para programas nativos</li>\n"
      + "</ul>\n";

    //When
    File file = new File(classLoader.getResource(appDataResourceFile).getFile());
    componentList = AppdataParser.parseAppdataFile(file);
    if (componentList != null) {
      component = componentList.get(0);
    }

    //Then
    assertThat(componentList).isNotNull();
    assertThat(component.findNameByLang(LANG)).isEqualToIgnoringCase(EXPECTED_DEFAULT_NAME);
    assertThat(component.findSummaryByLang(LANG)).isEqualToIgnoringCase(EXPECTED_DEFAULT_SUMMARY);
    assertThat(component.findDescriptionByLang(LANG)).isEqualToIgnoringCase(EXPECTED_DEFAULT_DESCRIPTION);

  }

  @Test
  public void when_ParsingDiscord_Expect_ComponentInfoObtained() throws Exception {

    //Given
    String appDataResourceFile = "appstream-test-app-discord.xml";
    List<AppdataComponent> componentList = null;
    AppdataComponent component = null;
    String EXPECTED_FLATPAKID ="com.discordapp.Discord";
    String EXPECTED_RUNTIME = "org.freedesktop.Platform/x86_64/1.6";
    String EXPECTED_DEFAULT_NAME = "Discord";
    String EXPECTED_DEFAULT_SUMMARY = "Chat client";
    String EXPECTED_DEFAULT_DESCRIPTION = "<p>All-in-one voice and text chat for gamers that's free, secure, and works on both your desktop and phone. Stop paying for TeamSpeak servers and hassling with Skype. Simplify your life.</p>\n";

    String EXPECTED_PROJECT_LICENSE = "LicenseRef-proprietary";

    short EXPECTED_ICONHEIGHT_128 = 128;
    String EXPECTED_ICONURL_128 = "https://lh3.googleusercontent.com/_4zBNFjA8S9yjNB_ONwqBvxTvyXYdC7Nh1jYZ2x6YEcldBr2fyijdjM2J5EoVdTpnkA=w256";
    short EXPECTED_ICONHEIGHT_64 = 64;
    String EXPECTED_ICONURL_64 = "https://lh3.googleusercontent.com/_4zBNFjA8S9yjNB_ONwqBvxTvyXYdC7Nh1jYZ2x6YEcldBr2fyijdjM2J5EoVdTpnkA=w256";
    int EXPECTED_SCREENSHOT_COUNT = 2;
    short EXPECTED_SCHEENSHOT_HEIGHT = 423;
    String EXPECTED_SCREENSHOT_URL = "https://flathub.org/repo/screenshots/com.discordapp.Discord-stable/752x423/com.discordapp.Discord-37a5e4d4631fa5155a87bb08d30da1b0.png";
    int EXPECTEC_CATEGORY_COUNT = 2;
    String EXPECTED_CATEGORY_FIRST = "InstantMessaging";

    //When
    File file = new File(classLoader.getResource(appDataResourceFile).getFile());
    componentList = AppdataParser.parseAppdataFile(file);
    if (componentList != null) {
      component = componentList.get(0);
    }

    //Then
    assertThat(componentList).isNotNull();
    assertThat(componentList.size()).isEqualTo(1);
    assertThat(component.getType()).isEqualToIgnoringCase(APPSTREAM_TYPE_DESKTOP);
    assertThat(component.getFlatpakId()).isEqualToIgnoringCase(EXPECTED_FLATPAKID);
    assertThat(component.getFlatpakRuntime()).isEqualToIgnoringCase(EXPECTED_RUNTIME);
    assertThat(component.findDefaultName()).isEqualToIgnoringCase(EXPECTED_DEFAULT_NAME);
    assertThat(component.findDefaultSummary()).isEqualToIgnoringCase(EXPECTED_DEFAULT_SUMMARY);
    assertThat(component.findDefaultDescription()).isEqualToIgnoringCase(EXPECTED_DEFAULT_DESCRIPTION);
    assertThat(component.getProjectLicense()).isEqualToIgnoringCase(EXPECTED_PROJECT_LICENSE);

    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_128)).isNull();
    assertThat(component.findIconUrl(ICON_BASE_RELATIVE_PATH, EXPECTED_ICONHEIGHT_128)).isEqualToIgnoringCase(EXPECTED_ICONURL_128);

    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_64)).isNull();
    assertThat(component.findIconUrl(ICON_BASE_RELATIVE_PATH, EXPECTED_ICONHEIGHT_64)).isEqualToIgnoringCase(EXPECTED_ICONURL_64);

    assertThat(component.getScreenshots().size()).isEqualTo(EXPECTED_SCREENSHOT_COUNT);
    assertThat(component.getScreenshots().get(0).findThumbnailUrlByHeight(EXPECTED_SCHEENSHOT_HEIGHT)).isPresent();
    assertThat(component.getScreenshots().get(0).findThumbnailUrlByHeight(EXPECTED_SCHEENSHOT_HEIGHT).get()).isEqualToIgnoringCase(EXPECTED_SCREENSHOT_URL);

    assertThat(component.getCategories()).isNotNull();
    assertThat(component.getCategories().getCategory().size()).isEqualTo(EXPECTEC_CATEGORY_COUNT);
    assertThat(component.getCategories().getCategory().get(0)).isEqualToIgnoringCase(EXPECTED_CATEGORY_FIRST);

  }

  @Test
  public void when_ParsingKdenlive_Expect_ComponentInfoObtained() throws Exception {

    //Given
    String appDataResourceFile = "appstream-test-app-kdenlive.xml";
    List<AppdataComponent> componentList = null;
    AppdataComponent component = null;
    String EXPECTED_FLATPAKID ="org.kde.kdenlive";
    String EXPECTED_RUNTIME = "org.kde.Platform/x86_64/5.9";
    String EXPECTED_DEFAULT_NAME = "Kdenlive";
    String EXPECTED_DEFAULT_SUMMARY = "Video Editor";
    String EXPECTED_DEFAULT_DESCRIPTION = "<p>Kdenlive is a non linear video editor. It is based on the MLT framework and accepts many audio and video formats, allows you to add effects, transitions and render into the format of your choice.</p>\n"
      + "<p>Features:</p>\n"
      + "<ul>\n"
      + "<li>Intuitive multitrack interface.</li>\n"
      + "<li>Many effects and transitions.</li>\n"
      + "<li>Color scopes</li>\n"
      + "<li>Basic DVD Wizard</li>\n"
      + "</ul>\n";

    String EXPECTED_PROJECT_LICENSE = "GPL-2.0+";

    short EXPECTED_ICONHEIGHT_128 = 128;
    String EXPECTED_ICONURL_128 = "/repo/appstream/x86_64/icons/128x128/org.kde.kdenlive.png";
    short EXPECTED_ICONHEIGHT_64 = 64;
    String EXPECTED_ICONURL_64 = "/repo/appstream/x86_64/icons/64x64/org.kde.kdenlive.png";
    int EXPECTED_SCREENSHOT_COUNT = 1;
    short EXPECTED_SCHEENSHOT_HEIGHT = 423;
    String EXPECTED_SCREENSHOT_URL = "https://flathub.org/repo/screenshots/org.kde.kdenlive-stable/752x423/org.kde.kdenlive-097e6cd6748a6b371b413b947f956a0e.png";
    int EXPECTEC_CATEGORY_COUNT = 2;
    String EXPECTED_CATEGORY_FIRST = "AudioVideo";

    //When
    File file = new File(classLoader.getResource(appDataResourceFile).getFile());
    componentList = AppdataParser.parseAppdataFile(file);
    if (componentList != null) {
      component = componentList.get(0);
    }

    //Then
    assertThat(componentList).isNotNull();
    assertThat(componentList.size()).isEqualTo(1);
    assertThat(component.getType()).isEqualToIgnoringCase(APPSTREAM_TYPE_DESKTOP);
    assertThat(component.getFlatpakId()).isEqualToIgnoringCase(EXPECTED_FLATPAKID);
    assertThat(component.getFlatpakRuntime()).isEqualToIgnoringCase(EXPECTED_RUNTIME);
    assertThat(component.findDefaultName()).isEqualToIgnoringCase(EXPECTED_DEFAULT_NAME);
    assertThat(component.findDefaultSummary()).isEqualToIgnoringCase(EXPECTED_DEFAULT_SUMMARY);
    assertThat(component.findDefaultDescription()).isEqualToIgnoringCase(EXPECTED_DEFAULT_DESCRIPTION);
    assertThat(component.getProjectLicense()).isEqualToIgnoringCase(EXPECTED_PROJECT_LICENSE);

    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_128).getHeight()).isEqualTo(EXPECTED_ICONHEIGHT_128);
    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_128).getValue()).isNotNull();
    assertThat(component.findIconUrl(ICON_BASE_RELATIVE_PATH, EXPECTED_ICONHEIGHT_128)).isEqualToIgnoringCase(EXPECTED_ICONURL_128);

    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_64).getHeight()).isEqualTo(EXPECTED_ICONHEIGHT_64);
    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_64).getValue()).isNotNull();
    assertThat(component.findIconUrl(ICON_BASE_RELATIVE_PATH, EXPECTED_ICONHEIGHT_64)).isEqualToIgnoringCase(EXPECTED_ICONURL_64);

    assertThat(component.getScreenshots().size()).isEqualTo(EXPECTED_SCREENSHOT_COUNT);
    assertThat(component.getScreenshots().get(0).findThumbnailUrlByHeight(EXPECTED_SCHEENSHOT_HEIGHT)).isPresent();
    assertThat(component.getScreenshots().get(0).findThumbnailUrlByHeight(EXPECTED_SCHEENSHOT_HEIGHT).get()).isEqualToIgnoringCase(EXPECTED_SCREENSHOT_URL);

    assertThat(component.getCategories()).isNotNull();
    assertThat(component.getCategories().getCategory().size()).isEqualTo(EXPECTEC_CATEGORY_COUNT);
    assertThat(component.getCategories().getCategory().get(0)).isEqualToIgnoringCase(EXPECTED_CATEGORY_FIRST);
  }

  @Test
  public void when_ParsingVim_Expect_ComponentInfoObtained() throws Exception {

    //Given
    String appDataResourceFile = "appstream-test-app-vim.xml";
    List<AppdataComponent> componentList = null;
    AppdataComponent component = null;
    String EXPECTED_FLATPAKID ="org.vim.Vim";
    String EXPECTED_RUNTIME = "org.freedesktop.Platform/x86_64/1.6";
    String EXPECTED_DEFAULT_NAME = "Vim";
    String EXPECTED_DEFAULT_SUMMARY = "Edit text files";
    String EXPECTED_DEFAULT_DESCRIPTION = "<p>Vim is an advanced text editor that seeks to provide the power of the de-facto Unix editor 'Vi', with a more complete feature set. It's useful whether you're already using vi or using a different editor.</p>\n"
      + "<p>Vim is a highly configurable text editor built to enable efficient text editing. Vim is often called a \"programmer's editor,\" and so useful for programming that many consider it an entire IDE. It is not just for programmers, though. Vim is perfect for all kinds of text editing, from composing email to editing configuration files.</p>\n";

    String EXPECTED_PROJECT_LICENSE = "Vim";

    short EXPECTED_ICONHEIGHT_128 = 128;
    String EXPECTED_ICONURL_128 = "/repo/appstream/x86_64/icons/128x128/org.vim.Vim.png";
    short EXPECTED_ICONHEIGHT_64 = 64;
    String EXPECTED_ICONURL_64 = "/repo/appstream/x86_64/icons/64x64/org.vim.Vim.png";
    int EXPECTED_SCREENSHOT_COUNT = 1;
    short EXPECTED_SCHEENSHOT_HEIGHT = 423;
    String EXPECTED_SCREENSHOT_URL = "https://flathub.org/repo/screenshots/org.vim.Vim-stable/752x423/org.vim.Vim-b8bde54ac7d233817a6d3ef72792e564.png";
    int EXPECTEC_CATEGORY_COUNT = 2;
    String EXPECTED_CATEGORY_FIRST = "TextEditor";

    //When
    File file = new File(classLoader.getResource(appDataResourceFile).getFile());
    componentList = AppdataParser.parseAppdataFile(file);
    if (componentList != null) {
      component = componentList.get(0);
    }

    //Then
    assertThat(componentList).isNotNull();
    assertThat(componentList.size()).isEqualTo(1);
    assertThat(component.getType()).isEqualToIgnoringCase(APPSTREAM_TYPE_DESKTOP);
    assertThat(component.getFlatpakId()).isEqualToIgnoringCase(EXPECTED_FLATPAKID);
    assertThat(component.getFlatpakRuntime()).isEqualToIgnoringCase(EXPECTED_RUNTIME);
    assertThat(component.findDefaultName()).isEqualToIgnoringCase(EXPECTED_DEFAULT_NAME);
    assertThat(component.findDefaultSummary()).isEqualToIgnoringCase(EXPECTED_DEFAULT_SUMMARY);
    assertThat(component.findDefaultDescription()).isEqualToIgnoringCase(EXPECTED_DEFAULT_DESCRIPTION);
    assertThat(component.getProjectLicense()).isEqualToIgnoringCase(EXPECTED_PROJECT_LICENSE);

    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_128).getHeight()).isEqualTo(EXPECTED_ICONHEIGHT_128);
    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_128).getValue()).isNotNull();
    assertThat(component.findIconUrl(ICON_BASE_RELATIVE_PATH, EXPECTED_ICONHEIGHT_128)).isEqualToIgnoringCase(EXPECTED_ICONURL_128);

    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_64).getHeight()).isEqualTo(EXPECTED_ICONHEIGHT_64);
    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_64).getValue()).isNotNull();
    assertThat(component.findIconUrl(ICON_BASE_RELATIVE_PATH, EXPECTED_ICONHEIGHT_64)).isEqualToIgnoringCase(EXPECTED_ICONURL_64);

    assertThat(component.getScreenshots().size()).isEqualTo(EXPECTED_SCREENSHOT_COUNT);
    assertThat(component.getScreenshots().get(0).findThumbnailUrlByHeight(EXPECTED_SCHEENSHOT_HEIGHT)).isPresent();
    assertThat(component.getScreenshots().get(0).findThumbnailUrlByHeight(EXPECTED_SCHEENSHOT_HEIGHT).get()).isEqualToIgnoringCase(EXPECTED_SCREENSHOT_URL);

    assertThat(component.getCategories()).isNotNull();
    assertThat(component.getCategories().getCategory().size()).isEqualTo(EXPECTEC_CATEGORY_COUNT);
    assertThat(component.getCategories().getCategory().get(0)).isEqualToIgnoringCase(EXPECTED_CATEGORY_FIRST);
  }

  @Test
  public void when_ParsingLbry_Expect_ComponentInfoObtained() throws Exception {

    //Given
    String appDataResourceFile = "appstream-test-app-lbry.xml";
    List<AppdataComponent> componentList = null;
    AppdataComponent component = null;
    String EXPECTED_FLATPAKID ="io.lbry.lbry-app";
    String EXPECTED_RUNTIME = "org.freedesktop.Platform/x86_64/1.6";
    String EXPECTED_DEFAULT_NAME = "LBRY";
    String EXPECTED_DEFAULT_SUMMARY = "A browser and wallet for LBRY, the decentralized, user-controlled content marketplace.";
    String EXPECTED_DEFAULT_DESCRIPTION = "<p>LBRY is a free, open, and community-run digital marketplace.</p>\n"
      + "<p>You own your data. You control the network. Indeed, you are the network.</p>\n"
      + "<p>Hollywood films, college lessons, amazing streamers and more are on the first media network ruled by you.</p>\n";

    String EXPECTED_PROJECT_LICENSE = "MIT";

    short EXPECTED_ICONHEIGHT_128 = 128;
    String EXPECTED_ICONURL_128 = "/repo/appstream/x86_64/icons/128x128/io.lbry.lbry-app.png";
    short EXPECTED_ICONHEIGHT_64 = 64;
    String EXPECTED_ICONURL_64 = "/repo/appstream/x86_64/icons/64x64/io.lbry.lbry-app.png";
    int EXPECTED_SCREENSHOT_COUNT = 5;
    short EXPECTED_SCHEENSHOT_HEIGHT = 846;
    String EXPECTED_SCREENSHOT_URL = "https://flathub.org/repo/screenshots/io.lbry.lbry-app-stable/1504x846/io.lbry.lbry-app-21533f305ef79994d2c3a678b3e6cd60.png";
    int EXPECTEC_CATEGORY_COUNT = 2;
    String EXPECTED_CATEGORY_FIRST = "AudioVideo";

    //When
    File file = new File(classLoader.getResource(appDataResourceFile).getFile());
    componentList = AppdataParser.parseAppdataFile(file);
    if (componentList != null) {
      component = componentList.get(0);
    }

    //Then
    assertThat(componentList).isNotNull();
    assertThat(componentList.size()).isEqualTo(1);
    assertThat(component.getType()).isEqualToIgnoringCase(APPSTREAM_TYPE_DESKTOP);
    assertThat(component.getFlatpakId()).isEqualToIgnoringCase(EXPECTED_FLATPAKID);
    assertThat(component.getFlatpakRuntime()).isEqualToIgnoringCase(EXPECTED_RUNTIME);
    assertThat(component.findDefaultName()).isEqualToIgnoringCase(EXPECTED_DEFAULT_NAME);
    assertThat(component.findDefaultSummary()).isEqualToIgnoringCase(EXPECTED_DEFAULT_SUMMARY);
    assertThat(component.findDefaultDescription()).isEqualToIgnoringCase(EXPECTED_DEFAULT_DESCRIPTION);
    assertThat(component.getProjectLicense()).isEqualToIgnoringCase(EXPECTED_PROJECT_LICENSE);

    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_128).getHeight()).isEqualTo(EXPECTED_ICONHEIGHT_128);
    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_128).getValue()).isNotNull();
    assertThat(component.findIconUrl(ICON_BASE_RELATIVE_PATH, EXPECTED_ICONHEIGHT_128)).isEqualToIgnoringCase(EXPECTED_ICONURL_128);

    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_64).getHeight()).isEqualTo(EXPECTED_ICONHEIGHT_64);
    assertThat(component.findIconByHeight(EXPECTED_ICONHEIGHT_64).getValue()).isNotNull();
    assertThat(component.findIconUrl(ICON_BASE_RELATIVE_PATH, EXPECTED_ICONHEIGHT_64)).isEqualToIgnoringCase(EXPECTED_ICONURL_64);

    assertThat(component.getScreenshots().size()).isEqualTo(EXPECTED_SCREENSHOT_COUNT);
    assertThat(component.getScreenshots().get(0).findThumbnailUrlByHeight(EXPECTED_SCHEENSHOT_HEIGHT)).isPresent();
    assertThat(component.getScreenshots().get(0).findThumbnailUrlByHeight(EXPECTED_SCHEENSHOT_HEIGHT).get()).isEqualToIgnoringCase(EXPECTED_SCREENSHOT_URL);


    assertThat(component.getCategories()).isNotNull();
    assertThat(component.getCategories().getCategory().size()).isEqualTo(EXPECTEC_CATEGORY_COUNT);
    assertThat(component.getCategories().getCategory().get(0)).isEqualToIgnoringCase(EXPECTED_CATEGORY_FIRST);
  }

  @Test
  public void when_ParsingGnomeRuntime_Expect_ComponentInfoObtained() throws Exception {

    //Given
    String appDataResourceFile = "appstream-test-runtime-gnome.xml";
    List<AppdataComponent> componentList = null;
    AppdataComponent component = null;
    String EXPECTED_FLATPAKID ="org.gnome.Platform";
    String EXPECTED_RUNTIME = "org.gnome.Platform/x86_64/3.26";
    String EXPECTED_DEFAULT_NAME = "GNOME Application Platform version 3.26";
    String EXPECTED_DEFAULT_SUMMARY = "Shared libraries used by GNOME applications";
    String EXPECTED_DEFAULT_DESCRIPTION = "";
    String EXPECTED_HOMEPAGE_URL = "http://www.gnome.org/";
    String EXPECTED_PROJECT_LICENSE = "GPL-2.0+";

    //When
    File file = new File(classLoader.getResource(appDataResourceFile).getFile());
    componentList = AppdataParser.parseAppdataFile(file);
    if (componentList != null) {
      component = componentList.get(0);
    }

    //Then
    assertThat(componentList).isNotNull();
    assertThat(componentList.size()).isEqualTo(1);
    assertThat(component.getType()).isEqualToIgnoringCase(APPSTREAM_TYPE_RUNTIME);
    assertThat(component.getFlatpakId()).isEqualToIgnoringCase(EXPECTED_FLATPAKID);
    assertThat(component.getFlatpakRuntime()).isEqualToIgnoringCase(EXPECTED_RUNTIME);
    assertThat(component.findDefaultName()).isEqualToIgnoringCase(EXPECTED_DEFAULT_NAME);
    assertThat(component.findDefaultSummary()).isEqualToIgnoringCase(EXPECTED_DEFAULT_SUMMARY);
    assertThat(component.findDefaultDescription()).isEqualToIgnoringCase(EXPECTED_DEFAULT_DESCRIPTION);
    assertThat(component.getProjectLicense()).isEqualToIgnoringCase(EXPECTED_PROJECT_LICENSE);

    assertThat(component.findHomepageUrl()).isPresent();
    assertThat(component.findHomepageUrl().get()).isEqualToIgnoringCase(EXPECTED_HOMEPAGE_URL);
    assertThat(component.findDonationUrl()).isNotPresent();
  }



  @Test
  public void when_ParsingGtk3ThemeAdapta_Expect_ComponentInfoObtained() throws Exception {

    //Given
    String appDataResourceFile = "appstream-test-runtime-gtk3theme-adapta.xml";
    List<AppdataComponent> componentList = null;
    AppdataComponent component = null;
    String EXPECTED_FLATPAKID ="org.gtk.Gtk3theme.Adapta";
    String EXPECTED_RUNTIME = "org.gnome.Sdk/x86_64/3.26";
    String EXPECTED_DEFAULT_NAME = "Adapta Gtk+ theme";
    String EXPECTED_DEFAULT_SUMMARY = "Adapta Gtk+ theme";
    String EXPECTED_DEFAULT_DESCRIPTION = "<p>An adaptive Gtk+ theme based on Material Design</p>\n";
    String EXPECTED_HOMEPAGE_URL = "https://github.com/adapta-project/adapta-gtk-theme";
    String EXPECTED_PROJECT_LICENSE = null;

    //When
    File file = new File(classLoader.getResource(appDataResourceFile).getFile());
    componentList = AppdataParser.parseAppdataFile(file);
    if (componentList != null) {
      component = componentList.get(0);
    }

    //Then
    assertThat(componentList).isNotNull();
    assertThat(componentList.size()).isEqualTo(1);
    assertThat(component.getType()).isEqualToIgnoringCase(APPSTREAM_TYPE_RUNTIME);
    assertThat(component.getFlatpakId()).isEqualToIgnoringCase(EXPECTED_FLATPAKID);
    assertThat(component.getFlatpakRuntime()).isEqualToIgnoringCase(EXPECTED_RUNTIME);
    assertThat(component.findDefaultName()).isEqualToIgnoringCase(EXPECTED_DEFAULT_NAME);
    assertThat(component.findDefaultSummary()).isEqualToIgnoringCase(EXPECTED_DEFAULT_SUMMARY);
    assertThat(component.findDefaultDescription()).isEqualToIgnoringCase(EXPECTED_DEFAULT_DESCRIPTION);
    assertThat(component.getProjectLicense()).isEqualToIgnoringCase(EXPECTED_PROJECT_LICENSE);

    assertThat(component.findHomepageUrl()).isPresent();
    assertThat(component.findHomepageUrl().get()).isEqualToIgnoringCase(EXPECTED_HOMEPAGE_URL);
    assertThat(component.findDonationUrl()).isNotPresent();
  }

  @Test
  public void when_ParsingOpenJdk9_Expect_ComponentInfoObtained() throws Exception {

    //Given
    String appDataResourceFile = "appstream-test-runtime-openjdk9.xml";
    List<AppdataComponent> componentList = null;
    AppdataComponent component = null;
    String EXPECTED_FLATPAKID ="org.freedesktop.Sdk.Extension.openjdk9";
    String EXPECTED_RUNTIME = "org.freedesktop.Sdk/x86_64/1.6";
    String EXPECTED_DEFAULT_NAME = "OpenJdk 9 Sdk extension";
    String EXPECTED_DEFAULT_SUMMARY = "OpenJdk 9 Sdk extension";
    String EXPECTED_DEFAULT_DESCRIPTION = "<p>This SDK extension allows you to build java apps.</p>\n";
    String EXPECTED_PROJECT_LICENSE = null;

    //When
    File file = new File(classLoader.getResource(appDataResourceFile).getFile());
    componentList = AppdataParser.parseAppdataFile(file);
    if (componentList != null) {
      component = componentList.get(0);
    }

    //Then
    assertThat(componentList).isNotNull();
    assertThat(componentList.size()).isEqualTo(1);
    assertThat(component.getType()).isEqualToIgnoringCase(APPSTREAM_TYPE_RUNTIME);
    assertThat(component.getFlatpakId()).isEqualToIgnoringCase(EXPECTED_FLATPAKID);
    assertThat(component.getFlatpakRuntime()).isEqualToIgnoringCase(EXPECTED_RUNTIME);
    assertThat(component.findDefaultName()).isEqualToIgnoringCase(EXPECTED_DEFAULT_NAME);
    assertThat(component.findDefaultSummary()).isEqualToIgnoringCase(EXPECTED_DEFAULT_SUMMARY);
    assertThat(component.findDefaultDescription()).isEqualToIgnoringCase(EXPECTED_DEFAULT_DESCRIPTION);
    assertThat(component.getProjectLicense()).isEqualToIgnoringCase(EXPECTED_PROJECT_LICENSE);

  }


}
