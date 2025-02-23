package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.getById</b> method.
 * <p>
 * Returns messages by their IDs.
 *
 * @see <a href="https://vk.com/dev/messages.getById">https://vk.com/dev/messages.getById</a>
 */
public class GetById extends VkMethod<GetById.Response> {
    public GetById(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("messages.getById");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetById setMessageIds(Integer... messageIds) {
        return setMessageIds(Arrays.asList(messageIds));
    }

    public GetById setMessageIds(List<Integer> messageIds) {
        return addParam("message_ids", toCommaSeparatedValues(messageIds));
    }

    public GetById setPreviewLength(int previewLength) {
        return addParam("preview_length", previewLength);
    }

    public GetById setExtended(boolean extended) {
        return addParam("extended", extended ? 1 : 0);
    }

    public GetById setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetById setFields(List<String> fields) {
        return addParam("fields", toCommaSeparatedValues(fields));
    }

    public GetById setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetById addParam(String key, Object value) {
        return (GetById) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.getById</b> request.
     */
    public static class Response extends GetByConversationMessageId.Response {
    }
}
