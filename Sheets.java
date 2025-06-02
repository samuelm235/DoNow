import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;

import java.io.FileInputStream;
import java.util.*;

public class SheetWriter {
    private static final String SPREADSHEET_ID = "1m1jCVLDY8BjiAksDEXY7oJXrZAiKWe-oMPUejefe0g4";
    private static final String RANGE = "Sheet1!A1"; // Adjust range as needed

    public static void writeToSheet(List<List<Object>> values) throws Exception {
        JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
        Sheets service = new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                GoogleCredential.fromStream(new FileInputStream("credentials.json"))
                        .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS)))
                .setApplicationName("InventoryWriter")
                .build();

        ValueRange body = new ValueRange().setValues(values);
        service.spreadsheets().values()
                .append(SPREADSHEET_ID, RANGE, body)
                .setValueInputOption("RAW")
                .execute();
    }

    // Example call
    public static void main(String[] args) throws Exception {
        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList("Name", "Quantity", "Condition", "Cost", "Notes")); // header
        data.add(Arrays.asList("Couch", 1, "DEMOLISHED", 50, "Two legs fallen off"));
        data.add(Arrays.asList("3D Printer", 5, "Fair", 200, "hard to fix"));

        writeToSheet(data);
    }
}
