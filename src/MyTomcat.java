import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: joe
 * @created: 2019/7/7 22:05
 */
public class MyTomcat {
    private int port = 8088;
    private Map<String,String> urlServletMap = new HashMap<>(16);

    public MyTomcat(int port) {
        this.port = port;
    }

    public void start(){
        //初始化URL与对应处理的servlet的关系
        init();

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("tomcat is starting...");

            while (true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                LRequest lRequest = new LRequest(inputStream);
                LResponse lResponse = new LResponse(outputStream);

                //请求分发
                dispatch(lRequest,lResponse);
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void init(){
        for (ServletMapping servletMapping:ServletMappingConfig.servletMappingList){
            urlServletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
        }
    }

    public void dispatch(LRequest lRequest,LResponse lResponse){
        String clazz = urlServletMap.get(lRequest.getUrl());

        //反射
        try {
            Class<LServlet> servletClass = (Class<LServlet>) Class.forName(clazz);
            LServlet servlet = servletClass.newInstance();

            servlet.service(lRequest,lResponse);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new MyTomcat(8088).start();
    }

}
