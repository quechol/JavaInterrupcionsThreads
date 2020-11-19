package condicionescompetencias;
import java.util.ArrayList;

public class RCompartido {
    private String rc;
    private int turno;
    private ArrayList<Interrupcion> interrupciones;
    RCompartido(){
        rc="";
        turno = 0;
        
        this.interrupciones = new ArrayList<Interrupcion>();
        for(int i = 0; i<4; i++){
            interrupciones.add(new Interrupcion());
        }
    }
    public String getRc() {
        return rc;
    }
    public void setRc(String rc) {
        this.rc = rc;
    }
    public boolean estadoDeLasInterrupciones(){    //Función para saber el estado de las interrupciones, si han sido bloqueadas o no
        for(Interrupcion i: interrupciones){
            if(i.estado() == false){
                return false;
            }
        }
        return true;
    }
    
    public void desactivarInterrupciones(){     //Manejo de interrupciones
        for(Interrupcion i: interrupciones){
            i.desactivar();
        }
    }
    public void activarInterrupciones(){    
        for(Interrupcion i: interrupciones){
            i.activar();
        }
    }
}