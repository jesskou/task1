


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class Products extends HttpServlet {
    private String name;
    private String description;
    private int numberofcategory;
    private categories[] categoriess;


    public product() {
    }

   

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String abv) {
        this.description = description;
    }

    public int numberofcategory() {
        return numberofcategory;
    }

    public categories[] getcategories() {
        return categoriess;
    }

    public boolean setcategories (categories c)
   {
     
          for(int i=0;i<this.getProduct;i++)
             {
                if(categories[i].isSimilar(c)==true)
                        return false;
             }
      categories[numberofcategory]=d;
       return true;
      }
     else 
          return false;
   }
    public void setName(String name) {
        this.name = name;
    } 
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)  {
		
		String requestUrl = request.getRequestURI();
		String name = requestUrl.substring("/products/".length());
		
		Product product = DataStore.getInstance().getProduct(name);
		
		if(product != null){
			String json = "{\n";
			json += "\"name\": " + JSONObject.quote(person.getName()) + ",\n";
			json += "\"description\": " + JSONObject.quote(person.getdescription()) + ",\n";
			
			json += "}";
			response.getOutputStream().println(json);
		}
		else{
			//That product wasn't found
			response.getOutputStream().println("{}");
		}
	}
	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)  {

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		DataStore.getInstance().putProduct(new product(name, description));
	}
}