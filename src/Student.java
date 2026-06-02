public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int[] grades;


    public Student(String studentId, String firstName, String lastName, String email, int age, int[] grades) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.grades = grades;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public void print() {
        System.out.println(getStudentId());
        System.out.println(getFirstName() + " " + getLastName());
        System.out.println(getEmail());
        System.out.println(getAge());
        System.out.println(getGrades());
    }
}
