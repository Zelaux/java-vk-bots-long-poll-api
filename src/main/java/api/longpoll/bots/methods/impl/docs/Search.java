package api.longpoll.bots.methods.impl.docs;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.media.Doc;

/**
 * Implements <b>docs.search</b> method.
 *
 * @see <a href="https://vk.com/dev/docs.search">https://vk.com/dev/docs.search</a>
 */
public class Search extends VkMethod<Search.Response> {

    public Search(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("docs.search");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public Search setQ(String q) {
        return addParam("q", q);
    }

    public Search setCount(int count) {
        return addParam("count", count);
    }

    public Search setOffset(int offset) {
        return addParam("offset", offset);
    }

    public Search setReturnTags(boolean returnTags) {
        return addParam("return_tags", returnTags ? 1 : 0);
    }

    @Override
    public Search addParam(String key, Object value) {
        return (Search) super.addParam(key, value);
    }

    /**
     * Response to <b>docs.search</b> request.
     */
    public static class Response extends VkList<Doc> {
    }
}
