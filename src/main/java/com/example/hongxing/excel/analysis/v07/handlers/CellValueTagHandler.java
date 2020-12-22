package com.example.hongxing.excel.analysis.v07.handlers;

import com.example.hongxing.excel.context.xlsx.XlsxReadContext;
import com.example.hongxing.excel.enums.CellDataTypeEnum;
import com.example.hongxing.excel.metadata.CellData;

/**
 * Cell Value Handler
 *
 * @author jipengfei
 */
public class CellValueTagHandler extends AbstractCellValueTagHandler {

    @Override
    protected void setStringValue(XlsxReadContext xlsxReadContext) {
        // Have to go "sharedStrings.xml" and get it
        CellData tempCellData = xlsxReadContext.xlsxReadSheetHolder().getTempCellData();
        switch (tempCellData.getType()) {
            case STRING:
                String stringValue = xlsxReadContext.readWorkbookHolder().getReadCache()
                    .get(Integer.valueOf(tempCellData.getStringValue()));
                if (stringValue != null && xlsxReadContext.currentReadHolder().globalConfiguration().getAutoTrim()) {
                    stringValue = stringValue.trim();
                }
                tempCellData.setStringValue(stringValue);
                break;
            case DIRECT_STRING:
                tempCellData.setType(CellDataTypeEnum.STRING);
                break;
            default:
        }
    }

}
