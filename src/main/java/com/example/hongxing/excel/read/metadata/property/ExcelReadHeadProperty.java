package com.example.hongxing.excel.read.metadata.property;

import java.util.List;

import com.example.hongxing.excel.metadata.Holder;
import com.example.hongxing.excel.metadata.property.ExcelHeadProperty;

/**
 * Define the header attribute of excel
 *
 * @author jipengfei
 */
public class ExcelReadHeadProperty extends ExcelHeadProperty {

    public ExcelReadHeadProperty(Holder holder, Class headClazz, List<List<String>> head, Boolean convertAllFiled) {
        super(holder, headClazz, head, convertAllFiled);
    }
}
