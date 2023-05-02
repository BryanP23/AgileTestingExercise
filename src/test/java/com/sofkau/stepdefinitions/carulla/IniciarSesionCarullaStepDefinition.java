package com.sofkau.stepdefinitions.carulla;

import com.sofkau.questions.carulla.IniciarSesionCarullaQuestion;
import com.sofkau.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.sofkau.tasks.AbrirPaginaInicial.abrirPaginaInicial;
import static com.sofkau.tasks.carulla.AsercionNombreUsuarioCarullaTask.asercionNombreUsuarioCarullaTask;
import static com.sofkau.tasks.carulla.IniciarSesionCarullaTask.iniciarSesionCarullaTask;
import static com.sofkau.ui.carulla.AsercionInicioSesionCarullaUI.NOMBRE_USUARIO_CARULLA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;



public class IniciarSesionCarullaStepDefinition extends SetUp {
    private final Logger log = LoggerFactory.getLogger(IniciarSesionCarullaStepDefinition.class);
    Actor actor = Actor.named("BRYAN");
    @Given("que el usuario esta en la pagina de inicio de carulla")
    public void queElUsuarioEstaEnLaPaginaDeInicioDeCarulla() {
        configurarNavegador();
        theActorInTheSpotlight().wasAbleTo(
                abrirPaginaInicial()
                        .conLaPagina("https://www.carulla.com/")
        );

    }

    @When("inicia sesion en la pagina web de carulla con su email y contrasenna validos")
    public void iniciaSesionEnLaPaginaWebDeCarullaConSuEmailYContrasennaValidos() {
        theActorInTheSpotlight().wasAbleTo(
                iniciarSesionCarullaTask(),
                asercionNombreUsuarioCarullaTask()
        );
    }

    @Then("al dar click en el boton cuenta deberia aparecer el nombre de mi usuario")
    public void alDarClickEnElBotonCuentaDeberiaAparecerElNombreDeMiUsuario() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(IniciarSesionCarullaQuestion.isEqualTo(NOMBRE_USUARIO_CARULLA), equalTo("1035436114"))
            );
            quitarDriver();
        } catch (Exception e){
            log.warn(e.getMessage());
            quitarDriver();
        }
    }
}
