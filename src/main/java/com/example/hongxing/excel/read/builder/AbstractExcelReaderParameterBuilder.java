package com.example.hongxing.excel.read.builder;

import java.util.ArrayList;

import com.example.hongxing.excel.metadata.AbstractParameterBuilder;
import com.example.hongxing.excel.read.listener.ReadListener;
import com.example.hongxing.excel.read.metadata.ReadBasicParameter;

/**
 * Build ExcelBuilder
 *
 * @author Jiaju Zhuang
 */
public abstract class AbstractExcelReaderParameterBuilder<T extends AbstractExcelReaderParameterBuilder,
    C extends ReadBasicParameter> extends AbstractParameterBuilder<T, C> {
    /**
     * Count the number of added heads when read sheet.
     *
     * <p>
     * 0 - This Sheet has no head ,since the first row are the data
     * <p>
     * 1 - This Sheet has one row head , this is the default
     * <p>
     * 2 - This Sheet has two row head ,since the third row is the data
     *
     * @param headRowNumber
     * @return
     */
    public T headRowNumber(Integer headRowNumber) {
        parameter().setHeadRowNumber(headRowNumber);
        return self();
    }

    /**
     * Whether to use scientific Format.
     *
     * default is false
     *
     * @param useScientificFormat
     * @return
     */
    public T useScientificFormat(Boolean useScientificFormat) {
        parameter().setUseScientificFormat(useScientificFormat);
        return self();
    }

    /**
     * Custom type listener run after default
     *
     * @param readListener
     * @return
     */
    public T registerReadListener(ReadListener readListener) {
        if (parameter().getCustomReadListenerList() == null) {
            parameter().setCustomReadListenerList(new ArrayList<ReadListener>());
        }
        parameter().getCustomReadListenerList().add(readListener);
        return self();
    }
}
