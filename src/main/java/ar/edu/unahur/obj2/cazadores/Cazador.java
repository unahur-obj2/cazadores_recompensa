package ar.edu.unahur.obj2.cazadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.zonas.Zona;

public abstract class Cazador {
    protected Integer experiencia;
    protected List<IProfugo> profugos;

    public Cazador(Integer experiencia) {
        this.experiencia = experiencia;
        this.profugos = new ArrayList<>();
    }

    public List<IProfugo> getProfugosCapturados() {
        return List.copyOf(profugos);
    }

    public Boolean puedeCapturarse(IProfugo profugo) {
        return this.puedeCapturarseGeneral(profugo) && this.puedeCapturarseEspecifica(profugo);
    }

    public Boolean puedeCapturarseGeneral(IProfugo profugo) {
        return this.experiencia > profugo.getInocencia();
    }

    public abstract Boolean puedeCapturarseEspecifica(IProfugo profugo);

    public abstract void intimidarParticular(IProfugo profugo);

    public void intimidar(IProfugo profugo) {
        profugo.disminuirInocencia();
        this.intimidarParticular(profugo);
    }

    public void procesoCaptura(Zona zona) {
        List<IProfugo> intimidados = new ArrayList<>();
        zona.getProfugos().stream().forEach(
                profugo -> {
                    if (this.puedeCapturarse(profugo)) {
                        profugos.add(profugo);
                        zona.quitarProfugo(profugo);
                    } else {
                        this.intimidar(profugo);
                        intimidados.add(profugo);
                    }
                });
        this.sumarExperiencia(intimidados);
    }

    private void sumarExperiencia(List<IProfugo> intimidados) {
        Optional<Integer> minimaHabilidad = encontrarMinimaHabilidad(intimidados);
        experiencia += minimaHabilidad.isPresent() ? minimaHabilidad.get()
                : 0
                        + 2 * profugos.size();
    }

    private Optional<Integer> encontrarMinimaHabilidad(List<IProfugo> intimidados) {
        return intimidados.stream()
                .map(IProfugo::getHabilidad)
                .min(Comparator.naturalOrder());
    }

}
