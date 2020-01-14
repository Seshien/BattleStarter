package loader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;
//Klasa obslugujaca ladowanie oraz zapisywanie json
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
    public void saveToFile(ArrayList<String> first, ArrayList<String> second)
    {

		try {
			FileWriter os = new FileWriter("army_"+System.currentTimeMillis()+".txt");
			JSONObject firstArmy = new JSONObject();
			JSONObject secondArmy = new JSONObject();
			for (String unit : first)
			{
				firstArmy.put(Integer.toString(firstArmy.length()), unit);
			}
			for (String unit : second)
			{
				secondArmy.put(Integer.toString(secondArmy.length()), unit);
			}
			os.write(firstArmy.toString(4));
			//firstArmy.write(os);
			os.write(secondArmy.toString(4));
			//secondArmy.write(os);
			os.close();
			System.out.println("Hey");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
