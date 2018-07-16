package Util;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by hasee on 2018/7/11.
 */

public class HttpUtils {

//    private static String remoteAddr = "http://39.108.165.156:8080/loginTest/LoginServlet";
//    private static String remoteAddr = "http://39.108.165.156:8080/loginTest/LoginServlet";
    private static String resultString = "";
    private static String remoteAddr = "";
//    "http://192.168.1.101:8080/myhttp/servlet/LoginAction"

    //send
    public static String postMsg(final Map<String, String> params) {
        Thread postThread = new Thread(new Runnable() {
            @Override
            public void run() {
//                resultTextView.setText(HttpUtils.submitPostData(params,"utf-8"));
                resultString = submitPostData(params,"utf-8");
            }
        });
        postThread.start();
        return resultString;
    }

    public static String directPost(String remoteData,String addr){
        byte[] data = remoteData.getBytes();
        try{
            URL url = new URL(addr);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);

            httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length",String.valueOf(data.length));
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(data);

            int response = httpURLConnection.getResponseCode();
            if(response == HttpURLConnection.HTTP_OK){
                InputStream inputStream = httpURLConnection.getInputStream();
                return dealResponseResult(inputStream);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "wrong";
    }

    public static String submitPostData(Map<String ,String> params,String encode){
        byte[] data = getRequestData(params,encode).toString().getBytes();
        try{
            URL url = new URL(remoteAddr);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);

            httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length",String.valueOf(data.length));
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(data);

            int response = httpURLConnection.getResponseCode();
            if(response == HttpURLConnection.HTTP_OK){
                InputStream inputStream = httpURLConnection.getInputStream();
                return dealResponseResult(inputStream);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "wrong";
    }

    //封装
    public static StringBuffer getRequestData(Map<String ,String> params,String encode){
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for(Map.Entry<String ,String> entry:params.entrySet()){
                stringBuffer.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(),encode))
                        .append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return stringBuffer;
    }

    //返回结果
    public static String dealResponseResult(InputStream inputStream){
        String resultData = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(data))!= -1){
                byteArrayOutputStream.write(data,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        resultData = new String(byteArrayOutputStream.toByteArray());
        return resultData;
    }
}
