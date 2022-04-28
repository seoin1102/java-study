package chapter3;

public class StudentTest {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setGrade(1);
		
		Person p1 = s1; //upcasting(person이라고 안붙여줘도 됨. 암시적, implicity) 자식을 부모로
		p1.setName("둘리");
		
		Student s2 =(Student)p1; //downcasting(명시적, Explicity)
		s2.setMajor("cs");
	}
}
