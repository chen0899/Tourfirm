package com.tourfirm;

public abstract class DAOFactory {
    public static final int MySQL = 1;

    public abstract HotelDAO getHotelDAO();
    public abstract RoomDAO getRoomDAO();
    public abstract ClientDAO geClientDAO();
    public abstract CountryDAO getCountryDAO();
}
