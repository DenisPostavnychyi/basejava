package main.model;

import java.io.Serializable;
import java.time.YearMonth;

public abstract class AbstractExperience extends OrganizationName implements Serializable {
    protected YearMonth startDate;
    protected YearMonth endDate;
    protected String objective;

    public AbstractExperience(){
        super();
    }

    public AbstractExperience(YearMonth startDate, YearMonth endDate, String title, String link, String objective) {
        super(title, link);
        this.startDate = startDate;
        this.endDate = endDate;
        this.objective = objective;
    }

    public YearMonth getStartDate() {
        return startDate;
    }

    public YearMonth getEndDate() {
        return endDate;
    }

    public String getObjective() {
        return objective;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}