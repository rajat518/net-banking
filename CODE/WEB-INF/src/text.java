/*public class text
{
	public static void main(String args[])
	{
	int i=9; 
	switch (i) { 
                case 0: 
				       System.out.println("zero"); 
							break; 
		        case 1: 
				       System.out.println("one"); 
				            break; 
		        case 2: 
						System.out.println("two"); 
							break; 
		        default: 
						System.out.println("default"); 
							break; 
}}
};*/



public class text{
    public static void main(String argv[]){ 
        text c=new text(); 
        String s=new String("ello"); 
        c.amethod(s); 
    } 
public void amethod(String s){ 
    char c='H'; 
	//String c="h";
    //c+=s; 
	s+=c;
    System.out.println(s); 
    } 
}

