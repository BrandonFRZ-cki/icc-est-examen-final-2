package controllers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import models.Maquina;

public class MaquinaController {

    public Stack<Maquina> filtrarPorSubred(List<Maquina> maquinas , int umbral){
        Stack<Maquina> pilaMaquinas = new Stack<>();
        for (Maquina maquina : maquinas) {
            if (maquina.getSubred()>umbral) pilaMaquinas.push(maquina);
        }
        return pilaMaquinas;
    }
    public Set<Maquina> ordenarPorSubred(Stack<Maquina> pila){
        Set<Maquina> treeSet=new TreeSet<>(new Comparator<Maquina>() {
            @Override
            public int compare(Maquina o1, Maquina o2) {
                if (o1.getSubred()!=o2.getSubred()) 
                    return Integer.compare(o2.getSubred(), o1.getSubred());
                return o1.getNombre().compareTo(o2.getNombre());
            }
            
        });
        for (Maquina maquina : pila) {
            treeSet.add(maquina);
        }
        return treeSet;
    }
    public Map<Integer,Queue<Maquina>> agruparPorRiesgo (List<Maquina> maquinas){
        Map<Integer,Queue<Maquina>> treeMap= new TreeMap<Integer,Queue<Maquina>>();
        
        for (Maquina maquina : maquinas) {
            Queue<Maquina> cola = new LinkedList<>(); 
            cola.add(maquina);
            treeMap.put(maquina.getRiesgo(), cola);

        }
        return treeMap;
    }
    public Stack<Maquina>exportarGrupo(Map<Integer,Queue<Maquina>>mapa){
        return null;
    }
}