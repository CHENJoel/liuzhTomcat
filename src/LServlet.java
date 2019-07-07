import java.io.IOException;

/**
 * @author: joe
 * @created: 2019/7/7 21:38
 */
public abstract class LServlet {
    public abstract void doGet(LRequest lRequest,LResponse lResponse);
    public abstract void doPost(LRequest lRequest,LResponse lResponse);
    public  void service(LRequest lRequest,LResponse lResponse){
        if(lRequest.getMethod().equalsIgnoreCase("POST")){
            doPost(lRequest,lResponse);
        }else if (lRequest.getMethod().equalsIgnoreCase("GET")){
            doGet(lRequest,lResponse);
        }
    };
}
