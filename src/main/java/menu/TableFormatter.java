package menu;

import java.util.ArrayList;
import java.util.List;

public class TableFormatter {

    private final List<String> headers;
    private final List<List<String>> rows = new ArrayList<>();
    private final List<Integer> columnWidths;

    public TableFormatter(List<String> headers) {
        this.headers = headers;
        this.columnWidths = new ArrayList<>();

        for (String h : headers) {
            columnWidths.add(h.length());
        }
    }

    public void addRow(List<?> row) {
        List<String> stringRow = new ArrayList<>();

        for (int i = 0; i < row.size(); i++) {
            String cell = String.valueOf(row.get(i));

            stringRow.add(cell);

            if (cell.length() > columnWidths.get(i)) {
                columnWidths.set(i, cell.length());
            }
        }

        rows.add(stringRow);
    }

    public void print() {
        printSeparator();
        printHeader();
        printSeparator();
        printRows();
        printSeparator();
    }

    private void printHeader() {
        for (int i = 0; i < headers.size(); i++) {
            System.out.printf("| %-"+columnWidths.get(i)+"s ", headers.get(i));
        }
        System.out.println("|");
    }

    private void printRows() {
        for (List<String> row : rows) {
            for (int i = 0; i < row.size(); i++) {
                System.out.printf("| %-"+columnWidths.get(i)+"s ", row.get(i));
            }
            System.out.println("|");
        }
    }

    private void printSeparator() {
        for (int w : columnWidths) {
            System.out.print("+");
            System.out.print("-".repeat(w + 2));
        }
        System.out.println("+");
    }
}