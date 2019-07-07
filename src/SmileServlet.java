import java.io.IOException;

/**
 * @author: joe
 * @created: 2019/7/7 21:48
 */
public class SmileServlet extends LServlet {
    @Override
    public void doGet(LRequest lRequest, LResponse lResponse) {
        try {
            lResponse.write("GET:Smile please");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(LRequest lRequest, LResponse lResponse) {
        try {
            lResponse.write("POST:Smile please");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
