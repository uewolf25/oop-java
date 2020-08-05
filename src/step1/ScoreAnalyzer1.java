package step1;

import abstractClass.AbstractFileClass;

/**
 * メインクラス
 */
public class ScoreAnalyzer1 {

	/**
	 * メインメソッド
	 *  
	 */
	public static void main(String... arguments) {
		String questionNumber = null;
		String csvFile = null;
		
		try{
			questionNumber = arguments[0];
			csvFile = arguments[1];
		} catch(ArrayIndexOutOfBoundsException e){ 
			Printer printer = new Printer();
			printer.inputHelpPrint();
			e.printStackTrace(); 
		}

		FileClass fileClass = new FileClass(csvFile);
		fileClass.reader();

		Calculation aCalculation = new Calculation(questionNumber);
		aCalculation.setMap();
		aCalculation.calculation();
	}

}
