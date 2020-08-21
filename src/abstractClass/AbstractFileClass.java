package abstractClass;

/**
 * ファイルの読み書きを行う抽象クラス。
 */
public abstract class AbstractFileClass {

	protected AbstractFileClass() {}

	protected abstract void reader();

	protected abstract void writer(String str);

}
