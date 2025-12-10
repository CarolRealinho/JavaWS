package players;

import java.util.Objects;

public class RugbyPlayer implements Comparable<RugbyPlayer>{
   private String fullname;
   private int weight;

   public RugbyPlayer(String fullname, int weight) {
      this.fullname = fullname;
      this.weight = weight;
   }

   public String toString(){
      return this.fullname + " (" + this.weight + "kg)";
   }

   public int compareTo(RugbyPlayer o){
      if(o == this){
         return 0;
      }
      if(this.weight!=o.weight){
         return Integer.compare(this.weight, o.weight);
      }
      return this.fullname.compareTo(o.fullname);
   }

   public boolean equals(Object obj){
      if(obj==this){
         return true;
      }
      if(!(obj instanceof RugbyPlayer)){
         return false;
      }
      RugbyPlayer player = (RugbyPlayer) obj;
      return this.fullname==player.fullname && this.weight == player.weight;
   }

   public int hashCode(){
      return Objects.hash(this.fullname,this.weight);
   }
}
