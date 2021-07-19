package cn.happyOnion801.SSMMusic.utils;

import com.google.gson.Gson;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * Project : SSMMusic
 * Author : HappyOnion801
 * Date : 2021-06-25
 * Blog : https://www.happyOnion801.cn
 */
public class Utils {

    private final SimpleDateFormat sdf;
    private final Gson gson;

    @Autowired
    private FileConfig fileConfig;

    public Utils() {
        this.gson = new Gson();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss");
    }

    public String getID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public String getCurrentTime() {
        return sdf.format(System.currentTimeMillis());
    }

    public boolean saveFile(String path, MultipartFile file) {
        File f = new File(fileConfig.getBathPath() + File.separator + path);
        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f.exists();
    }

    public boolean deleteFile(String path) {
        File f = new File(fileConfig.getBathPath() + File.separator + path);
        return f.delete();
    }

    public byte[] saveToXls(List<?> list) {
        if (list == null || list.size() == 0)
            return null;

        Field[] fields = list.get(0).getClass().getDeclaredFields();
        for (Field field : fields)
            field.setAccessible(true);

        HSSFWorkbook wk = new HSSFWorkbook();
        HSSFSheet sheet = wk.createSheet();
        HSSFRow row = sheet.createRow(0);

        for (int i = 0; i < fields.length; i++) {
            row.createCell(i).setCellValue(fields[i].getName());
        }

        int cour = 1;
        for (Object obj : list) {
            row = sheet.createRow(cour++);
            for (int j = 0; j < fields.length; j++) {
                try {
                    row.createCell(j).setCellValue(fields[j].get(obj).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            wk.write(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public String toJson(Object o) {
        return gson.toJson(o);
    }
}
