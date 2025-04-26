import java.util.*;
abstract class CourseType {
    public abstract String getEvaluationType();
}
class ExamCourse extends CourseType{
    @Override
    public String getEvaluationType() {
        return "exam-based";
    }
}
class AssignmentCourse extends CourseType{
    @Override
    public String getEvaluationType() {
        return "Assignment based";
    }
}
class ResearchCourse extends CourseType{
    @Override
    public String getEvaluationType() {
        return "research based";
    }
}
class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T type;

    public Course(String courseName, String department, T type) {
        this.courseName = courseName;
        this.department = department;
        this.type = type;
    }
    public String getCourseName()
    {
    return courseName;}
    public String getDepartment(){
        return department;
    }
    public T getType(){
        return type;
    }
    public void display(){
        System.out.printf("Course: %s | Department: %s | Evaluation: %s\n",
                courseName, department, type.getEvaluationType());
    }
}
class CourseUtils{
    public static void displayCourse(List<? extends CourseType>courses){
        for (CourseType courseType:courses){
            System.out.println("EValuation type: "+ courseType.getEvaluationType());
        }
    }
}
 class UniversityCourseApp{
    public static void main(String[]args){
        Course<ExamCourse>math=new Course<>("Calculus","Mathematics",new ExamCourse());
        Course<AssignmentCourse> programming = new Course<>("Java Programming", "Computer Science", new AssignmentCourse());
        Course<ResearchCourse> thesis = new Course<>("AI Research", "Computer Science", new ResearchCourse());

        List<Course<?extends CourseType>>courseCatalog=new ArrayList<>();
        courseCatalog.add(math);
        courseCatalog.add(programming);
        courseCatalog.add(thesis);

        System.out.println("===University Courses===");
        for(Course<?extends CourseType>c:courseCatalog){
            c.display();
        }

    }
}
