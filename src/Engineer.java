// 1人のエンジニアの希望条件・スキル・経験情報を管理するクラス
public class Engineer {

    String preferredLocation;
    boolean remotePreferred;

    // 保有スキルをSkillオブジェクトの配列として管理する
    Skill[] skills;

    // エンジニア情報を受け取り、各フィールドを初期化する
    Engineer(
            String preferredLocation,
            boolean remotePreferred,
            Skill[] skills) {

        this.preferredLocation = preferredLocation;
        this.remotePreferred = remotePreferred;
        this.skills = skills;
    }
}
