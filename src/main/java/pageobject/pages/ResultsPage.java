package pageobject.pages;

import core.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageobject.pages.panels.SearchResultsPanel;

public class ResultsPage extends BasePage {

    @FindBy(how = How.ID, using = "search_results_table")
    private WebElement searchResultPanel;
    public SearchResultsPanel searchResults = new SearchResultsPanel(searchResultPanel);
}
