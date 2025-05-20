import java.util.ArrayList;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

public class Inventory
{
     
    public Inventory(ArrayList<String> preList)
    {
        list = preList;
    }



    public String toString()
    {

    }

} 
