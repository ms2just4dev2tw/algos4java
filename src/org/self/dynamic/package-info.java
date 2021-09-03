/**
 * <h2>动态规划</h2>
 * <h3>{@link org.self.dynamic.knapsack 1，0-1背包问题}</h3>
 * <b>确定版本的0-1背包问题是NP完全问题</b>
 * <p>
 * 贪心算法求解0-1背包问题存在诸多问题，根据最小重量，最大价值和价值重量比选择物品都可能失败
 * <p>
 * 一个背包问题例子：背包负重capacity=100
 * <p>
 * weight				20		30		40		50		60<p>
 * value					20		30		44		55		60<p>
 * value/weight		 1		 1		1.1	1.1	 1
 * <p>
 * 选择方式			X1		X2		X3		X4		X5		最终价值<p>
 * 最小重量			 1		 1		 1		 0		 0			 94	<p>
 * 最大价值			 0		 0 		 1		 0		 1			104	<p>
 * 价值/重量			 0		 0 		 1		 1		 0			 99	<p>
 * 最优值				 1		 1 		 0		 1		 0			105
 * <p>
 * 
 * <h3>{@link org.self.dynamic.MatrixChain 2，矩阵链乘问题}</h3>
 * <p>
 */
package org.self.dynamic;
