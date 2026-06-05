import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class StudentRoster {
    private ArrayList<Student> roster;


    public StudentRoster() {
        this.roster = new ArrayList<Student>();
    }

    public void add(String studentId, String firstName, String lastName, String email, int age, int grade1, int grade2, int grade3) {
        // turn individual grades into array
        int[] gradeList = {grade1, grade2, grade3};
        // create student and add to roster
        Student newStudent = new Student(studentId, firstName, lastName, email, age, gradeList);
        roster.add(newStudent);
    }

    public void remove(String studentID) {
        // remove student from roster using ID code. If value is false print error
        if (!roster.removeIf(student -> student.getStudentId().equals(studentID))) {
            System.out.println("No student found with that ID.");
        }
    }

    public void print_all() {
        //iterate through students in roster and print tab separated list.
        for (Student student : roster) {
            System.out.println(student.getStudentId() + "\tFirst Name: " +
                    student.getFirstName() + "\tLast Name: " + student.getLastName() +
                    "\tAge: " + student.getAge() + "\tGrades: " + Arrays.toString(student.getGrades()) + ".");
        }
    }

    public void print_average_grade(String studentID) {
        // use stream to iterate through the roster
        // filter to select the student with the matching student ID
        // isolate that specific value using findFirst
        Student student = roster.stream()
                .filter(candidate -> candidate.getStudentId().equals(studentID))
                .findFirst()
                .orElse(null);

        // if student is not found, output an error message
        if (student == null) {
            System.out.println("Error: Student with ID " + studentID + " not found.");
            return;
        }


        // use reduce to get the sum of the grades array. divide it by the length
        // of the grades array to get average. cast to double
        Double average = (Arrays.stream(student.getGrades()).reduce(0, (subtotal, element) -> subtotal + element) / (double) student.getGrades().length);

        // print the information - use decimalformat to format the double to only
        // two decimal spaces
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println(student.getFirstName() + " " + student.getLastName() + " (" +
                student.getStudentId() + "):\t" + decimalFormat.format(average));
    }

    public void print_invalid_emails() {
        // regex that ensures there is no whitespace
        // and that the string follows the format:
        // x@x.x
        String regex = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";

        // loop through all students. Print the email of students
        // that do not match the regex
        for (Student student : roster) {
            if (!Pattern.matches(regex, student.getEmail())) {
                System.out.println("Invalid Email:\t" + student.getEmail());
            }
        }
    }
}
