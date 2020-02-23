package com.android.myhealthcare.api;

import com.android.myhealthcare.models.User;
import com.android.myhealthcare.router.UserRouter;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

public class UserAPI {

    UserRouter userRouter = Retro.getInstance().create(UserRouter.class);
    boolean checkReg, checkLogin, checkUpdate = false;
    public static User userDetail;
    public static String token;
    public static String id;

    public boolean register(User user) {

        Call<Void> callUser = userRouter.register(user);
        try {
            Response<Void> regResponse = callUser.execute();
            if (regResponse.isSuccessful()) {
                checkReg = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkReg;
    }

    public boolean login(User user) {

        Call<User> callUser = userRouter.login(user);
        try {
            Response<User> regResponse = callUser.execute();
            if (regResponse.isSuccessful()) {
                checkLogin = true;
                userDetail = regResponse.body();
                token = regResponse.body().getToken();
                id = regResponse.body().get_id();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkLogin;
    }

    public User getPatientDetail(String id) {
        Call<User> userCall = userRouter.getPatientByid(id);
        Strict.StrictMode();
        try {
            Response<User> response = userCall.execute();
            if (response.isSuccessful()) {
                userDetail = response.body();

            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        return userDetail;
    }

    public boolean updatePatient(User user, MultipartBody.Part image) {

        RequestBody name = RequestBody.create(MediaType.parse("text/plain"), user.getName());
        RequestBody address = RequestBody.create(MediaType.parse("text/plain"), user.getAddress());
        RequestBody dob = RequestBody.create(MediaType.parse("text/plain"), user.getDob());
        RequestBody bloodgroup = RequestBody.create(MediaType.parse("text/plain"), user.getBloodgroup());
        RequestBody weight = RequestBody.create(MediaType.parse("text/plain"), user.getWeight());
        RequestBody height = RequestBody.create(MediaType.parse("text/plain"), user.getHeight());
        RequestBody phone = RequestBody.create(MediaType.parse("text/plain"), user.getPhone());

        Call<Void> userCall = userRouter.updatePatient(userDetail.getId(), name, address, dob, bloodgroup, weight, height, phone, image);
        try {
            Response<Void> response = userCall.execute();
            if (response.isSuccessful()) {
                checkUpdate = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkUpdate;
    }
    
}
