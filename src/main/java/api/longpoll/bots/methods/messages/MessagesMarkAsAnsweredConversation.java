package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.other.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>messages.markAsAnsweredConversation</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.markAsAnsweredConversation">https://vk.com/dev/messages.markAsAnsweredConversation</a>
 */
public class MessagesMarkAsAnsweredConversation extends GetMethod<GenericResult<Integer>> {
    /**
     * Peer Id.
     */
    private Integer peerId;

    /**
     * Answered.
     */
    private Boolean answered;

    /**
     * Group ID.
     */
    private Integer groupId;

    public MessagesMarkAsAnsweredConversation(LongPollBot bot) {
        super(bot);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesMarkAsAnsweredConversation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>() {}.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("answered", answered, true),
                keyVal("group_id", groupId)
        );
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesMarkAsAnsweredConversation setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public Boolean getAnswered() {
        return answered;
    }

    public MessagesMarkAsAnsweredConversation setAnswered(Boolean answered) {
        this.answered = answered;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesMarkAsAnsweredConversation setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}