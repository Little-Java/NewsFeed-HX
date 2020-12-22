package com.example.hongxing.excel.read.metadata.holder;

import java.util.List;

import com.example.hongxing.excel.metadata.ConfigurationHolder;
import com.example.hongxing.excel.read.listener.ReadListener;
import com.example.hongxing.excel.read.metadata.property.ExcelReadHeadProperty;

/**
 *
 * Get the corresponding Holder
 *
 * @author Jiaju Zhuang
 **/
public interface ReadHolder extends ConfigurationHolder {
    /**
     * What handler does the currently operated cell need to execute
     *
     * @return Current {@link ReadListener}
     */
    List<ReadListener> readListenerList();

    /**
     * What {@link ExcelReadHeadProperty} does the currently operated cell need to execute
     *
     * @return Current {@link ExcelReadHeadProperty}
     */
    ExcelReadHeadProperty excelReadHeadProperty();

}
