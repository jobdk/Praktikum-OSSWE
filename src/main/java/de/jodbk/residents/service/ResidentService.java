package de.jodbk.residents.service;

import de.jodbk.residents.domain.Resident;

import java.text.ParseException;
import java.util.List;

/**
 * @author Stefan Betermieux
 */
public interface ResidentService {

    Resident getUniqueResident(Resident filterResident) throws ResidentServiceException, ParseException;

    List<Resident> getFilteredResidentsList(Resident filterResident) throws ParseException;

}