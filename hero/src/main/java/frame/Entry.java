package main.java.frame;

//键值对
public class Entry {
	
	public Object key;
	public Object value;
	
	public Entry(Object key, Object value) {
//      super();
		this.key = key;
		this.value = value;
	}
  
	@Override
	public String toString() {
		return "[key=" + key + ", value=" + value + "]";
	}
}

