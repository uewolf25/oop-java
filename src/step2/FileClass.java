package step2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import abstractClass.AbstractFileClass;

/**
 * ファイルの読み書きを行う具象クラス。
 */
public class FileClass extends AbstractFileClass{

	/**
	 * 引数のファイル名
	 */
	private File fileName;

	/**
	 * 出力用のファイルパス
	 */
	private String outputFilePath = "../../output";

	// private AbstractFileClass abstractFileClass;
	

	/**
	 * コンストラクタ。
	 * @param file 引数で与えるファイル
	 *  
	 */
	public FileClass(String file) {
		this.fileName = new File(file);
	}

	/**
	 * CSVファイルの読み込みを行う。
	 * 1行ずつ読み込み、コンマで区切る。各データをStudentData::appendDataに追加していく。
	 *  
	 */
	@Override
	public void reader(){
		StudentData studentData = StudentData.getInstance();
		// ファイル読み込み用
		String lines;

		try {
			BufferedReader input = new BufferedReader(new FileReader(this.fileName));
			while( (lines = input.readLine()) != null ){
				// fileLineList.add(line);
				String[] line = lines.split(",", -1);
				studentData.appendData(new CsvDataField(line[0],
																								line[1],
																								line[2],
																								Integer.valueOf(line[3]),
																								line[4],// == "" ? null : line[4],
																								line[5],
																								line[6])
				);
			}
			input.close();
				
		} 
		catch (FileNotFoundException e) { 
			System.out.println("ファイルが見つかりません。"); 
			System.out.println(e); 
		}
		catch (IOException e) { System.out.println(e); }
	}

	/**
	 * CSVの書き込みを行う。
	 * 
	 */
	@Override
	protected void writer(String outputString) {
		System.out.println("使用しません。");
		// try {
		// 	FileWriter output = new FileWriter(outputFilePath, true);
		// 	output.write(outputString);
		// 	output.close();
		// } catch (IOException e) {
		// 	System.out.println(e);
		// }
	}
}
