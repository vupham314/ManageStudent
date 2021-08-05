import java.util.*;

public class ManageStudent {
    public static Scanner scn = new Scanner(System.in);
    public static ArrayList<Student> studentList = new ArrayList<>();

    public static void showAll(){
        for (Student student : studentList) {
            student.showInformation();
            System.out.println();
        }
    }

    public static void showStudentByMark(){
        System.out.print("enter average mark: ");
        double mark = Double.parseDouble(scn.nextLine());

        boolean check = true;
        for (Student student: studentList) {
            if(student.avgMark() >= mark){
                check = false;
                student.showInformation();
                System.out.println();
            }
        }
        if(check){
            System.out.println("there are no any student");
        }
    }

    public static void showStudentByNameSubject(){
        System.out.print("enter subject name: ");
        String subjectName = scn.nextLine();

        boolean check = true;
        for (Student student: studentList) {
            boolean checkStudent = false;
            for (Subject subject : student.getSubjects()) {
                if(subject.getNameSubject().equals(subjectName)){
                    check = false;
                    checkStudent = true;
                }
            }
            if(checkStudent){
                student.showInformation();
                System.out.println();
            }
        }
        if(check){
            System.out.println("there are no any student");
        }
    }

    public static void insertSortByFirstName() {
        for  ( int  i =  1 ; i <studentList.size(); i ++) {
            Student temp = studentList.get(i);
            int  j = i -  1 ;
            for  (; j >=  0  && studentList.get(i).getName().getFirstName().compareTo(temp.getName().getFirstName()) > 0 ; j--) {
                // Moves the value greater than temp back by one unit
                studentList.set(j+1, studentList.get(j));
            }
            studentList.set(j+1, temp);
        }
    }

    public static void insertSortByAvgMark() {
        for  ( int  i =  1 ; i <studentList.size(); i ++) {
            Student temp = studentList.get(i);
            int  j = i -  1 ;
            for  (; j >=  0  && studentList.get(i).avgMark() > temp.avgMark(); j--) {
                // Moves the value greater than temp back by one unit
                studentList.set(j+1, studentList.get(j));
            }
            studentList.set(j+1, temp);
        }
    }

    public static void addStudent(Student student){
        studentList.add(student);
    }

    public static FullName createFulName(){
        System.out.print("first name: ");
        String firstName = scn.nextLine();

        System.out.print("surname: ");
        String surname = scn.nextLine();

        return new FullName(firstName, surname);
    }

    public static Student createStudent(){
        FullName name = createFulName();

        System.out.print("day of birth: ");
        String dayOfBirth = scn.nextLine();

        Student student = new Student(name, dayOfBirth);

        int numberOfSubject = 0;
        do{
            System.out.println("the total number of subjects must be more than 3");
            System.out.print("number of subject: ");
            numberOfSubject = Integer.parseInt(scn.nextLine());
        } while (numberOfSubject < 3);

        for (int i = 1; i <= numberOfSubject; i++) {
            System.out.println("subject " + i);
            Subject subject = createSubject();
            student.addSubject(subject);
        }

        return student;
    }

    public static Subject createSubject(){
        System.out.print("name subject: "); // tên môn học
        String nameSubject = scn.nextLine();

        double mark = checkMark();

        return new Subject(nameSubject, mark);
    }

    public static double checkMark(){
        double mark;
        try{
            System.out.print("mark: ");
            mark = Double.parseDouble(scn.nextLine());
            if(mark > 10 || mark < 0){
                throw new Exception("invalid value, the mark must be between 0 and 10");
            }
        } catch (Exception e){
            System.out.println(e.toString());
            return checkMark();
        }
        return mark;
    }



}
