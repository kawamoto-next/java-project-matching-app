package model;

import java.util.List;

// 1人のエンジニアの希望条件・スキル・経験情報を管理するクラス
public class Engineer {

    private String preferredLocation;
    private boolean remotePreferred;

    // 保有スキルをSkillオブジェクトの一覧として管理する
    private List<Skill> skills;

    // エンジニア情報を受け取り、各フィールドを初期化する
    public Engineer(
            String preferredLocation,
            boolean remotePreferred,
            List<Skill> skills) {

        this.preferredLocation = preferredLocation;
        this.remotePreferred = remotePreferred;
        this.skills = skills;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public boolean isRemotePreferred() {
        return remotePreferred;
    }

    public void setRemotePreferred(boolean remotePreferred) {
        this.remotePreferred = remotePreferred;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
