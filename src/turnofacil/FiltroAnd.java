package turnofacil;

public class FiltroAnd implements Filtro{
    Filtro f1;
    Filtro f2;
    
    public FiltroAnd(Filtro f1, Filtro f2) {
        this.f1 = f1;
        this.f2 = f2;
    }
    
    public void setFiltro1(Filtro f1) {
        this.f1 = f1;
    }
    
    public void setFiltro2(Filtro f2) {
        this.f2 = f2;
    }
    
    public Filtro getFiltro1() {
        return f1;
    }
    
    public Filtro getFiltro2() {
        return f2;
    }
    
    public boolean cumple(Turno t) {
        return f1.cumple(t) && f2.cumple(t);
    }
}
