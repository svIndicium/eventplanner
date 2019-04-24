package hu.indicium.eventplanner.schedule;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class ScheduleRetriever {
    static InputStream getSchedule(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
//        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuilder content = new StringBuilder();
//        while ((inputLine = in.readLine()) != null) {
//            content.append(inputLine + "\n");
//        }
//        in.close();
//        con.disconnect();
//        return content.toString();
        return con.getInputStream();
    }
}
