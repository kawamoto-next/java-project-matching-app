public class Main {
  public static void main(String[] args) {
    System.out.println("案件マッチングアプリ　ver0.1");

    // 以下案件情報
    // 案件名
    String[] projectNames = {
        "Java業務システム開発",
        "Reactフロントエンド開発",
        "Javaバックエンド開発",
        "Webシステムテスト支援",
        "AWSインフラ構築支援"
    };

    // 必須スキル
    String[] requiredSkills = {
        "Java",
        "React",
        "Java",
        "PostgreSQL",
        "AWS"
    };

    // 尚可スキル
    String[] optionalSkills = {
        "PostgreSQL",
        "TypeScript",
        "Spring Boot",
        "Linux",
        "Linux"
    };

    // 必要経験年数
    int[] requiredYears = {
        0,
        1,
        2,
        1,
        2
    };

    // 勤務地
    String[] locations = {
        "大阪",
        "大阪",
        "東京",
        "大阪",
        "東京"
    };

    // リモート可否
    boolean[] remoteAvailable = {
        true,
        true,
        true,
        false,
        false
    };

    // 以下エンジニア情報
    // 希望勤務地
    String preferredLocation = "大阪";

    // リモート希望
    boolean remotePreferred = true;

    // 保有スキル
    String[] engineerSkills = {
        "Java",
        "React",
        "TypeScript",
        "PostgreSQL",
        "Linux"
    };

    // 実務経験あり:2、学習経験のみ:1
    int[] experienceTypes = {
        1,
        2,
        2,
        2,
        2
    };

    // 実務経験年数
    int[] skillYears = {
        0,
        1,
        1,
        1,
        1
    };
  }
}
