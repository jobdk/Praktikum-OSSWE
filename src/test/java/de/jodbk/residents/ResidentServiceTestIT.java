package de.jodbk.residents;

import de.jodbk.residents.domain.Resident;
import de.jodbk.residents.repository.ResidentRepository;
import de.jodbk.residents.repository.ResidentRepositoryImplStub;
import de.jodbk.residents.service.BaseResidentService;
import de.jodbk.residents.service.ResidentService;
import de.jodbk.residents.service.ResidentServiceException;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResidentServiceTestIT {

    private final ResidentRepository residentRepository = new ResidentRepositoryImplStub();
    private ResidentService classUnderTest;


    @Before
    public void init() {
        classUnderTest = new BaseResidentService(residentRepository);
    }

    @Test
    public void test_getUniqueResident_returns_correct() throws ParseException, ResidentServiceException {
        Resident testData = new Resident("Steve", "Rodgers", "Bushwik 2", "Brooklyn",
                new SimpleDateFormat("dd-MM-yyyy").parse("04-07-1918"));

        Resident result = classUnderTest.getUniqueResident(testData);

        Assert.assertEquals(testData.getGivenName(), result.getGivenName());
        Assert.assertEquals(testData.getFamilyName(), result.getFamilyName());
        Assert.assertEquals(testData.getStreet(), result.getStreet());
        Assert.assertEquals(testData.getCity(), result.getCity());
        Assert.assertEquals(testData.getDateOfBirth(), result.getDateOfBirth());
    }

    @Test(expected = ResidentServiceException.class)
    public void test_getUniqueResident_returns_ResidentServiceException() throws ParseException, ResidentServiceException {
        Resident testData = new Resident("Not Found", "Rodgers", "Bushwik 2", "Brooklyn",
                new SimpleDateFormat("dd-MM-yyyy").parse("04-07-1918"));

        classUnderTest.getUniqueResident(testData);
    }

    @Test(expected = ResidentServiceException.class)
    public void test_getUniqueResident_returns_ResidentServiceException_with_Wildcards() throws ParseException, ResidentServiceException {
        Resident testData = new Resident("*", "*", "*", "*",
                new SimpleDateFormat("dd-MM-yyyy").parse("04-07-1918"));

        classUnderTest.getUniqueResident(testData);
    }

    @Test
    public void test_getFilteredResidentsList_returns_correct() throws ParseException, ResidentServiceException {
        Resident testData = new Resident("*", "Rodgers", "*", "*",
                new SimpleDateFormat("dd-MM-yyyy").parse("04-07-1918"));

        List<Resident> result = classUnderTest.getFilteredResidentsList(testData);

        Assert.assertEquals(result.size(), 2);
    }

    @Test
    public void test_getFilteredResidentsList_returns_correct_with_dateOfBirth_null() throws ParseException, ResidentServiceException {
        Resident testData = new Resident("*", "Rodgers", "*", "*",
                null);

        List<Resident> result = classUnderTest.getFilteredResidentsList(testData);

        Assert.assertEquals(result.size(), 2);
    }

    @Test
    public void test_getFilteredResidentsList_returns_correct_with_nonResident() throws ParseException, ResidentServiceException {
        Resident testData = new Resident("Peter", "Parker", "Queenstreet", "Brooklyn",
                null);

        List<Resident> result = classUnderTest.getFilteredResidentsList(testData);

        Assert.assertEquals(result.size(), 0);
    }

    @Test(expected = ResidentServiceException.class)
    public void test_getUniqueResident_returns_ResidentServiceException_with_Mock() throws ParseException, ResidentServiceException {
        Resident testData = new Resident("Steve", "Rodgers", "Bushwik 2", "Brooklyn",
                new SimpleDateFormat("dd-MM-yyyy").parse("04-07-1918"));
        ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);
        expect(residentRepositoryMock.getResidents()).andReturn(Collections.emptyList());
        replay(residentRepositoryMock);
        classUnderTest = new BaseResidentService(residentRepositoryMock);


        Resident result = classUnderTest.getUniqueResident(testData);

        verify(residentRepositoryMock);
    }

    @Test
    public void test_getFilteredResidentsList_returns_ResidentServiceException_with_Mock() throws ParseException, ResidentServiceException {
        Resident testData = new Resident("*", "*", "*", "Brooklyn",
                new SimpleDateFormat("dd-MM-yyyy").parse("04-07-1918"));
        Resident testDataResident = new Resident("Steve", "Rodgers", "Bushwik 2", "Brooklyn",
                new SimpleDateFormat("dd-MM-yyyy").parse("04-07-1918"));
        ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);
        expect(residentRepositoryMock.getResidents()).andReturn(Arrays.asList(
                new Resident("Jarvies", "Man", "Straße 1", "Freiburg",
                        new SimpleDateFormat("dd-MM-yyyy").parse("31-12-1997")),
                new Resident("Steve", "Rodgers", "Bushwik 2", "Brooklyn",
                        new SimpleDateFormat("dd-MM-yyyy").parse("04-07-1918")),
                new Resident("Michael", "Rodgers", "Bushwik 2", "Brooklyn",
                        new SimpleDateFormat("dd-MM-yyyy").parse("04-07-1918"))));
        replay(residentRepositoryMock);
        classUnderTest = new BaseResidentService(residentRepositoryMock);

        List<Resident> result = classUnderTest.getFilteredResidentsList(testData);

        verify(residentRepositoryMock);

        assertThat(result.size(), equalTo(2));
        assertThat(result.get(0), Matchers.samePropertyValuesAs(testDataResident));
    }

}
