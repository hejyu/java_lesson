package io.day13;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class D07ImageFileCopy {

    public static void main(String[] args) {
        
        // System 클래스에서 시간 측정할 수 있는 메소드 : ns 10억분의 1, ms : 1000분의 1
        long start = System.nanoTime();     // 시작시간

        // 처리할 메소드
        // copyByByte();       // 소요시간 : 3,902,944,999 ns
        // copyByByteArray();  // 소요시간 :    24,216,100 ns
        copyByButter();        // 소요시간 :    14,088,500 ns
        long end = System.nanoTime();       // 메소드 종료시간
        System.out.println(String.format("소요시간 : %,d ns",(end-start)));

    }
    
    /**
     * 1바이트 단위 입출력
     */
    public static void copyByByte() {
        int b; int count=0;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        // try with resources - try () 안에 close 해야 할 자원(리소스.파일입출력스트림)을 선언하면
        //                      finally없이 close를 자동으로 한다. 이때 자원은 Closeable 인터페이스 구현체이어야 합니다

        try {
            fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\계곡.jpg");
            fos = new FileOutputStream("계곡복사2.jpg");
            
            while((b=fis.read())!= -1){      //1바이트 씩 복사하기(파일fis에서 파일fos 로)
                
                fos.write(b);   
                count++;
            }
        }catch (IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }finally {
            try{ 
                fis.close(); 
                fos.close();}
            catch(IOException e) {}
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }

    public static void copyByByteArray() {
        int b; int count=0;
        byte[] buffer = new byte[1024];  //  -> 버퍼에서 씀. 버퍼입출력스트림

        try
        (FileInputStream fis = new FileInputStream("C:\\\\Users\\\\Administrator\\\\Downloads\\\\계곡.jpg");
        FileOutputStream fos = new FileOutputStream("계곡복사4.jpg")){
            
            while((b=fis.read(buffer,0,buffer.length)) != -1){      
                //read(배열이름,시작위치,길이) 리턴값 b는 실제 읽어온 바이트 수
                //길이 1024바이트가 안될수도 있으므로 실제 읽어온 바이트 수를 알아야 처리할 수 있음
                fos.write(buffer,0,b); // write(배열이름, 시작인덱스, 출력길이)
                count+=b;
            }

        }catch(IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }
        
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }
    
    

    public static void copyByButter() {
        int b; int count=0;
        byte[] buffer = new byte[1024];

        try
        (
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\Administrator\\Downloads\\계곡.jpg"));     // 보조 버퍼입력스트림
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("계곡복사3.jpg"))   // 보조 버퍼출력스트림
        ){
            
            while((b=bis.read(buffer,0,buffer.length)) != -1){      
                //read(배열이름,시작위치,길이) 리턴값 b는 실제 읽어온 바이트 수
                //길이 1024바이트가 안될수도 있으므로 실제 읽어온 바이트 수를 알아야 처리할 수 있음
                bos.write(buffer,0,b); // write(배열이름, 시작인덱스, 출력길이)
                count+=b;
            }

        }catch(IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }
        
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }

    

}
