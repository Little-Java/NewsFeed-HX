package com.example.hongxing.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.example.hongxing.dto.ExcelDto;
import com.example.hongxing.utils.TestFileUtil;
import com.example.hongxing.excel.EasyExcel;
import com.example.hongxing.excel.ExcelWriter;
import com.example.hongxing.excel.enums.WriteDirectionEnum;
import com.example.hongxing.excel.write.metadata.WriteSheet;
import com.example.hongxing.excel.write.metadata.fill.FillConfig;
import com.example.hongxing.excel.write.metadata.fill.FillWrapper;

public class ExcelCommon {

    public static void complexFill() {
        // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
        // {} 代表普通变量 {.} 代表是list的变量
//        String templateFileName = TestFileUtil.getPath() + "demo" + File.separator + "fill" + File.separator + "demo.xlsx";
//        String fileName = TestFileUtil.getPath() + "complexFill" + System.currentTimeMillis() + ".xlsx";

        String templateFileName = "/C:/Users/liu13/Desktop/demo.xlsx";
        String fileName = "/C:/Users/liu13/Desktop/出库单.xlsx";

        ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        // 这里注意 入参用了forceNewRow 代表在写入list的时候不管list下面有没有空行 都会创建一行，然后下面的数据往后移动。默认 是false，会直接使用下一行，如果没有则创建。
        // forceNewRow 如果设置了true,有个缺点 就是他会把所有的数据都放到内存了，所以慎用
        // 简单的说 如果你的模板有list,且list不是最后一行，下面还有数据需要填充 就必须设置 forceNewRow=true 但是这个就会把所有数据放到内存 会很耗内存
        // 如果数据量大 list不是最后一行 参照下一个
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
        excelWriter.fill(data(), fillConfig, writeSheet);
        excelWriter.fill(data(), fillConfig, writeSheet);
        Map<String, Object> map = new HashMap<String, Object>();
        map = JSON.parseObject(JSON.toJSONString(getData()), Map.class);
//        map.put("date", "2019年10月9日13:28:28");
//        map.put("total", 1000);
        excelWriter.fill(map, writeSheet);
        excelWriter.finish();
    }

    private static ExcelDto getData(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ExcelDto excelDto = new ExcelDto();
        excelDto.setCompanyName("国网江西综合能源服务有限公司");
        excelDto.setCompanyName2("江西亚铂电气有限公司");
        excelDto.setDepartment("节能事业部");
        excelDto.setCode("666");
        excelDto.setDate(sdf.format(new Date()));
        return  excelDto;
    }

    private static List<ExcelDto> data() {
        List<ExcelDto> list = new ArrayList<ExcelDto>();
        for (int i = 0; i < 10; i++) {
            ExcelDto excelDto = new ExcelDto();
            excelDto.setSerialNumber(i+1+"");
            excelDto.setName("测试");
            excelDto.setUnit("台");
            excelDto.setReceivable("1");
            excelDto.setOfficialReceipts("1");
            excelDto.setUnitPrice("1.00");
            excelDto.setMoney("1.00");
            excelDto.setTax("1.00");
            excelDto.setTotalMoney("1.00");
            excelDto.setOrderNumber("6767");
            list.add(excelDto);
        }
        return list;
    }

    public static void main(String[] args) {
//        String templateFileName = TestFileUtil.getPath() + "demo" + File.separator + "fill" + File.separator + "demo.xlsx";
//        String fileName = TestFileUtil.getPath() + "demo" + System.currentTimeMillis() + ".xlsx";
//        String templateFileName2 = "/C:/Users/liu13/Desktop/demo.xlsx";
//        String fileName2 = "/C:/Users/liu13/Desktop/demo1.xlsx";
//        System.out.println("TestFileUtil:"+TestFileUtil.getPath());
//        System.out.println("File:"+File.separator);
//        System.out.println("templateFileName:"+templateFileName);
//        System.out.println("templateFileName2:"+templateFileName2);
//        System.out.println("fileName:"+fileName);
//        System.out.println("fileName2:"+fileName2);
        complexFill();
    }
}
