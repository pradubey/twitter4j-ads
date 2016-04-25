package twitter4j;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.Base64;
import twitter4j.auth.Authorization;
import twitter4j.auth.OAuthSupport;
import twitter4j.conf.Configuration;
import twitter4j.models.TwitterTonUploadResponse;
import twitter4j.models.ads.AudienceUploadDetails;
import twitter4j.models.ads.HttpVerb;
import twitter4j.models.ads.ListStatusResponse;
import twitter4j.models.ads.cards.TwitterVideoErrors;
import twitter4j.models.ads.cards.VideoObjectResponseData;
import twitter4j.models.video.UploadMediaObjectResponse;
import twitter4j.util.TwitterAdUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static twitter4j.TwitterAdsConstants.*;
import static twitter4j.util.TwitterAdUtil.constructBaseAdsResponse;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 7:07 PM
 */
public class TwitterAdsClient extends TwitterImpl implements OAuthSupport {

    private static final HttpParameter[] IMPLICIT_PARAMS = new HttpParameter[0];

    public static final Gson GSON_INSTANCE = new Gson();

    public static TwitterAdsClient getInstance(Configuration conf, Authorization auth) {
        return new TwitterAdsClient(conf, auth);
    }

    public TwitterAdsClient(Configuration conf, Authorization auth) {
        super(conf, auth);
    }

    private String getImplicitParamsStr() {
        return StringUtils.EMPTY;
    }

    private HttpParameter[] getImplicitParams() {
        return IMPLICIT_PARAMS;
    }

    public String getBaseAdsAPIUrl() {
        return conf.getAdsAPIURL();
    }

    public <T> BaseAdsListResponseIterable<T> executeHttpListRequest(String baseUrl, List<HttpParameter> params, Type type) throws TwitterException {
        return executeHttpListRequest(baseUrl, params, type, false);
    }

    public <T> BaseAdsListResponseIterable<T> executeHttpListRequest(String baseUrl, List<HttpParameter> params, Type type,
                                                                     boolean isCostBasedRateLimit) throws TwitterException {
        HttpResponse httpResponse;
        if (params != null) {
            httpResponse = get(baseUrl, params.toArray(new HttpParameter[params.size()]));
        } else {
            httpResponse = get(baseUrl);
        }
        BaseAdsListResponseIterable<T> response;
        try {
            response = constructBaseAdsListResponse(baseUrl, httpResponse, params, type, isCostBasedRateLimit);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse response.", e);
        }
        return response;
    }

    public <T> BaseAdsListResponseIterable<T> constructBaseAdsListResponse(String baseUrl, HttpResponse httpResponse, List<HttpParameter> params,
                                                                           Type type, boolean isCostBasedRateLimit)
            throws TwitterException, IOException {
        return new BaseAdsListResponseIterable<>(this, baseUrl, params, type, httpResponse, isCostBasedRateLimit);
    }

