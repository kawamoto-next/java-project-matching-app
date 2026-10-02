package service;

import model.Engineer;
import model.Project;
import model.ProjectSkill;
import model.Skill;

public class MatchCalculator {

    // 必須スキルの最大スコア
    private static final int MAX_REQUIRED_SCORE = 50;

    // 尚可スキルの最大スコア
    private static final int MAX_OPTIONAL_SCORE = 30;

    // 実務経験あり(1.0)と学習経験のみ(0.5)の係数
    private static final double PRACTICAL_COEFFICIENT = 1.0;
    private static final double LEARNING_COEFFICIENT = 0.5;

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

        double score = 0.0;

        // 必須スキルのマッチング
        double requiredCoefficientTotal = 0.0;
        int requiredSkillCount = 0;

        for (ProjectSkill projectSkill : project.getProjectSkills()) {
            if (projectSkill.getRequirementType() == ProjectSkill.REQUIRED) {
                requiredSkillCount++;
                for (Skill skill : engineer.getSkills()) {
                    if (projectSkill.getSkillName().equals(skill.getSkillName())) {
                        if (skill.getExperienceType() == Skill.PRACTICAL_EXPERIENCE) {
                            if (projectSkill.getRequiredYears() == 0) {
                                // 必要経験年数が指定されていない場合は、実務経験ありの係数を加算
                                requiredCoefficientTotal += PRACTICAL_COEFFICIENT;
                            } else {
                                // 必要経験年数が指定されている場合、経験年数に応じて係数を計算
                                double experienceRatio = (double) skill.getSkillYears()
                                        / projectSkill.getRequiredYears();

                                double practicalCoefficient = LEARNING_COEFFICIENT
                                        + LEARNING_COEFFICIENT * experienceRatio;

                                // 係数が1.0を超えないように制限
                                if (practicalCoefficient > PRACTICAL_COEFFICIENT) {
                                    practicalCoefficient = PRACTICAL_COEFFICIENT;
                                }
                                requiredCoefficientTotal += practicalCoefficient;
                            }
                        } else if (skill.getExperienceType() == Skill.LEARNING_ONLY) {
                            requiredCoefficientTotal += LEARNING_COEFFICIENT;
                        }
                        break;
                    }
                }
            }
        }

        // マッチング結果に応じてスコアを加算
        if (requiredSkillCount > 0) {
            score += MAX_REQUIRED_SCORE * (requiredCoefficientTotal / requiredSkillCount);
        }

        // 尚可スキルのマッチング
        double optionalCoefficientTotal = 0.0;
        int optionalSkillCount = 0;

        for (ProjectSkill projectSkill : project.getProjectSkills()) {
            if (projectSkill.getRequirementType() == ProjectSkill.OPTIONAL) {
                optionalSkillCount++;
                for (Skill skill : engineer.getSkills()) {
                    if (projectSkill.getSkillName().equals(skill.getSkillName())) {
                        if (skill.getExperienceType() == Skill.PRACTICAL_EXPERIENCE) {
                            optionalCoefficientTotal += PRACTICAL_COEFFICIENT;
                        } else if (skill.getExperienceType() == Skill.LEARNING_ONLY) {
                            optionalCoefficientTotal += LEARNING_COEFFICIENT;
                        }
                        break;
                    }
                }
            }
        }

        // 尚可スキルのマッチング結果に応じてスコアを加算
        if (optionalSkillCount > 0) {
            score += MAX_OPTIONAL_SCORE * (optionalCoefficientTotal / optionalSkillCount);
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
        return (int) Math.round(score);
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
