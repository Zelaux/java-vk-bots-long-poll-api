package api.longpoll.bots.methods.impl.wall;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>wall.closeComments</b> method.
 *
 * @see <a href="https://vk.com/dev/wall.closeComments">https://vk.com/dev/wall.closeComments</a>
 */
public class CloseComments extends VkMethod<IntegerResponse> {
    public CloseComments(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("wall.closeComments");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public CloseComments setOwnerId(int ownerId) {
        return addParam("owner_id", ownerId);
    }

    public CloseComments setPostId(int postId) {
        return addParam("post_id", postId);
    }

    @Override
    public CloseComments addParam(String key, Object value) {
        return (CloseComments) super.addParam(key, value);
    }
}