    public <T> BaseAdsResponse<T> executeHttpRequest(String baseUrl, HttpParameter[] params, Type type, HttpVerb httpVerb) throws TwitterException {
        HttpResponse httpResponse;
        String stringResponse;
        BaseAdsResponse<T> response = null;
        switch (httpVerb) {
            case GET:
                try {
                    httpResponse = get(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructBaseAdsResponse(httpResponse, stringResponse, type);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case PUT:
                try {
                    httpResponse = put(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructBaseAdsResponse(httpResponse, stringResponse, type);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case POST:
                try {
                    httpResponse = postRequest(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructBaseAdsResponse(httpResponse, stringResponse, type);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case DELETE:
                try {
                    httpResponse = delete(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructBaseAdsResponse(httpResponse, stringResponse, type);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
        }
        return response;
    }

    public HttpResponse postRequest(String url, String requestBody) throws TwitterException {
        return post(url, requestBody);
    }

    public HttpResponse postRequest(String url, HttpParameter[] params) throws TwitterException {
        return post(url, params);
    }

    public HttpResponse getRequest(String url, HttpParameter[] params) throws TwitterException {
        return get(url, params);
    }

    public HttpResponse getRequest(String url) throws TwitterException {
        return get(url);
    }

    public HttpResponse getWithoutMergeOfParams(String url, HttpParameter[] params) throws TwitterException {
        return getWithoutMergingImplicitParams(url, params);
    }

    public HttpResponse putRequest(String url, HttpParameter[] params) throws TwitterException {
        return put(url, params);
    }

    public <T> BaseAdsResponse<T> executePostRequestWithJsonRequestBody(String baseUrl, String requestBody, Type type) throws TwitterException {
        HttpResponse httpResponse;
        String stringResponse;
        BaseAdsResponse<T> response = null;
        try {
            httpResponse = postRequest(baseUrl, requestBody);
            stringResponse = httpResponse.asString();
            response = constructBaseAdsResponse(httpResponse, stringResponse, type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse response.", e);
        }
        return response;
    }

    public <T> T executeRequest(String baseUrl, HttpParameter[] params, Type typeToken, HttpVerb httpVerb) throws TwitterException {
        HttpResponse httpResponse;
        String stringResponse;
        T response = null;
        switch (httpVerb) {
            case GET:
                try {
                    httpResponse = getRequest(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructHTTPRequestResponse(stringResponse, typeToken);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case PUT:
                try {
                    httpResponse = put(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructHTTPRequestResponse(stringResponse, typeToken);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case POST:
                try {
                    httpResponse = postRequest(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructHTTPRequestResponse(stringResponse, typeToken);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case DELETE:
                try {
                    httpResponse = delete(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructHTTPRequestResponse(stringResponse, typeToken);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
        }
        return response;
    }

    public TwitterTonUploadResponse executeHttpRequestForTon(String baseUrl, HttpParameter[] params, HttpVerb httpVerb,
                                                             Map<String, String> customHeaders) throws TwitterException {
        HttpResponse httpResponse;
        AudienceUploadDetails response = null;
        //noinspection EnumSwitchStatementWhichMissesCases
        switch (httpVerb) {
            case PUT:
                httpResponse = putWithCustomHeaders(baseUrl, params, customHeaders, true);
                response = getResponseFromHeaders(httpResponse);

                break;
            case POST:
                httpResponse = postWithCustomHeaders(baseUrl, params, customHeaders, true);
                response = getResponseFromHeaders(httpResponse);
                break;
        }
        return response;
    }

    public BaseListResponseIterable<ListStatusResponse, Status> executeAndGetStatusIterable(String baseUrl, List<HttpParameter> params)
            throws TwitterException {

        HttpResponse httpResponse;
        if (params != null) {
            httpResponse = getRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        } else {
            httpResponse = getRequest(baseUrl);
        }
        BaseListResponseIterable<ListStatusResponse, Status> response;
        try {
            response = new StatusListResponseIterableImpl(this, baseUrl, params, httpResponse, conf);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse response.", e);
        }
        return response;
    }

    public VideoObjectResponseData uploadAndCreateVideoObject(String videoUrl, String accountId) throws TwitterException {
        try {
            String videoSizeInBytes = getVideoSizeInBytes(videoUrl);
            String mediaId = initiateVideoUpload(videoSizeInBytes);
            uploadVideo(videoUrl, mediaId, videoSizeInBytes);
            finalizeUpload(mediaId);
            waitForVideoTranscoding(mediaId, MAX_WAIT_TIME_TRANSCODING);
            String videoId = createVideoObject(mediaId, accountId);
            return waitForVideoProcessing(accountId, videoId, MAX_WAIT_TIME);
        } catch (IOException e) {
            throw new TwitterException("Error Occurred while uploading Promoted Video");
        }
    }

    public UploadMediaObjectResponse uploadAndGetMediaId(String videoUrl) throws TwitterException {
        try {
            String videoSizeInBytes = getVideoSizeInBytes(videoUrl);
            String mediaId = initiateVideoUpload(videoSizeInBytes);
            uploadVideo(videoUrl, mediaId, videoSizeInBytes);
            return finalizeUploadVideoForPreRoll(mediaId);
        } catch (IOException e) {
            throw new TwitterException("Error Occurred while uploading Promoted Video");
        }
    }

    public UploadMediaObjectResponse getUploadStatus(String mediaId) throws TwitterException {
        String url = conf.getMediaUploadBaseUrl() + "media/upload.json";
        List<HttpParameter> params = Lists.newArrayList();

        params.add(new HttpParameter(PARAM_VIDEO_MEDIA_ID, mediaId));
        params.add(new HttpParameter(PARAM_COMMAND, "STATUS"));
        Type type = new TypeToken<UploadMediaObjectResponse>() {}.getType();
        return executeRequest(url, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    public VideoObjectResponseData waitForVideoProcessing(String accountId, String videoId, long maxWaitTime) throws TwitterException {
        Long totalWaitTime = 0l;
        String url = getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PREFIX_VIDEOS;

        List<HttpParameter> params = createGetVideoObjectParams(videoId);

        Type type = new TypeToken<BaseAdsListResponse<VideoObjectResponseData>>() {}.getType();
        while (totalWaitTime < maxWaitTime) {
            BaseAdsListResponseIterable<VideoObjectResponseData> responseList = executeHttpListRequest(url, params, type, false);
            for (BaseAdsListResponse<VideoObjectResponseData> listResponse : responseList) {
                if (CollectionUtils.isNotEmpty(listResponse.getData())) {
                    VideoObjectResponseData response = listResponse.getData().iterator().next();
                    boolean readyToTweet = response.isReadyToTweet();
                    TwitterVideoErrors status = null;
                    if (response.getReasonsNotServable() != null && response.getReasonsNotServable().size() > 0) {
                        status = response.getReasonsNotServable().get(0);
                    }
                    if (readyToTweet) {
                        return response;
                    } else if (TwitterVideoErrors.PROCESSING.equals(status)) {
                        TwitterAdUtil.reallySleep(WAIT_INTERVAL);
                        totalWaitTime += WAIT_INTERVAL;
                    } else {
                        throw new TwitterException("Video processing error. Error code: " + (status != null ? status.getLabel() : StringUtils.EMPTY));
                    }
                    break;
                }
            }
        }
        return null;
    }

    public String uploadVideoInChunks(File file, Map<String, String> customHeaders, String baseUrl, List<HttpParameter> params)
            throws TwitterException {
        baseUrl = baseUrl + "?resumable=true";
        customHeaders.put("Content-Type", "video/mp4");
        customHeaders.put("X-TON-Content-Type", "video/mp4");
        customHeaders.put("Content-Length", String.valueOf(file.length()));
        customHeaders.put("X-TON-Content-Length", String.valueOf(file.length()));
        executeHttpRequestForTon(baseUrl, params.toArray(new HttpParameter[params.size()]), HttpVerb.POST, customHeaders);
        return null;
    }

    public Configuration getConf() {
        return super.getConfiguration();
    }

    // ------------------------------------------- Private Methods -------------------------------------------------

    private <T> T constructHTTPRequestResponse(String response, Type typeToken) throws IOException {
        return GSON_INSTANCE.fromJson(response, typeToken);

    }

    private <T> T constructResponse(String response, Type typeToken) throws IOException {
        return GSON_INSTANCE.fromJson(response, typeToken);

    }

    private Integer getBytesUploadedFromHeader(HttpResponse httpResponse) {
        String range;
        String rangeFromHeader = httpResponse.getResponseHeader("range");
        if (rangeFromHeader != null) {
            int i = rangeFromHeader.indexOf("-");
            if (i > 0) {
                range = rangeFromHeader.substring(i + 1, rangeFromHeader.length());
                return Integer.valueOf(range);
            }
        }
        return null;
    }

    private List<HttpParameter> createGetVideoObjectParams(String videoId) {
        List<HttpParameter> params = Lists.newArrayList();

        params.add(new HttpParameter(PARAM_VIDEO_IDS, videoId));
        return params;
    }

    private List<HttpParameter> createChunkedUploadStatusParams(String mediaId) {
        List<HttpParameter> params = Lists.newArrayList();

        params.add(new HttpParameter(PARAM_COMMAND, "STATUS"));
        params.add(new HttpParameter(PARAM_MEDIA_ID, mediaId));
        return params;
    }

    private UploadMediaObjectResponse finalizeUploadVideoForPreRoll(String mediaId) throws TwitterException {
        String url = getBaseAdsAPIUrl() + UPLOAD_MEDIA_URL + UPLOAD_JSON;
        List<HttpParameter> params = finalizeVideoUploadParams(mediaId);
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<UploadMediaObjectResponse>() {}.getType();
        return executeRequest(url, parameters, type, HttpVerb.POST);
    }

    private String createVideoObject(String mediaId, String accountId) throws TwitterException {
        String url = getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PREFIX_VIDEOS;
        //TODO add video title and description (optional)
        List<HttpParameter> params = createVideoObjectParams(mediaId);
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<VideoObjectResponseData>>() {}.getType();
        BaseAdsResponse<VideoObjectResponseData> response = executeHttpRequest(url, parameters, type, HttpVerb.POST);
        return response.getData().getId();
    }

    private List<HttpParameter> createVideoObjectParams(String mediaId) {
        List<HttpParameter> params = Lists.newArrayList();

        params.add(new HttpParameter(PARAM_VIDEO_MEDIA_ID, mediaId));
        params.add(new HttpParameter(PARAM_COMMAND, "FINALIZE"));
        return params;
    }

    private List<HttpParameter> finalizeVideoUploadParams(String mediaId) {
        List<HttpParameter> params = Lists.newArrayList();

        params.add(new HttpParameter(PARAM_VIDEO_MEDIA_ID, mediaId));
        params.add(new HttpParameter(PARAM_COMMAND, "FINALIZE"));
        return params;
    }

    private List<HttpParameter> createInitiateVideoUploadParams(String videoSizeInBytes) {

        List<HttpParameter> params = Lists.newArrayList();

        params.add(new HttpParameter(PARAM_COMMAND, "INIT"));
        params.add(new HttpParameter(PARAM_MEDIA_TYPE, "video/mp4"));
        params.add(new HttpParameter(PARAM_MEDIA_CATEGORY, "amplify_video"));
        if (StringUtils.isNotBlank(videoSizeInBytes)) {
            params.add(new HttpParameter(PARAM_TOTAL_BYTES, videoSizeInBytes));
        }
        return params;
    }

    private void finalizeUpload(String mediaId) throws TwitterException {
        String url = conf.getMediaUploadBaseUrl() + "media/upload.json";

        List<HttpParameter> params = createFinalizeUploadParams(mediaId);
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        videoUploadInitAndFinalize(url, parameters);
    }

    private List<HttpParameter> createFinalizeUploadParams(String mediaId) {
        List<HttpParameter> params = Lists.newArrayList();

        params.add(new HttpParameter(PARAM_COMMAND, "FINALIZE"));
        params.add(new HttpParameter(PARAM_MEDIA_ID, mediaId));
        return params;
    }

    private void waitForVideoTranscoding(String mediaId, long maxWaitTime) throws TwitterException {
        long totalWaitTime = 0;
        String url = conf.getMediaUploadBaseUrl() + "media/upload.json";

        List<HttpParameter> params = createChunkedUploadStatusParams(mediaId);
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);

        while (totalWaitTime < maxWaitTime) {
            TwitterAdUtil.reallySleep(WAIT_INTERVAL_TRANSCODING);
            totalWaitTime += WAIT_INTERVAL_TRANSCODING;
            Media media = checkVideoUploadStatus(url, parameters);
            if (STATE_SUCCEEDED.equals(media.getState())) {
                return;
            } else if (!STATE_IN_PROGRESS.equals(media.getState())) {
                throw new TwitterException("Video transcoding error. Error code: " + media.getState());
            }
        }
    }

    private AudienceUploadDetails getResponseFromHeaders(HttpResponse httpResponse) {
        Integer minChunkSize = null;
        Integer maxChunkSize = null;
        String location = httpResponse.getResponseHeader("location");
        Integer bytesSuccessfullyUploaded = getBytesUploadedFromHeader(httpResponse);
        String minimumChunkSizeFromHeader = httpResponse.getResponseHeader("x-ton-min-chunk-size");
        if (minimumChunkSizeFromHeader != null) {
            minChunkSize = Integer.valueOf(minimumChunkSizeFromHeader);

        }
        String maximumChunkSizeFromHeader = httpResponse.getResponseHeader("x-ton-max-chunk-size");
        if (maximumChunkSizeFromHeader != null) {
            maxChunkSize = Integer.valueOf(maximumChunkSizeFromHeader);

        }
        return new AudienceUploadDetails(location, minChunkSize, maxChunkSize, bytesSuccessfullyUploaded, null);
    }

    private void appendChunk(String mediaId, String chunk, int segmentIndex) throws TwitterException {
        String url = conf.getMediaUploadBaseUrl() + "media/upload.json";

        List<HttpParameter> params = createAppendChunkParams(mediaId, chunk, segmentIndex);
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);

        HttpResponse response = postRequest(url, parameters);
        int responseCode = response.getStatusCode();
        if (responseCode < SUCCESSFULL_CALL_BEGIN_CODE || responseCode > SUCCESSFULL_CALL_END_CODE) {
            throw new TwitterException(response.asString());
        }

    }

    private List<HttpParameter> createAppendChunkParams(String mediaId, String chunk, int segment_index) {
        List<HttpParameter> params = Lists.newArrayList();

        params.add(new HttpParameter(PARAM_COMMAND, "APPEND"));
        params.add(new HttpParameter(PARAM_MEDIA_ID, mediaId));
        params.add(new HttpParameter(PARAM_MEDIA_DATA, chunk));
        params.add(new HttpParameter(PARAM_SEGMENT_INDEX, segment_index));

        return params;
    }

    private String getVideoSizeInBytes(String videoUrl) throws TwitterException, IOException {
        URLConnection urlConnection = new URL(videoUrl).openConnection();
        return urlConnection.getHeaderField("Content-Length");
    }

    private String initiateVideoUpload(String videoSizeInBytes) throws TwitterException {
        Long videoSizeInBytesLong;
        try{
            videoSizeInBytesLong = Long.valueOf(videoSizeInBytes);
        } catch (NumberFormatException eX){
            throw new TwitterException("Video could not be uploaded as connection could not be established");
        }
        if (videoSizeInBytesLong > MAX_VIDEO_SIZE_IN_BYTES) {
            throw new TwitterException("Video should be less than 500 MB in size");
        }

        String url = conf.getMediaUploadBaseUrl() + "media/upload.json";

        List<HttpParameter> params = createInitiateVideoUploadParams(videoSizeInBytes);
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Media media = videoUploadInitAndFinalize(url, parameters);
        return media.getMediaIdString();
    }

    private void uploadVideo(String videoUrl, String mediaId, String videoSizeInBytes) throws TwitterException, IOException {
        int segmentIndex = 0;
        Long bytesLeftTOUpload = Long.valueOf(videoSizeInBytes);
        InputStream inputStream = new URL(videoUrl).openStream();
        while (bytesLeftTOUpload > 0) {
            byte[] chunk = new byte[CHUNK_SIZE_IN_BYTES];
            int bytesRead = inputStream.read(chunk);
            if (bytesRead != -1) {
                chunk = Arrays.copyOf(chunk, bytesRead);
            }
            String base64Encoding = Base64.encodeBase64String(chunk);
            appendChunk(mediaId, base64Encoding, segmentIndex);
            bytesLeftTOUpload -= bytesRead;
            segmentIndex += 1;
        }
    }

    public HttpResponse get(String url) throws TwitterException {
        ensureAuthorizationEnabled();
        if (IMPLICIT_PARAMS_STR.length() > 0) {
            if (url.contains("?")) {
                url = url + "&" + IMPLICIT_PARAMS_STR;
            } else {
                url = url + "?" + IMPLICIT_PARAMS_STR;
            }
        }
        if (!conf.isMBeanEnabled()) {
            return http.get(url, null, auth, this);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.get(url, null, auth, this);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    public HttpResponse get(String url, HttpParameter... params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.get(url, mergeImplicitParams(params), auth, this);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.get(url, mergeImplicitParams(params), auth, this);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    public HttpResponse post(String url) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.post(url, IMPLICIT_PARAMS, auth, this);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.post(url, IMPLICIT_PARAMS, auth, this);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    public HttpResponse post(String url, HttpParameter... params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.post(url, mergeImplicitParams(params), auth, this);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.post(url, mergeImplicitParams(params), auth, this);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    public HttpParameter[] mergeParameters(HttpParameter[] params1, HttpParameter[] params2) {
        if (params1 != null && params2 != null) {
            HttpParameter[] params = new HttpParameter[params1.length + params2.length];
            System.arraycopy(params1, 0, params, 0, params1.length);
            System.arraycopy(params2, 0, params, params1.length, params2.length);
            return params;
        }
        if (null == params1 && null == params2) {
            return new HttpParameter[0];
        }
        if (params1 != null) {
            return params1;
        } else {
            return params2;
        }
    }

    public HttpParameter[] mergeParameters(HttpParameter[] params1, HttpParameter params2) {
        if (params1 != null && params2 != null) {
            HttpParameter[] params = new HttpParameter[params1.length + 1];
            System.arraycopy(params1, 0, params, 0, params1.length);
            params[params.length - 1] = params2;
            return params;
        }
        if (null == params1 && null == params2) {
            return new HttpParameter[0];
        }
        if (params1 != null) {
            return params1;
        } else {
            return new HttpParameter[]{params2};
        }
    }

    public HttpParameter[] mergeImplicitParams(HttpParameter... params) {
        return mergeParameters(params, IMPLICIT_PARAMS);
    }

    private boolean isOk(HttpResponse response) {
        return response != null && response.getStatusCode() < 300;
    }

    protected HttpResponse put(String url) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.put(url, getImplicitParams(), auth, null);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.put(url, getImplicitParams(), auth, null);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    protected HttpResponse put(String url, HttpParameter[] params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.put(url, mergeImplicitParams(params), auth, null);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.put(url, mergeImplicitParams(params), auth, null);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    protected HttpResponse delete(String url) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.delete(url, getImplicitParams(), auth, null);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.delete(url, getImplicitParams(), auth, null);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    protected HttpResponse delete(String url, HttpParameter[] params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.delete(url, mergeImplicitParams(params), auth, null);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.delete(url, mergeImplicitParams(params), auth, null);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    protected HttpResponse putWithCustomHeaders(String url, HttpParameter[] params, Map<String, String> customHeaders, boolean isTonUpload)
            throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.putWithCustomHeaders(url, params, auth, customHeaders, isTonUpload);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.putWithCustomHeaders(url, params, auth, customHeaders, isTonUpload);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }
}

