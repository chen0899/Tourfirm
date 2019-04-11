package com.tourfirm;

import com.toufirm.Room;

import java.util.List;

public interface MySQLRoomDAO {

    Room getRoomById(int id);

    List<Room> findAll();
}
