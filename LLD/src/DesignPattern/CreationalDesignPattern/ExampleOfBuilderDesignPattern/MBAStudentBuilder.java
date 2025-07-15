package DesignPattern.CreationalDesignPattern.ExampleOfBuilderDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class MBAStudentBuilder extends  StudentBuilder{
    @Override
    public  StudentBuilder setSubjects()
    {
        List<String> subs = new ArrayList<>();
        subs.add("Economics");
        subs.add("Finanace");

        this.subjects = subs;
        return this;
    }
}
