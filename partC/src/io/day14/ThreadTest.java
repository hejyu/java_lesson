package io.day14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadTest {
    public static void main(String[] args) {
        // 실행 시간이 오래 걸릴 경우 실행 중이라는 표시를 사용자에게 보여줍니다
        //      예제 : main 쓰레드의 실행중 표시를 . 출력 => 쓰레드로 작성합니다 
        // 쓰레드 작성방식 2가지 : 1) Thread 클래스를 상속  2) Runnable 인터페이스를 구현
        Runnable runnable = new Runnable() {
            
            // 쓰레드가 할일을 인터페이스로 활용하여 정의 (익명클래스)
            @Override
            public void run() {     // 쓰레드가 할 일을 여기에 작성합니다
                boolean run =true;
                while(run) {
                    System.out.print(".");
                    try {
                        Thread.sleep(500);     // 쓰레드에 지연시간을 줍니다
                    } catch (InterruptedException e) { 
                        run = false;
                        System.out.println();
                    }
                    // interrupt : 방해하다. 간섭하다. 끼어들다
                }
            }

        };

        // 1. 쓰레드 생성. 할일은 생성자의 인자로 전달
        Thread thread = new Thread(runnable);
        // 2. 쓰레드 실행
        thread.start();

        // 3. System 클래스에서 시간 측정할 수 있는 메소드 : ns 10억분의 1, ms : 1000분의 1
        long start = System.nanoTime();     // 시작시간
        copyByByte();        // main 쓰레드에서 실행
        long end = System.nanoTime();       // 메소드 종료시간
        System.out.println(String.format("소요시간 : %,d ns",(end-start)));

        // 4. 쓰레드 종료를 위해 인터럽트 발생시키기
        // thread.stop();      // not recommend
        thread.interrupt();

        
    }

    public static void copyByByte() {
        int b; int count=0;
        // try with resources - try () 안에 close 해야 할 자원(리소스.파일입출력스트림)을 선언하면
        //                      finally없이 close를 자동으로 한다. 이때 자원은 Closeable 인터페이스 구현체이어야 합니다
        try(
            FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\stream.jpg");
            FileOutputStream fos = new FileOutputStream("계곡복사2.jpg")
        ) {
            while((b=fis.read())!= -1){      //1바이트 씩 복사하기(파일fis에서 파일fos 로)    
                System.out.println(Integer.toBinaryString(b));
                fos.write(b);   
                count++;
            }

        } catch (IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }

        System.out.println(String.format("\n복사한 파일 크기 : %,d 바이트",count));
    }
}
