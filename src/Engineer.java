import java.util.List;

// 1人のエンジニアの希望条件・スキル・経験情報を管理するクラス
public class Engineer {

    String preferredLocation;
    boolean remotePreferred;

    // 保有スキルをSkillオブジェクトの一覧として管理する
    List<Skill> skills;

    // エンジニア情報を受け取り、各フィールドを初期化する
    Engineer(
            String preferredLocation,
            boolean remotePreferred,
            List<Skill> skills) {

        this.preferredLocation = preferredLocation;
        this.remotePreferred = remotePreferred;
        this.skills = skills;
    }
}
