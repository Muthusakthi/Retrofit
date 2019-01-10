package ple.sam.com.retrofit.network;

import java.util.List;

import ple.sam.com.retrofit.model.Apires;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetEmployeeDataService {
    @GET("getuser.php")

    Call<List<Apires>> getEmployeeData();

}
