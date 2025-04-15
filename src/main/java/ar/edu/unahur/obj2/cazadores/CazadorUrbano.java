package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class CazadorUrbano extends Cazador {

    public CazadorUrbano(Integer experiencia) {
        super(experiencia);
    }

    @Override
    public Boolean puedeCapturarseEspecifica(IProfugo profugo) {
        return !profugo.esNervioso();
    }

    @Override
    public void intimidar(IProfugo profugo) {
        profugo.dejarDeEstarNervioso();
    }

}
