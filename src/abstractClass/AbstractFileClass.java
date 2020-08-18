package abstractClass;

import step2.FileClass;

/**
 * ファイルの読み書きを行う抽象クラス。
 */
public abstract class AbstractFileClass {

	protected AbstractFileClass() {}

	private FileClass fileClass;

	protected abstract void reader();

	protected abstract void writer(String str);

}
