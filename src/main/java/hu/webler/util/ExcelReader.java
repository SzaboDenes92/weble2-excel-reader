package hu.webler.util;

import java.io.InputStream;
import java.nio.file.Files;

public class ExcelReader {

    protected static void processExcelManipulation() {
        private static final String RESOURCES_FILE_PATH = Paths.get ("src", "main", "resources");
        private static final Path EXCEL_FILE_PATH = RESOURCES_FILE_PATH.resolve ("webler.xlsx");
    }

    public static void main( final String[] args ) {
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


    private static Workbook openExcelFile(Path path) throws IOException {
        try (InputStream inputStream = Files.newInputStream(path)) {
            return new XSSFWorbook(inputStream);
        }
    }
}
