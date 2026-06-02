import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class StudentRoster {
    public ArrayList<Student> roster;


    public StudentRoster() {
        this.roster = new ArrayList<Student>();
    }

    public void add(String studentId, String firstName, String lastName, String email, int age, int grade1, int grade2, int grade3) {
        int[] gradeList = {grade1, grade2, grade3};
        Student newStudent = new Student(studentId, firstName, lastName, email, age, gradeList);
        roster.add(newStudent);
    }

    public void remove(String studentID) {
        if (!roster.removeIf(student -> student.getStudentId().equals(studentID))) {
            System.out.println("No student found with that ID.");
        }
    }

    public void print_all() {
        for (Student student : roster) {
            System.out.println(student.getStudentId() + "\tFirst Name: " +
                    student.getFirstName() + "\tLast Name: " + student.getLastName() +
                    "\tAge: " + student.getAge() + "\tGrades: " + Arrays.toString(student.getGrades()) + ".");
        }
    }

    public void print_average_grade(String studentID) {
        Student student = roster.stream().filter(candidate -> {
            return candidate.getStudentId() == studentID;
        }).findFirst().orElse(null);

        Double average = (Arrays.stream(student.getGrades()).reduce(0, (subtotal, element) -> subtotal + element) / (double) student.getGrades().length);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println(student.getFirstName() + " " + student.getLastName() + " (" +
                student.getStudentId() + "):\t" + decimalFormat.format(average));
    }

    public void print_invalid_emails() {
        String regex = "[^\\s].+[^\\s]@{1}[^\\s].+[^\\s]\\.+[^\\s].+[^\\s]";

        for (Student student : roster) {
            if (!Pattern.matches(regex, student.getEmail())) {
                System.out.println("Invalid Email:\t" + student.getEmail());
            }
        }
    }
}
