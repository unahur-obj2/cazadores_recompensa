package ar.edu.unahur.obj2.profugos;

public class ProteccionLegalProfugoDecorator extends ProfugoDecorator {

    public ProteccionLegalProfugoDecorator(IProfugo profugo) {
        super(profugo);
    }

    @Override
    public Integer getInocencia() {
        return Math.max(profugo.getInocencia(), 40);
    }

}
