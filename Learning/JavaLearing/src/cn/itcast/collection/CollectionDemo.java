package cn.itcast.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionDemo {
	public static void main(String [] arg) {
		Collection coll = new ArrayList<>();
		show(coll);
	}

	public static void show(Collection coll) {
		
		//���Ԫ��
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		coll.add("abc4");
		System.out.println(coll);
		
		//ɾ��Ԫ��
		coll.remove("abc2");
		System.out.println(coll);
		
	}
}
