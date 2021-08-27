package api.longpoll.bots.methods;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.http.HttpClient;
import api.longpoll.bots.model.objects.media.FileType;

import java.io.File;

/**
 * Uploads file to VK.
 * This request requires neither <b>access token</b> not <b>API version</b> as parameters.
 *
 * @param <Response> VK API response type.
 * @see VkApiMethod
 */
public abstract class FileUploadingVkApiMethod<Response> extends VkApiMethod<Response> {
    /**
     * File to be uploaded to VK server.
     */
    private File file;

    @Override
    protected String execute(HttpClient httpClient) throws VkApiException {
        return super.execute(httpClient.setFile(getType().getKey(), file.getName(), file));
    }

    /**
     * Gets file type.
     *
     * @return file type.
     * @see FileType
     */
    protected abstract FileType getType();

    public File getFile() {
        return file;
    }

    public FileUploadingVkApiMethod<Response> setFile(File file) {
        this.file = file;
        return this;
    }
}
