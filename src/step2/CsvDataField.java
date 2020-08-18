package step2;

/**
 * CSVのデータを格納する。
 */
public class CsvDataField {

	/**
	 * 日付
	 */
	private String date;

	/**
	 * ファイルの種類。(reading or writing)
	 */
	private String fileType;

	/**
	 * 課題番号
	 */
	private String questionNumber;

	/**
	 * 学生ID
	 */
	private Integer studentId;

	/**
	 * 点数
	 */
	private String point;

	/**
	 * テスト開始時刻
	 */
	private String startTime;

	/**
	 * テスト提出時刻
	 */
	private String submitTime;

	// private StudentData studentData;

	/**
	 * コンストラクタ
	 * 
	 * @param date 
	 * @param fileType 
	 * @param questionNumber 
	 * @param studentId 
	 * @param point 
	 * @param startTime 
	 * @param submitTime 
	 */
	public CsvDataField(
		String date, 
		String fileType, 
		String questionNumber, 
		Integer studentId, 
		String point, 
		String startTime, 
		String submitTime
		) {
			this.date = date;
			this.fileType = fileType;
			this.questionNumber = questionNumber;
			this.studentId = studentId;
			this.point = point;
			this.startTime = startTime;
			this.submitTime = submitTime;
	}

	/**
	 * 課題番号のGetter
	 * @return 問題番号
	 */
	public String getQuestionNumber() {
		return this.questionNumber;
	}

	/**
	 * 提出時間のGetter
	 * @return 得点
	 */
	public String getPoint(){
		return this.point;
	}

	/**
	 * 提出時間のGetter
	 * @return 提出時刻
	 */
	public String getSubmitTime() {
		return this.submitTime;
	}

}
