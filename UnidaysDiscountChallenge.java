import java.util.*;

/**
 * UniDays discount challenge. To run this programme, first create a Map of the pricing rules to include into the constructor
 * where the key is the item name (A,B,C,D,E) and the value is the price.
 * 
 * @author (Sareena Naser) 
 * @version (10/11/2019)
 */
public class UnidaysDiscountChallenge
{
   Map<String, Integer> prices = new HashMap<>();
   List<String> basket = new ArrayList<>();
   int total = 0;
   int deliveryCharge = 7;
   int overallTotal;
   
   //constructor allows pricing rules to be added in the form of a map. Keys are item names and values are prices
   public UnidaysDiscountChallenge(Map<String, Integer> pricingRules)
   {
      prices = pricingRules; 
   }
   
   public void addToBasket(String item)
   {
      //make sure input is converted to uppercase so can be searched and Map keys
      String str = item.toUpperCase();
      
      //items existing in the map are added to the basket and total is updated.
      if(prices.containsKey(str))
      {
         basket.add(item);
         total += prices.get(str);
      }
      
      System.out.println(total);
 
   }
   
   //helper method to calculate item B in basket
    public int calculateB()
    {
      List <String> B = new ArrayList<>();
      
      //extract only item "B" from basket and add it to new list
      for(String item : basket)
      {
         if(item == "B")
         {
            B.add(item);   
         }
      }
      
      //on every odd index  i.e. second, total is deducted by £4
      
      for(int i = 1; i<B.size(); i++)
      {
       if((i%2!=0))
       {
           total = total - 4;
        }
      }
      return total;
      }
      
     //helper method to calculate item C in basket
    public int calculateC()
       {
       List <String> C = new ArrayList<>();
       
      //extract only item "C" from basket and add it to new list
      for(String item : basket)
      {
         if(item == "C")
         {
            C.add(item);    
         }
      }
      
      //Every third index, total is deducted by £2
      for(int i = 1; i<C.size()+1; i++)
      {
       if((i%3==0))
       {
           total = total - 2;
        }
      }
      return total;
      }
       
    //helper method to calculate item D in basket  
    public int calculateD()
     {
       List <String> D = new ArrayList<>();
      
      //extract only item "D" from basket and add it to new list
      for(String item : basket)
      {
         if(item == "D")
         {
            D.add(item);    
         }
      }
      
      //Every second index total is deducted by £7 (free item)
      for(int i = 1; i<D.size(); i++)
      {
       if((i%2!=0))
       {
           total = total - 7;
        }
      }
       return total;
      }
    
    //helper method to calculate item E in basket  
    public int calculateE()
    {
       List <String> E = new ArrayList<>();
     
     //extract only item "E" from basket and add it to new list
      for(String item : basket)
      {
         if(item == "E")
         {
            E.add(item);    
         }
      }
      
      //Every third index, i.e. third item of its kind, the total is deducted by £5 (free item)
      for(int i = 1; i<E.size()+1; i++)
      {
       if((i%3==0))
       {
           total = total - 5;
        }
      }
       return total;
      }
    
     //Method outputs final calculations including delivery costs and total in basket. 
     
   public String calculateTotalPrice() 
      {      
         String returnStatement = "";
      
            this.calculateB();
            this.calculateC();
            this.calculateD();
            this.calculateE();
         
            if(total > 49 || total== 0 )
               {
                  deliveryCharge = 0;
                  overallTotal = total;
                  returnStatement = "Total: " + Integer.toString(total) + "\nDelivery charge: " + Integer.toString(deliveryCharge) + "\nOverall Charge: " + overallTotal;
               }
               else
               {
                  deliveryCharge = 7;
                  overallTotal = total + deliveryCharge;
                  returnStatement = "Total: " + Integer.toString(total) + "\nDelivery charge: " + Integer.toString(deliveryCharge) + "\nOverall Charge: " + overallTotal;
               }
      
         return returnStatement;
   
   }
}
   
