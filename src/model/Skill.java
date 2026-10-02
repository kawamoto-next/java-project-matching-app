// 1つのスキルに関する経験情報を管理するクラス
package model;

public class Skill {

    private String skillName;
    private int experienceType;
    private int skillYears;

    public static final int LEARNING_ONLY = 1; // 学習経験のみ
    public static final int PRACTICAL_EXPERIENCE = 2; // 実務経験あり

    // スキル情報を受け取り、各フィールドを初期化する
    public Skill(
            String skillName,
            int experienceType,
            int skillYears) {

        this.skillName = skillName;
        this.experienceType = experienceType;
        this.skillYears = skillYears;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getExperienceType() {
        return experienceType;
    }

    public void setExperienceType(int experienceType) {
        this.experienceType = experienceType;
    }

    public int getSkillYears() {
        return skillYears;
    }

    public void setSkillYears(int skillYears) {
        this.skillYears = skillYears;
    }
}
