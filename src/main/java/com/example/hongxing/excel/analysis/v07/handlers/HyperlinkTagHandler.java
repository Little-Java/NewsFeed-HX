package com.example.hongxing.excel.analysis.v07.handlers;

import org.xml.sax.Attributes;

import com.example.hongxing.excel.constant.ExcelXmlConstants;
import com.example.hongxing.excel.context.xlsx.XlsxReadContext;
import com.example.hongxing.excel.enums.CellExtraTypeEnum;
import com.example.hongxing.excel.metadata.CellExtra;
import com.example.hongxing.excel.util.StringUtils;

/**
 * Cell Handler
 *
 * @author Jiaju Zhuang
 */
public class HyperlinkTagHandler extends AbstractXlsxTagHandler {

    @Override
    public boolean support(XlsxReadContext xlsxReadContext) {
        return xlsxReadContext.readWorkbookHolder().getExtraReadSet().contains(CellExtraTypeEnum.HYPERLINK);
    }

    @Override
    public void startElement(XlsxReadContext xlsxReadContext, String name, Attributes attributes) {
        String ref = attributes.getValue(ExcelXmlConstants.ATTRIBUTE_REF);
        String location = attributes.getValue(ExcelXmlConstants.ATTRIBUTE_LOCATION);
        if (StringUtils.isEmpty(ref)) {
            return;
        }
        CellExtra cellExtra = new CellExtra(CellExtraTypeEnum.HYPERLINK, location, ref);
        xlsxReadContext.readSheetHolder().setCellExtra(cellExtra);
        xlsxReadContext.analysisEventProcessor().extra(xlsxReadContext);
    }

}
