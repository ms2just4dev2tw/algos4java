package org.self.sorting;

public enum SortType {
	ASCEND, // 升序
	DESCEND,;// 降序

	/**
	 * @param <K>
	 * @param key1 key1 位于 key2 的前方
	 * @param key2 key2 位于 key1 的后方
	 * @return 根据排序类型返回 key1 与 key2 是否是合理的顺序
	 */
	public <K extends Comparable<K>> boolean isAccord(K key1, K key2) {
		return !notAccord(key1, key2);
	}

	/**
	 * @param <K>
	 * @param key1 key1 位于 key2 的前方
	 * @param key2 key2 位于 key1 的后方
	 * @return 根据排序类型返回 key1 与 key2 是否是不合理的顺序
	 */
	public <K extends Comparable<K>> boolean notAccord(K key1, K key2) {
		switch (this) {
		case ASCEND:
			return key1.compareTo(key2) > 0;
		case DESCEND:
			return key1.compareTo(key2) < 0;
		default:
			throw new UnsupportedOperationException("UnsupportedOperation");
		}
	}

}
