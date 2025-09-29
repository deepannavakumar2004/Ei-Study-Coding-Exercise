public class ReportFactory {
    public Report getReport(String type) {
        if (type == null) return null;

        switch (type.toLowerCase()) {
            case "pdf":
                return new PDFReport();
            case "excel":
                return new ExcelReport();
            default:
                System.out.println("Unknown report type: " + type);
                return null;
        }
    }
}
