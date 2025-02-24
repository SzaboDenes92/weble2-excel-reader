package hu.webler.util;

import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;

public class ExcelReaderApp {

    private static final String RESOURCES_FILE_PATH = Paths.get("src", "main", "resources");
    private static  final Path EXCEL_FILE_PATH = RESOURCES_FILE_PATH.resolve("webler.xlsx");

    public static void main( String[] args ) {
        try {
            Workbook workbook = openExcelFile(EXCEL_FILE_PATH);
            String content = readExcelFileContent(workbook);
            Path folderpath = createFolder();
            Path outputFile = folderPath.resolve("output.txt");
            writeContentToTxtFile(content, );
        } catch (IOException e) {
            throw new RunTimeException(e);
        }
    }

    private static  processExcelManipulation( );

    private static Workbook openExcelFile(Path path) throws IOException {
        try (InputStream inputStream = Files.newInputStream(path)) {
            return new XSSFWorbook(inputStream);
        }
    }

    private static String readExcelFileContent (Workbook workbook) {
        StringBuilder content = new StringBuilder();
        Sheet sheet = workbook.getSheetAt( 0);
        for (Row row : sheet) {
            for (Cell cell : row) {
                content.append(cell.toString()).append("\t");
            }
            content.append("\n");
        }
        return content.toString();
    }

    private static Path createFolder() throws IOException {
        String date = new SimpleDateFormat ("dd-MM-yyyy").format(new Date());
        Path directoryPath = Paths.get(sTRING.VALUEoF(RESOURSCES_FILE_PATH), date);
        if (File.notExists(directoryPath)) {
            File.createDirectories(directoryPath);
        }
        return directoryPath;
    }

    private static void writeContentToTxtFile(String content, Path path) {
        Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

    }
}
