package COM.TEST1;

import com.utility.ConfigDataProvider;

public class indentdata {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ConfigDataProvider config=new ConfigDataProvider("intententry");
		System.out.println(config.getconfigdata("IndentReqBy"));
		boolean a=true;
		char b='A';
		byte c=19;
		short d=5;
		int e=4;
		long f=2000000000;
		float g=19.5f;
		double h=23.655656;
	}

}
