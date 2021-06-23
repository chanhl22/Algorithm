import java.util.*;

class Person{
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

public class Test {
	public static void main(String[] args) {
		Person a = new Person("Noah");
		Person b = new Person("Noah");

		System.out.println(a == b);

		String a2 = "noah";
		String b2 = "noah";
		System.out.println(a2 == b2);

		String a3 = new String("Noah");
		String b3 = new String("Noah");
		System.out.println(a3 == b3);
		HashSet<String> a1 = new HashSet<String>();
		a1.add(a2);
		a1.add(b2);
		System.out.println(a1.size());
		ArrayList<String[]> list2 = new ArrayList<String[]>();  //String[] 타입을 받는 ArrayList 생성
		list2.add(new String[]{"가을", "하늘"});                 //요소를 추가한다.

		for(int t=0; t<list2.size(); t++)                            //요소의 크기만큼 돌면서
			System.out.println(list2.get(t)[0]);
	}
}

//import java.util.*;
//
//public class Test {
//	public static void main(String[] args) {
//
//	}
//}