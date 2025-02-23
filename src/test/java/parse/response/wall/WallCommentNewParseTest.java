package parse.response.wall;

import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.wall.comments.WallReply;
import api.longpoll.bots.model.objects.basic.WallComment;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class WallCommentNewParseTest {
    @Test
    void wallReplyNew() {
        VkEvent event = ParseUtil.getFirstEvent("json/response/wall_reply_new/wall_reply_new_sample_5_110.json");
        assertEquals(EventType.WALL_REPLY_NEW, event.getType());
        assertEquals(444, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        assertNotNull(eventObject);
        assertTrue(eventObject instanceof WallReply);

        WallReply wallReplyUpdate = (WallReply) eventObject;
        assertEquals(4, wallReplyUpdate.getId());
        assertEquals(111, wallReplyUpdate.getFromId());
        assertEquals(3, wallReplyUpdate.getPostId());
        assertEquals(-222, wallReplyUpdate.getOwnerId());
        assertEquals(1594972082, wallReplyUpdate.getDate());
        assertEquals(-333, wallReplyUpdate.getPostOwnerId());
        assertEquals("test", wallReplyUpdate.getText());

        WallComment.Thread thread = wallReplyUpdate.getThread();
        assertNotNull(thread);
        assertEquals(0, thread.getCount());
    }
}
