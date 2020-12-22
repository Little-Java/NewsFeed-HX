package com.example.hongxing.excel.converters;

import java.util.HashMap;
import java.util.Map;

import com.example.hongxing.excel.converters.bigdecimal.BigDecimalBooleanConverter;
import com.example.hongxing.excel.converters.bigdecimal.BigDecimalNumberConverter;
import com.example.hongxing.excel.converters.bigdecimal.BigDecimalStringConverter;
import com.example.hongxing.excel.converters.booleanconverter.BooleanBooleanConverter;
import com.example.hongxing.excel.converters.booleanconverter.BooleanNumberConverter;
import com.example.hongxing.excel.converters.booleanconverter.BooleanStringConverter;
import com.example.hongxing.excel.converters.bytearray.BoxingByteArrayImageConverter;
import com.example.hongxing.excel.converters.bytearray.ByteArrayImageConverter;
import com.example.hongxing.excel.converters.byteconverter.ByteBooleanConverter;
import com.example.hongxing.excel.converters.byteconverter.ByteNumberConverter;
import com.example.hongxing.excel.converters.byteconverter.ByteStringConverter;
import com.example.hongxing.excel.converters.date.DateNumberConverter;
import com.example.hongxing.excel.converters.date.DateStringConverter;
import com.example.hongxing.excel.converters.doubleconverter.DoubleBooleanConverter;
import com.example.hongxing.excel.converters.doubleconverter.DoubleNumberConverter;
import com.example.hongxing.excel.converters.doubleconverter.DoubleStringConverter;
import com.example.hongxing.excel.converters.file.FileImageConverter;
import com.example.hongxing.excel.converters.floatconverter.FloatBooleanConverter;
import com.example.hongxing.excel.converters.floatconverter.FloatNumberConverter;
import com.example.hongxing.excel.converters.floatconverter.FloatStringConverter;
import com.example.hongxing.excel.converters.inputstream.InputStreamImageConverter;
import com.example.hongxing.excel.converters.integer.IntegerBooleanConverter;
import com.example.hongxing.excel.converters.integer.IntegerNumberConverter;
import com.example.hongxing.excel.converters.integer.IntegerStringConverter;
import com.example.hongxing.excel.converters.longconverter.LongBooleanConverter;
import com.example.hongxing.excel.converters.longconverter.LongNumberConverter;
import com.example.hongxing.excel.converters.longconverter.LongStringConverter;
import com.example.hongxing.excel.converters.shortconverter.ShortBooleanConverter;
import com.example.hongxing.excel.converters.shortconverter.ShortNumberConverter;
import com.example.hongxing.excel.converters.shortconverter.ShortStringConverter;
import com.example.hongxing.excel.converters.string.StringBooleanConverter;
import com.example.hongxing.excel.converters.string.StringErrorConverter;
import com.example.hongxing.excel.converters.string.StringNumberConverter;
import com.example.hongxing.excel.converters.string.StringStringConverter;
import com.example.hongxing.excel.converters.url.UrlImageConverter;

/**
 * Load default handler
 *
 * @author Jiaju Zhuang
 */
public class DefaultConverterLoader {
    private static Map<String, Converter> defaultWriteConverter;
    private static Map<String, Converter> allConverter;

    static {
        initDefaultWriteConverter();
        initAllConverter();
    }

    private static void initAllConverter() {
        allConverter = new HashMap<String, Converter>(64);
        putAllConverter(new BigDecimalBooleanConverter());
        putAllConverter(new BigDecimalNumberConverter());
        putAllConverter(new BigDecimalStringConverter());

        putAllConverter(new BooleanBooleanConverter());
        putAllConverter(new BooleanNumberConverter());
        putAllConverter(new BooleanStringConverter());

        putAllConverter(new ByteBooleanConverter());
        putAllConverter(new ByteNumberConverter());
        putAllConverter(new ByteStringConverter());

        putAllConverter(new DateNumberConverter());
        putAllConverter(new DateStringConverter());

        putAllConverter(new DoubleBooleanConverter());
        putAllConverter(new DoubleNumberConverter());
        putAllConverter(new DoubleStringConverter());

        putAllConverter(new FloatBooleanConverter());
        putAllConverter(new FloatNumberConverter());
        putAllConverter(new FloatStringConverter());

        putAllConverter(new IntegerBooleanConverter());
        putAllConverter(new IntegerNumberConverter());
        putAllConverter(new IntegerStringConverter());

        putAllConverter(new LongBooleanConverter());
        putAllConverter(new LongNumberConverter());
        putAllConverter(new LongStringConverter());

        putAllConverter(new ShortBooleanConverter());
        putAllConverter(new ShortNumberConverter());
        putAllConverter(new ShortStringConverter());

        putAllConverter(new StringBooleanConverter());
        putAllConverter(new StringNumberConverter());
        putAllConverter(new StringStringConverter());
        putAllConverter(new StringErrorConverter());
    }

    private static void initDefaultWriteConverter() {
        defaultWriteConverter = new HashMap<String, Converter>(32);
        putWriteConverter(new BigDecimalNumberConverter());
        putWriteConverter(new BooleanBooleanConverter());
        putWriteConverter(new ByteNumberConverter());
        putWriteConverter(new DateStringConverter());
        putWriteConverter(new DoubleNumberConverter());
        putWriteConverter(new FloatNumberConverter());
        putWriteConverter(new IntegerNumberConverter());
        putWriteConverter(new LongNumberConverter());
        putWriteConverter(new ShortNumberConverter());
        putWriteConverter(new StringStringConverter());
        putWriteConverter(new FileImageConverter());
        putWriteConverter(new InputStreamImageConverter());
        putWriteConverter(new ByteArrayImageConverter());
        putWriteConverter(new BoxingByteArrayImageConverter());
        putWriteConverter(new UrlImageConverter());
    }

    /**
     * Load default write converter
     *
     * @return
     */
    public static Map<String, Converter> loadDefaultWriteConverter() {
        return defaultWriteConverter;
    }

    private static void putWriteConverter(Converter converter) {
        defaultWriteConverter.put(ConverterKeyBuild.buildKey(converter.supportJavaTypeKey()), converter);
    }

    /**
     * Load default read converter
     *
     * @return
     */
    public static Map<String, Converter> loadDefaultReadConverter() {
        return loadAllConverter();
    }

    /**
     * Load all converter
     *
     * @return
     */
    public static Map<String, Converter> loadAllConverter() {
        return allConverter;
    }

    private static void putAllConverter(Converter converter) {
        allConverter.put(ConverterKeyBuild.buildKey(converter.supportJavaTypeKey(), converter.supportExcelTypeKey()),
            converter);
    }
}
