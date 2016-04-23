package twitter4j;

import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;
import twitter4j.util.TwitterAdHttpUtils;
import twitter4j.util.TwitterAdUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static com.restfb.util.StringUtils.isBlank;

public abstract class BaseListResponseIterable<T extends BaseListResponse, DataType> implements Iterable<T> {

    protected final TwitterBaseImpl twitterBase;
    protected final Class<T> responseType;
    protected final Class<DataType> responseDataType;
    protected final String baseUrl;
    protected final List<HttpParameter> baseParameters;
    protected final Configuration conf;
    private T data;
    private String nextCursor;

    public BaseListResponseIterable(TwitterBaseImpl twitterBase, String baseUrl, List<HttpParameter> baseParameters, Class<T> clazz,
                                    Class<DataType> dataTypeClazz, HttpResponse response, Configuration conf) throws IOException, TwitterException {
        TwitterAdUtil.ensureNotNull(twitterBase, "Twitter Ads API");
        TwitterAdUtil.ensureNotNull(response, "Twitter Ads Response");
        this.twitterBase = twitterBase;
        this.baseUrl = baseUrl;
        this.baseParameters = baseParameters == null ? Collections.<HttpParameter>emptyList() : Collections.unmodifiableList(baseParameters);
        this.responseType = clazz;
        this.responseDataType = dataTypeClazz;

        this.conf = conf;

        try {
            data = clazz.newInstance();

            JSONObject dataJson = response.asJSONObject();
            if (dataJson.has("next_cursor")) {
                nextCursor = dataJson.getString("next_cursor");
                data.setNextCursor(nextCursor);
            }
            List<DataType> rawData = Collections.emptyList();
            if (dataJson.has("data")) {
                JSONArray dataTypeListJson = dataJson.getJSONArray("data");
                rawData = readData(dataTypeListJson, conf);
                data.setData(rawData);
            }

            if (dataJson.has("data_type")) {
                data.setDataType(dataJson.getString("data_type"));
            }

            RateLimitStatus rateLimitStatus = TwitterAdHttpUtils.createFromResponseHeader(response);
            data.setRateLimitStatus(rateLimitStatus);
            if (TwitterAdUtil.isNotEmpty(data.getData()) && data.getNextCursor() != null) {
                nextCursor = data.getNextCursor();
            }
        } catch (InstantiationException | IllegalAccessException | JSONException e) {
            throw new TwitterException("Failed to create response.", e);
        }
    }

    protected abstract List<DataType> readData(JSONArray data, Configuration conf) throws TwitterException;

    @Override
    public Iterator<T> iterator() {
        return new BaseListResponseIterator<T, DataType>(this);
    }

    private static class BaseListResponseIterator<T extends BaseListResponse, DataType> implements Iterator<T> {
        private BaseListResponseIterable<T, DataType> baseListResponseIterable;
        private boolean initialResponse = true;

        protected BaseListResponseIterator(BaseListResponseIterable<T, DataType> baseListResponseIterable) {
            this.baseListResponseIterable = baseListResponseIterable;
        }

        @Override
        public boolean hasNext() {
            return initialResponse || baseListResponseIterable.hasNext();
        }

        @Override
        public T next() {
            if (initialResponse) {
                initialResponse = false;
                return baseListResponseIterable.getData();
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more data to fetch");
            }
            try {
                baseListResponseIterable = baseListResponseIterable.fetchNextResponse();
            } catch (IOException e) {
                throw new TwitterRuntimeException(e, new TwitterException("Could not fetch more data."));
            } catch (TwitterException e) {
                throw new TwitterRuntimeException(e, new TwitterException("Could not fetch more data."));
            }
            return baseListResponseIterable.getData();
        }

        @Override
        public void remove() {
            // NOT SUPPORTED OPERATION
        }
    }

    private BaseListResponseIterable<T, DataType> fetchNextResponse() throws IOException, TwitterException {
        List<HttpParameter> parameters = TwitterAdUtil.createMutableList(baseParameters);
        parameters.add(new HttpParameter("cursor", getNextCursor()));
        HttpResponse httpResponse = twitterBase.get(baseUrl, parameters.toArray(new HttpParameter[parameters.size()]));
        return createIterable(httpResponse);
    }

    protected abstract BaseListResponseIterable<T, DataType> createIterable(HttpResponse httpResponse) throws TwitterException, IOException;

    private T getData() {
        return data;
    }

    public boolean hasData() {
        return data != null && data.getData() != null && !data.getData().isEmpty();
    }

    private boolean hasNext() {
        return !isBlank(getNextCursor());
    }

    public String getNextCursor() {
        return nextCursor;
    }
}
