import java.io.IOException;

/**
 * @author: joe
 * @created: 2019/7/7 21:56
 */
public class CryServlet extends LServlet {
    @Override
    public void doGet(LRequest lRequest, LResponse lResponse) {
        try {
            lResponse.write("GET:Don't cry");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(LRequest lRequest, LResponse lResponse) {
        try {
            lResponse.write("POST:Don't cry");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
