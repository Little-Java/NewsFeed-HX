package com.example.hongxing.excel.analysis.v07.handlers;

import org.xml.sax.Attributes;

import com.example.hongxing.excel.context.xlsx.XlsxReadContext;
import com.example.hongxing.excel.read.metadata.holder.xlsx.XlsxReadSheetHolder;

/**
 * Cell Handler
 *
 * @author jipengfei
 */
public class CellFormulaTagHandler extends AbstractXlsxTagHandler {

    @Override
    public void startElement(XlsxReadContext xlsxReadContext, String name, Attributes attributes) {
        XlsxReadSheetHolder xlsxReadSheetHolder = xlsxReadContext.xlsxReadSheetHolder();
        xlsxReadSheetHolder.getTempCellData().setFormula(Boolean.TRUE);
        xlsxReadSheetHolder.setTempFormula(new StringBuilder());
    }

    @Override
    public void endElement(XlsxReadContext xlsxReadContext, String name) {
        XlsxReadSheetHolder xlsxReadSheetHolder = xlsxReadContext.xlsxReadSheetHolder();
        xlsxReadSheetHolder.getTempCellData().setFormulaValue(xlsxReadSheetHolder.getTempFormula().toString());
    }

    @Override
    public void characters(XlsxReadContext xlsxReadContext, char[] ch, int start, int length) {
        xlsxReadContext.xlsxReadSheetHolder().getTempFormula().append(ch, start, length);
    }
}
