package ar.edu.unahur.obj2.profugos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProfugoDecoratorTest {

    private Profugo conInocenciaDe25Habilidad40 = new Profugo(25, 40, true);
    private Profugo conInocenciaDe41Habilidad51 = new Profugo(41, 51, true);

    @Test
    void dadoUnProfugoCon25UnidadesDeInocenciaQueAdquiereProteccion_SuInocenciaNuncaEstaDebajoDe40Unidades() {
        var conProteccionLegal = new ProteccionLegalProfugoDecorator(conInocenciaDe25Habilidad40);
        assertEquals(40, conProteccionLegal.getInocencia());
    }

    @Test
    void dadoUnProfugoCon41UnidadesDeInocenciaQueAdquiereProteccion_SuInocenciaSeMantieneEn41() {
        var conProteccionLegal = new ProteccionLegalProfugoDecorator(conInocenciaDe41Habilidad51);
        assertEquals(41, conProteccionLegal.getInocencia());
    }

    @Test
    void dadoUnProfugoCon40UnidadesDeHabilidadQueAdquiereArteMarcial_SuHabilidadSeDuplica() {
        var conProteccionLegal = new ArteMarcialProfugoDecorator(conInocenciaDe25Habilidad40);
        assertEquals(80, conProteccionLegal.getHabilidad());
    }

    @Test
    void dadoUnProfugoCon51UnidadesDeHabilidadQueAdquiereArteMarcial_SuHabilidadLlegaAlMaximo() {
        var conProteccionLegal = new ArteMarcialProfugoDecorator(conInocenciaDe41Habilidad51);
        assertEquals(100, conProteccionLegal.getHabilidad());
    }

    @Test
    void dadoUnProfugoCon25InocenciaY40Habilidad_QueAdquireProteccionYArteMarcial_SuInocenciaNuncaEstaDebajoDe40YSuHabilidadSeDuplica() {
        var decortor = new ArteMarcialProfugoDecorator(
                new ProteccionLegalProfugoDecorator(conInocenciaDe25Habilidad40));
        assertEquals(40, decortor.getInocencia());
        assertEquals(80, decortor.getHabilidad());
    }

    @Test
    void dadoUnProfugoCon41InocenciaY51HabilidadQueAdquireProteccionYArteMarcial_SuInocenciaSeMantieneEn41YSuHabilidadLlegaAlMaximo() {
        var decortor = new ArteMarcialProfugoDecorator(
                new ProteccionLegalProfugoDecorator(conInocenciaDe41Habilidad51));
        assertEquals(41, decortor.getInocencia());
        assertEquals(100, decortor.getHabilidad());
    }
}
