import java.lang.reflect.Field;

class Item {
  private int id;
  private String description;
  private double price;
  
  public Item(int id, String description, double price) {
    this.id = id;
    this.description = description;
    this.price = price;
  }
  
  public String toString() {
  	return getClass().getName() + "[id=" + id + 
      ",description=" + description + ",price=" + price + "]";
  }
}
  

public class Ch04Ex09 {
  public static String toString(Object obj) {
    Class<?> cl = obj.getClass();
  	String str = cl.getName();
    str += "[";
    
    for (Field f : cl.getDeclaredFields()) {
      Object value = 0;
      f.setAccessible(true);
      try {
        value = f.get(obj);
      }
      catch (IllegalAccessException ex) {
        System.out.println("No access");
      }
      str += (f.getName() + "=" + value + ",");
    }
    
    str += "]";
    return str;
  }
  
  public static void main(String[] args) {
  	Item item = new Item(1, "solt", 0.2);
    
    System.out.println(item);
    System.out.println(toString(item));
  }
}
  
