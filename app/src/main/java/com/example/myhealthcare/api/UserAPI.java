package com.example.myhealthcare.api;

import com.example.myhealthcare.models.User;
import com.example.myhealthcare.router.UserRouter;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class UserAPI {

    UserRouter userRouter = Retro.getInstance().create(UserRouter.class);
    boolean checkReg = false;

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
}
