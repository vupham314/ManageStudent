import java.util.*;

public class ManageStudent {
    public static Scanner scn = new Scanner(System.in);
    public ArrayList<Student> students = new ArrayList<>();

    public void showAll(){
        for (Student student : students) {
            student.showInformation();
            System.out.println();
        }
    }

    public void showStudentByMark(){
        System.out.print("enter average mark: ");
        double mark = Double.parseDouble(scn.nextLine());

        boolean check = true;
        for (Student student: students) {
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

    public void showStudentByNameSubject(){
        System.out.print("enter subject name: ");
        String subjectName = scn.nextLine();

        boolean check = true;
        for (Student student: students) {
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

    public void insertSortByFirstName() {
//        for  ( int  i =  1 ; i <students.size(); i ++) {
//            Student temp = students.get(i);
//            int  j = i -  1 ;
//            for  (; j >=  0  && students.get(i).getName().getFirstName().compareTo(temp.getName().getFirstName()) > 0 ; j--) {
//                students.set(j+1, students.get(j));
//            }
//            students.set(j+1, temp);
//        }
        Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student st1, Student st2) {
                        if (st1.getName().getFirstName().compareToIgnoreCase(st2.getName().getFirstName()) > 0) {
                            return 1;
                        } else {
                            if (st1.getName().getFirstName().compareToIgnoreCase(st2.getName().getFirstName()) == 0) {
                                return 0;
                            } else {
                                return -1;
                            }
                        }
                    }
                }
        );
    }

    public void insertSortByAvgMark() {
        for (int i = 1; i < students.size(); i ++) {
            Student temp = students.get(i);
            int  j = i -  1 ;
            for  (; j >=  0  && students.get(i).avgMark() > temp.avgMark(); j--) {
                // Moves the value greater than temp back by one unit
                students.set(j+1, students.get(j));
            }
            students.set(j+1, temp);
        }
    }





    public void selectSortByMark () {
//        int  position =  0 ;
//        for  ( int  i =  0 ; i <students.size(); i ++) {
//            int  j = i +  1 ;
//            position = i;
//            Student temp = students.get(i);
//            for  (; j <students.size(); j ++) {
//                if  (students.get(i).avgMark() > temp.avgMark()) {
//                    temp = students.get(j);
//                    position = j;
//                }
//            }
//            students.set(position,students.get(i));
//            students.set(i,temp);
//        }
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student st1, Student st2) {
                if (st1.avgMark() < st2.avgMark()) {
                    return 1;
                } else {
                    if (st1.avgMark() == st2.avgMark()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        }
        );
    }

//    public static void sort(){
//        for (int i = 0; ) {
//            for (Student student2 : studentList) {
//                if  (student1.avgMark() > student2.avgMark()) {
//
//                }
//            }
//        }
//    }

    public void addStudent(Student student){
        students.add(student);
    }

    public static FullName createFulName(){
        System.out.print("first name: ");
        String firstName = scn.nextLine();

        System.out.print("surname: ");
        String surname = scn.nextLine();

        return new FullName(firstName, surname);
    }

    public Student createStudent(){
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

    public Subject createSubject(){
        System.out.print("name subject: "); // tên môn học
        String nameSubject = scn.nextLine();

        double mark = checkMark();

        return new Subject(nameSubject, mark);
    }

    public double checkMark(){
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
