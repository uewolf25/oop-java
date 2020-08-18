package step2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.function.BiConsumer;
// import java.util.function.Consumer;
import java.util.stream.Collectors;

import abstractClass.AbstractCalculationClass;

/**
 * 計算を行う具象クラス。
 */
public class Calculation extends AbstractCalculationClass{

	/**
	 * (問題番号：点数) の情報を持つ
	 */
	private Map<String, Integer> scoreMap;

	/**
	 * 問題番号
	 */
	private String questionNumber;

	/**
	 * csvのデータが格納されたStudentDataのインスタンス
	 */
	private StudentData studentsData;

	private AbstractCalculationClass abstractCalculationClass;

	/**
	 * コンストラクタ。
	 * @param qNumber 問題番号
	 */
	protected Calculation(Integer count) {
		this.questionNumber = String.valueOf(count);
		this.scoreMap = new HashMap<>();
		this.studentsData = StudentData.getInstance();
	}


	/**
	 * mapに点数の種類とそれぞれの人数を格納する。
	 * 繰り返しが行えるように引数は問題番号をとる。
	 * 
	 *  
	 */
	public void setMap() {
		List<String> scoreList = this.studentsData.getPointList(this.questionNumber);
		scoreList.stream()
			.forEach(score -> {
				try {
					this.scoreMap.put(score, this.scoreMap.get(score) + 1);
				} catch (NullPointerException e) {
					this.scoreMap.put(score, 1);
				}
			}
		);
	}
	
	/**
	 * 割合の計算。100.0 / 人数でスコアの割合の計算が可能。
	 * print(
	 * 点数：　スコアの割合 (人数 / 全人数)
	 *  )
	 */
	protected void calculation() {
		Integer examineeCount = this.studentsData.getExamineeCount(this.questionNumber).intValue();
		// this.scoreMap.forEach((key, value) -> System.out.println(key + " : " + value));

		// 問題番号の出力
		System.out.printf("%s, ", this.questionNumber);
		
		String outputCsvFormat = 
			this.scoreMap.entrySet().stream()
				.map(e -> String.format("%.3f", (double)e.getValue()/examineeCount * 100))
				.collect(Collectors.joining(","));
		
		System.out.println(outputCsvFormat);
	}
}
