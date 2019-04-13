package com.tourfirm;

import com.toufirm.Visa;

import java.util.List;

/**
 * Created by Illia Chenchak
 */
public interface VisaDAO {

    Visa getVisaById(Integer id);

    List<Visa> findAll();

    void save (Visa visa);

    void update (Integer id, Visa visa);

    void delete (Integer id);


}
