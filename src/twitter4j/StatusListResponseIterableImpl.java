package twitter4j;

import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.json.StatusJSONImpl;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.models.ads.ListStatusResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Date: 25/09/14
 * Time: 7:56 PM
 *
 * @author yogin
 */
public class StatusListResponseIterableImpl extends BaseListResponseIterable<ListStatusResponse, Status> {

    public StatusListResponseIterableImpl(TwitterBaseImpl twitterBase, String baseUrl, List<HttpParameter> baseParameters, HttpResponse response,
                                          Configuration conf)
            throws IOException, TwitterException {
        super(twitterBase, baseUrl, baseParameters, ListStatusResponse.class, Status.class, response, conf);
    }

    @Override
    protected List<Status> readData(JSONArray data, Configuration conf) throws TwitterException {
        try {
            if (data == null || data.length() == 0) {
                return Collections.emptyList();
            }
            return StatusJSONImpl.parseStatuses(conf, data);
        } catch (JSONException e) {
            throw new TwitterException("Failed to parse response." + data, e);
        }
    }

    @Override
    protected BaseListResponseIterable<ListStatusResponse, Status> createIterable(HttpResponse httpResponse) throws TwitterException, IOException {
        return new StatusListResponseIterableImpl(twitterBase, baseUrl, baseParameters, httpResponse, conf);
    }
}
