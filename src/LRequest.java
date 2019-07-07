import java.io.IOException;
import java.io.InputStream;

/**
 * @author: joe
 * @created: 2019/7/7 21:01
 * 封装请求对象
 * 对http协议进行解析，拿到http请求头的方法和url
 */
public class LRequest {
    private String url;

    private String method;

    public LRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        //将字节的数据转为字符串
        if((length=inputStream.read(httpRequestBytes))>0){
            httpRequest = new String(httpRequestBytes,0,length);
        }

        /*
        /GET /hello.txt HTTP/1.1
        User-Agent: curl/7.16.3 libcurl/7.16.3 OpenSSL/0.9.7l zlib/1.2.3
        Host: www.example.com
        Accept-Language: en, mi
        */
        String httpHead = httpRequest.split("\n")[0];

        url = httpHead.split("\\s")[1];
        method=httpHead.split("\\s")[0];
//        System.out.println(this);
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}
