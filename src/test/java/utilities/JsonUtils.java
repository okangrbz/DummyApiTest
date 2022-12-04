package utilities;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtils {

    private static ObjectMapper mapper; //ObjectMapper codehaus dan olacak

    static {
        mapper=new ObjectMapper();

    }
    //1. Method Json datasini Java objesine cevirir --->De-serialisation
    public static  <T> T  convertJsonToJavaObject(String json, Class<T> cls ){//burada ikinci data tipi Class<T> cls
        // (Bu tip meth Generique meth denir) olarak koymamzizin sebebi
        //sonradan koyacagimiz data tpini koyabilmemiz icin. Object koysaydik objenin meth olmadigi icin zorlaniridik

        T javaResult=null;
		/*
		<T> T --> burdaki T Class<T> cls daki T dir.Type anlamina geliyor. degisebilir onemli degil.
		Yapilan bu is generik meth olusuturmaktir yani her turlu class koyabilecegimiz.
		 */
        try {
            javaResult=mapper.readValue(json,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return javaResult;


    }




    //2.method: Java objesini Json dataya cevirir -->serialisation

    public static String convertJavaObjetToJson(Object obj){


        String jsonResult=null;
        try {
            jsonResult=mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

}
