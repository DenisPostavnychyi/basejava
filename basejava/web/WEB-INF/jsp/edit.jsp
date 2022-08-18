<%@ page import="main.util.DateUtil" %>
<%@ page import="main.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:useBean id="resume" type="main.model.Resume" scope="request"/>
    <title>Резюме ${resume.fullName}</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <form method="post" action="resume" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <h1>Ім'я:</h1>
        <dl>
            <input type="text" name="fullName" size=50 value="${resume.fullName}">
        </dl>
        <h2>Контакти:</h2>
        <c:forEach var="type" items="<%=ContactType.values()%>">
            <dl>
                <dt>${type.title}</dt>
                <dd><input type="text" name="${type.name()}" size=30 value="${resume.getContact(type)}"></dd>
            </dl>
        </c:forEach>
        <hr>
        <h3>Секції:</h3>
        <c:forEach var="type" items="<%=SectionType.values()%>">
            <c:set var="section" value="${resume.getSection(type)}"/>
            <jsp:useBean id="section" type="main.model.Section"/>
            <h2><a>${type.title}</a></h2>
            <c:choose>
                <c:when test="${type=='OBJECTIVE'}">
                    <input type='text' name='${type}' size=75 value='<%=section%>'>
                </c:when>
                <c:when test="${type=='PERSONAL'}">
                    <textarea name='${type}' cols=75 rows=5><%=section%></textarea>
                </c:when>
                <c:when test="${type=='QUALIFICATIONS' || type=='ACHIEVEMENT'}">
                    <textarea name='${type}' cols=75
                              rows=5><%=String.join("\n", ((AchievementAndQualifications) section).getElements())%></textarea>
                </c:when>
                <c:when test="${type=='EXPERIENCE'}">
                    <c:forEach var="org" items="<%=((ExperienceWorkSection) section).getExperiences()%>" varStatus="counter">
                        <dl>
                            <dt>Назва установи:</dt>
                            <dd><input type="text" name='${type}' size=100 value="${org.title}"></dd>
                        </dl>
                        <dl>
                            <dt>Сайт установи:</dt>
                            <dd><input type="text" name='${type}url' size=100 value="${org.link}"></dd>
                            </dd>
                        </dl>
                        <br>
                        <div style="margin-left: 30px">
                            <c:forEach var="expWork" items="<%=AbstractExperience.getExperiences()%>">
                                <jsp:useBean id="expWork" type="main.model.ExperienceWork"/>
                                <dl>
                                    <dt>Початкова дата:</dt>
                                    <dd>
                                        <input type="text" name="${type}${counter.index}startDate" size=10
                                               value="<%=DateUtil.format(expWork.getStartDate())%>" placeholder="MM/yyyy">
                                    </dd>
                                </dl>
                                <dl>
                                    <dt>Кінцева дата:</dt>
                                    <dd>
                                        <input type="text" name="${type}${counter.index}endDate" size=10
                                               value="<%=DateUtil.format(expWork.getEndDate())%>" placeholder="MM/yyyy">
                                </dl>
                                <dl>
                                    <dt>Посада:</dt>
                                    <dd><input type="text" name='${type}${counter.index}title' size=75
                                               value="${expWork.getObjective()}">
                                </dl>
                                <dl>
                                    <dt>Опис:</dt>
                                    <dd><textarea name="${type}${counter.index}description" rows=5
                                                  cols=75>${expWork.getDescription()}</textarea></dd>
                                </dl>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </c:when>
                <c:when test="${type=='EDUCATION'}">
                    <c:forEach var="org" items="<%=((ExperienceEducationSection) section).getEducations()%>" varStatus="counter">
                        <dl>
                            <dt>Назва установи:</dt>
                            <dd><input type="text" name='${type}' size=100 value="${org.title}"></dd>
                        </dl>
                        <dl>
                            <dt>Сайт установи:</dt>
                            <dd><input type="text" name='${type}url' size=100 value="${org.link}"></dd>
                            </dd>
                        </dl>
                        <br>
                        <div style="margin-left: 30px">
                            <c:forEach var="expEdu" items="<%=AbstractExperience.getExperiences()%>">
                                <jsp:useBean id="expEdu" type="main.model.ExperienceEducation"/>
                                <dl>
                                    <dt>Початкова дата:</dt>
                                    <dd>
                                        <input type="text" name="${type}${counter.index}startDate" size=10
                                               value="<%=DateUtil.format(expEdu.getStartDate())%>" placeholder="MM/yyyy">
                                    </dd>
                                </dl>
                                <dl>
                                    <dt>Кінцева дата:</dt>
                                    <dd>
                                        <input type="text" name="${type}${counter.index}endDate" size=10
                                               value="<%=DateUtil.format(expEdu.getEndDate())%>" placeholder="MM/yyyy">
                                </dl>
                                <dl>
                                    <dt>Посада:</dt>
                                    <dd><input type="text" name='${type}${counter.index}title' size=75
                                               value="${expEdu.getObjective()}">
                                </dl>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </c:when>
            </c:choose>
        </c:forEach>
        <button type="submit">Зберегти</button>
        <button onclick="window.history.back()">Відмінити</button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

