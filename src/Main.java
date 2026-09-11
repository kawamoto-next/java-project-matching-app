import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 案件情報
    // 各配列の同じ添字が、同一案件の情報を表す

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

    // エンジニア情報
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

    // 経験区分（1: 学習経験のみ、2: 実務経験あり）
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
      number = Integer.parseInt(numberStr);

      // numberの値に応じて処理を分岐
      switch (number) {
        case 1:
          showProjectList(
              projectNames,
              requiredSkills,
              optionalSkills,
              requiredYears,
              locations,
              remoteAvailable);
          System.out.println("\nEnterキーを押すとメニューに戻ります。");
          scanner.nextLine();
          break;

        case 2:
          System.out.println("\n【必須スキル検索】");
          System.out.print("\n検索する必須スキルを入力してください: ");
          String searchSkill = scanner.nextLine();
          searchByRequiredSkill(
              projectNames,
              requiredSkills,
              optionalSkills,
              requiredYears,
              locations,
              remoteAvailable,
              searchSkill);
          System.out.println("\nEnterキーを押すとメニューに戻ります。");
          scanner.nextLine();
          break;

        case 3:
          showRemoteProjects(
              projectNames,
              requiredSkills,
              optionalSkills,
              requiredYears,
              locations,
              remoteAvailable);

          System.out.println("\nEnterキーを押すとメニューに戻ります。");
          scanner.nextLine();
          break;

        case 4:
          showMatchScores(
              projectNames,
              requiredSkills,
              optionalSkills,
              requiredYears,
              locations,
              remoteAvailable,
              engineerSkills,
              experienceTypes,
              skillYears,
              preferredLocation,
              remotePreferred);

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
  static void showProjectList(
      String[] projectNames,
      String[] requiredSkills,
      String[] optionalSkills,
      int[] requiredYears,
      String[] locations,
      boolean[] remoteAvailable) {

    System.out.println("\n【案件一覧】");
    for (int i = 0; i < projectNames.length; i++) {
      showProjectDetails(
          projectNames,
          requiredSkills,
          optionalSkills,
          requiredYears,
          locations,
          remoteAvailable,
          i);
    }
  }

  // 入力された必須スキルと一致する案件を検索・表示する
  static void searchByRequiredSkill(
      String[] projectNames,
      String[] requiredSkills,
      String[] optionalSkills,
      int[] requiredYears,
      String[] locations,
      boolean[] remoteAvailable,
      String searchSkill) {

    System.out.println("\n検索結果:");
    boolean found = false;
    for (int i = 0; i < projectNames.length; i++) {
      if (requiredSkills[i].equals(searchSkill)) {
        showProjectDetails(
            projectNames,
            requiredSkills,
            optionalSkills,
            requiredYears,
            locations,
            remoteAvailable,
            i);
        found = true;
      }
    }

    if (!found) {
      System.out.println("\n該当する案件が見つかりませんでした。");
    }
  }

  // リモート対応可能な案件だけを表示する
  static void showRemoteProjects(
      String[] projectNames,
      String[] requiredSkills,
      String[] optionalSkills,
      int[] requiredYears,
      String[] locations,
      boolean[] remoteAvailable) {
    System.out.println("\n【リモート可能案件一覧】");

    System.out.println("\n検索結果:");
    for (int i = 0; i < projectNames.length; i++) {
      if (remoteAvailable[i]) {
        showProjectDetails(
            projectNames,
            requiredSkills,
            optionalSkills,
            requiredYears,
            locations,
            remoteAvailable,
            i);
      }
    }
  }

  // 各案件のマッチスコアとマッチレベルを表示する
  static void showMatchScores(
      String[] projectNames,
      String[] requiredSkills,
      String[] optionalSkills,
      int[] requiredYears,
      String[] locations,
      boolean[] remoteAvailable,
      String[] engineerSkills,
      int[] experienceTypes,
      int[] skillYears,
      String preferredLocation,
      boolean remotePreferred) {

    System.out.println("\n【マッチスコア表示】");
    for (int i = 0; i < projectNames.length; i++) {

      int score = calculateMatchScore(
          requiredSkills,
          optionalSkills,
          requiredYears,
          locations,
          remoteAvailable,
          engineerSkills,
          experienceTypes,
          skillYears,
          preferredLocation,
          remotePreferred,
          i);

      String matchLevel = getMatchLevel(score);

      System.out.println("\n" + (i + 1) + ". " + projectNames[i]);
      System.out.println("--------------------------------");
      System.out.println("マッチスコア:" + score + "点(" + matchLevel + ")");
    }
  }

  // 指定された添字の案件情報を1件表示する
  static void showProjectDetails(
      String[] projectNames,
      String[] requiredSkills,
      String[] optionalSkills,
      int[] requiredYears,
      String[] locations,
      boolean[] remoteAvailable,
      int i) {

    System.out.println("\n" + (i + 1) + ". " + projectNames[i]);
    System.out.println("--------------------------------");
    System.out.println("必須スキル: " + requiredSkills[i]);
    System.out.println("尚可スキル: " + optionalSkills[i]);

    if (requiredYears[i] == 0) {
      System.out.println("必要経験年数: 指定なし");
    } else {
      System.out.println("必要経験年数: " + requiredYears[i] + "年");
    }
    System.out.println("勤務地: " + locations[i]);

    if (remoteAvailable[i]) {
      System.out.println("リモート可否: 可");
    } else {
      System.out.println("リモート可否: 不可");
    }
  }

  // 指定された案件とエンジニア情報を比較し、マッチスコアを返す
  static int calculateMatchScore(
      String[] requiredSkills,
      String[] optionalSkills,
      int[] requiredYears,
      String[] locations,
      boolean[] remoteAvailable,
      String[] engineerSkills,
      int[] experienceTypes,
      int[] skillYears,
      String preferredLocation,
      boolean remotePreferred,
      int i) {

    int score = 0;

    // 必須スキルのマッチング
    // 実務経験あり: 50点、学習経験のみ: 25点
    for (int j = 0; j < engineerSkills.length; j++) {
      if (requiredSkills[i].equals(engineerSkills[j])) {
        if (experienceTypes[j] == 2) {
          score += 50;
        } else if (experienceTypes[j] == 1) {
          score += 25;
        }
        break;
      }
    }

    // 尚可スキルのマッチング
    // 実務経験あり: 15点、学習経験のみ: 8点
    for (int j = 0; j < engineerSkills.length; j++) {
      if (optionalSkills[i].equals(engineerSkills[j])) {
        if (experienceTypes[j] == 2) {
          score += 15;
        } else if (experienceTypes[j] == 1) {
          score += 8;
        }
        break;
      }
    }

    // 経験年数のマッチング
    // 必要経験年数の指定なし、または条件を満たす場合は15点
    // 条件未達の場合は実務経験年数に応じて部分点を加算
    if (requiredYears[i] == 0) {
      score += 15;
    } else {
      for (int j = 0; j < engineerSkills.length; j++) {
        if (requiredSkills[i].equals(engineerSkills[j])) {
          if (experienceTypes[j] == 2) {
            if (skillYears[j] >= requiredYears[i]) {
              score += 15;
            } else {
              score += skillYears[j] * 15 / requiredYears[i];
            }
          }
          break;
        }
      }
    }

    // 勤務地のマッチング
    // 希望勤務地と案件勤務地が一致する場合は10点
    if (locations[i].equals(preferredLocation)) {
      score += 10;
    }

    // リモート可否のマッチング
    // リモート希望の場合、案件がリモート対応なら10点
    // リモートを希望しない場合は案件条件に関係なく10点
    if (remotePreferred) {
      if (remoteAvailable[i]) {
        score += 10;
      }
    } else {
      score += 10;
    }

    // 算出した合計スコアを返す
    return score;
  }

  // マッチスコアからマッチレベルを判定して返す
  // 80点以上: 高マッチ、60点以上: 候補、それ未満: 低マッチ
  static String getMatchLevel(int score) {
    String matchLevel;
    if (score >= 80) {
      matchLevel = "高マッチ";
    } else if (score >= 60) {
      matchLevel = "候補";
    } else {
      matchLevel = "低マッチ";
    }

    return matchLevel;
  }
}
