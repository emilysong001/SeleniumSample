package com.automation.dental.tests;

import com.automation.dental.base.BaseTest;
import com.automation.dental.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchEPODentist extends BaseTest {

    @Test
    public void searchEPODentistWithEmptyInformation() throws IOException {

        LandingPage landingPage = launchApplication();
        FindDentistPage findDentistPage = landingPage.goToFindADentistPage();
        EPODentistPage ePODentistPage = findDentistPage.goToEPOPage();
        ePODentistPage.loadingEPODentistPage();
        ePODentistPage.searchWithEmptyCredentials();
        Assert.assertEquals(ePODentistPage.getErrorMessage1(), "To serach by location, a Zip code must be provided.");
        Assert.assertEquals(ePODentistPage.getErrorMessage2(), "To search by Name, a State must be provided.");
        Assert.assertEquals(ePODentistPage.getErrorMessage3(), "Please correct invalid fields");
    }

    @Test(dataProvider = "searchCredentials")
    public void searchEPODentistWithBasicInformation(String zipCode, String city, String state, String maximumDistance, String numberOfResults) throws IOException {

        LandingPage landingPage = launchApplication();
        FindDentistPage findDentistPage = landingPage.goToFindADentistPage();
        EPODentistPage ePODentistPage = findDentistPage.goToEPOPage();
        ePODentistPage.loadingEPODentistPage();
        ePODentistPage.searchWithBasicCredentials( zipCode,  city,  state,  Integer.valueOf(maximumDistance),  numberOfResults);
        ePODentistPage.search();
        Assert.assertEquals(ePODentistPage.getErrorMessage1(), "To search by address, a provider last name must be provided");
        Assert.assertEquals(ePODentistPage.getErrorMessage2(), "Please correct invalid fields");
    }
    @Test(dataProvider = "dentistNameCredentials")
    public void searchEPODentistWithOnlyDentistName(String dentistLastName) throws IOException {

        LandingPage landingPage = launchApplication();
        FindDentistPage findDentistPage = landingPage.goToFindADentistPage();
        EPODentistPage ePODentistPage = findDentistPage.goToEPOPage();
        ePODentistPage.loadingEPODentistPage();
        ePODentistPage.searchWithOnlyAdditionalCredentials(dentistLastName);
        ePODentistPage.search();
        Assert.assertEquals(ePODentistPage.getErrorMessage1(), "To search by Name, a State must be provided.");
        Assert.assertEquals(ePODentistPage.getErrorMessage2(), "Please correct invalid fields");
    }

    @Test
    public void searchEPODentistWithAllInformation() throws IOException {

        LandingPage landingPage = launchApplication();
        FindDentistPage findDentistPage = landingPage.goToFindADentistPage();
        EPODentistPage ePODentistPage = findDentistPage.goToEPOPage();
        ePODentistPage.loadingEPODentistPage();
        EPODentistResultPage ePODentistResultPage = ePODentistPage.searchWithAllCredentials("48375", "Novi","Michigan", 4 ,"50","Lin");
        ePODentistResultPage.loadingEPODentistResultPage();
        Assert.assertEquals(ePODentistResultPage.searchResults.getText(), "Delta Dental EPO Dentist Search Results");
    }

    @DataProvider
    public Object[][] searchCredentials() {
        String[][] credentials = {
                {"48375", "Novi","Michigan", "5" ,"50"},
                {"48374", "Farmington","Michigan", "3" ,"100"},
                {" ", "Novi","Michigan", "5" ,"50"},
        };
        return credentials;
    }

    @DataProvider
    public Object[][] dentistNameCredentials() {
        String[][] credentials = {
                {"Lin"},
                {"Song"}
        };
        return credentials;
    }



}
