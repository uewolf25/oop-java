package abstractClass;

import step2.Calculation;

/**
 * 計算を行う抽象クラス。
 */
public abstract class AbstractCalculationClass {

	protected AbstractCalculationClass() {}

	private Calculation calculation;

	protected abstract void calculation();

}
