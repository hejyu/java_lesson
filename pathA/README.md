## git 버전 관리 

### git 설치
* [git-scm 다운로드](https://git-scm.com/)

### github 원격 저장소 사용하기

* [github 계정만들기](https://github.com/)


#### 로컬 저장소 초기화

1. git bash 열기

    로컬 저장소 마우스 오른쪽 클릭 > Open Git Bash 

    ![Alt text](image-2.png)

1. Class231228 - java 폴더 초기화

    $ git init

1. git 사용자 이메일 설정

    $ git config --global user.email "자신의 이메일"

1. git 사용자 이름 설정

    $ git config --global user.name "자신의 이름"

1. git 사용자 이메일 확인

    $ git config user.email

#### 로컬 저장소를 원격 저장소에 연결

1. 원격 저장소에 연결

    $ git remote add origin 자신의 원격 저장소의 주소

1. 원격 저장소 상태 확인

    $ git remote -v

#### 로컬 저장소 커밋
![Alt text](image.png)
* 파일의 변경점을 관리하기 위한 기록입니다.
* git 명령어와 vs code 메뉴를 사용할 수 있습니다.
* 편의상 vs code 메뉴를 활용해 커밋 했습니다.
    - Changes 항목 아래에는 commit 대상이 되는 파일들이 보입니다.
    - 그 파일들 중에서 원하는 파일들으 선택해서 + 아이콘을 선택하여
    Stage 항목에 올립니다.
    - Commit 버튼 클릭 전 커밋 메시지를 작성해야 합니다.



#### 원격 저장소로 Push
* Stage 로 올린 파일들을 원격 저장소로 보내 저장합니다.

    $ git push origin main

    - 로컬 저장소 mian 에 커밋된 파일들을 원격 저장소 origin 으로 push 하는 명령입니다.
    - push 를 처음 할 때는 github 인증 절차 화면으로 자동 이동 합니다. 버튼 클릭!!


* 원격 저장소를 새로 고침하면 커밋한 파일들의 목록을 확인할 수 있습니다.

* 커밋 히스토리를 확인합니다

    $ git log
    
    ![Alt text](image-3.png)



### <u>집에서 원격 저장소에 연결하는 법</u>

#### 1) git clone 원격 저장소의 주소
#### 2) git config --global user.email
#### 3) git config --global user.name
#### 4) clone 한 프로젝트 vs code 에서 열기

### <u>원격 저장소 집에서 관리하기</u>

#### 1) vscode 형상관리 메뉴에서 소스 내려받기 pull (동기화)
#### 2) 수정한 소스 원격 저장소에 올리기 stage - commit - push 


### 업데이트된 원격 저장소, 로컬 저장소에서 업데이트하기

#### 1) 최신 원격 저장소 내용 가져오기

    $git fectch 원격-저장소-이름 가져오고자-하는-브랜치이름 

    예) $git fetch orgin main

#### 2) 모든 브랜지 목록 확인

   $git branch -a
   
   ![Alt text](image-4.png)

#### 3) 로컬 저장소 업데이트

    $git merge 가져오고자-하는-브랜치-이름

    예)git merge origin/main