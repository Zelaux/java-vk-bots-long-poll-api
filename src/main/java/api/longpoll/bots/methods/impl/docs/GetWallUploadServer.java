package api.longpoll.bots.methods.impl.docs;

import api.longpoll.bots.methods.impl.VkMethod;

/**
 * Implements <b>docs.getWallUploadServer</b> method.
 *
 * @see <a href="https://vk.com/dev/docs.getWallUploadServer">https://vk.com/dev/docs.getWallUploadServer</a>
 */
public class GetWallUploadServer extends VkMethod<GetWallUploadServer.Response> {
    public GetWallUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("docs.getWallUploadServer");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetWallUploadServer setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetWallUploadServer addParam(String key, Object value) {
        return (GetWallUploadServer) super.addParam(key, value);
    }

    /**
     * Response to <b>docs.getWallUploadServer</b> request.
     */
    public static class Response extends GetMessagesUploadServer.Response {
    }
}
