public class Student implements Comparable<Student> {
    String name;
    String email;
    int yearStarted;
    boolean isActive;
    boolean hasHandedIn = true;


    public Student(String name, String email, int yearStarted, boolean isActive) {
        this.name = name;
        this.email = email;
        this.yearStarted = yearStarted;
        this.isActive = isActive;


    }

    public int compareTo(Student other){
        if(other.name.compareTo(name)== 0 )return 0;
        else
            return other.name.compareTo(name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}