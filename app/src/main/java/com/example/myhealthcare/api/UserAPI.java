package com.example.myhealthcare.api;

import com.example.myhealthcare.models.User;
import com.example.myhealthcare.router.UserRouter;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class UserAPI {

    UserRouter userRouter = Retro.getInstance().create(UserRouter.class);
    boolean checkReg, checkLogin, checkUpdate = false;
    public static User userDetail = null;

    public boolean register(User user) {

        Call<Void> callUser = userRouter.register(user);
        Strict.StrictMode();
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
        Strict.StrictMode();
        try {
            Response<User> regResponse = callUser.execute();
            if (regResponse.isSuccessful()) {
                checkLogin = true;
                userDetail = regResponse.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkLogin;
    }

    public void getPatientDetail() {
        Call<User> userCall = userRouter.getPatientByid(userDetail.getId());
        Strict.StrictMode();
        try {
            Response<User> response = userCall.execute();
            if (response.isSuccessful()) {
                userDetail=response.body();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean updatePatient(User user) {
        Call<Void> userCall = userRouter.updatePatient(userDetail.getId(), user);
        Strict.StrictMode();
        try {
            Response<Void> response = userCall.execute();
            if (response.isSuccessful()) {
                checkUpdate = true;
                getPatientDetail();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkUpdate;
    }

}