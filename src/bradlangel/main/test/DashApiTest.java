package bradlangel.main.test;

import bradlangel.GasStation;
import org.junit.Test;
import retrofit.RestAdapter;

import java.util.List;

/**
 * Created by bradlangel on 7/18/14.
 */
public class DashApiTest {

    private final static String latitude = "40.686647";
    private final static String longitude = "-73.991809";
    private final static String sort = "regular";



    @Test
    public void callToAPI() {
//Create Rest Adaptor; explicitly call Okhttp

        RestAdapter restAdapterT =  new RestAdapter.Builder()
                .setEndpoint("https://dash.by/api/v1")
                .build();

        DashApiInterface dashApiServiceT = restAdapterT.create(DashApiInterface.class);


        //Each call on the generated dashApiService makes an HTTP request to the remote web server.
        List<GasStation> gasStationsT = dashApiServiceT.listGasStations(latitude, longitude, sort, key, value);

        String gasLocationT = gasStationsT.get(0).getLongName();

    }
}
