package DesignPattern.CreationalDesignPattern.ExampleOfBuilderDesignPattern;

public class Director {
    StudentBuilder studentBuilder;

    Director(StudentBuilder studentBuilder) {this.studentBuilder = studentBuilder;}

    public Student createStudent()
    {
        if(studentBuilder instanceof EngineeringStudentBuilder)
        {
            return createEngineeringStudent();
        }
        else if(studentBuilder instanceof  MBAStudentBuilder)
        {
            return createMBAStudent();
        }
        return null;
    }

    private Student createEngineeringStudent()
    {
        return studentBuilder.setRollNumber(1).setAge(22).setName("Naman").setSubjects().build();
    }

    private Student createMBAStudent()
    {
        return studentBuilder.setRollNumber(1).setAge(22).setName("Rahul").setFatherName("Rajnish").setMotherName("Nisha").setSubjects().build();

    }

}
