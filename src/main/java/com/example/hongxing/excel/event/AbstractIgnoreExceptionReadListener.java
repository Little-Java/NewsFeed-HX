package com.example.hongxing.excel.event;

import com.example.hongxing.excel.context.AnalysisContext;
import com.example.hongxing.excel.metadata.CellExtra;
import com.example.hongxing.excel.read.listener.ReadListener;

/**
 * Receives the return of each piece of data parsed
 *
 * @author jipengfei
 */
public abstract class AbstractIgnoreExceptionReadListener<T> implements ReadListener<T> {

    /**
     * All listeners receive this method when any one Listener does an error report. If an exception is thrown here, the
     * entire read will terminate.
     *
     * @param exception
     * @param context
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) {}

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

    @Override
    public boolean hasNext(AnalysisContext context) {
        return true;
    }
}
