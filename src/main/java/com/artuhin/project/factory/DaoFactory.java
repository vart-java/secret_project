package com.artuhin.project.factory;

import com.artuhin.project.dao.AppointmentDao;
import com.artuhin.project.dao.ProcedureDao;
import com.artuhin.project.dao.UserDao;

public class DaoFactory {
    private UserDao userDao = UserDao.getInstance();
    private AppointmentDao appointmentDao = AppointmentDao.getInstance();
    private ProcedureDao procedureDao = ProcedureDao.getInstance();

    private static DaoFactory instance;

    public static synchronized DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    private DaoFactory() {
    }

    public UserDao getUsersDao() {
        return userDao;
    }

    public AppointmentDao getAppointmentDao() {
        return appointmentDao;
    }

    public ProcedureDao getProcedureDao() {
        return procedureDao;
    }
}
