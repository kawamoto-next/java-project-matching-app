// 1件の案件情報を管理するクラス
public class Project {

    String projectName;
    String requiredSkill;
    String optionalSkill;
    int requiredYears;
    String location;
    boolean remoteAvailable;

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
}
