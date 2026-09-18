// 1つのスキルに関する経験情報を管理するクラス
public class Skill {

    String skillName;
    int experienceType;
    int skillYears;

    // スキル情報を受け取り、各フィールドを初期化する
    Skill(
            String skillName,
            int experienceType,
            int skillYears) {

        this.skillName = skillName;
        this.experienceType = experienceType;
        this.skillYears = skillYears;
    }
}
