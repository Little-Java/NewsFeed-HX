package com.example.hongxing.excel.event;

import java.util.Map;

import com.example.hongxing.excel.context.AnalysisContext;
import com.example.hongxing.excel.metadata.CellData;
import com.example.hongxing.excel.metadata.CellExtra;
import com.example.hongxing.excel.read.listener.ReadListener;
import com.example.hongxing.excel.util.ConverterUtils;

/**
 * Receives the return of each piece of data parsed
 *
 * @author jipengfei
 */
public abstract class AnalysisEventListener<T> implements ReadListener<T> {

    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        invokeHeadMap(ConverterUtils.convertToStringMap(headMap, context), context);
    }

    /**
     * Returns the header as a map.Override the current method to receive header data.
     *
     * @param headMap
     * @param context
     */
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {}

    /**
     * The current method is called when extra information is returned
     *
     * @param extra
     *            extra information
     * @param context
     *            analysis context
     */
    @Override
    public void extra(CellExtra extra, AnalysisContext context) {}

    /**
     * All listeners receive this method when any one Listener does an error report. If an exception is thrown here, the
     * entire read will terminate.
     *
     * @param exception
     * @param context
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        throw exception;
    }

    @Override
    public boolean hasNext(AnalysisContext context) {
        return true;
    }
}
