package com.nt.phase1;
import java.io.*;
import java.util.*;


public class Companylockers implements Serializable{

	//declare mermber variables for companylockers-- id, name, type
	private int product_id;
	private String product_name;
	private String product_type;
	
	//- constructors- default and parameterized
	public Companylockers(){
		
	}
	
	public Companylockers(int product_id,String product_name, String product_type) {
		this.product_id=product_id;
		this.product_name=product_name;
		this.product_type=product_type;
	}
	
	//generate toString method for the class
	@Override
	public String toString() {
		return "CompanyLocker [product_id=" + product_id + ", product_name=" + product_name + ", product_type="
				+ product_type + "]";
	}
	
	
	
	
	public static void main(String[] args) {
		
		int choice1, choice2; String path;
		Scanner sc = new Scanner(System.in);
		ArrayList<Companylockers> comlst = new ArrayList<Companylockers>();
		comlst.add(new Companylockers(1,"apple","juice"));
		comlst.add(new Companylockers(2,"orange","juice"));
		comlst.add(new Companylockers(3,"guava","jam"));
		comlst.add(new Companylockers(4,"apple","jam"));


		do{
		System.out.println("Enter your choice");
		System.out.println("1. Return all file names in current directory:");
		System.out.println("2. Woriking with files:");
		System.out.println("3. Exit:");

		choice1 = sc.nextInt();
		switch(choice1)
		{
		case 1:
		System.out.println("Please enter the path");
		path = sc.next();
		//File f=new File("C:\\Amar\\CALTECH\\Phase 1\\Project\\Ascending 2");C:\Amar\CALTECH\Phase1\Project\Ascending2
		File f = new File(path);
		String filenames[]=f.list();
		// need to sort 
		Arrays.sort(filenames);
			for(String filename: filenames){
			System.out.println(filename);
			}
		break;
		case 2:
		do{
		System.out.println("Enter your choice");
		System.out.println("1. Add a file:");
		System.out.println("2. Delete a file:");
		System.out.println("3. Read a file:");
		System.out.println("4. Exit:");

		choice2 = sc.nextInt();
		switch(choice2)
		{
		case 1:
		File file = new File("C:\\Amar\\CALTECH\\Phase1\\Project\\Ascending2\\myfile1.txt");
		boolean result;
		try
		{
		result = file.createNewFile(); //creates a new file
		if(result) // test if successfully created a new file
		{
		System.out.println("file created "+file.getCanonicalPath());
		FileOutputStream writeData = new FileOutputStream(file);
		ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

		writeStream.writeObject(comlst);
		writeStream.flush();
		writeStream.close();

		}
		else
		{
		System.out.println("File already exist at location: "+file.getCanonicalPath());
		}
		}
		catch (IOException e)
		{
		e.printStackTrace(); //prints exception if any
		}
		break;
		case 2:
		try
		{
		File f1= new File("C:\\\\Amar\\\\CALTECH\\\\Phase 1\\\\Project\\\\Ascending 2\\myfile1.txt"); //file to be delete
		if(f1.delete()) //returns Boolean value
		{
		System.out.println(f1.getName() + " deleted"); //getting and printing the file name
		}
		else
		{
		System.out.println("failed");
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		break;
		case 3:
		try{
		FileInputStream readData = new FileInputStream("C:\\\\Amar\\\\CALTECH\\\\Phase 1\\\\Project\\\\Ascending 2\\myfile1.txt");
		ObjectInputStream readStream = new ObjectInputStream(readData);

		ArrayList<Companylockers> product = (ArrayList<Companylockers>) readStream.readObject();
		readStream.close();
		for(Companylockers c: product)
		System.out.println(c.toString());
		}catch (Exception e) {
		e.printStackTrace();
		}
		break;
		case 4:
		break;
		default: System.out.println("Please enter a correct choice:");
		}

		}while(choice2!=4);
		break;
		case 3:
		break;
		default: System.out.println("Please enter a correct choice:");
		}
		}while (choice1!=3);

		}
		
		}

