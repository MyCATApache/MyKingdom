package edu.ldcollege.bean;

public class KeyValueBean<K,V> {
public K key;
public V value;
public KeyValueBean()
{
	this(null,null);
}
public KeyValueBean(K key,V value)
{
	this.key=key;
	this.value=value;
}
}
