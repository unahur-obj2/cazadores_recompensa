package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cazadores.Cazador;
import ar.edu.unahur.obj2.cazadores.CazadorSigiloso;
import ar.edu.unahur.obj2.cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.profugos.ArteMarcialProfugoDecorator;
import ar.edu.unahur.obj2.profugos.EntrenamientoEliteProfugoDecorator;
import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.profugos.ProteccionLegalProfugoDecorator;
import ar.edu.unahur.obj2.zonas.Zona;

public class AgenciaTest {

    Cazador sigiloso = new CazadorSigiloso(40);
    Cazador urbano = new CazadorUrbano(50);

    IProfugo progugoSimple1 = new Profugo(30, 26, false);
    IProfugo conArteMarcial = new ArteMarcialProfugoDecorator(new Profugo(30, 26, false));
    IProfugo conProteccionLegal = new ProteccionLegalProfugoDecorator(new Profugo(30, 3, false));

    IProfugo profugoSimpe2 = new Profugo(30, 26, true);
    IProfugo conEntrenamiento = new EntrenamientoEliteProfugoDecorator(
            new Profugo(30, 26, true));
    IProfugo conArteMarcialYEntrenamiento = new ArteMarcialProfugoDecorator(
            new EntrenamientoEliteProfugoDecorator(
                    new Profugo(30, 33, true)));
    Zona zona1 = new Zona("Zona 1");
    Zona zona2 = new Zona("Zona 2");

    Agencia agencia = new Agencia(Arrays.asList(sigiloso, urbano));

    @BeforeEach
    void setUp() {
        zona1.vaciarProfugos();
        zona1.agregarProfugo(progugoSimple1);
        zona1.agregarProfugo(conArteMarcial);
        zona1.agregarProfugo(conProteccionLegal);

        zona2.vaciarProfugos();
        zona2.agregarProfugo(profugoSimpe2);
        zona2.agregarProfugo(conEntrenamiento);
        zona2.agregarProfugo(conArteMarcialYEntrenamiento);
    }

    @Test
    void testAgenciaProcesarCaptura() {
        agencia.procesoCaptura(sigiloso, zona1);
        agencia.procesoCaptura(urbano, zona2);
        assertEquals(3, agencia.todosLosProfugosCapturados().size());
        assertEquals(urbano, agencia.cazadorConMasCapturas());
        assertEquals(conArteMarcialYEntrenamiento, agencia.profugoMasHabilCapturado().get());
    }

}
