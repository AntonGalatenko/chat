import com.toxa.spring.ajax.chat.domain.Message;
import com.toxa.spring.ajax.chat.domain.Messages;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class MessagesTest {

    @Test
    public void testGet() throws Exception{
        Messages msg = Messages.getInstance();
        msg.add(new Message("1", "1"));
        msg.add(new Message("2", "2"));
        msg.add(new Message("3", "3"));
        msg.add(new Message("4", "4"));
        msg.add(new Message("5", "5"));

        ArrayList<Message> eq = new ArrayList<Message>();
        eq.add(new Message("3", "3"));
        eq.add(new Message("4", "4"));
        eq.add(new Message("5", "5"));

        assertEquals(eq, msg.get(3));
    }
}
