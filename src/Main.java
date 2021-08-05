public class Main {
    ManageStudent manage = new ManageStudent();
    public void menu(){

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
                    manage.addStudent(manage.createStudent());
                    System.out.println();
                }
            }
            case 2 -> {
                manage.showAll();
            }
            case 3 -> {
                manage.selectSortByMark();
                manage.showAll();
            }
            case 4 -> {
                manage.insertSortByFirstName();
                manage.showAll();
            }
            case 5 -> {
                manage.showStudentByMark();
            }
            case 6 -> {
                manage.showStudentByNameSubject();
            }
            case 7 -> {
                return;
            }

        }
        menu();

    }

    public static void main(String[] args) {
        Main menu = new Main();
        menu.menu();
    }

}
