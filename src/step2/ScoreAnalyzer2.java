package step2;

import java.util.stream.IntStream;

import abstractClass.AbstractFileClass;

/**
 * メインクラス
 */
public class ScoreAnalyzer2 {

	/**
	 * メインメソッド
	 *  
	 */
	public static void main(String... arguments) {
		String csvFile = null;
		
		try{
			csvFile = arguments[0];
		} catch(ArrayIndexOutOfBoundsException e){ 
			Printer printer = new Printer();
			printer.inputHelpPrint();
			e.printStackTrace(); 
		}

		FileClass fileClass = new FileClass(csvFile);
		fileClass.reader();

		// CSVファイルのデータを管理しているクラス
		StudentData studentData = StudentData.getInstance();
		// 点数の出現回数を出力
		System.out.println(studentData.getAllPoint());
		// 問題の最大番号の取得
		Integer sumOfqNumber = Integer.valueOf(studentData.getMaxQuestionNumber());
		// 問題数分スコアの割合を計算し、出力する。
		IntStream.rangeClosed(1, sumOfqNumber)
			.forEach(qNum -> {
				Calculation aCalculation = new Calculation(qNum);
				aCalculation.setMap();
				aCalculation.calculation();
			});
	}

}
