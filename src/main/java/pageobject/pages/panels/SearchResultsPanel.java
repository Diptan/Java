package pageobject.pages.panels;

import core.base.BasePanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageobject.objects.Location;
import pageobject.objects.ResultItem;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPanel extends BasePanel {

    public SearchResultsPanel(WebElement element) {
        super(element);
    }

    @FindBy(how = How.CLASS_NAME, using = "sr_item_content")
    private List<WebElement> resultItems;

    public List<ResultItem> getResults() {
        ArrayList<ResultItem> items = new ArrayList<ResultItem>();
        for (WebElement item : resultItems)
        {
            String[] coord = item.findElement(By.cssSelector(".address  a")).getAttribute("data-coords").split(",");
            String name = item.findElement(By.cssSelector(".sr-hotel__name")).getText();
            ResultItem product = new ResultItem();
            product.setCoordinates(new Location(Double.parseDouble(coord[1]), Double.parseDouble(coord[0])));
            product.setName(name);
            items.add(product);
        }
        return items;
    }
}
