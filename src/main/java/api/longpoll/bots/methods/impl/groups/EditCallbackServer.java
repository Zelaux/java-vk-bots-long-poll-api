package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>groups.editCallbackServer</b> method.
 * <p>
 * Edits Callback API server in the community.
 *
 * @see <a href="https://vk.com/dev/groups.editCallbackServer">https://vk.com/dev/groups.editCallbackServer</a>
 */
public class EditCallbackServer extends VkMethod<IntegerResponse> {
    public EditCallbackServer(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("groups.editCallbackServer");
    }

    public EditCallbackServer setUrl(String url) {
        return addParam("url", url);
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public EditCallbackServer setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public EditCallbackServer setServerId(int serverId) {
        return addParam("server_id", serverId);
    }

    public EditCallbackServer setTitle(String title) {
        return addParam("title", title);
    }

    public EditCallbackServer setSecretKey(String secretKey) {
        return addParam("secret_key", secretKey);
    }

    @Override
    public EditCallbackServer addParam(String key, Object value) {
        return (EditCallbackServer) super.addParam(key, value);
    }
}
