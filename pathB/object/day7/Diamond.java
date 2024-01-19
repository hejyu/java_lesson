package object.day7;

// Shape 클래스 상속 예시2
public class Diamond extends Shape{

    // 생성자 정의가 명시적으로 없으면 기본생성자를 실행함
    // 자식 클래스는 부모클래스 기본생성자를 먼저 실행함


    // 자식이지만 부모가 private으로 해놨으므로 불가능!!
    // public void setShaeName(String shapeName) {
    //     this.shapeName = shapeName;
    // }
    public Diamond() {
        
    }

    public Diamond(String shapeName, int width, int height) {
        super(shapeName, width, height);
    }

    // 부모가 protected 로 선언한 필드는 자식 클래스에서 자유롭게 사용 가능!!
    public void setEtc(String etc) {
        this.etc = etc;
    }


    @Override
    public void draw() {
        System.out.println("도형 그리기 >>> " + this.getShapeName());
    }
}

/**
 * 접근 한정자
 * public               : 모두에게 오픈
 * private              : 모두에게 숨기기
 * protected            : 같은 패키지 클래스와 다른 패키지에서 가져다 쓰는 경우에는 자식 클래스에게만 오픈
 *                          ㄴ Shape 클래스의 etc 필드는 Triangle, Diamond 한테는 오픈 / B10DiamondTest 한테는 숨기기
 *                          ㄴ 그 외의 경우는 비공개, 다른 패키지 이지만 자식 클래스라면 공개
 * 아무것도 안씀         : 거의 사용되지 않음. 같은 패키지 클래스에게만 오픈
 *                          ㄴ 같은 패키지 클래스와 다른 패키지에서 가져다 쓰는 경우에는 자식 클래스에게만 오픈
 */         
