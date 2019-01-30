package cn.itcast.shiro.authorization;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

public class User32{

public interface TestInteface extends StdCallLibrary{
	     //打开设备
	     int ZT_REC_OpenDevice(String pstrCom, int nHandle, int nFage); 
	     //关闭设备
	     int ZT_REC_CloseDevice(int nHandle);
	     //打印接口	
	     int ZT_REC_PrintLine(int nHandle,String print_data,String style); 
	     
    }
	
 public static void main(String[] args) throws Exception{
	    System.load("C:\\Users\\Administrator\\Desktop\\eshi\\ceshi\\ceshi\\DeviceDll\\ZT_RECEIPT.dll");
	           
        try{
		    TestInteface INSTANCE = (TestInteface) Native.loadLibrary("ZT_RECEIPT",TestInteface.class);
		    System.out.println(INSTANCE.ZT_REC_OpenDevice("ZTP80—USB1:115200:E:8:1",123,1));
		    String print_data = "我是刘子昂";
		    System.out.println(INSTANCE.ZT_REC_PrintLine(123,print_data,"")); 
		    //System.out.println(INSTANCE.ZT_REC_CloseDevice(123));
		 }catch(Exception e1) {
             System.out.println(e1.getMessage());
         }
		 System.out.println("end");
	  }
}