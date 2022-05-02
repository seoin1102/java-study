package prob3;

public class Sparrow extends Bird {
	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void fly() {
		System.out.println("참새(" + getName() + ")는 날아다닙니다.");
	}

	@Override
	public void sing() {
		System.out.println("참새(" + getName() + ")는 소리내어 웁니다.");
	}

	@Override
	public String toString() { // // System.out.println(Sparrow)을 실행하면 메소드 실행
		return "참새의 이름은 " + name + " 입니다.";
	}
}
