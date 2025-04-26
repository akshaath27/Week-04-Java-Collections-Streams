import java.util.*;

// Step 1: Abstract base class
abstract class JobRole {
    abstract String getRequiredSkills();
}

// Step 2: Concrete job roles
class SoftwareEngineer extends JobRole {
    @Override
    String getRequiredSkills() {
        return "Java, Data Structures, Algorithms";
    }
}

class DataScientist extends JobRole {
    @Override
    String getRequiredSkills() {
        return "Python, Machine Learning, Statistics";
    }
}

class ProductManager extends JobRole {
    @Override
    String getRequiredSkills() {
        return "Leadership, Roadmap Planning, Communication";
    }
}

// Step 3: Generic Resume class
class Resume<T extends JobRole> {
    private String applicantName;
    private T jobRole;

    public Resume(String applicantName, T jobRole) {
        this.applicantName = applicantName;
        this.jobRole = jobRole;
    }

    public void printResumeSummary() {
        System.out.println("Applicant: " + applicantName);
        System.out.println("Applying for: " + jobRole.getClass().getSimpleName());
        System.out.println("Required Skills: " + jobRole.getRequiredSkills());
        System.out.println();
    }

    public T getJobRole() {
        return jobRole;
    }
}

// Step 4: Screening processor using wildcards
class ResumeScreeningSystem {
    public static void processResumes(List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("Processing Resumes...");
        for (Resume<? extends JobRole> resume : resumes) {
            resume.printResumeSummary();
        }
    }
}

// Step 5: Main to simulate usage
public class Main {
    public static void main(String[] args) {
        List<Resume<? extends JobRole>> resumes = new ArrayList<>();

        resumes.add(new Resume<>("Alice", new SoftwareEngineer()));
        resumes.add(new Resume<>("Bob", new DataScientist()));
        resumes.add(new Resume<>("Charlie", new ProductManager()));

        ResumeScreeningSystem.processResumes(resumes);
    }
}
