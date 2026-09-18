// 1人のエンジニアの希望条件・スキル・経験情報を管理するクラス
public class Engineer {

    String preferredLocation;
    boolean remotePreferred;

    // 保有スキル・経験区分・経験年数は、各配列の同じ添字が同一スキルの情報を表す
    String[] engineerSkills;
    int[] experienceTypes;
    int[] skillYears;

    // エンジニア情報を受け取り、各フィールドを初期化する
    Engineer(
            String preferredLocation,
            boolean remotePreferred,
            String[] engineerSkills,
            int[] experienceTypes,
            int[] skillYears) {

        this.preferredLocation = preferredLocation;
        this.remotePreferred = remotePreferred;
        this.engineerSkills = engineerSkills;
        this.experienceTypes = experienceTypes;
        this.skillYears = skillYears;
    }
}
