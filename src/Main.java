import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
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

    int number = 1;// メニュー番号の初期値
    Scanner scanner = new Scanner(System.in);

    while (number != 0) {
      // 初期メニュー表示
      System.out.print(
          "\n================================" +
              "\n  案件マッチングアプリ Ver0.1" +
              "\n================================" +
              "\n1. 案件一覧を表示" +
              "\n2. 必須スキルで検索" +
              "\n3. リモート可能案件を表示" +
              "\n4. マッチスコアを表示" +
              "\n0. 終了" +
              "\n" +
              "\n番号を入力してください: ");

      String numberStr = scanner.nextLine();
      number = Integer.parseInt(numberStr);

      // numberの値に応じて処理を分岐
      switch (number) {
        case 1:
          System.out.println("\n案件一覧機能は現在作成中です。");
          break;
        case 2:
          System.out.println("\n必須スキル検索機能は現在作成中です。");
          break;
        case 3:
          System.out.println("\nリモート可能案件表示機能は現在作成中です。");
          break;
        case 4:
          System.out.println("\nマッチスコア表示機能は現在作成中です。");
          break;
        case 0:
          System.out.println("\nアプリを終了します。");
          break;
        default:
          System.out.println("\n該当するメニューがありません。");
      }
    }

    scanner.close();
  }
}
