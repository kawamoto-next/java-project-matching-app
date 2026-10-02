// 1件の案件情報を管理するクラス
public class Project {

    private String projectName;
    private String requiredSkill;
    private String optionalSkill;
    private int requiredYears;
    private String location;
    private boolean remoteAvailable;

    // 案件情報を受け取り、各フィールドを初期化する
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    public String getOptionalSkill() {
        return optionalSkill;
    }

    public void setOptionalSkill(String optionalSkill) {
        this.optionalSkill = optionalSkill;
    }

    public int getRequiredYears() {
        return requiredYears;
    }

    public void setRequiredYears(int requiredYears) {
        this.requiredYears = requiredYears;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRemoteAvailable() {
        return remoteAvailable;
    }

    public void setRemoteAvailable(boolean remoteAvailable) {
        this.remoteAvailable = remoteAvailable;
    }
}
