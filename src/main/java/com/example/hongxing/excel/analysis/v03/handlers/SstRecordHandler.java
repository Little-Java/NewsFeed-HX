package com.example.hongxing.excel.analysis.v03.handlers;

import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SSTRecord;

import com.example.hongxing.excel.analysis.v03.IgnorableXlsRecordHandler;
import com.example.hongxing.excel.cache.XlsCache;
import com.example.hongxing.excel.context.xls.XlsReadContext;

/**
 * Record handler
 *
 * @author Dan Zheng
 */
public class SstRecordHandler extends AbstractXlsRecordHandler implements IgnorableXlsRecordHandler {
    @Override
    public void processRecord(XlsReadContext xlsReadContext, Record record) {
        xlsReadContext.readWorkbookHolder().setReadCache(new XlsCache((SSTRecord)record));
    }
}
