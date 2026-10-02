public class MatchCalculator {

    // 必須スキルのスコア
    // 実務経験あり: 50点、学習経験のみ: 25点
    private static final int REQUIRED_PRACTICAL_SCORE = 50;
    private static final int REQUIRED_LEARNING_SCORE = 25;

    // 尚可スキルのスコア
    // 実務経験あり: 15点、学習経験のみ: 8点
    private static final int OPTIONAL_PRACTICAL_SCORE = 15;
    private static final int OPTIONAL_LEARNING_SCORE = 8;

    // 経験年数の最大スコア
    private static final int MAX_EXPERIENCE_SCORE = 15;

    // 勤務地のスコア
    private static final int LOCATION_SCORE = 10;

    // リモート可否のスコア
    private static final int REMOTE_SCORE = 10;

    // 高マッチ基準
    private static final int HIGH_MATCH_THRESHOLD = 80;

    // 候補基準
    private static final int CANDIDATE_THRESHOLD = 60;

    // 指定された案件とエンジニア情報を比較し、マッチスコアを返す
    public int calculateMatchScore(
            Project project, Engineer engineer) {

        int score = 0;

        // 必須スキルのマッチング
        for (Skill skill : engineer.getSkills()) {
            if (project.getRequiredSkill().equals(skill.getSkillName())) {
                if (skill.getExperienceType() == Skill.PRACTICAL_EXPERIENCE) {
                    score += REQUIRED_PRACTICAL_SCORE;
                } else if (skill.getExperienceType() == Skill.LEARNING_ONLY) {
                    score += REQUIRED_LEARNING_SCORE;
                }
                break;
            }
        }

        // 尚可スキルのマッチング
        // 実務経験あり: 15点、学習経験のみ: 8点
        for (Skill skill : engineer.getSkills()) {
            if (project.getOptionalSkill().equals(skill.getSkillName())) {
                if (skill.getExperienceType() == Skill.PRACTICAL_EXPERIENCE) {
                    score += OPTIONAL_PRACTICAL_SCORE;
                } else if (skill.getExperienceType() == Skill.LEARNING_ONLY) {
                    score += OPTIONAL_LEARNING_SCORE;
                }
                break;
            }
        }

        // 経験年数のマッチング
        // 必要経験年数の指定なし、または条件を満たす場合は15点
        // 条件未達の場合は実務経験年数に応じて部分点を加算
        if (project.getRequiredYears() == 0) {
            score += MAX_EXPERIENCE_SCORE;
        } else {
            for (Skill skill : engineer.getSkills()) {
                if (project.getRequiredSkill().equals(skill.getSkillName())) {
                    if (skill.getExperienceType() == Skill.PRACTICAL_EXPERIENCE) {
                        if (skill.getSkillYears() >= project.getRequiredYears()) {
                            score += MAX_EXPERIENCE_SCORE;
                        } else {
                            score += skill.getSkillYears() * MAX_EXPERIENCE_SCORE / project.getRequiredYears();
                        }
                    }
                    break;
                }
            }
        }

        // 勤務地のマッチング
        // 希望勤務地と案件勤務地が一致する場合は10点
        if (project.getLocation().equals(engineer.getPreferredLocation())) {
            score += LOCATION_SCORE;
        }

        // リモート可否のマッチング
        // リモート希望の場合、案件がリモート対応なら10点
        // リモートを希望しない場合は案件条件に関係なく10点
        if (engineer.isRemotePreferred()) {
            if (project.isRemoteAvailable()) {
                score += REMOTE_SCORE;
            }
        } else {
            score += REMOTE_SCORE;
        }

        // 算出した合計スコアを返す
        return score;
    }

    // マッチスコアからマッチレベルを判定して返す
    // 定数で定義した基準値に応じて、高マッチ・候補・低マッチを判定する
    public String getMatchLevel(int score) {
        String matchLevel;
        if (score >= HIGH_MATCH_THRESHOLD) {
            matchLevel = "高マッチ";
        } else if (score >= CANDIDATE_THRESHOLD) {
            matchLevel = "候補";
        } else {
            matchLevel = "低マッチ";
        }

        return matchLevel;
    }

}
