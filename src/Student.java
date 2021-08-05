import java.util.ArrayList;

public class Student {
    private static int stt = 0;
    private final int id;
    private FullName fullName;
    private String dayOfBirth;

    private final ArrayList<Subject> subjects = new ArrayList<>();
    // mỗi học sinh bắt buộc phải đăng ký từ 3 môn trở lên

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public Student(FullName name, String dayOfBirth) {
        this.id = stt; // mỗi sinh viên có mỗi id dựa trên biến static stt;
        stt++;
        this.fullName = name;
        this.dayOfBirth = dayOfBirth;
    }

    public double avgMark(){
        double sumMark = 0;
        assert subjects != null;
        for (Subject subject: subjects) {
            sumMark += subject.getMark();
        }
        return (double) Math.round(sumMark/subjects.size() * 100) / 100;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + fullName + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                '}';
    }

    public void showSubject(){
        for (Subject subject: subjects) {
            System.out.println(subject.getNameSubject() + ": " + subject.getMark());
        }
    }

    public void showInformation(){
        System.out.println(this.toString());
        showSubject();
        System.out.println("average mark: " + avgMark());
    }

    public int getId() {
        return id;
    }

    public FullName getName() {
        return fullName;
    }

    public void setName(FullName name) {
        this.fullName = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

}
