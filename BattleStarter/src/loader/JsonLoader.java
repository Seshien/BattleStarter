package loader;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class JsonLoader 
{
    public JSONObject loadFromFile(String filepath)
    {
    	try 
        {
            System.out.println(filepath);
            InputStream is = new FileInputStream(filepath);
            @SuppressWarnings("deprecation")
            String jsonTxt = IOUtils.toString(is);

            JSONObject json = new JSONObject(jsonTxt);      
            return json;
        } 
    	catch(Exception e) 
    	{
        	System.out.println("Fuck");
        	return null;
        }
    }
    public void saveToFile(String first, String second)
    {
    	try 
    	{
			FileWriter os = new FileWriter("army_"+System.currentTimeMillis()+".txt");
			os.write(first);
			os.close();
		} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
		}
    }
}
