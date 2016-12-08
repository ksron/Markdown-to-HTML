package Node;

import java.util.Iterator;
import java.util.LinkedList;
import util.Lines;

public class Link_Addr extends Node{

   private String id;
   private String path_text;
   private String title="";
   private static LinkedList<String> refList = new LinkedList<String>();

   private String reference = "none";

   public Link_Addr(Lines lines)
   {
      super();

      if(lines!=null)
      {
         refList.add(lines.toString());
      }
   }

   public void removeList(){
      Link_Addr.refList.clear();
   }

   public void setProperties(String id)
   {
      Iterator<String> iterator = refList.iterator();
      String ref = null;

      //select ref which has same id
      while (iterator.hasNext())
      {
         ref = iterator.next();
         this.id = ref.substring(0,ref.indexOf(":")).substring(ref.indexOf("[")+1,ref.lastIndexOf("]"));//[id] => ref = id
         if(this.id.equalsIgnoreCase(id)){
            reference = "yes";
            break;
         }
      }

      //No reference : cannot link to url
      if(reference.equals("none"))
         return;

      //set title
      String[] info_list=null;
      String temp;
      temp = ref.substring(ref.indexOf(":"));

      if((temp.lastIndexOf("\"")==temp.substring(0,temp.lastIndexOf("\"")+1).length()-1)&&temp.lastIndexOf("\"")!=-1)
      {
         info_list= temp.split("\"");
         title=(info_list[1]);
      }

      else if((temp.lastIndexOf("'")==temp.substring(0,temp.lastIndexOf("'")+1).length()-1)&&temp.lastIndexOf("'")!=-1)
      {
         info_list= temp.split("'");
         title=(info_list[1]);
      }

      else if((temp.lastIndexOf(")")==temp.substring(0,temp.lastIndexOf(")")+1).length()-1)&&temp.lastIndexOf(")")!=-1)
      {
         info_list= temp.split("\\(");
         info_list[1]=info_list[1].substring(0, info_list[1].lastIndexOf(")"));
         title=(info_list[1]);
      }
      else
         info_list = temp.split(":::");//don't split

      //set path_text
      if(info_list[0].contains("<"))
      {
         path_text = info_list[0].substring(info_list[0].indexOf("<")+1, info_list[0].indexOf(">")).trim();
      }

      else if(info_list[0].contains("http"))
      {
         path_text = info_list[0].substring(info_list[0].indexOf("http"), info_list[0].length()).trim();
      }
      else
      {
         path_text = info_list[0].substring(info_list[0].indexOf(":")+1).trim().replace("\\", "/");
      }

   }


   public String getTitle()
   {
      return title;
   }

   public String getPath_text()
   {
      return path_text;
   }

   @Override
   public String generate(){
      return "";
   }
}