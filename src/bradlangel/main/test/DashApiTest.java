package bradlangel.main.test;

import bradlangel.main.java.ApiCredentials;
import bradlangel.main.java.DashService;
import bradlangel.main.java.GasStation;
import org.junit.Assert;
import org.junit.Test;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.List;

/**
 * Created by bradlangel on 7/18/14.
 */
public class DashApiTest {

    private final static String latitude = "40.686647";
    private final static String longitude = "-73.991809";
    private final static String sort = "regular";
    private final ApiCredentials apiCredentials = new ApiCredentials();


    @Test
    public void callToAPI() {





        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader(apiCredentials.getKey(), apiCredentials.getValue());
            }
        };


        RestAdapter restAdapterT =  new RestAdapter.Builder()
                .setEndpoint("https://dash.by/api/v1")
                .setRequestInterceptor(requestInterceptor)
                .build();

        DashService dashApiServiceT = restAdapterT.create(DashService.class);




        //Each call on the generated dashApiService makes an HTTP request to the remote web server.
        dashApiServiceT.getGasStations(latitude,
                longitude,
                sort,
                new Callback<List<GasStation>>() {
                    @Override
                    public void success(List<GasStation> gasStations, Response response) {
                        String gasLocationT = gasStations.get(0).getLongName();
                        System.out.print(gasLocationT);
                        Assert.assertTrue(gasLocationT.equals("Brooklyn Hess"));
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {

                    }
                });



    }
}
