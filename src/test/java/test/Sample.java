package test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class Sample {
@Test
public void Samplee() throws IOException 
{
	//DataDrive d=new DataDrive();
dataDriven d=new dataDriven();
ArrayList<String> data = d.getData("Add brand");
//ArrayList<String> data = d.GetData("ADD BRAND");
System.out.println(data.get(1));
System.out.println(data.get(2));
}
}
