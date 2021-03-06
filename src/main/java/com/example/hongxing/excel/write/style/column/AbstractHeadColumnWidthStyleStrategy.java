package com.example.hongxing.excel.write.style.column;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import com.example.hongxing.excel.metadata.CellData;
import com.example.hongxing.excel.metadata.Head;
import com.example.hongxing.excel.write.metadata.holder.WriteSheetHolder;

/**
 * Returns the column width according to each column header
 *
 * @author Jiaju Zhuang
 */
public abstract class AbstractHeadColumnWidthStyleStrategy extends AbstractColumnWidthStyleStrategy {

    @Override
    protected void setColumnWidth(WriteSheetHolder writeSheetHolder, List<CellData> cellDataList, Cell cell, Head head,
        Integer relativeRowIndex, Boolean isHead) {
        boolean needSetWidth = relativeRowIndex != null && (isHead || relativeRowIndex == 0);
        if (!needSetWidth) {
            return;
        }
        Integer width = columnWidth(head, cell.getColumnIndex());
        if (width != null) {
            width = width * 256;
            writeSheetHolder.getSheet().setColumnWidth(cell.getColumnIndex(), width);
        }
    }

    /**
     * Returns the column width corresponding to each column head.
     *
     * <p>
     * if return null,ignore
     *
     * @param head
     *            Nullable.
     * @param columnIndex
     *            Not null.
     * @return
     */
    protected abstract Integer columnWidth(Head head, Integer columnIndex);

}
