package com.goura.test.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap<K, V> {
	private int currentBucketSize = 20;
	private List<Bucket> buckets = new ArrayList<>(currentBucketSize);

	public MyHashMap() {
		for (int i = 0; i < currentBucketSize; i++) {
			buckets.add(new Bucket());
		}
	}

	class Bucket {
		LinkedList<Entry<K, V>> elements = new LinkedList<>();

		Entry<K, V> find(K key) {
			for (Entry<K, V> e : elements) {
				if (e.getKey().equals(key)) {
					return e;
				}
			}
			return null;
		}

		void put(Entry<K, V> e) {
			elements.add(e);
		}
	}

	public V get(K k) {
		int hash = k.hashCode();
		int bucketNo = hash % currentBucketSize;
		return findValue(buckets.get(bucketNo), k);
	}

	private V findValue(Bucket b, K k) {
		Entry<K, V> entry = b.find(k);
		return null == entry? null : entry.getValue();
	}

	void put(K key, V value) {
		Entry<K, V> e = new Entry<>(key, value);
		int bucketNo = key.hashCode() % currentBucketSize;
		buckets.get(bucketNo).put(e);
	}

	static class Entry<K, V> {
		K key;
		V value;

		public Entry(K k, V v) {
			this.key = k;
			this.value = v;
		}

		K getKey() {
			return this.key;
		}

		V getValue() {
			return this.value;
		}
	}
}
