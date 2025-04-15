package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class CazadorSigiloso extends Cazador {
    public CazadorSigiloso(Integer experiencia) {
        super(experiencia);
    }

    @Override
    public Boolean puedeCapturarseEspecifica(IProfugo profugo) {
        return profugo.getHabilidad() < 50;
    }

    @Override
    public void intimidar(IProfugo profugo) {
        profugo.reducirHabilidad();
    }
}
