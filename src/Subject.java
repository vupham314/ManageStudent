public class Subject {
    private String nameSubject;
    private double mark;

    public Subject(String nameSubject, double mark) {
        this.nameSubject = nameSubject;
        this.mark = mark;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

}
