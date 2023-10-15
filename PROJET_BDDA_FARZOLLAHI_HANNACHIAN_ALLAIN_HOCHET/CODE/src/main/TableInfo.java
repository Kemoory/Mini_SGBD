package main;
import java.util.List;

public class TableInfo {
    private String tableName;
    private int numberOfColumns;
    private List<ColInfo> columns;
    private PageId headerPageId;
    private PageId firstDataPageId;

    public TableInfo(String tableName, List<ColInfo> columns,PageId headerPageId) throws Exception {
        this.tableName = tableName;
        this.numberOfColumns = columns.size();
        this.columns = columns;
        this.headerPageId = headerPageId;
        this.firstDataPageId = null; // Initialisez à null pour une valeur invalide
        for (ColInfo colInfo : columns) {
            if (!colInfo.isValidColumnType(colInfo.getColType()))
                throw new Exception("Type de colonne invalide : " + colInfo.getColType());
        }
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public List<ColInfo> getColumns() {
        return columns;
    }

    public void setColumns(List<ColInfo> columns) {
        this.columns = columns;
    }

    public PageId getHeaderPageId() {
        return headerPageId;
    }

    public PageId getFirstDataPageId() {
        return firstDataPageId;
    }

    public void setFirstDataPageId(PageId firstDataPageId) {
        this.firstDataPageId = firstDataPageId;
    }
}