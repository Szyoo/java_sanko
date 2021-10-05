package szyoo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class ioFile {
    private String path = "src/pathMapLog.txt";

    public void saveMapTXT(Map<String, Boolean> map) {
        OutputStreamWriter osw = null;
        FileOutputStream fileName;
        

        try {       
            fileName = new FileOutputStream(path);
            osw = new OutputStreamWriter(fileName);
            String s = "";
            for (String key : map.keySet()) {
                s += key + ":" + map.get(key) + "\n";
            }
            osw.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                osw.flush();
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, Boolean> readMapTXT() {
        File file = new File(path);

        try {
            FileInputStream fis = new FileInputStream(file);
            int n=0;
            byte[] b=new byte[fis.available()];//新建一个字节数组
            while (n!=-1) {
                n=fis.read(b);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        return map;
    }

}
