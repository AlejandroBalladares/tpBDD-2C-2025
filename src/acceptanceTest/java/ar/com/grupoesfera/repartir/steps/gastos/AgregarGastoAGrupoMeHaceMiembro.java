package ar.com.grupoesfera.repartir.steps.gastos;

import ar.com.grupoesfera.repartir.steps.CucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class AgregarGastoAGrupoMeHaceMiembro extends CucumberSteps {

    @Dado("que existe un grupo con los miembros {string} y {string}, sin incluir al usuario")
    public void queExisteUnGrupoConLosMiembrosY(String miembro1, String miembro2) {
        throw new io.cucumber.java.PendingException();
    }

    @Dado("que existe un grupo con los miembros {string} y el usuario")
    public void queExisteUnGrupoEnElQueElUsuarioEsMiembroCon(String miembro) {
        throw new io.cucumber.java.PendingException();
    }

    @Cuando("el usuario agrega un gasto")
    public void elUsuarioAgregaUnGastoDe() {
        throw new io.cucumber.java.PendingException();
    }

    @Entonces("la lista de miembros pasa a ser {string}, {string} y el usuario")
    public void laListaDeMiembrosPasaASerY(String miembro1, String miembro2) {
        throw new io.cucumber.java.PendingException();
    }

    @Entonces("la lista de miembros del grupo sigue siendo {string} y el usuario")
    public void laListaDeMiembrosDelGrupoSigueSiendoY(String miembro) {
        throw new io.cucumber.java.PendingException();
    }
}