package api.longpoll.bots.methods.impl.docs;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.response.GenericResponse;

/**
 * Implements <b>docs.save</b> method.
 *
 * @see <a href="https://vk.com/dev/docs.save">https://vk.com/dev/docs.save</a>
 */
public class Save extends VkMethod<Save.Response> {

    public Save(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("docs.save");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public Save setFile(String file) {
        return addParam("file", file);
    }

    public Save setTitle(String title) {
        return addParam("title", title);
    }

    public Save setTags(String tags) {
        return addParam("tags", tags);
    }

    public Save setReturnTags(boolean returnTags) {
        return addParam("return_tags", returnTags ? 1 : 0);
    }

    @Override
    public Save addParam(String key, Object value) {
        return (Save) super.addParam(key, value);
    }

    /**
     * Response to <b>docs.save</b> request.
     */
    public static class Response extends GenericResponse<Attachment> {
    }
}
