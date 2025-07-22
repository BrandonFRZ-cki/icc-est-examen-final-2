package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maquina {
    private String nombre;
    private String ip;
    private List<Integer> codigos;
    private int subred;
    private int riesgo;
    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
        subred = calcularSubred();
        riesgo = calcularRiesgo();
    }
    private int calcularSubred(){
        String [] partes = ip.split("\\.");
        return Integer.parseInt(partes[2]);
    }
    private int calcularRiesgo(){
        int suma =0;
        String nm = nombre.trim();
        Set<Character> caracteresUnicos=new HashSet<Character>();
        for (int i = 0; i < nombre.length(); i++) {
            caracteresUnicos.add(nm.charAt(i));
        }
        for (Integer codigo : codigos) {
            if (codigo%5==0)suma+=codigo;
        }
        return suma*caracteresUnicos.size();
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public List<Integer> getCodigos() {
        return codigos;
    }
    public void setCodigos(List<Integer> codigos) {
        this.codigos = codigos;
    }
    public int getSubred() {
        return subred;
    }
    public void setSubred(int subred) {
        this.subred = subred;
    }
    public int getRiesgo() {
        return riesgo;
    }
    public void setRiesgo(int riesgo) {
        this.riesgo = riesgo;
    }
    @Override
    public String toString() {
        return  nombre + ", ip=" + ip + " → " + subred + "]\n";
    }

    
    
}
