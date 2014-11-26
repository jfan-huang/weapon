/**
 * 
 */
package org.jfan.weapon.probability.random;

import java.util.Random;

/**
 * <br>
 * <br>
 * 
 * @author JFan - 2014年10月30日 上午9:32:35
 */
public final class RandomUtil {

	private static final char[] charArray = "abcdefghijklmnopqratuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final Random random = new Random();

	// 随机生成 34~64个长度在4~8的字符串
	public static final String[] strs;// strs 在类被装载时确定，如果重新装载‘比如重启服务’，其值会改变

	static {
		int cLength = charArray.length;
		int size = nextInt(32, 64);// 32 ~ 64
		strs = new String[size];
		for (int index = 0; index < size; index++) {
			int length = nextInt(4, 8);// 4 ~ 8
			char[] cs = new char[length];
			for (int jndex = 0; jndex < length; jndex++)
				cs[jndex] = charArray[nextInt(cLength)];
			strs[index] = new String(cs);
		}
	}

	public final static String choice() {
		return choice(strs);
	}

	@SuppressWarnings("unchecked")
	public final static <T> T choice(T... ts) {
		if (null == ts || 0 >= ts.length)
			return null;
		int size = ts.length;
		return ts[nextInt(size)];
	}

	public final static int nextInt(int bound) {
		return random.nextInt(bound);
	}

	public final static int nextInt(int min, int max) {
		if (min == max)
			return max;
		int min_ = (max < min ? max : min);
		int max_ = (min > max ? min : max);
		return min_ + nextInt(max_ - min_);
	}

	// ####
	// ## main

	public static void main(String[] args) {
		int s = 100;

		for (int i = 0; i < s; i++)
			System.out.println(choice());

		for (int i = 0; i < s; i++)
			System.out.println(nextInt(30, 20));
	}

}
