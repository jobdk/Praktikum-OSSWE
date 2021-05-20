package de.jodbk.residents.repository;

import de.jodbk.residents.domain.Resident;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class ResidentRepositoryImplStub implements ResidentRepository {

    @Override
    public List<Resident> getResidents() {
        try {
            return Arrays.asList(
                    new Resident("Jarvies", "Man", "Straße 1", "Freiburg",
                            new SimpleDateFormat("dd-MM-yyyy").parse("31-12-1997")),
                    new Resident("Steve", "Rodgers", "Bushwik 2", "Brooklyn",
                            new SimpleDateFormat("dd-MM-yyyy").parse("04-07-1918")),
                    new Resident("Michael", "Rodgers", "Bushwik 2", "Brooklyn",
                            new SimpleDateFormat("dd-MM-yyyy").parse("04-07-1918")));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
