void main() {

    String[] students = {"1,John,Smith,John1989@gmail.com,20,88,79,59","2,Suzan,Erickson,Erickson_1990@gmailcom,19,91,72,85",
 "3,Jack,Napoli,The_lawyer99yahoo.com,19,85,84,87",
 "4,Erin,Black,Erin.black@comcast.net,22,91,98,82",
 "5,Nick,Paldino,fake@fake.com,36,51,90,83"};

    StudentRoster studentRoster = new StudentRoster();

    // loop through students
    for (int i = 0; i < students.length; i++) {
        // split the accessed student element into smaller parts
        String[] studentInfo = students[i].split(",");

        String studentId = studentInfo[0];
        String firstName = studentInfo[1];
        String lastName = studentInfo[2];
        String email = studentInfo[3];
        int age = Integer.parseInt(studentInfo[4]);
        int grade1 = Integer.parseInt(studentInfo[5]);
        int grade2 = Integer.parseInt(studentInfo[6]);
        int grade3 = Integer.parseInt(studentInfo[7]);

        studentRoster.add(studentId, firstName, lastName, email, age, grade1, grade2, grade3);
    }

    studentRoster.print_all();
    studentRoster.print_invalid_emails();

    // iterate through local array of student data
    for (int i = 0; i < students.length; i++) {
        // split the accessed student element into smaller parts
        String[] studentInfo = students[i].split(",");

        // extract ID
        String studentId = studentInfo[0];

        studentRoster.print_average_grade(studentId);
    }

    // remove Jack Napoli
    studentRoster.remove("3");

    // try to remove again, student not found.
    studentRoster.remove("3");
}
