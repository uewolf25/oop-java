package step1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CSVのデータ(CsvDataFieldクラス)をリストで管理するためのクラス。
 */
public class StudentData {

	/**
	 * CsvDataField型のリスト。CSVの全データを格納する。
	 */
	private List<CsvDataField> studentsList;

	/**
	 * インデックス番号をカウントする。
	 */
	private Integer indexSize;

	// private CsvDataField[] csvDataField;

	/**
	 * シングルトン設計。唯一のインスタンスを作る。
	 */
	private static StudentData studentData = new StudentData();


	/**
	 * コンストラクタ
	 * 外部ファイルからnewできない。
	 */
	public StudentData() {
		this.studentsList = new ArrayList<>();
		this.indexSize = 0;
	}

	/**
	 * CSVデータを格納する。
	 * @param data CSVのデータをCsvDataField型として格納。
	 *  
	 */
	public void appendData(CsvDataField data) {
		this.studentsList.add(data);
		// System.out.println(this.indexSize);
		this.indexSize++;
	}

	/**
	 * CSVのデータのGetter
	 * @param index 取り出したいリストのインデックス
	 */
	public CsvDataField getList(Integer index) {
		return this.studentsList.get(index);
	}

	/**
	 * リストの数のGetter
	 * @return リスト全体の大きさを返す
	 */
	public Integer getMaxIndex() {
		return this.indexSize;
	}

	/**
	 * 問題番号の最大値のGetter
	 * 問題番号をcsvData型のリストから抜き出し、比較して最大値を探索する
	 * @return 問題番号の最大値を返す
	 */
	public String getMaxQuestionNumber(){
		return this.studentsList.stream()
			.map(CsvDataField::getQuestionNumber)
			.max(Comparator.comparing(item -> item))
			.get();
	}


	/**
	 * 唯一のインスタンスを返す。
	 * @return インスタンス
	 */
	public static StudentData getInstance(){
		return studentData;
	}

	/**
	 * 得点一覧のGetter
	 * @param number 問題番号
	 * @return 得点をString型のリストとして返す
	 */
	public List<String> getPointList(String number) {
		return this.studentsList.stream()
			.filter(csvData -> csvData.getQuestionNumber().equals(number))
			.map(CsvDataField::getPoint)
			.collect(Collectors.toList());
	}

	/**
	 * @param qNumber 問題番号
	 * @return 指定した問題番号の要素数をリストで返す
	 */
	public Long getExamineeCount(String qNumber){
		return this.studentsList.stream()
			.filter(csvData -> csvData.getQuestionNumber().equals(qNumber))
			.count();
	}
}
