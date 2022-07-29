package main.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class DateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String v) {
        return null;
    }

    @Override
    public String marshal(LocalDate v) {
        return null;
    }
}
