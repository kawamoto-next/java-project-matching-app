public class Project {

    String projectName;
    String requiredSkill;
    String optionalSkill;
    int requiredYears;
    String location;
    boolean remoteAvailable;

    Project(
            String projectName,
            String requiredSkill,
            String optionalSkill,
            int requiredYears,
            String location,
            boolean remoteAvailable) {

        this.projectName = projectName;
        this.requiredSkill = requiredSkill;
        this.optionalSkill = optionalSkill;
        this.requiredYears = requiredYears;
        this.location = location;
        this.remoteAvailable = remoteAvailable;
    }
}
