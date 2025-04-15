package ar.edu.unahur.obj2.cazadores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.profugos.ArteMarcialProfugoDecorator;
import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.profugos.ProteccionLegalProfugoDecorator;
import ar.edu.unahur.obj2.zonas.Zona;

public class CazadorSigilosoTest {

    Cazador sigiloso = new CazadorSigiloso(40);
    IProfugo progugoSimple = new Profugo(30, 26, false);
    IProfugo conArteMarcial = new ArteMarcialProfugoDecorator(new Profugo(30, 26, false));
    IProfugo conProteccionLegal = new ProteccionLegalProfugoDecorator(new Profugo(30, 3, false));

    Zona zona = new Zona("Zona 1");

    @BeforeEach
    void setUp() {
        zona.vaciarProfugos();
        zona.agregarProfugo(progugoSimple);
        zona.agregarProfugo(conArteMarcial);
        zona.agregarProfugo(conProteccionLegal);
    }

    @Test
    void testProcesoCapturaCazadorSigiloso_CapuraAlProfugoNoDecoradoEIntimidaAlResto() {
        sigiloso.procesoCaptura(zona);
        assertEquals(1, sigiloso.getProfugosCapturados().size());
        assertEquals(2, zona.getProfugos().size());
        assertTrue(sigiloso.getProfugosCapturados().contains(progugoSimple));
        assertEquals(42, conArteMarcial.getHabilidad());
        assertEquals(0, conProteccionLegal.getHabilidad());
    }
}
