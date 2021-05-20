package de.jodbk.residents.repository;

import de.jodbk.residents.domain.Resident;

import java.text.ParseException;
import java.util.List;

/**
 * @author Stefan Betermieux
 */
public interface ResidentRepository {

    List<Resident> getResidents() throws ParseException;

}