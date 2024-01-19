package object.day9;

import java.util.Arrays;
import java.util.Comparator;

import object.day6.AddQuiz;

/* 
 * Arrays.sort 메소드 두 번째 인자로 Comparator 인터페이스 타입 객체를 전달하는 예제
 *  비교 기준과 정렬 종류를 실행시점에서 결정.
 */
public class C25StudentCompareTest {

    public static void main(String[] args) {
        Student[] students = new Student[4];
        AddQuiz utils = new AddQuiz();

        for (int i =0 ; i < students.length ; i++){

            students[i] = new Student("장"+ utils.makeRandomNumber(0, 10), utils.makeRandomNumber(20, 25), (char)(utils.makeRandomNumber(65, 70)));

        }

        System.out.println("초기 students 배열 : \n" + Arrays.toString(students));
        
        // Arrays.sort(students);      // Comparable 객체 형변환 불가능 오류
        
        Comparator<Student> ageAscending = new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {    // o1객체와 o2 객체를 비교
                return o1.getAge() - o2.getAge();
            }
            // ascending : 오름차순
        };

        Arrays.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {    // o1객체와 o2 객체를 비교
                return o1.getAge() - o2.getAge();
            }
            // ascending : 오름차순
        });        // 나이 오름차순 정렬
        // 오름/내림 차순 상관없이 교환해주지 않아도 되는 경우는 음수값으로 리턴합니다.
        // sort 메소드 정렬 알고리즘은 비교결과 음수를 리턴하면 교환하지 않고 양수를 리턴하면 교환합니다.
        System.out.println("나이 오름차순 정렬 후  students 배열 : \n" + Arrays.toString(students));

        Comparator<Student> nameAscending = new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {    // o1객체와 o2 객체를 비교
                return o1.getName().compareTo(o2.getName());
            }
            // ascending : 오름차순
        };

        Arrays.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {    // o1객체와 o2 객체를 비교
                return o1.getName().compareTo(o2.getName());
            }
        });

        // 람다식, 이름 오름차순 
        Arrays.sort(students, (o1, o2) -> {    // o1객체와 o2 객체를 비교
                return o1.getName().compareTo(o2.getName());
        });
        System.out.println("이름 오름차순 정렬 후  students 배열 : \n" + Arrays.toString(students));

        // 람다식, 이름 내림차순 
        Arrays.sort(students, (o1, o2) -> {    // o1객체와 o2 객체를 비교
                return o2.getName().compareTo(o1.getName());
        });
        System.out.println("이름 내림차순 정렬 후  students 배열 : \n" + Arrays.toString(students));

        // 성적 오름차순
        Arrays.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {    // o1객체와 o2 객체를 비교
                return o1.getGrade() - o2.getGrade();
            }
        });

        System.out.println("성적 오름차순 정렬 후  students 배열 : \n" + Arrays.toString(students));

        // 람다식, 성적 내림차순
        Arrays.sort(students, (o1, o2) -> {    // o1객체와 o2 객체를 비교
            return o2.getGrade() - o1.getGrade();
            
        });

        System.out.println("성적 내림차순 정렬 후  students 배열 : \n" + Arrays.toString(students));
        
    }
    
}
