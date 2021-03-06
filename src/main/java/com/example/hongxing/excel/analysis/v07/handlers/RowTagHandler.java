package com.example.hongxing.excel.analysis.v07.handlers;

import java.util.LinkedHashMap;

import org.xml.sax.Attributes;

import com.example.hongxing.excel.constant.ExcelXmlConstants;
import com.example.hongxing.excel.context.xlsx.XlsxReadContext;
import com.example.hongxing.excel.enums.RowTypeEnum;
import com.example.hongxing.excel.metadata.Cell;
import com.example.hongxing.excel.read.metadata.holder.ReadRowHolder;
import com.example.hongxing.excel.read.metadata.holder.xlsx.XlsxReadSheetHolder;
import com.example.hongxing.excel.util.CollectionUtils;
import com.example.hongxing.excel.util.PositionUtils;

/**
 * Cell Handler
 *
 * @author jipengfei
 */
public class RowTagHandler extends AbstractXlsxTagHandler {

    @Override
    public void startElement(XlsxReadContext xlsxReadContext, String name, Attributes attributes) {
        XlsxReadSheetHolder xlsxReadSheetHolder = xlsxReadContext.xlsxReadSheetHolder();
        int rowIndex = PositionUtils.getRowByRowTagt(attributes.getValue(ExcelXmlConstants.ATTRIBUTE_R),
            xlsxReadSheetHolder.getRowIndex());
        Integer lastRowIndex = xlsxReadContext.readSheetHolder().getRowIndex();
        while (lastRowIndex + 1 < rowIndex) {
            xlsxReadContext.readRowHolder(new ReadRowHolder(lastRowIndex + 1, RowTypeEnum.EMPTY,
                xlsxReadSheetHolder.getGlobalConfiguration(), new LinkedHashMap<Integer, Cell>()));
            xlsxReadContext.analysisEventProcessor().endRow(xlsxReadContext);
            xlsxReadSheetHolder.setColumnIndex(null);
            xlsxReadSheetHolder.setCellMap(new LinkedHashMap<Integer, Cell>());
            lastRowIndex++;
        }
        xlsxReadSheetHolder.setRowIndex(rowIndex);
    }

    @Override
    public void endElement(XlsxReadContext xlsxReadContext, String name) {
        XlsxReadSheetHolder xlsxReadSheetHolder = xlsxReadContext.xlsxReadSheetHolder();
        RowTypeEnum rowType =
            CollectionUtils.isEmpty(xlsxReadSheetHolder.getCellMap()) ? RowTypeEnum.EMPTY : RowTypeEnum.DATA;
        xlsxReadContext.readRowHolder(new ReadRowHolder(xlsxReadSheetHolder.getRowIndex(), rowType,
            xlsxReadSheetHolder.getGlobalConfiguration(), xlsxReadSheetHolder.getCellMap()));
        xlsxReadContext.analysisEventProcessor().endRow(xlsxReadContext);
        xlsxReadSheetHolder.setColumnIndex(null);
        xlsxReadSheetHolder.setCellMap(new LinkedHashMap<Integer, Cell>());
    }

}
