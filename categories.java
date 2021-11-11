
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import org.json.JSONObject;

import org.json.JSONObject;

public class categories extends product
 {
    private String Categoryname;

    public categories(){

    }

public String getname() {
        return Categoryname;
    }

    public void setName(String Categoryname) {
        this.Categoryname = Categoryname;
    }


    public boolean findcategory(String category)
    {
        
        String[] categories=this.getname().split(":");
         for(int i=0;i<categories.length;i++)
          {  if(categories[i].equals(category)==true)
                       return true;
          }
         return false;
    }

    public boolean addcategory(String category)
    {
        if(findcategory(category)==true)
            return false;
            Categoryname+=":"+category;
        return true;
        
    }

    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)  {
		
		String requestUrl = request.getRequestURI();
		String Categoryname = requestUrl.substring("/categories/".length());
		
		categories category = DataStore.getInstance().getProduct(name);
		
		if(category != null){
			String json = "{\n";
			json += "\"categoryname\": " + JSONObject.quote(person.getCategoryName()) + ",\n";
		
			
			json += "}";
			response.getOutputStream().println(json);
		}
		else{
			//That category wasn't found
			response.getOutputStream().println("{}");
		}
	}
	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)  {

		String Categoryname = request.getParameter("Categoryname");

		
		DataStore.getInstance().putCategory(new categories(Categoryname));
	}
}