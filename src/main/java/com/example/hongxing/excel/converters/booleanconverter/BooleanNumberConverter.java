package com.example.hongxing.excel.converters.booleanconverter;

import java.math.BigDecimal;

import com.example.hongxing.excel.converters.Converter;
import com.example.hongxing.excel.enums.CellDataTypeEnum;
import com.example.hongxing.excel.metadata.CellData;
import com.example.hongxing.excel.metadata.GlobalConfiguration;
import com.example.hongxing.excel.metadata.property.ExcelContentProperty;

/**
 * Boolean and number converter
 *
 * @author Jiaju Zhuang
 */
public class BooleanNumberConverter implements Converter<Boolean> {
    @Override
    public Class supportJavaTypeKey() {
        return Boolean.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.NUMBER;
    }

    @Override
    public Boolean convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
        GlobalConfiguration globalConfiguration) {
        if (BigDecimal.ONE.compareTo(cellData.getNumberValue()) == 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public CellData convertToExcelData(Boolean value, ExcelContentProperty contentProperty,
        GlobalConfiguration globalConfiguration) {
        if (value) {
            return new CellData(BigDecimal.ONE);
        }
        return new CellData(BigDecimal.ZERO);
    }

}
