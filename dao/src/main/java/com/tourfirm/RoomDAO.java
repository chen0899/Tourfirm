package com.tourfirm;

import com.toufirm.Room;

import java.util.List;

public interface RoomDAO  {

    Room getRoomById(int id);

    List<Room> findAll();
}
