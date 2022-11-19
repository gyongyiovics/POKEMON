package org.example.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJSON {
    public static void main(String[] args) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("address.json"));
        JSONObject jo = (JSONObject) obj;

        String firstName = (String) jo.get("firstName");
        String lastName = (String) jo.get("lastName");
        System.out.println(firstName+lastName);

        long age = (long) jo.get("age");
        System.out.println(age);

        Map address = ((Map) jo.get("address"));

        Iterator<Map.Entry> itr1 = address.entrySet().iterator();

        while(itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
            //System.out.println(pair.getKey().getClass());
            //System.out.println(pair.getValue().getClass());

            //can I put these getKey and getValue values to a map?
            //HashMap<String, String>
        }


        /**
         * here: postalCode
         * in pokemon: pokemon numbers!
         *
         *
         */
        System.out.println("***************************");


        JSONArray ja = (JSONArray) jo.get("phoneNumbers");
        Iterator itr2 = ja.iterator();


        while (itr2.hasNext()) {
            itr1 = ((Map) itr2.next()).entrySet().iterator();
            while(itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }
        }
    }

    //https://www.delftstack.com/howto/java/read-json-file-java/ -- reads it correcty, but then comes the nullpointerexception
    //https://www.geeksforgeeks.org/parse-json-java/ -- seems to be ok


}
