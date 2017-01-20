import java.util.*;
import java.io.*;
class str extends test
{
    public static void main(String args[])throws IOException
    {
        LinkedHashMap<String,Integer> ht=new LinkedHashMap<String,Integer>();
        LinkedHashMap<String,Integer> ht1=new LinkedHashMap<String,Integer>();
        String s;
        InputStreamReader ir=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ir);
        System.out.println("Enter the first file name");
        String file1=br.readLine();
            System.out.println("Enter the 2nd file name");
        String file2=br.readLine();
        FileInputStream fin1=null;
        FileInputStream fin2=null;
        try
        {
            fin1=new FileInputStream(file1);
            fin2=new FileInputStream(file2);
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("file not found");
            return ;
        }
        BufferedInputStream bin1=new BufferedInputStream(fin1);
        BufferedInputStream bin2=new BufferedInputStream(fin2);
        String a="";
        String b="";
        int ch;
      //  bin.readLine();
        while((ch=bin1.read())!=-1)
        {
            a=a+(char)ch;
        }
        while((ch=bin2.read())!=-1)
        {
            b=b+(char)ch;
        }
       /* String a="this this is a dog so i want a dog";
        String b="this is a cat";*/
      //  String a="this is a dog";
       // String b="thi it aa cat";
         // System.out.println(a);
       // System.out.println(b);
        bin1.close();
        bin2.close();
        StringTokenizer st=new StringTokenizer(a," ");
        StringTokenizer st1=new StringTokenizer(b," ");
        
        str obj=new str();
        obj.create_hash(ht,ht1,st,a);
        obj.create_hash(ht1,ht,st1,b);
for (String key : ht.keySet())
 {
    Integer value = ht.get(key);
    System.out.println("Key = " + key + ", Value = " + value);
}
System.out.println();
for (String key : ht1.keySet())
 {
    Integer value = ht1.get(key);
    System.out.println("Key = " + key + ", Value = " + value);
}
System.out.println();
System.out.println();
float l1=0;
float l2=0;
//
//
for (String key : ht.keySet())
 {
    float value = (float)ht.get(key);
    l1+=value*value;
}
l1=(float)Math.sqrt(l1);
System.out.println(l1);
//
//
//    
for (String key : ht.keySet())
 {
    float value = (float)ht1.get(key);
    l2+=value*value;
}
l2=(float)Math.sqrt(l2);
System.out.println(l2);  
//
//
//
float p=obj.check_per(ht,ht1,l1,l2);
int angle=(int)Math.toDegrees((Math.acos(p)));
System.out.println("documents are at"+angle+" angle to each other");
}
    }