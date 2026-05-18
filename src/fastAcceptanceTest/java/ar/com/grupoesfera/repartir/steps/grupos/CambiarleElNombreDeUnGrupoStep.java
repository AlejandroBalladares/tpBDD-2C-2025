package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import java.util.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CambiarleElNombreDeUnGrupoStep  extends FastCucumberSteps {

    private Grupo grupo;

    @Dado("que tengo un grupo llamado {string}")
    public void existeUnGrupoLlamado(String name) {
        List<String> miembros = new LinkedList<String>();
        miembros.add( "Oscar" );
        miembros.add( "Juan" );

        grupo = new Grupo();

        grupo.setMiembros(miembros);
        grupo.setNombre(name);
    }


    @Cuando("intento cambiarle el nombre por {string}")
    public void elUsuarioIntentaCambiarleElNombreAlGrupo(String name) {
        grupo.setNombre(name);
    }

    @Entonces("el nombre del grupo cambia a {string}")
    public void elNombreDelGrupoCambia(String name){
        assertThat( this.grupo.getNombre() == name);
    }

     @Entonces("el nombre seguirá siendo {string}")
    public void elNombreDelGrupoNoCambia(String name){
        assertThat( this.grupo.getNombre() == name);
    }
}