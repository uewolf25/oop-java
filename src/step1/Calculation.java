package step1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.function.BiConsumer;
// import java.util.function.Consumer;

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
	 * 点数：割合の情報を持つ
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
	protected Calculation(String qNumber) {
		this.questionNumber = qNumber;
		this.scoreMap = new HashMap<>();
		this.studentsData = StudentData.getInstance();
	}

	/**
	 * mapにデータを格納。
	 *  
	 */
	public void setMap() {
		if(!(Integer.valueOf(this.questionNumber) <= Integer.valueOf(this.studentsData.getMaxQuestionNumber()))){
			System.err.println("問題番号の入力値が不適です。");
			System.exit(-1);
		}
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

		// StreamAPIでスマートに例外処理
		// scoreList.stream()
		// 	.forEach(ConsumerNullPointerThrows(score -> { this.scoreMap.put(score, this.scoreMap.get(score) + 1 ); }, 
		// 																		(error, score) -> this.scoreMap.put(score, 1)) 
		// 	);
	}

	// /**
	//  * 例外インタフェース
	//  * @param <T>
	//  */
	// interface ThrowableConsumer<T> {
  //   void accept(T t) throws NullPointerException;
  // }
	
	// /**
	//  * 例外Consumer
	//  */
  // public <T> Consumer<T> ConsumerNullPointerThrows(ThrowableConsumer<T> tryException,
  //                                          BiConsumer<NullPointerException, T> catchException){
  //   return t -> {
  //     try {
  //       tryException.accept(t);
  //     } catch (NullPointerException error) {
  //       catchException.accept(error, t);
  //     }
  //   };
  // }

	/**
	 * 割合の計算。100.0 / 人数でスコアの割合の計算が可能。
	 * print(
	 * 点数：　スコアの割合 (人数 / 全人数)
	 *  )
	 */
	@Override
	protected void calculation() {
		Integer examineeCount = this.studentsData.getExamineeCount(this.questionNumber).intValue();
		// this.scoreMap.forEach((key, value) -> System.out.println(key + " : " + value));

		this.scoreMap.entrySet().stream()
			.forEach(e -> {
				System.out.format("%2s: %4.3f (%3d/%d)", 
													e.getKey(), 
													(double)e.getValue()/examineeCount * 100, 
													e.getValue(),
													examineeCount)
									.println();
			}
		);
	}
}
