package twitter4j;

import com.google.gson.Gson;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.util.TwitterAdHttpUtils;
import twitter4j.util.TwitterAdUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

import static com.restfb.util.StringUtils.isBlank;

/**
 * User: poly
 * Date: 07/02/14
 * Time: 11:56 AM
 */
public class BaseAdsListResponseIterable<T> implements Iterable<BaseAdsListResponse<T>> {
    private final TwitterBaseImpl twitterBase;
    private BaseAdsListResponse<T> data;
    private final String baseUrl;
    private final Type type;
    private String nextCursor;
    private final List<HttpParameter> baseParameters;
    private boolean isCostBasedRateLimit;

    public BaseAdsListResponseIterable(TwitterBaseImpl twitterBase, String baseUrl, List<HttpParameter> baseParameters, Type type,
                                       HttpResponse response, boolean isCostBasedRateLimit) throws IOException, TwitterException {
        this.isCostBasedRateLimit = isCostBasedRateLimit;
        TwitterAdUtil.ensureNotNull(twitterBase, "Twitter Ads API");
        TwitterAdUtil.ensureNotNull(response, "Twitter Ads Response");
        this.twitterBase = twitterBase;
        this.baseUrl = baseUrl;
        this.baseParameters = baseParameters == null ? Collections.<HttpParameter>emptyList() : Collections.unmodifiableList(baseParameters);
        Gson gson = new Gson();

        this.data = gson.fromJson(response.asString(), type);
        if (this.data == null) {
            this.data = new BaseAdsListResponse<>();
        }

        this.type = type;
        RateLimitStatus rateLimitStatus;
        if (isCostBasedRateLimit) {
            rateLimitStatus = TwitterAdHttpUtils.createFromResponseHeaderForCostBasedRateLimit(response);
        } else {
            rateLimitStatus = TwitterAdHttpUtils.createFromResponseHeader(response);
        }
        data.setRateLimitStatus(rateLimitStatus);
        if (TwitterAdUtil.isNotEmpty(data.getData()) && data.getNextCursor() != null) {
            nextCursor = data.getNextCursor();
        }
    }

    @Override
    public BaseAdsListResponseIterator<T> iterator() {
        return new BaseAdsListResponseIterator<>(this);
    }

    private static class BaseAdsListResponseIterator<T> implements Iterator<BaseAdsListResponse<T>> {
        private BaseAdsListResponseIterable<T> baseAdsListResponseIterable;
        private boolean initialResponse = true;

        private BaseAdsListResponseIterator(BaseAdsListResponseIterable<T> baseAdsListResponseIterable) {
            this.baseAdsListResponseIterable = baseAdsListResponseIterable;
        }

        @Override
        public boolean hasNext() {
            return initialResponse || baseAdsListResponseIterable.hasNext();
        }

        @Override
        public BaseAdsListResponse<T> next() {
            if (initialResponse) {
                initialResponse = false;
                return baseAdsListResponseIterable.getData();
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more data to fetch");
            }
            try {
                baseAdsListResponseIterable = baseAdsListResponseIterable.fetchNextResponse();
            } catch (IOException | TwitterException e) {
                throw new TwitterRuntimeException(e, new TwitterException("Could not fetch more data."));
            }
            return baseAdsListResponseIterable.getData();
        }

        @Override
        public void remove() {
            // NOT SUPPORTED OPERATION
        }

        public String getNextCursor() {
            return baseAdsListResponseIterable.getNextCursor();
        }
    }

    private BaseAdsListResponseIterable<T> fetchNextResponse() throws IOException, TwitterException {
        List<HttpParameter> parameters = TwitterAdUtil.createMutableList(baseParameters);
        parameters = removeParamIfExist(parameters, "cursor");
        parameters.add(new HttpParameter("cursor", getNextCursor()));
        HttpResponse httpResponse = twitterBase.get(baseUrl, parameters.toArray(new HttpParameter[parameters.size()]));
        return new BaseAdsListResponseIterable<>(twitterBase, baseUrl, baseParameters, type, httpResponse, isCostBasedRateLimit);
    }

    private List<HttpParameter> removeParamIfExist(List<HttpParameter> parameters, String param) {
        if (parameters.isEmpty() || param == null) {
            return parameters;
        }

        List<HttpParameter> toReturn = new ArrayList<HttpParameter>();
        for (HttpParameter parameter : parameters) {
            if (parameter != null && param.equalsIgnoreCase(parameter.getName())) {
                continue;
            }
            toReturn.add(parameter);
        }
        return toReturn;
    }

    public boolean hasData() {
        return data != null && data.getData() != null && !data.getData().isEmpty();
    }

    private BaseAdsListResponse<T> getData() {
        return data == null ? new BaseAdsListResponse<T>() : data;
    }

    private boolean hasNext() {
        return !isBlank(getNextCursor());
    }

    public String getNextCursor() {
        return nextCursor;
    }

}
