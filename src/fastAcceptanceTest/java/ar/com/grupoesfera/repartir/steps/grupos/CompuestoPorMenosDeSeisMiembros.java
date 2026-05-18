package ar.com.grupoesfera.repartir.steps.grupos;
import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CompuestoPorMenosDeSeisMiembros extends FastCucumberSteps {

    private Grupo grupo;

    @Cuando("el usuario intenta crear un grupo indicando seis miembros")
    public void elUsuarioIntentaCrearUnGrupoIndicandoSeisMiembros() {

        List<String> miembros = new LinkedList<String>();
        miembros.add( "Emilio" );
        miembros.add( "Emiliano" );
        miembros.add( "Maximiliano" );
        miembros.add( "Alex" );
        miembros.add( "Alexis" );
        miembros.add( "Alejo" );
        grupo = new Grupo();

        grupo.setMiembros( miembros );
    }

    @Cuando("el usuario intenta crear un grupo indicando cinco miembros")
    public void elUsuarioIntentaCrearUnGrupoIndicandoCincoMiembros() {

        List<String> miembros = new LinkedList<String>();
        miembros.add( "Emilio" );
        miembros.add( "Emiliano" );
        miembros.add( "Maximiliano" );
        miembros.add( "Alex" );
        miembros.add( "Alexis" );
        grupo = new Grupo();

        grupo.setMiembros( miembros );
    }
    
    @Entonces("no debería crear el grupo con un seis miembros")
    public void noDeberiaCrearElGrupoConUnSeisMiembros() {
        assertThat( this.grupo.estaFormado() ).isFalse();
    }

    @Entonces("visualiza dentro del listado el grupo con los miembros indicados")
    public void visualizaDentroDelListadoElGrupoConLosMiembrosIndicados() {
        assertThat( this.grupo.estaFormado() ).isTrue();
    }
}
