package com.example.hongxing.excel.context.xls;

import com.example.hongxing.excel.context.AnalysisContext;
import com.example.hongxing.excel.read.metadata.holder.xls.XlsReadSheetHolder;
import com.example.hongxing.excel.read.metadata.holder.xls.XlsReadWorkbookHolder;

/**
 * A context is the main anchorage point of a ls xls reader.
 *
 * @author Jiaju Zhuang
 **/
public interface XlsReadContext extends AnalysisContext {
    /**
     * All information about the workbook you are currently working on.
     *
     * @return Current workbook holder
     */
    XlsReadWorkbookHolder xlsReadWorkbookHolder();

    /**
     * All information about the sheet you are currently working on.
     *
     * @return Current sheet holder
     */
    XlsReadSheetHolder xlsReadSheetHolder();
}
