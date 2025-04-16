package ar.edu.unahur.obj2.profugos;

abstract public class ProfugoDecorator implements IProfugo {

    protected IProfugo profugo;

    public ProfugoDecorator(IProfugo profugo) {
        this.profugo = profugo;
    }

    @Override
    public Integer getInocencia() {
        return profugo.getInocencia();
    }

    @Override
    public Integer getHabilidad() {
        return profugo.getHabilidad();
    }

    @Override
    public Boolean esNervioso() {
        return profugo.esNervioso();
    }

    @Override
    public void volverseNervioso() {
        profugo.volverseNervioso();
    }

    @Override
    public void dejarDeEstarNervioso() {
        profugo.dejarDeEstarNervioso();
    }

    @Override
    public void reducirHabilidad() {
        profugo.reducirHabilidad();
    }

    @Override
    public void disminuirInocencia() {
        profugo.disminuirInocencia();
        ;
    }

}
