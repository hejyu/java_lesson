1. 입출력 비교
    단위 : 1바이트 -> 바이트 배열 -> 바이트배열 + 버퍼를 이용
    - 소요시간 차이

2. checked Exception
    - try catch 반드시 처리 예외

3. file input/out stream close()    
    - try() 안에 close 해야될 자원 작성
    - 자원은 Closeable 인터페이스를 구현한 객체여야 한다.


표준입력(콘솔장치-키보드)
키보드 입력 => 입력 버퍼 => 프로그램 메모리

표준출력(콘솔장치-화면)
프로그램 메모리 => 출력버퍼 =>  화면(모니터)

한글 인코딩
유니코드(UTF-8 UTF-16) 중에 UTF-8. 한글(다국어) 3바이트
윈도우 터미널 MS949(CP949) 는 EUC-KR 국산인코딩 방식을 따름
한글 2바이트 
