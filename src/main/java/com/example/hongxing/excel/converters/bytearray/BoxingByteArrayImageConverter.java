package com.example.hongxing.excel.converters.bytearray;

import com.example.hongxing.excel.converters.Converter;
import com.example.hongxing.excel.enums.CellDataTypeEnum;
import com.example.hongxing.excel.metadata.CellData;
import com.example.hongxing.excel.metadata.GlobalConfiguration;
import com.example.hongxing.excel.metadata.property.ExcelContentProperty;

/**
 * Boxing Byte array and image converter
 *
 * @author Jiaju Zhuang
 */
public class BoxingByteArrayImageConverter implements Converter<Byte[]> {
    @Override
    public Class supportJavaTypeKey() {
        return Byte[].class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.IMAGE;
    }

    @Override
    public Byte[] convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
        GlobalConfiguration globalConfiguration) {
        throw new UnsupportedOperationException("Cannot convert images to byte arrays");
    }

    @Override
    public CellData convertToExcelData(Byte[] value, ExcelContentProperty contentProperty,
        GlobalConfiguration globalConfiguration) {
        byte[] byteValue = new byte[value.length];
        for (int i = 0; i < value.length; i++) {
            byteValue[i] = value[i];
        }
        return new CellData(byteValue);
    }

}
