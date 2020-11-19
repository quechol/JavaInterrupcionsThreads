package condicionescompetencias;
import javax.swing.JTextArea;
public class Hilo extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private boolean dead=false;
    private final static int inicio = 995;
    private final static int fin = 1000;
    private boolean apaga = false;
    
    Hilo(JTextArea area, RCompartido rc){
        this.area=area;
        this.rc=rc;
    }
    public void run(){
        while(true){
            try{
                if(isReinicio()==false){
                    if(rc.estadoDeLasInterrupciones()){
                        rc.desactivarInterrupciones();
                        rc.setRc(this.getName());
                        area.append(rc.getRc()+": Eats\n");
                        if(isDead()){   
                            stop();
                        }   
                        rc.activarInterrupciones();                                           
                    }else{
                        area.append("En espera...\n");
                    }
                    Thread.sleep((int) (inicio+Math.random()*fin));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public boolean isDead(){
        return dead;
    }
    public void setDead(boolean d){
        dead=d;
    }
    
    public boolean isReinicio() {
        return apaga;
    }

    public void setReinicio(boolean reinicio) {
        this.apaga = reinicio;
    }
}
