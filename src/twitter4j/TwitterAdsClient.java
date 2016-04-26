package twitter4j;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import twitter4j.auth.Authorization;
import twitter4j.auth.OAuthSupport;
import twitter4j.conf.Configuration;
import twitter4j.models.ads.AudienceUploadDetails;
import twitter4j.models.ads.HttpVerb;
import twitter4j.models.ads.cards.VideoObjectResponseData;
import twitter4j.models.video.UploadMediaObjectResponse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import static twitter4j.TwitterAdsConstants.*;
import static twitter4j.util.TwitterAdUtil.constructBaseAdsResponse;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 7:07 PM
 */
public class TwitterAdsClient extends TwitterImpl implements OAuthSupport {

    public static final String ADS_API_URL = "https://ads-api.twitter.com/";
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


    public String getBaseAdsAPIUrl() {
        return ADS_API_URL;//conf.getAdsAPIURL();
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
        Type type = new TypeToken<UploadMediaObjectResponse>() {
        }.getType();
        return executeRequest(url, parameters, type, HttpVerb.POST);
    }

    private String createVideoObject(String mediaId, String accountId) throws TwitterException {
        String url = getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PREFIX_VIDEOS;
        //TODO add video title and description (optional)
        List<HttpParameter> params = createVideoObjectParams(mediaId);
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<VideoObjectResponseData>>() {
        }.getType();
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

    private List<HttpParameter> createFinalizeUploadParams(String mediaId) {
        List<HttpParameter> params = Lists.newArrayList();

        params.add(new HttpParameter(PARAM_COMMAND, "FINALIZE"));
        params.add(new HttpParameter(PARAM_MEDIA_ID, mediaId));
        return params;
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

    public HttpResponse get(String url) throws TwitterException {
        ensureAuthorizationEnabled();

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
            return http.get(url, params, auth, this);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.get(url, params, auth, this);
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
            return http.post(url, null, auth, this);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.post(url, null, auth, this);
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
            return http.post(url, params, auth, this);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.post(url, params, auth, this);
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

    private boolean isOk(HttpResponse response) {
        return response != null && response.getStatusCode() < 300;
    }

    protected HttpResponse put(String url) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.put(url, null, auth, null);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.put(url, null, auth, null);
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
            return http.put(url, params, auth, null);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.put(url, params, auth, null);
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
            return http.delete(url, null, auth, null);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.delete(url, null, auth, null);
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
            return http.delete(url, params, auth, null);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.delete(url, params, auth, null);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    protected HttpResponse getWithoutMergingImplicitParams(String url, HttpParameter[] params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.get(url, params, auth, null);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.get(url, params, auth, null);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }
}

