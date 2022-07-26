package main.model;

import java.io.Serializable;
import java.time.YearMonth;

public abstract class AbstractExperience extends OrganizationName implements Serializable {
    public YearMonth startDate;
    public YearMonth endDate;
    public String objective;

    public AbstractExperience(YearMonth startDate, YearMonth endDate, String title, String link, String objective) {
        super(title, link);
        this.startDate = startDate;
        this.endDate = endDate;
        this.objective = objective;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}