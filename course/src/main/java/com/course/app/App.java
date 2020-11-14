package com.course.app;

import org.joda.time.DateTime;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {

        // Create Students
        Student john = new Student("John", 21, "01/01/1999");
        Student mary = new Student("Mary", 20, "01/01/2000");
        Student tom = new Student("Tom", 20, "10/10/2000");
        Student kate = new Student("Kate", 21, "11/03/1999");

        // Create modules + add students to modules
        Module softwareEngineering = new Module("Software Engineering");
        softwareEngineering.addStudent(john);
        softwareEngineering.addStudent(mary);
        softwareEngineering.addStudent(kate);

        Module machineLearning = new Module("Machine Learning");
        machineLearning.addStudent(tom);
        machineLearning.addStudent(kate);

        Module realTimeSystems = new Module("Real Time Systems");
        realTimeSystems.addStudent(john);
        realTimeSystems.addStudent(mary);
        realTimeSystems.addStudent(tom);
        realTimeSystems.addStudent(kate);

        // Create course + add modules
        Course computerScience = new Course("Computer Science", DateTime.now(), DateTime.now().plusWeeks(12));
        computerScience.addModule(softwareEngineering);
        computerScience.addModule(machineLearning);

        // Print Computer Science Details
        String courseDetails = "Course name: " + computerScience.getCourseName() +
                "\nStart date: " + computerScience.getStartDate() +
                "\nEnd date: " + computerScience.getEndDate();
        System.out.println(courseDetails);

        System.out.println("---------------------");

        // Modules in course
        System.out.println("Modules in course:");
        for (Module module: computerScience.getModuleList()) {
            System.out.println(module.getModuleName());
            System.out.println("\tStudents enrolled:");
            for (Student student: module.getStudentList())
                System.out.println("\t- "+student.getUsername());
        }

        System.out.println("---------------------");

        // All students enrolled in course
        System.out.println("Students in course");
        for (Student student: computerScience.getStudents())
            System.out.println(student);


        System.out.println("---------------------");

        // Show modules for given student & course
        System.out.println("Tom's modules & courses:");
        System.out.println("- Course: " + tom.getCourse().iterator().next().getCourseName());
        for (Module module: tom.getModuleList())
            System.out.println("\t- Module: " + module.getModuleName());
    }
}
