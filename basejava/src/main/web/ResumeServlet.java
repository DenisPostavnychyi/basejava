package main.web;

import main.Config;
import main.model.*;
import main.storage.Storage;
import main.util.HtmlUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class ResumeServlet extends HttpServlet {

    private Storage storage; //= Config.get().getStorage();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = Config.get().getStorage();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uuid = request.getParameter("uuid");
        String fullName = request.getParameter("fullName");

        final boolean isCreate = (uuid == null || uuid.length() == 0);
        Resume resume;
        if (isCreate) {
            resume = new Resume(fullName);
        } else {
            resume = storage.get(uuid);
            resume.setFullName(fullName);
        }

        for (ContactType type : ContactType.values()) {
            String value = request.getParameter(type.name());
            if (HtmlUtil.isEmpty(value)) {
                resume.getContacts().remove(type);
            } else {
                resume.setContact(type, value);
            }
        }

        for (SectionType type : SectionType.values()) {
            String value = request.getParameter(type.name());
            String[] values = request.getParameterValues(type.name());
            if (HtmlUtil.isEmpty(value)) {
                resume.getSections().remove(type);
            } else {
                switch (type){
                    case PERSONAL:
                    case OBJECTIVE:
                        resume.setSection(type, new PersonalAndObjective(value));
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        resume.setSection(type, new AchievementAndQualifications(value));
                        break;
                    case EXPERIENCE:
                        List<ExperienceWork> workList = new ArrayList<>();
                        for (int i = 0; i < values.length; i++) {
                            String name = values[i];
                            if (!HtmlUtil.isEmpty(name)) {
                                List<ExperienceWork> positions  = new ArrayList<>();
                                String pfx = type.name() + i;
                                String[] startDates = request.getParameterValues(pfx + "startDate");
                                String[] endDates = request.getParameterValues(pfx + "endDate");
                                String[] titles = request.getParameterValues(pfx + "title");
                                String[] titleLinks = request.getParameterValues(pfx + "titleLink");
                                String[] objectives = request.getParameterValues(pfx + "objective");
                                String[] descriptions = request.getParameterValues(pfx + "description");
                                for (int j = 0; j < titles.length; j++) {
                                    if (!HtmlUtil.isEmpty(titles[j])) {
                                        positions.add(new ExperienceWork(YearMonth.parse(startDates[j]), YearMonth.parse(endDates[j]), titles[j], titleLinks[j], objectives[j], descriptions[j]));
                                    }
                                }
                                //workList.add(new ExperienceWork(positions));
                            }
                        }
                        resume.setSection(type, new ExperienceWorkSection(workList));
                        break;
                    case EDUCATION:
                        List<ExperienceEducation> educationList = new ArrayList<>();
                        for (int i = 0; i < values.length; i++) {
                            String name = values[i];
                            if (!HtmlUtil.isEmpty(name)) {
                                List<ExperienceEducation> positions  = new ArrayList<>();
                                String pfx = type.name() + i;
                                String[] startDates = request.getParameterValues(pfx + "startDate");
                                String[] endDates = request.getParameterValues(pfx + "endDate");
                                String[] titles = request.getParameterValues(pfx + "title");
                                String[] titleLinks = request.getParameterValues(pfx + "titleLink");
                                String[] objectives = request.getParameterValues(pfx + "objective");
                                for (int j = 0; j < titles.length; j++) {
                                    if (!HtmlUtil.isEmpty(titles[j])) {
                                        positions.add(new ExperienceEducation(YearMonth.parse(startDates[j]), YearMonth.parse(endDates[j]), titles[j], titleLinks[j], objectives[j]));
                                    }
                                }
                                educationList.add(new ExperienceEducation(positions));
                            }
                        }
                        resume.setSection(type, new ExperienceEducationSection(educationList));
                        break;
                }
            }
        }

        if (isCreate) {
            storage.save(resume);
        } else {
            storage.update(resume);
        }
        response.sendRedirect("resume");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String uuid = request.getParameter("uuid");
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("resumes", storage.getAllSorted());
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
            return;
        }

        Resume resume;
        switch (action) {
            case "delete":
                storage.delete(uuid);
                response.sendRedirect("resume");
                return;
            case "view":
                resume = storage.get(uuid);
                break;
            case "add":
                resume = Resume.EMPTY;
                break;
            case "edit":
                resume = storage.get(uuid);
                for (SectionType type : SectionType.values()) {
                    Section section = resume.getSection(type);
                    switch (type) {
                        case OBJECTIVE:
                        case PERSONAL:
                            if (section == null) {
                                section = PersonalAndObjective.EMPTY;
                            }
                            break;
                        case ACHIEVEMENT:
                        case QUALIFICATIONS:
                            if (section == null) {
                                section = AchievementAndQualifications.EMPTY;
                            }
                            break;
                        case EXPERIENCE:
                            ExperienceWorkSection workSection = (ExperienceWorkSection) section;
                            List<ExperienceWork> emptyFirstWork = new ArrayList<>();
                            //emptyFirstWork.add(ExperienceWork.EMPTY);
                            if (workSection != null) {
                                for (ExperienceWork org : workSection.getExperiences()) {
                                    emptyFirstWork.add(ExperienceWork.EMPTY);
                                    //emptyFirstWork.addAll(org.getPositions());
                                }
                            }
                            section = new ExperienceWorkSection(emptyFirstWork);
                            break;
                        case EDUCATION:
                            ExperienceEducationSection orgSection = (ExperienceEducationSection) section;
                            List<ExperienceEducation> emptyFirstEducation = new ArrayList<>();
                            //emptyFirstEducation.add(ExperienceEducation.EMPTY);
                            if (orgSection != null) {
                                for (ExperienceEducation org : orgSection.getEducations()) {
                                    emptyFirstEducation.add(ExperienceEducation.EMPTY);
                                    //emptyFirstEducation.addAll(org.getPositions());
                                }
                            }
                            section = new ExperienceEducationSection(emptyFirstEducation);
                            break;
                    }
                    resume.setSection(type, section);
                }
                break;
            default:
                throw new IllegalArgumentException("Action " + action + " is illegal");
        }

        request.setAttribute("resume", resume);
        request.getRequestDispatcher(
                ("view".equals(action) ? "/WEB-INF/jsp/view.jsp" : "/WEB-INF/jsp/edit.jsp")
        ).forward(request, response);
    }
}
