package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class CazadorRural extends Cazador {

    public CazadorRural(Integer experiencia) {
        super(experiencia);
    }

    @Override
    public Boolean puedeCapturarseEspecifica(IProfugo profugo) {
        return profugo.esNervioso();
    }

    @Override
    public void intimidarParticular(IProfugo profugo) {
        profugo.volverseNervioso();
    }

}
