package com.example.hongxing.excel.converters;

import com.example.hongxing.excel.enums.CellDataTypeEnum;
import com.example.hongxing.excel.metadata.CellData;
import com.example.hongxing.excel.metadata.GlobalConfiguration;
import com.example.hongxing.excel.metadata.property.ExcelContentProperty;

/**
 * Convert between Java objects and excel objects
 *
 * @author Dan Zheng
 * @param <T>
 */
public interface Converter<T> {

    /**
     * Back to object types in Java
     *
     * @return Support for Java class
     */
    Class supportJavaTypeKey();

    /**
     * Back to object enum in excel
     *
     * @return Support for {@link CellDataTypeEnum}
     */
    CellDataTypeEnum supportExcelTypeKey();

    /**
     * Convert excel objects to Java objects
     *
     * @param cellData
     *            Excel cell data.NotNull.
     * @param contentProperty
     *            Content property.Nullable.
     * @param globalConfiguration
     *            Global configuration.NotNull.
     * @return Data to put into a Java object
     * @throws Exception
     *             Exception.
     */
    T convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
        GlobalConfiguration globalConfiguration) throws Exception;

    /**
     * Convert Java objects to excel objects
     *
     * @param value
     *            Java Data.NotNull.
     * @param contentProperty
     *            Content property.Nullable.
     * @param globalConfiguration
     *            Global configuration.NotNull.
     * @return Data to put into a Excel
     * @throws Exception
     *             Exception.
     */
    CellData convertToExcelData(T value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration)
        throws Exception;
}
