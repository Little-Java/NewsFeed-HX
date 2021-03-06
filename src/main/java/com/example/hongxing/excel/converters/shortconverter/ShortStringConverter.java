package com.example.hongxing.excel.converters.shortconverter;

import java.text.ParseException;

import com.example.hongxing.excel.converters.Converter;
import com.example.hongxing.excel.enums.CellDataTypeEnum;
import com.example.hongxing.excel.metadata.CellData;
import com.example.hongxing.excel.metadata.GlobalConfiguration;
import com.example.hongxing.excel.metadata.property.ExcelContentProperty;
import com.example.hongxing.excel.util.NumberUtils;

/**
 * Short and string converter
 *
 * @author Jiaju Zhuang
 */
public class ShortStringConverter implements Converter<Short> {

    @Override
    public Class supportJavaTypeKey() {
        return Short.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Short convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
        GlobalConfiguration globalConfiguration) throws ParseException {
        return NumberUtils.parseShort(cellData.getStringValue(), contentProperty);
    }

    @Override
    public CellData convertToExcelData(Short value, ExcelContentProperty contentProperty,
        GlobalConfiguration globalConfiguration) {
        return NumberUtils.formatToCellData(value, contentProperty);
    }
}
