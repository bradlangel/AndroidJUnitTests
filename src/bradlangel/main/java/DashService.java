package bradlangel.main.java;


import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;
/**
 * Created by bradlangel on 7/18/14.
 */
public interface DashService {



    @GET("/gas/price/latlng/{latitude}/{longitude}/{sort}")
        void getGasStations(@Path("latitude") String latitude,
                                     @Path("longitude") String longitude,
                                     @Path("sort") String sort,
                                     Callback<List<GasStation>> callback);

    @GET("/gas/price/latlng/{latitude}/{longitude}/{sort}")
    List<GasStation> listGasStations(@Path("latitude") String latitude,
                        @Path("longitude") String longitude,
                        @Path("sort") String sort);
}

