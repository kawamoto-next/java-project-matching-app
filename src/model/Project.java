// 1件の案件情報を管理するクラス
package model;

import java.util.List;

public class Project {

    private String projectName;
    private List<ProjectSkill> projectSkills;
    private String location;
    private boolean remoteAvailable;

    // 案件情報を受け取り、各フィールドを初期化する
    public Project(
            String projectName,
            List<ProjectSkill> projectSkills,
            String location,
            boolean remoteAvailable) {

        validateProjectSkills(projectSkills);

        this.projectName = projectName;
        this.projectSkills = projectSkills;
        this.location = location;
        this.remoteAvailable = remoteAvailable;
    }

    private void validateProjectSkills(List<ProjectSkill> projectSkills) {
        // 必須スキルが1件以上設定されているかをチェックする
        boolean hasRequiredSkill = false;
        for (ProjectSkill skill : projectSkills) {
            if (skill.getRequirementType() == ProjectSkill.REQUIRED) {
                hasRequiredSkill = true;
                break;
            }
        }

        if (!hasRequiredSkill) {
            throw new IllegalArgumentException("必須スキルを1件以上設定してください");
        }
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<ProjectSkill> getProjectSkills() {
        return projectSkills;
    }

    public void setProjectSkills(List<ProjectSkill> projectSkills) {
        validateProjectSkills(projectSkills);

        this.projectSkills = projectSkills;
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
