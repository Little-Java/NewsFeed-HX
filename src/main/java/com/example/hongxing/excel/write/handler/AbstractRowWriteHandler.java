package com.example.hongxing.excel.write.handler;

import org.apache.poi.ss.usermodel.Row;

import com.example.hongxing.excel.write.metadata.holder.WriteSheetHolder;
import com.example.hongxing.excel.write.metadata.holder.WriteTableHolder;

/**
 * Abstract row write handler
 *
 * @author Jiaju Zhuang
 **/
public abstract class AbstractRowWriteHandler implements RowWriteHandler {
    @Override
    public void beforeRowCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Integer rowIndex,
        Integer relativeRowIndex, Boolean isHead) {

    }

    @Override
    public void afterRowCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row,
        Integer relativeRowIndex, Boolean isHead) {

    }

    @Override
    public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row,
        Integer relativeRowIndex, Boolean isHead) {

    }
}
