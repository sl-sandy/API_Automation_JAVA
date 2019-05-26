import java.io.*;
import java.util.HashMap;

public class TestDataReader {
    private static String testDataFile = System.getProperty("user.dir") + "/src/main/resources/TestData";

    private static HashMap<String, String> testDataMap = readDataFile();
    public static final String login = readDataFile("LOGIN");
    public static final String id = readDataFile("ID");
    public static final String nodeId = readDataFile("NODE_ID");
    public static final String ownerNodeId = readDataFile("OWNER_NODE_ID");

    private TestDataReader() {
    }

    private static String readDataFile(String Key) {
        return testDataMap.get(Key);
    }

    private static HashMap<String, String> readDataFile() {
        try {
            HashMap<String, String> TestDataMapTemp = new HashMap<String, String>();
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(testDataFile), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() == 0)
                    continue;
                String[] strTemp = line.split(":=");
                String value = null;
                if (strTemp.length > 1) {
                    if (!strTemp[1].trim().isEmpty())
                        value = strTemp[1].trim();
                }
                TestDataMapTemp.put(strTemp[0].trim(), value);

            }
            bufferedReader.close();
            inputStreamReader.close();
            return TestDataMapTemp;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}