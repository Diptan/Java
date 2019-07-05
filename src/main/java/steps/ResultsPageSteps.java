package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pageobject.objects.Location;
import pageobject.pages.ResultsPage;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsPageSteps {

    private ResultsPage resultsPage;

    public ResultsPageSteps()
    {
        resultsPage = new ResultsPage();
    }

    @Step("Verify results have correct location with acceptable deviation.")
    public void verifyResultsHaveCorrectLocation(double deviation, Location expectedLocation) {

        List<Location> location = resultsPage.searchResults.getResults()
                .stream().map(x->x.getCoordinates()).collect(Collectors.toList());

        Double expectedLatitude = expectedLocation.getLatitude();
        List<Double> actualLatitudes = location.stream().map(x -> x.getLatitude()).collect(Collectors.toList());
        actualLatitudes.forEach(v ->
                Assert.assertTrue(expectedLatitude - deviation <= v && v <= expectedLatitude + deviation,
                        "Locations has correct Latitude"));

        Double expectedLongitude = expectedLocation.getLongitude();
        List<Double> actualLongitudes = location.stream().map(x -> x.getLongitude()).collect(Collectors.toList());
        actualLongitudes.forEach(v ->
                Assert.assertTrue(expectedLongitude - deviation <= v && v <= expectedLongitude + deviation,
                        "Locations has correct Longitude "));
    }
}
