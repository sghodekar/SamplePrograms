package com.santosh.java;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {

	private Node<K,V>[] buckets;
	private int size = 100;
	
	public MyHashMap () {
		@SuppressWarnings("unchecked")
		Node<K,V>[] newbuckets = (Node<K,V>[])new Node[size];
		buckets = newbuckets;
	}
	
	private int keyHashCode(Object key) {
		return key!=null?key.hashCode() % 100:0;
	}
	
	public V get(Object key) {
		int hash = keyHashCode(key);
		
		if (buckets[hash] != null) {
			Node<K, V> n = buckets[hash];
			do {
				if (key == null && n.getKey() == null) {
					return n.getValue();
				}
				if (key!= null && key.equals(n.getKey())) {
					return n.getValue();
				}
				n = n.getNextNode();
			} while (n != null);
		}
		
		return null;
	}

	public V put(K key, V value) {
		int hash = keyHashCode(key);
		Node<K,V> prevNode = null;
		
		if (buckets[hash] != null) {
			Node<K, V> n = buckets[hash];
			do {
				if (key == null && n.getKey() == null) {
					Node<K,V> newNode = new Node(key, value);
					if (prevNode != null) {
						//replace newnode in the list
						newNode.nextNode = n.nextNode;
						prevNode.nextNode = newNode;
					} else
						buckets[hash] = newNode;
				}
				if (key!= null && key.equals(n.getKey())) {
					Node<K,V> newNode = new Node(key, value);
					if (prevNode != null) {
						//replace newnode in the list
						newNode.nextNode = n.nextNode;
						prevNode.nextNode = newNode;
					} else
						buckets[hash] = newNode;
				}
				
				prevNode = n;
				n = n.getNextNode();
			} while (n != null);
		} else
		{
			buckets[hash] = new Node<K, V>(key, value);
		}
		return null;
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		// TODO Auto-generated method stub		
	}

	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		MyHashMap<String, String> hm = new MyHashMap<String, String>();
		
		hm.put("Sec1", "Bond");
		hm.put("Sec2", "Agency");
		hm.put("Sec3", "Futures");
		hm.put("Sec1", "Options");
		
		System.out.println(hm.get("Sec2"));
		System.out.println(hm.get("Sec1"));
	}
    
}

class Node<K,V> {
	K key;
	V value;
	Node<K,V> nextNode = null;
	
	Node() {
		
	}
	
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public Node<K,V> getNextNode() {
		return nextNode;
	}	

}