package cucumber.teste.passos;

import org.json.simple.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Actions.ActGuide;
import cucumber.modelo.Photos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PhotosTestePassos {

	private WebDriver driver;
	private ActGuide act;
	private String dados;
	private JSONArray jsonArray;
	
	public PhotosTestePassos() {
		System.setProperty("webdriver.chrome.driver", "../testese2e/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		act = new ActGuide(driver);
	}

	@Given("Que eu acessei a pagina {string}")
	public void acessarPagina(String pagina) {
		driver.get(pagina);
	}

	@And("acessei o menu Guide")
	public void acessarMenuGuide() {
		act.clicarMenuGuide();
	}

	@And("cliquei no link photos")
	public void clicarNolinkPhotos() {
		act.clicarLnkPhotos();
	}

	@When("Eu copiei os dados apresentados na tela")
	public void copiarDados() {
		this.dados = act.copiarDados();
	}

	@And("salvei os dados em um array json")
	public void salvarDadosEmArrayJson() {
		this.jsonArray = act.criarArrayJson(dados);
	}

	@Then("Eu validei os dados do objeto com o id = {long}, albumId = {long}, title = {string}, url = {string} e thumbnailUrl = {string}")
	public void validarDadosById(long id, long albumId, String title, String url, String thumbnailUrl) {
		act.validarAlbum(jsonArray, new Photos(albumId, id, title, url, thumbnailUrl));
	}

	@And("fechei o browser")
	public void fecharBrowser() {
		driver.quit();
	}

}
