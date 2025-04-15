package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ar.edu.unahur.obj2.cazadores.Cazador;
import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.zonas.Zona;

public class Agencia {
    private List<Cazador> cazadores;

    public Agencia() {
        this.cazadores = new ArrayList<>();
    }

    public Agencia(List<Cazador> cazadores) {
        this.cazadores = cazadores;
    }

    public void procesoCaptura(Cazador cazador, Zona zona) {
        cazador.procesoCaptura(zona);
    }

    public List<IProfugo> todosLosProfugosCapturados() {
        return cazadores.stream().flatMap(cazador -> cazador.getProfugosCapturados().stream())
                .collect(Collectors.toList());
    }

    public Optional<IProfugo> profugoMasHabilCapturado() {
        return this.todosLosProfugosCapturados().stream()
                .max(Comparator.comparingInt(IProfugo::getHabilidad));
    }

    public Cazador cazadorConMasCapturas() {
        return cazadores.stream()
                .filter(c -> !c.getProfugosCapturados().isEmpty())
                .max(Comparator.comparingInt(c -> c.getProfugosCapturados().size()))
                .orElseThrow(() -> new IllegalStateException("No hay cazadores con profugos capturados"));
    }
}
