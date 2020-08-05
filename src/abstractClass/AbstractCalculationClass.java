package abstractClass;

import step1.Calculation;

/**
 * 計算を行う抽象クラス。
 */
public abstract class AbstractCalculationClass {

	protected AbstractCalculationClass() {}

	private Calculation calculation;

	protected abstract void calculation();

}
