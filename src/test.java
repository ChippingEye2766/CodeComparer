import java.util.*;
import java.io.*;
class test
{
       int cal_fre(String a,String b)
        {
            int fre=0;
            StringTokenizer st=new StringTokenizer(a," ");
            while(st.hasMoreElements())
            {
                if(b.equals(st.nextToken()))
                fre++;
            }
        return fre;
        }
        void create_hash(LinkedHashMap ht,LinkedHashMap ht1,StringTokenizer st, String a)
        {
            String s;
                while(st.hasMoreTokens())
        {
            s=st.nextToken();
            int fre=cal_fre(a,s);
         //   
           if(ht.containsKey(s))
           {
               int t=(int)ht.get(s);
               if(t!=0)
               {}
               else
               {
               ht.put(s,fre);
            }
            } 
           else
            {
                ht.put(s,fre);
               ht1.put(s,0);
            }
            
        }
        }
        float check_per(LinkedHashMap<String,Integer> ht,LinkedHashMap<String,Integer> ht1,float l1,float l2)
        {
            float t=0;
             for (String key :ht.keySet())
            {
             int value = (int)ht.get(key);
             int value1=(int)ht1.get(key);
             t+=value*value1;
            }
            t=t/(l1*l2);
            return t;
        }
    }