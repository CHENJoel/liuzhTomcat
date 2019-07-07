import java.util.ArrayList;
import java.util.List;

/**
 * @author: joe
 * @created: 2019/7/7 21:59
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    //指定url交给哪个servlet来处理
    static {
        servletMappingList.add(new ServletMapping("smile","/smile","SmileServlet"));
        servletMappingList.add(new ServletMapping("cry","/cry","CryServlet"));
    }
}
