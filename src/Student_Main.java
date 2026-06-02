void main() {

    String[] students = {"1,John,Smith,John1989@gmail.com,20,88,79,59","2,Suzan,Erickson,Erickson_1990@gmailcom,19,91,72,85",
 "3,Jack,Napoli,The_lawyer99yahoo.com,19,85,84,87",
 "4,Erin,Black,Erin.black@comcast.net,22,91,98,82",
 "5,Nick,Paldino,fake@fake.com,36,51,90,83"};

    StudentRoster studentRoster = new StudentRoster();

    for (int i = 0; i < students.length; i++) {
        String[] studentInfo = students[i].split(",");
        studentRoster.add(studentInfo[0], studentInfo[1], studentInfo[2], studentInfo[3],
                Integer.parseInt(studentInfo[4]), Integer.parseInt(studentInfo[5]), Integer.parseInt(studentInfo[6]), Integer.parseInt(studentInfo[7]));
    }

    studentRoster.print_all();
    studentRoster.print_invalid_emails();

    for (Student student : studentRoster.roster) {
        studentRoster.print_average_grade(student.getStudentId());

    }
    studentRoster.remove("3");
    studentRoster.remove("3");
}
