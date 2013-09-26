package cn.newgxu.bgt.util;

import  java.net.*;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.management.RuntimeErrorException;


/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
public class HttpUtil {

	private String urlStr;
    private URL url;
    private HttpURLConnection url_con;
    private String response_content;

    public void setUrlStr(String urlStr) {
        this.urlStr = urlStr;
    }
    public String getResponse_content() {
        return response_content;
    }
    private  void setResponse_content(String response_content) {
        this.response_content = response_content;
    }
    public void send_url(String u,String p){
        try{
            url = new URL(urlStr);
            url_con=(HttpURLConnection)url.openConnection();
            url_con.setRequestMethod("GET");
            url_con.setDoOutput(true);
            String param="username="+u+"&passWord="+p;
           
            url_con.getOutputStream().write(param.getBytes());
            url_con.getOutputStream().flush();
            url_con.getOutputStream().close();
            InputStream in= url_con.getInputStream();
            BufferedReader   rd = new BufferedReader(new InputStreamReader(in));
            StringBuilder tempStr=new StringBuilder();
           System.out.println(rd.read());
            while(rd.read()!=-1){
            	System.out.println("1:"+rd.read());
                tempStr.append(rd.readLine());
                System.out.println("2:"+rd.read());
                
            }
           setResponse_content(new String(tempStr));
    } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("出错了");
        }
        finally{
            if(url_con!=null)
            url_con.disconnect();
        }
    }
	
 
}
