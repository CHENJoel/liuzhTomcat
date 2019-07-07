import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: joe
 * @created: 2019/7/7 21:13
 * 封装响应对象
 */
public class LResponse {
    private OutputStream outputStream;

    public LResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {
        StringBuffer httpResponse = new StringBuffer();
        httpResponse.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("</body></html>");
        outputStream.write(httpResponse.toString().getBytes());
        outputStream.close();
    }
}
