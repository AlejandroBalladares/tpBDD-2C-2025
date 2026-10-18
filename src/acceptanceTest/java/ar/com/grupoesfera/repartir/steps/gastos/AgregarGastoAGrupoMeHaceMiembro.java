package ar.com.grupoesfera.repartir.steps.gastos;

import ar.com.grupoesfera.repartir.steps.CucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class AgregarGastoAGrupoMeHaceMiembro extends CucumberSteps {

    private final String nombreUsuario = "Alejandro";

    @Dado("que existe un grupo con los miembros {string} y {string}, sin incluir al usuario")
    public void queExisteUnGrupoConLosMiembrosY(String miembro1, String miembro2) {
        baseDeDatos.existeUnGrupoConLosMiembros(12, "Grupo sin el usuario", List.of(miembro1, miembro2));

        iniciarSesion();
    }

    @Dado("que existe un grupo con los miembros {string} y el usuario")
    public void queExisteUnGrupoEnElQueElUsuarioEsMiembroCon(String miembro) {
        baseDeDatos.existeUnGrupoConLosMiembros(12, "Grupo con el usuario", List.of(miembro, nombreUsuario));

        iniciarSesion();
    }

    @Cuando("el usuario agrega un gasto")
    public void elUsuarioAgregaUnGastoDe() {
        String gasto = "500";
        var wait = new WebDriverWait(driver, 2);

        var agregarGastoButton = wait.until(
            visibilityOfElementLocated(
                By.id("agregarGastoGruposButton-" + 12)
            )
        );
        agregarGastoButton.click();

        var montoInput = driver.findElement(
            By.id("montoGastoNuevoInput")
        );
        montoInput.clear();
        montoInput.sendKeys(gasto);

        var guardarGastoButton = driver.findElement(
            By.id("guardarGastoNuevoButton")
        );
        guardarGastoButton.click();
    }

    @Entonces("la lista de miembros pasa a ser {string}, {string} y el usuario")
    public void laListaDeMiembrosPasaASerY(String miembro1, String miembro2) {
        verificarMiembrosDelGrupo(List.of(miembro1, miembro2, nombreUsuario), 3);
    }

    @Entonces("la lista de miembros del grupo sigue siendo {string} y el usuario")
    public void laListaDeMiembrosDelGrupoSigueSiendoY(String miembro) {
        verificarMiembrosDelGrupo(List.of(miembro, nombreUsuario), 2);
    }

    private void verificarMiembrosDelGrupo(List<String> miembrosEsperados, int posicion) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#miembros-12 > p-chip:nth-child(" + posicion + ") > div > div"), nombreUsuario));
        List<WebElement> miembros = driver.findElements(By.cssSelector("#miembros-12 div > div"));

        assertThat(miembros)
                .as("Lista de miembros visibles")
                .extracting(WebElement::getText)
                .containsExactlyElementsOf(miembrosEsperados);
    }

    private void iniciarSesion() {
        driver.navigate().to(url("/"));

        var wait = new WebDriverWait(driver, 2);
        wait.until(visibilityOfElementLocated(By.id("iniciarDialog")));

        driver.findElement(By.id("usuarioInput")).sendKeys(nombreUsuario);
        var iniciarButton = driver.findElement(By.id("iniciarBienvenidaButton"));
        iniciarButton.click();

        wait.until(invisibilityOfElementLocated(By.id("iniciarDialog")));
    }
}