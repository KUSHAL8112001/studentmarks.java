 package netcode.java;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.util.Timer;
public class f1 
{
	public static void main(String[] args) 
	{
		int l=1;
		while(l==1)
		{
	Scanner sc =new Scanner(System.in);
	System.out.println("PRESS 1 TO ADD DATA ");	
	System.out.println("PRESS 2 TO READ DATA ");
	System.out.println("PRESS 3 TO SEARCH DATA ");
	System.out.println("PRESS 4 TO DELETE DATA ");
	System.out.println("ENTER YOUR CHOICE ");
	int k=sc.nextInt();
	switch(k)
	{
	case 1:add();
	       break;
	case 2:read();
		   break;
	case 3:search();	
	       break;
	case 4:delete();
	       break;
		   default:
			 System.out.println("WRONG CHOICE ");
	} 
	System.out.println("##########################################");
	System.out.println("PRESS 1 TO CONTINUE OR 2 TO EXIT ");
	l=sc.nextInt();
	if(l==1)
	{
		continue;
	}
	else
	System.out.println("THANKS FOR USING");
	}
	}//end of main
	//********************************************************************
	public static void add()
	{
		float pert=0;
		Scanner s1=new Scanner(System.in);
		File f=new File("k5.txt");
		try 
		{
		FileWriter qw=new FileWriter("k5.txt",true);
		System.out.println("ENTER ROLL NUMBER ");
		String rn=s1.nextLine();
		System.out.println("ENTER NAME ");
		String nm=s1.nextLine();
		System.out.println("ENTER MARKS IN ENGLISH ");
		String en=s1.nextLine();
		int en1=Integer.parseInt(en);
		System.out.println("ENTER HINDI MARKS");
		String hn=s1.nextLine();
		int hn1=Integer.parseInt(hn);
		System.out.println("ENTER MATHS MARKS");
		String mt=s1.nextLine();
		int mt1=Integer.parseInt(mt);
		System.out.println("ENTER SCIENCE MARKS  ");
		String sc=s1.nextLine();
		int sc1=Integer.parseInt(sc);
        System.out.println("ENTER THE MAXIMUM MARKS FOR EACH SUBJECT ");
        int per=s1.nextInt();
         pert=(float)((en1+hn1+mt1+sc1)*100/(4*per));
        String pert2=Float.toString(pert);
		qw.write(rn+"\t\t");
		qw.write(nm+"\t\t");
		qw.write(en+"\t\t");
		qw.write(hn+"\t\t");
		qw.write(mt+"\t\t");
		qw.write(sc+"\t\t");
		qw.write(pert2+"% \t\t");
		qw.write("\n");
		qw.flush();
		qw.close();
		}
		catch(IOException e)
		{
			System.out.println("SORRY FILE NOT FOUND ");
			e.printStackTrace();
		}
	}
	//*****************************************************************
	public static void read()
	{	
		File f=new File("k5.txt");
		try
		{
		Scanner s2=new Scanner(f);
		while(s2.hasNextLine())
		{
			String a=s2.nextLine();
			System.out.println(a);
			System.out.println();
		}
		}//end of try
		catch(IOException e )
		{    
			System.out.println("FILE NOT FOUND ");
		}//end of catch
	}//end of read function 
	public static void search()
	{
		int found=0;
		Scanner sc =new Scanner(System.in);
	  System.out.println("PRESS 1 IF YOU WANT TO SEARCH BY ROLL NUMBER ");	
	  System.out.println("PRESS 2 IF YOU WANT TO SEARCH BY NAME ");
		int r=sc.nextInt();
		if(r==1)                  //to search by roll number
		{
			File f=new File("k5.txt");
			System.out.println("ENTER THE ROLL NUMBER");
			int rn=sc.nextInt();
			try
			{
				Scanner st=new Scanner(f);
				while(st.hasNext())
				{
				  	String rn1=st.next();
				  	String rname=st.next();
				  	String reng=st.next();
				  	String rnhin=st.next();
				  	String rnmat=st.next();
				  	String rnsc=st.next();
				  	String rnpt=st.next();
				  	int rn2=Integer.parseInt(rn1);
				  	if(rn2==rn)
				  	{ 
						System.out.println("ROLL NO IS "+rn1);
						System.out.println("NAME IS  "+rname);
						System.out.println("MARKS IN ENGLISH  "+reng);
						System.out.println("MARKS IN HINDI "+rnhin);
						System.out.println("MARKS IN MATHEMATICS  "+rnmat);
						System.out.println("MARKS IN SCIENCE "+rnsc);
						System.out.println("PERCENTAGE IS  "+rnpt);
				  		found =1;
				  		
				  	}
				}//end of while 
				
				st.close();
			}//end of try
			catch(IOException e)
			{
				System.out.println("SORRY NOT FOUND ");
			}
		}// end of if 
		else if(r==2)      // to search by name 
		{
			File f=new File("k5.txt");
			System.out.println("ENTER THE NAME OF STUDENT ");
			String n=sc.next();
			try
			{
				Scanner st=new Scanner(f);
				while(st.hasNextLine())
				{
				  	String rn1=st.next();
				  	String rname=st.next();
				  	String reng=st.next();
				  	String rnhin=st.next();
				  	String rnmat=st.next();
				  	String rnsc=st.next();
				  	String rnpt=st.next();
				  	if(n.equalsIgnoreCase(rname))
				  	{ 
						System.out.println("ROLL NO IS "+rn1);
						System.out.println("NAME IS  "+rname);
						System.out.println("MARKS IN ENGLISH  "+reng);
						System.out.println("MARKS IN HINDI "+rnhin);
						System.out.println("MARKS IN MATHEMATICS  "+rnmat);
						System.out.println("MARKS IN SCIENCE "+rnsc);
						System.out.println("PERCENTAGE IS  "+rnpt);
				  		found =1;
				  		break;
				  	}
				}//end of while 
				st.close();
			}//end of try
			catch(IOException e)
			{
				System.out.println("SORRY NOT FOUND ");
			}
		}// end of else if 
		else
		{
			System.out.println("RECORD NOT FOUND ");
			System.out.println("");
		}
	}// end of search
//**********************************************************
	//*************************************************************
	public static void delete()
	{
		File f=new File("k5.txt");
		File f1=new File("k6.txt");
		int found=0;
		Scanner sc =new Scanner(System.in);
		System.out.println("PRESS 1 TO DELETE BY ROLL NUMBER ");
		System.out.println("PRESS 2 TO DELETE BY NAME ");
		int a=sc.nextInt();
		if(a==1)
		{
			System.out.println("ENTER THE ROLL NUMBER");
			int rn=sc.nextInt();
			try
			{
				FileWriter fw1=new FileWriter("k6.txt");
				Scanner st=new Scanner(f);
				System.out.println("this is try block");
				while(st.hasNext())
				{
				  	String rn1=st.next();
				  	String rname=st.next();
				  	String reng=st.next();
				  	String rnhin=st.next();
				  	String rnmat=st.next();
				  	String rnsc=st.next();
				  	String rnpt=st.next();
				  	int rn2=Integer.parseInt(rn1);
					if(rn2==rn)
				  	{ 
						System.out.println("RECORD FOUND ");
				        System.out.println("PLEASE HOLD WHILE WE ARE DELTEING THE DATA ");
				  	}
					else 
					{
						fw1.write(rn1+"\t\t");
						fw1.write(rname+"\t\t");
						fw1.write(reng+"\t\t");
						fw1.write(rnhin+"\t\t");
						fw1.write(rnmat+"\t\t");
						fw1.write(rnsc+"\t\t");
						fw1.write(rnpt+"\n");
						fw1.flush();
					}
					System.out.println("helooooo");
				}//end of while
				st.close();
				fw1.close();
				System.out.println(f.delete());
				System.out.println(f1.renameTo(f));
				System.out.println("GOOD NIGHT");
			}//end of try
			catch(IOException e)
			{
				System.out.println("SORRY NOT FOUND ");
				e.printStackTrace();
			}
		}// end of if 
		else if(a==2)
		{
			File f6=new File("k6.txt");
			File f2=new File("k5.txt");
			System.out.println("ENTER THE NAME OF STUDENT ");
			String n=sc.next();
			try
			{
				FileWriter fw2=new FileWriter("k6.txt");
				Scanner st=new Scanner(f2);
				while(st.hasNext())
				{
				  	String rn1=st.next();
				  	String rname=st.next();
				  	String reng=st.next();
				  	String rnhin=st.next();
				  	String rnmat=st.next();
				  	String rnsc=st.next();
				  	String rnpt=st.next();
				  	if(n.equalsIgnoreCase(rname))
				  	{ 
				  		found =1;
				  	
				  	}
				  	else
				  	{
						fw2.write(rn1+"\t\t");
						fw2.write(rname+"\t\t");
						fw2.write(reng+"\t\t");
						fw2.write(rnhin+"\t\t");
						fw2.write(rnmat+"\t\t");
						fw2.write(rnsc+"\t\t");
						fw2.write(rnpt+"\n");
						fw2.flush();
				  	}
				}//end of while 
				st.close();
				fw2.close();
				System.out.println(f6.renameTo(f2));
			//	System.out.println(f6.delete());
				System.out.println("DELETING BY NAME ");
				
			}//end of try
			catch(IOException e)
			{
				System.out.println("SORRY NOT FOUND ");
			}
			
		}//end of else if
		else
		{
			System.out.println("SORRY WRONG CHOICE");
		}//end of else 
		}//end of delete
}// end of class 
