package com.android.myhealthcare;

import com.android.myhealthcare.api.AppointmentAPI;
import com.android.myhealthcare.api.DoctorAPI;
import com.android.myhealthcare.api.UserAPI;
import com.android.myhealthcare.models.Doctor;
import com.android.myhealthcare.models.RequestAppointment;
import com.android.myhealthcare.models.User;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnitTest {
    private AppointmentAPI appointmentAPI;
    private UserAPI userAPI;
    private DoctorAPI doctorAPI;

    @Before
    public void setup() {
        appointmentAPI = new AppointmentAPI();
        userAPI = new UserAPI();
        doctorAPI = new DoctorAPI();
    }

    @Test
    public void testAppointment() {
        RequestAppointment requestAppoint = new RequestAppointment("1998/1/1", "10AM", "5e35c1f5073c7226ac54a545", "5e35c5bc2cb43a69acd27655");
        boolean appointment = appointmentAPI.addAppointments(requestAppoint);
        assertTrue(appointment);
    }

    @Test
    public void testCorrectLogin() {
        User user = new User("krranjik", "kritik");
        boolean login = userAPI.login(user);
        assertTrue(login);
    }

    @Test
    public void testIncorrectLogin() {
        User user = new User("", "kritik");
        boolean login = userAPI.login(user);
        assertFalse(login);
    }

    @Test
    public void testRegister() {
        User user = new User("", "test1", "test1", "test1", "test1", "", "", "Male", "", "", "", "", "");
        boolean register = userAPI.register(user);
        assertTrue(register);
    }

    @Test
    public void testgetAllDoctor() {
        List<Doctor> alldoctor = doctorAPI.getAllDoctors();
        assertNotNull(alldoctor);
    }

    @Test
    public void testgetSingleDoctor() {
        Doctor singledoctor = doctorAPI.getDoctorDetails("5e35c1f5073c7226ac54a545");
        assertNotNull(singledoctor);
    }


}
