package io.day14;

import java.awt.FileDialog;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;


public class FileSelectTest {
    

    public static void main(String[] args) {
        
        // GUI : Graphic User Interface
        // java.awt 와 java.swing 클래스에서 제공합니다

        Map<String, String> map = showDialog();

        System.out.println("map 출력 : ");
        System.out.println(map);

    }

    public static  Map<String,String> showDialog() {
        JFrame jf = new JFrame();
        // jf.setSize(200,200);
        // jf.setVisible(true);
        jf.setVisible(false);

        FileDialog fd = new FileDialog(jf,"파일 선택", FileDialog.LOAD);

        fd.setVisible(true);

        System.out.println("선택한 폴더 : " + fd.getDirectory());   // 경로
        System.out.println("선택한 파일 : " + fd.getFile());
        System.out.println(fd.getDirectory() + fd.getFile());

        Map<String,String> map = new HashMap<>();

        map.put("folder", fd.getDirectory().replace("\\", "\\\\"));
        map.put("filename", fd.getFile());
        

        return map;
        
    }
}
