package io.day14;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket.png 그림참고 : 클라이언트와 서버 각각 실행하는 메소드가 다릅니다
 *                      서버와 클라이언트 연결 과정이 다르기 때문
 * 프로그램 실행은 서버가 먼저 실행중이어야 함
 */
public class Server {
 
    public static void main(String[] args) {

        ServerSocket server = null;
        Socket socket = null;
        BufferedOutputStream bos = null;
        InputStream is = null;
        DataInputStream dis = null;
        OutputStream os = null;
        DataOutputStream dos = null;

        try {
            // 서버 소켓을 생성
            server = new ServerSocket();
            // 시간 중지 시간 설정
            Thread.sleep(3000);     // 단위 ms,  3초

            // 1 바인딩 (Bind) : 서버 연결 정보를 설정 ip와 port 셋팅
            server.bind(new InetSocketAddress("192.168.30.8", 5050));
            System.out.println("[서버프로그램 시작] : 연결 요청을 기다리는 중입니다.");

            // 3. 수락 (Accept) : 클라이언트 커넥트요청에 대한 수락
            // 자바 플랫폼이 실행되고 있는 윈도우 방화벽 연결허용
            socket = server.accept();                                   // 입출력 스트림을 만들 소켓
            System.out.println("__연결을 수락합니다.");                 // 정상적으로 accept 되면 실행


            // 서버가 클라이언트에게 데이터 보내기 : 출력 스트림을 만들 소켓
            // 클라이언트와 서버가 연결된 소켓으로 출력스트림을 생성
            os = socket.getOutputStream();
            // 정수, 실수, 문자열 보내는 스트림
            dos = new DataOutputStream((os));      // 보조 스트림  
            dos.writeUTF("\t From 서버 >> 환영합니다 저의 이름은 모모  ");

            // 클라이언트가 보낸 인사말 읽기
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            String message = dis.readUTF();
            System.out.println(message);


            // 클라이언트가 보낸 이미지 읽기(받기)
            // 파일명은 "d:\\stream.jpg" 다운로드 위치는 d드라이브 입니다
            
            // 클라이언트가 업로드한 파일명 서버에서 읽기
            String filename =  dis.readUTF();
            System.out.println("\"From 클라이언트 파일명 >>  " + filename);
            bos = new BufferedOutputStream(new FileOutputStream("D:\\upload\\" + filename));

            int b; int count=0;
            while ((b=dis.read()) != -1) {
                bos.write(b);           // 클라이언트가 보낸 이미지를 서버에 저장시키는 코드(버퍼스트림 사용 바이트 단위 출력)
                count++;
            }

            System.out.println("파일 받기 완료 !! 파일 크기(바이트) :" + count);


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();        //예외 발생했을 때 코드 수정하려면 필요함
        } finally {
            try { // 자원해제. close 처리 실행
                server.close(); socket.close(); bos.close(); 
                is.close(); dis.close();  os.close(); dos.close();

            } catch (IOException e) {
                
            }
        }
    }
}
