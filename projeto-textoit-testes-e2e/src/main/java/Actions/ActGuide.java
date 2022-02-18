package Actions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.modelo.Photos;
import pageObjects.PgoGuide;

public class ActGuide {

	private PgoGuide pgoGuide;
	private WebDriverWait wait;

	public ActGuide(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		pgoGuide = PageFactory.initElements(driver, PgoGuide.class);
	}

	public void click(WebElement e) {
		wait.until(ExpectedConditions.visibilityOf(e)).click();
	}

	public void clicarMenuGuide() {
		click(pgoGuide.menuGuide);
	}

	public void clicarLnkPhotos() {
		click(pgoGuide.lnkPhotos);
	}

	public String copiarDados() {
		return pgoGuide.listPhotos.getText();
	}

	public JSONArray criarArrayJson(String dados) {
		try {
			return (JSONArray) new JSONParser().parse(dados);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public JSONObject retornarDadosDoAlbum(JSONArray jsonArray, long id) {
		JSONObject jasonObject;

		for (int i = 0; i < jsonArray.size(); i++) {
			jasonObject = (JSONObject) jsonArray.get(i);
			if (jasonObject.get("id").equals(id)) {
				return jasonObject;
			}
		}

		return null;
	}
	
	public void validarAlbum(JSONArray jsonArray, Photos photo) {
		JSONObject json = retornarDadosDoAlbum(jsonArray, photo.getId());

		assertEquals(photo.getAlbumId(), json.get("albumId"));
		assertEquals(photo.getId(), json.get("id"));
		assertEquals(photo.getTitle(), json.get("title"));
		assertEquals(photo.getUrl(), json.get("url"));
		assertEquals(photo.getThumbnailUrl(), json.get("thumbnailUrl"));
	}

}
