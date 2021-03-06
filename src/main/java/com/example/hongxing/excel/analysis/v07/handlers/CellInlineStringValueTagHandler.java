package com.example.hongxing.excel.analysis.v07.handlers;

import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import com.example.hongxing.excel.context.xlsx.XlsxReadContext;
import com.example.hongxing.excel.metadata.CellData;

/**
 * Cell inline string value handler
 *
 * @author jipengfei
 */
public class CellInlineStringValueTagHandler extends AbstractCellValueTagHandler {

    @Override
    protected void setStringValue(XlsxReadContext xlsxReadContext) {
        // This is a special form of string
        CellData tempCellData = xlsxReadContext.xlsxReadSheetHolder().getTempCellData();
        XSSFRichTextString richTextString = new XSSFRichTextString(tempCellData.getStringValue());
        tempCellData.setStringValue(richTextString.toString());
    }

}
