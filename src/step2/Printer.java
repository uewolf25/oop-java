package step2;

/**
 * ヘルプやメッセージを出力するクラス。
 */
public class Printer{
  /**
   * コンストラクタ
   */
  public Printer(){};

  public void inputHelpPrint(){
    System.out.println("入力方法が不適です。");
    System.out.println("Usage: java JAVA_FILE number CSV_FILE");
    System.out.format("JAVA_FILE:%n\tstep1/ScoreAnalyzer1%n");
    System.out.format("number:%n\t1~6%n");
    System.out.format("CSV_FILE:%n\t../csvFile/writing.csv%n\t../csvFile/reading.csv%n");
    System.out.format("===================================================================")
              .println();
  }
}