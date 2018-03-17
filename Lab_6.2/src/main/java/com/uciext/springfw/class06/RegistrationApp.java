package com.uciext.springfw.class06;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.uciext.springfw.class06.courses.model.Course;
import com.uciext.springfw.class06.courses.model.Department;
import com.uciext.springfw.class06.courses.model.Schedule;
import com.uciext.springfw.class06.courses.service.CourseService;
import com.uciext.springfw.class06.students.model.Registration;
import com.uciext.springfw.class06.students.model.Student;
import com.uciext.springfw.class06.students.service.StudentService;

@SpringBootApplication
@ImportResource(locations = {
"file:./src/main/resources/META-INF/spring/RegistrationConfig.xml"
})
public class RegistrationApp {

    public static void main(String[] args) throws Exception {
    	SpringApplication.run(RegistrationApp.class, args);
        System.out.println("Application Started.");
        
        RegistrationApp app = new RegistrationApp();
        app.run();
    }
    
    public void run() {
    	ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("/META-INF/spring/RegistrationConfig.xml");
        CourseService courseService = (CourseService) context.getBean("courseService");
        StudentService studentService = (StudentService) context.getBean("studentService");

        // Departments
    	System.out.println("\n==== Get Departments ...");
        List<Department> departments = courseService.getDepartments();
    	System.out.println("---- Total departments=" + departments.size());
        for (Department department : departments) {
        	System.out.println("----   " + department);
        }
    
        if (departments.size() == 0) {
        	System.out.println("\n==== Insert Departments ...");
        	courseService.insertDepartment(new Department(0, "Java Programming"));
        	courseService.insertDepartment(new Department(0, ".NET Programming"));

        	System.out.println("\n==== Get Departments after the Insert ...");
            departments = courseService.getDepartments();
        	System.out.println("---- Total departments=" + departments.size());
            for (Department department : departments) {
            	System.out.println("----   " + department);
            }
        }
        
    	System.out.println("\n==== Get Departments by Id ...");
       	System.out.println("----   [id=" + departments.get(0).getDepartmentId() + "] " 
       			+ courseService.getDepartment(departments.get(0).getDepartmentId()));
       	System.out.println("----   [id=" + departments.get(1).getDepartmentId() + "] " 
       			+ courseService.getDepartment(departments.get(1).getDepartmentId()));

        departments = courseService.getDepartments();  // Reset the list

        // Courses
    	System.out.println("\n==== Get Courses ...");
        List<Course> courses = courseService.getCourses();
    	System.out.println("---- Total courses=" + courses.size());
        for (Course course : courses) {
        	System.out.println("----   " + course);
        }

        if (courses.size() == 0) {
        	System.out.println("\n==== Insert Courses ...");
        	courseService.insertCourse(new Course(0, "I&C SCI X460.10", "Java Programming 1", null, departments.get(0)));
        	courseService.insertCourse(new Course(0, "I&C SCI X460.33", "Design Patterns for Java", null, departments.get(0)));
        	courseService.insertCourse(new Course(0, "I&C SCI X460.64", "Java Architecture", null, departments.get(0)));

        	courseService.insertCourse(new Course(0, "I&C SCI X402.01", "Introduction to .NET Architecture", null, departments.get(1)));
        	courseService.insertCourse(new Course(0, "I&C SCI X402.05", "Developing .NET Solutions with C#", null, departments.get(1)));

        	System.out.println("\n==== Get Courses after the Insert ...");
            courses = courseService.getCourses();
        	System.out.println("---- Total courses=" + courses.size());
            for (Course course : courses) {
            	System.out.println("----   " + course);
            }
        }

    	System.out.println("\n==== Get Courses for Java Department ...");
        courses = courseService.getCoursesByDepartment(departments.get(0));
    	System.out.println("---- Total courses=" + courses.size());
        for (Course course : courses) {
        	System.out.println("----   " + course);
        }

        courses = courseService.getCourses(); // Reset the list

        // Schedules
    	System.out.println("\n==== Get Schedules ...");
        List<Schedule> schedules = courseService.getSchedules();
    	System.out.println("---- Total schedules=" + schedules.size());
        for (Schedule schedule : schedules) {
        	System.out.println("----   " + schedule);
        }

        if (schedules.size() == 0) {
            System.out.println("\n==== Insert Schedules ...");
        	courseService.insertSchedule(new Schedule(0, courses.get(0), 2014, 1, "Bill Smith"));
        	courseService.insertSchedule(new Schedule(0, courses.get(0), 2014, 3, "Bill Smith"));
        	courseService.insertSchedule(new Schedule(0, courses.get(1), 2014, 2, "Mary White"));
        	courseService.insertSchedule(new Schedule(0, courses.get(3), 2014, 2, "Ed Russel"));
        	courseService.insertSchedule(new Schedule(0, courses.get(3), 2014, 4, "John Lee"));

        	System.out.println("\n==== Get Schedules after the Insert ...");
            schedules = courseService.getSchedules();
        	System.out.println("---- Total schedules=" + schedules.size());
            for (Schedule schedule : schedules) {
            	System.out.println("----   " + schedule);
            }
        }

    	System.out.println("\n==== Get Schedules for course 1 ...");
    	schedules = courseService.getSchedulesByCourse(courses.get(0));
    	System.out.println("---- Total schedules=" + schedules.size());
        for (Schedule schedule : schedules) {
        	System.out.println("----   " + schedule);
        }

    	System.out.println();
        schedules = courseService.getSchedules();  // Reset the list

        // Students
    	System.out.println("\n==== Get Students ...");
        List<Student> students = studentService.getStudents();
    	System.out.println("---- Total students=" + students.size());
        for (Student student : students) {
        	System.out.println("----   " + student);
        }
    
        if (students.size() == 0) {
        	System.out.println("\n==== Insert Students ...");
        	studentService.insertStudent(new Student(0, "Bob Moore"));
        	studentService.insertStudent(new Student(0, "Peter Sierra"));
        	studentService.insertStudent(new Student(0, "Kathy Bates"));
        	studentService.insertStudent(new Student(0, "Julie Freeman"));
        	studentService.insertStudent(new Student(0, "Mala Gupta"));

        	System.out.println("\n==== Get Students after the Insert ...");
        	students = studentService.getStudents();
        	System.out.println("---- Total students=" + students.size());
            for (Student student : students) {
            	System.out.println("----   " + student);
            }
        }

    	System.out.println("\n==== Get Students by Id ...");
       	System.out.println("----   [id=" + students.get(0).getStudentId() + "] " 
       			+ studentService.getStudent(students.get(0).getStudentId()));
       	System.out.println("----   [id=" + students.get(1).getStudentId() + "] " 
       			+ studentService.getStudent(students.get(1).getStudentId()));
       	System.out.println("----   [id=" + students.get(2).getStudentId() + "] " 
       			+ studentService.getStudent(students.get(2).getStudentId()));

       	System.out.println();
        students = studentService.getStudents();  // Reset the list
       	
        // Registrations
    	System.out.println("\n==== Get Registrations ...");
        List<Registration> registrations = studentService.getRegistrations();
    	System.out.println("---- Total registrations=" + registrations.size());
        for (Registration registration : registrations) {
        	System.out.println("----   " + registration);
        }

        if (registrations.size() == 0) {
            System.out.println("\n==== Insert Registrations ...");
        	studentService.insertRegistration(new Registration(0, students.get(0), schedules.get(0), new Date()));
        	studentService.insertRegistration(new Registration(0, students.get(1), schedules.get(0), new Date()));
        	studentService.insertRegistration(new Registration(0, students.get(2), schedules.get(0), new Date()));
        	studentService.insertRegistration(new Registration(0, students.get(3), schedules.get(1), new Date()));
        	studentService.insertRegistration(new Registration(0, students.get(1), schedules.get(2), new Date()));
        	studentService.insertRegistration(new Registration(0, students.get(3), schedules.get(2), new Date()));
        	
        	System.out.println("\n==== Get Registrations after the Insert ...");
        	registrations = studentService.getRegistrations();
        	System.out.println("---- Total registrations=" + registrations.size());
            for (Registration registration : registrations) {
            	System.out.println("----   " + registration);
            }
        }

    	System.out.println("\n==== Get Registrations By Student ...");
    	for (Student student : students) {
    		registrations = studentService.getRegistrationsByStudent(student);
    		System.out.println("---- Total registrations for student " + student.getStudentId() + 
    			"=" + registrations.size());
    		for (Registration registration : registrations) {
    			System.out.println("----   " + registration);
    		}
    	}

    	System.out.println("\n==== Get Registrations By Schedule ...");
    	for (Schedule schedule : schedules) {
    		registrations = studentService.getRegistrationsBySchedule(schedule);
    		System.out.println("---- Total registrations for schedule " + schedule.getScheduleId() + 
    			"=" + registrations.size());
    		for (Registration registration : registrations) {
    			System.out.println("----   " + registration);
    		}
    	}
    }
    
}
