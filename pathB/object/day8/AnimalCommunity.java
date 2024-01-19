package object.day8;


public class AnimalCommunity {

	public static void main(String[] args)  {
			System.out.println("~~~  여기는 유기동물 분양소 입니다 ~~~");
			Animal[] animals = new Animal[10];
			animals[0] = new Puppy("푸들이","브라운");

			animals[1] = new Cat("그레이");
			
			animals[2] = new Rabbit();
			animals[2].setColor("화이트");

			animals[3] = new Puppy("말티즈","화이트");

			// 퀴즈 : 아래 객체를 배열요소에 추가했습니다. 수정이 필요한 코드를 수정하세요
			animals[7] = new Animal() {
				static final String TYPE = "새";

				@Override
				public void sound() {
					System.out.println("앵무새는 안녕~~ 하고 말합니다");
				}

				public String toString() {
					return TYPE + "[color="+ color + ", name = " + name + "]";
				}
				
			};

			animals[7].setName("앵무새");
			animals[7].setColor("빨강");;

			System.out.println("\n[[반려동물 목록을 보여드리겠습니다.]] \n");
			for(int i=0;i<animals.length;i++) {
				if(animals[i]!= null)			// 베열에 참조값이 있는지 검사
					animals[i].sound();			// null 일때 메소드 실행시 오류 발생
			}	
			
	//	모모회원이 동물 보호소의 모든 동물들을 분양 받을 수 있는지 셀프 체크
	//	동물 보호소 규정(비즈니스 로직)
	//			ㄴ 강아지는 15세이상, 고양이는 18세이상, 토끼는 13세 이상 그 이외는 20세 이상 분양받을 수 있습니다.			
	//			ㄴ Member 클래스 isAdopt 메소드에서 검사 -> instanceof 연산 사용
		String name="모모";
		int age = 17;
	    Member member = new Member(age, name);		// Member 클래스의 인스턴스 필드는 2개 age, name
		
		StringBuilder sb = new StringBuilder(name);	// 문자열 연결 결과 다른 문자열이 나오면 객체를 새로 만들어 저장
		// String 객체는 불변객체 (문자열 변경 불가능) 
		// StringBuilder 객체는 가변 객체 (문자열 변경 가능,  문자열 추가 연산 등의 결과를 동일 객체에 저장) => 문자열 연결 연산에 사용

		sb.append(" 회원님 \n");				// message += " 회원님 \n" 과 같음
		boolean result;
		for(int i=0;i<animals.length;i++) {
			
			if(animals[i]==null) 
				//break;				// 배열요소에 객체를 참조하는 값이 없으면 break
				continue;				// null을 만나면 다음 명령어들 실행 안하고 for문 i++부터 다시 시작

			
			result =member.isAdopt(animals[i]);		// 인자를 Animal 타입으로 전달받는 메소드 (다형성 예시)
			sb.append(animals[i].toString());		// message += animals[i].toString(); 와 같음	
			
/* 			if(result) {
				sb.append("  😃 분양 가능합니다. \n");	// message += "  😃 분양 가능합니다. \n"
			} else {
				sb.append("  😓 분양 자격이 안됩니다.\n");
			}
 */
			String msg =  member.isAdopt(animals[i]) ? "\t😃 분양 가능합니다. \n": "\t😓 분양 자격이 안됩니다.\n";
			sb.append(msg);
		}
		System.out.println();
		System.out.println(sb.toString());		// StringBuilder 타입 데이터는 println 인자로 쓸때 toString() 자동 실행
		System.out.println(sb);		

	}//main end


	
}







