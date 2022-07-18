package test;

import main.model.*;
import main.service.ResumeService;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

import static main.model.ContactType.*;
import static main.model.SectionType.*;

public class ResumeTestData {
    public static void main(String[] args) throws FileNotFoundException {
        main.model.Resume resume = new main.model.Resume("uuid1", "Григорий Кислин");
        Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
        contacts.put(MOBILE_PHONE, "+7(921) 855-0482");
        contacts.put(HOME_PHONE, "+7(921) 855-0482");
        contacts.put(SKYPE, "skype:grigory.kislin");
        contacts.put(MAIL, "gkislin@yandex.ru");
        contacts.put(LINKEDIN, "https://www.linkedin.com/in/gkislin");
        contacts.put(GITHUB, "https://github.com/gkislin");
        contacts.put(STATCKOVERFLOW, "https://stackoverflow.com/users/548473");
        contacts.put(HOME_PAGE, "http://gkislin.ru/");
        resume.setContacts(contacts);


        Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);
        sections.put(OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        sections.put(PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

        sections.put(ACHIEVEMENT, new ListSection(ConvertToList("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет\n" +
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.\n" +
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.\n" +
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.\n" +
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.\n" +
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).\n" +
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.")));

        sections.put(QUALIFICATIONS, new ListSection(ConvertToList("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2\n" +
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce\n" +
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB\n" +
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy\n" +
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts\n" +
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).\n" +
                "Python: Django.\n" +
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js\n" +
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka\n" +
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.\n" +
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix\n" +
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer\n" +
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования\n" +
                "Родной русский, английский \"upper intermediate\"\n")));

        sections.put(EXPERIENCE, new ExperienceWorkSection(createExperienceWork()));

        sections.put(EDUCATION, new ExperienceEducationSection(createExperienceEducation()));

        resume.setSections(sections);

        ResumeService resumeService = new ResumeService();
        resumeService.print(resume);
    }

    private static List<ExperienceEducation> createExperienceEducation() {
        List<ExperienceEducation> experienceEducation = new ArrayList<>();

        experienceEducation.add(new ExperienceEducation(LocalDate.of(2013, 3, 1), LocalDate.of(2013, 5, 1), "Coursera", "https://www.coursera.org/course/progfun", "'Functional Programming Principles in Scala' by Martin Odersky"));
        experienceEducation.add(new ExperienceEducation(LocalDate.of(2011, 3, 1), LocalDate.of(2011, 4, 1), "Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'"));
        experienceEducation.add(new ExperienceEducation(LocalDate.of(2005, 1, 1), LocalDate.of(2005, 4, 1), "Siemens AG", "http://www.siemens.ru/", "3 месяца обучения мобильным IN сетям (Берлин)"));
        experienceEducation.add(new ExperienceEducation(LocalDate.of(1997, 9, 1), LocalDate.of(1998, 3, 1), "Alcatel", "http://www.alcatel.ru/", "6 месяцев обучения цифровым телефонным сетям (Москва)"));
        experienceEducation.add(new ExperienceEducation(LocalDate.of(1993, 9, 1), LocalDate.of(1996, 7, 1), "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/", "Аспирантура (программист С, С++)"));
        experienceEducation.add(new ExperienceEducation(LocalDate.of(1987, 9, 1), LocalDate.of(1993, 7, 1), "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/", "Инженер (программист Fortran, C)"));
        experienceEducation.add(new ExperienceEducation(LocalDate.of(1984, 9, 1), LocalDate.of(1987, 6, 1), "Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/", "Закончил с отличием"));

        return experienceEducation;
    }

    private static List<ExperienceWork> createExperienceWork() {
        List<ExperienceWork> experienceWork = new ArrayList<>();

        experienceWork.add(new ExperienceWork(LocalDate.of(2013, 10, 1), LocalDate.now(), "Java Online Projects", "http://javaops.ru/", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."));
        experienceWork.add(new ExperienceWork(LocalDate.of(2014, 10, 1), LocalDate.of(2016, 1, 1), "Wrike", "https://www.wrike.com/", "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));
        experienceWork.add(new ExperienceWork(LocalDate.of(2012, 4, 1), LocalDate.of(2014, 10, 1), "RIT Center", "", "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"));
        experienceWork.add(new ExperienceWork(LocalDate.of(2010, 12, 1), LocalDate.of(2012, 4, 1), "Luxoft (Deutsche Bank)", "http://www.luxoft.ru/", "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."));
        experienceWork.add(new ExperienceWork(LocalDate.of(2008, 6, 1), LocalDate.of(2010, 12, 1), "Yota", "https://www.yota.ru/", "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"));
        experienceWork.add(new ExperienceWork(LocalDate.of(2007, 3, 1), LocalDate.of(2008, 6, 1), "Enkata", "http://enkata.com/", "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."));
        experienceWork.add(new ExperienceWork(LocalDate.of(2005, 1, 1), LocalDate.of(2007, 2, 1), "Siemens AG", "https://www.siemens.com/ru/ru/home.html", "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."));
        experienceWork.add(new ExperienceWork(LocalDate.of(1997, 9, 1), LocalDate.of(2005, 1, 1), "Alcatel", "http://www.alcatel.ru/", "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));

        return experienceWork;
    }

    private static List<String> ConvertToList(String info) {
        String[] strings = info.split("\n");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, strings);
        return list;
    }
}
