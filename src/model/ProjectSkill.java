//プロジェクトに必要なスキル情報を保持するクラス
package model;

public class ProjectSkill {

    private String skillName;
    private int requirementType;
    private int requiredYears;

    // 必須/尚可を表す定数
    public static final int REQUIRED = 1;
    public static final int OPTIONAL = 2;

    // スキル情報を受け取り、各フィールドを初期化する
    public ProjectSkill(
            String skillName,
            int requirementType,
            int requiredYears) {

        this.skillName = skillName;
        this.requirementType = requirementType;
        this.requiredYears = requiredYears;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(int requirementType) {
        this.requirementType = requirementType;
    }

    public int getRequiredYears() {
        return requiredYears;
    }

    public void setRequiredYears(int requiredYears) {
        this.requiredYears = requiredYears;
    }

}
