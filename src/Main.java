public class Main {

    public static void menu(){
        System.out.println("""
                1: add student
                2: show all student
                3: sort by average mark
                4: sort by first name
                5: show by average mark
                6: show by subject
                7: exit
                """);
        System.out.print("choice: ");
        switch (Integer.parseInt(ManageStudent.scn.nextLine())){
            case 1 -> {
                System.out.print("number of student: ");
                int number = Integer.parseInt(ManageStudent.scn.nextLine());
                for (int i = 1; i <= number; i++) {
                    System.out.println("student " + i);
                    ManageStudent.addStudent(ManageStudent.createStudent());
                    System.out.println();
                }
            }
            case 2 -> {
                ManageStudent.showAll();
            }
            case 3 -> {
                ManageStudent.insertSortByAvgMark();
                ManageStudent.showAll();
            }
            case 4 -> {
                ManageStudent.insertSortByFirstName();
                ManageStudent.showAll();
            }
            case 5 -> {
                ManageStudent.showStudentByMark();
            }
            case 6 -> {
                ManageStudent.showStudentByNameSubject();
            }
            case 7 -> {
                return;
            }

        }
        menu();

    }

    public static void main(String[] args) {
        Main.menu();
    }

}
