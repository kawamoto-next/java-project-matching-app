import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    // 案件情報
    // 1案件ごとの情報をProjectオブジェクトとして管理する
    List<Project> projects = new ArrayList<>();
    projects.add(
        new Project(
            "Java業務システム開発",
            "Java",
            "PostgreSQL",
            0,
            "大阪",
            true));

    projects.add(
        new Project(
            "Reactフロントエンド開発",
            "React",
            "TypeScript",
            1,
            "大阪",
            true));

    projects.add(
        new Project(
            "Javaバックエンド開発",
            "Java",
            "Spring Boot",
            2,
            "東京",
            true));

    projects.add(
        new Project(
            "Webシステムテスト支援",
            "PostgreSQL",
            "Linux",
            1,
            "大阪",
            false));

    projects.add(
        new Project(
            "AWSインフラ構築支援",
            "AWS",
            "Linux",
            2,
            "東京",
            false));

    // スキル情報
    List<Skill> skills = new ArrayList<>();
    skills.add(
        new Skill(
            "Java",
            Skill.LEARNING_ONLY,
            0));

    skills.add(
        new Skill(
            "React",
            Skill.PRACTICAL_EXPERIENCE,
            1));

    skills.add(
        new Skill(
            "TypeScript",
            Skill.PRACTICAL_EXPERIENCE,
            1));

    skills.add(
        new Skill(
            "PostgreSQL",
            Skill.PRACTICAL_EXPERIENCE,
            1));

    skills.add(
        new Skill(
            "Linux",
            Skill.PRACTICAL_EXPERIENCE,
            1));

    // エンジニア情報
    // 希望条件・保有スキル・経験情報をEngineerオブジェクトとして管理する
    Engineer engineer = new Engineer(
        // 希望勤務地
        "大阪",

        // リモート希望
        true,

        // スキル情報
        skills);

    MatchCalculator matchCalculator = new MatchCalculator();

    int number = 1; // メニュー番号の初期値
    Scanner scanner = new Scanner(System.in);

    // 0が入力されるまでメニュー処理を繰り返す
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
      try {
        number = Integer.parseInt(numberStr);
      } catch (NumberFormatException e) {
        System.out.println("\n不正な値が入力されました。");
        System.out.println("Enterキーを押すとメニューに戻ります。");
        scanner.nextLine();
        continue;
      }
      // numberの値に応じて処理を分岐
      switch (number) {
        case 1:
          showProjectList(projects);
          System.out.println("\nEnterキーを押すとメニューに戻ります。");
          scanner.nextLine();
          break;

        case 2:
          System.out.println("\n【必須スキル検索】");
          System.out.print("\n検索する必須スキルを入力してください: ");
          String searchSkill = scanner.nextLine();
          searchByRequiredSkill(projects, searchSkill);
          System.out.println("\nEnterキーを押すとメニューに戻ります。");
          scanner.nextLine();
          break;

        case 3:
          showRemoteProjects(projects);

          System.out.println("\nEnterキーを押すとメニューに戻ります。");
          scanner.nextLine();
          break;

        case 4:
          showMatchScores(
              projects, engineer, matchCalculator);

          System.out.println("\nEnterキーを押すとメニューに戻ります。");
          scanner.nextLine();
          break;

        case 0:
          System.out.println("\nアプリを終了します。");
          break;

        default:
          System.out.println("\n該当するメニューがありません。");
          System.out.println("\nEnterキーを押すとメニューに戻ります。");
          scanner.nextLine();
      }
    }

    scanner.close();
  }

  // 登録されているすべての案件を一覧表示する
  static void showProjectList(List<Project> projects) {

    System.out.println("\n【案件一覧】");
    for (int i = 0; i < projects.size(); i++) {
      showProjectDetails(projects.get(i), i + 1);
    }
  }

  // 入力された必須スキルと一致する案件を検索・表示する
  static void searchByRequiredSkill(List<Project> projects, String searchSkill) {

    System.out.println("\n検索結果:");
    boolean found = false;
    for (int i = 0; i < projects.size(); i++) {
      if (projects.get(i).getRequiredSkill().equals(searchSkill)) {
        showProjectDetails(projects.get(i), i + 1);
        found = true;
      }
    }

    if (!found) {
      System.out.println("\n該当する案件が見つかりませんでした。");
    }
  }

  // リモート対応可能な案件だけを表示する
  static void showRemoteProjects(List<Project> projects) {
    System.out.println("\n【リモート可能案件一覧】");

    System.out.println("\n検索結果:");
    for (int i = 0; i < projects.size(); i++) {
      if (projects.get(i).isRemoteAvailable()) {
        showProjectDetails(projects.get(i), i + 1);
      }
    }
  }

  // 各案件とエンジニア情報を比較し、マッチスコアとマッチレベルを表示する
  static void showMatchScores(
      List<Project> projects, Engineer engineer, MatchCalculator matchCalculator) {

    System.out.println("\n【マッチスコア表示】");
    for (int i = 0; i < projects.size(); i++) {

      int score = matchCalculator.calculateMatchScore(
          projects.get(i), engineer);

      String matchLevel = matchCalculator.getMatchLevel(score);

      System.out.println("\n" + (i + 1) + ". " + projects.get(i).getProjectName());
      System.out.println("--------------------------------");
      System.out.println("マッチスコア:" + score + "点(" + matchLevel + ")");
    }
  }

  // 指定された案件情報を1件表示する
  static void showProjectDetails(
      Project project, int number) {

    System.out.println("\n" + number + ". " + project.getProjectName());
    System.out.println("--------------------------------");
    System.out.println("必須スキル: " + project.getRequiredSkill());
    System.out.println("尚可スキル: " + project.getOptionalSkill());

    if (project.getRequiredYears() == 0) {
      System.out.println("必要経験年数: 指定なし");
    } else {
      System.out.println("必要経験年数: " + project.getRequiredYears() + "年");
    }
    System.out.println("勤務地: " + project.getLocation());

    if (project.isRemoteAvailable()) {
      System.out.println("リモート可否: 可");
    } else {
      System.out.println("リモート可否: 不可");
    }
  }
}
