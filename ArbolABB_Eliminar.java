/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoExamenEd2Arboles_2;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ArbolABB_Eliminar {

    public Nodo raiz;

    public ArbolABB_Eliminar() {
        raiz = null;
    }

    public void insertar(int x) {
        raiz = insertar(raiz, x);
    }

    public Nodo insertar(Nodo p, int x) {
        if (p == null) {
            return new Nodo(x);
        } else {
            if (x < p.elem) {
                p.izq = insertar(p.izq, x);
            } else {
                p.der = insertar(p.der, x);
            }
            return p;
        }
    }

    public void inOrden() {
        inOrden(raiz);
        System.out.println("");
    }

    public void inOrden(Nodo p) {
        if (p == null) {
            return;
        } else {
            inOrden(p.izq);
            System.out.print(p.elem + " ,");
            inOrden(p.der);
        }
    }

    private boolean isHoja(Nodo p) {
        return (p.izq == null && p.der == null ? true : false);
    }
// Eliminar elementos de un Árbol Binario de Búsqueda.
    

 
//A1.eliminarHojas() : Método que elimina los nodos hoja de árbol A1.

    public void eliminarHojas() {
        eliminarHojas(raiz);
    }

    public Nodo eliminarHojas(Nodo p) {
        if (p == null) {
            return null;
        } else {
            if (isHoja(p)) {
                return null;
            } else {
                Nodo i = eliminarHojas(p.izq);
                p.izq = i;
                Nodo d = eliminarHojas(p.der);
                p.der = d;
                return p;
            }
        }
    }

    public int inmediatoSuperior(Nodo p) {
        if (p.izq == null) {
            return p.elem;
        } else {
            return inmediatoSuperior(p.izq);
        }
    }

    public Nodo eliminarNodo(Nodo p) {
        if (p.izq == null && p.der == null) {
            return null;
        }
        if (p.izq != null && p.der == null) {
            return p.izq;
        }
        if (p.izq == null && p.der != null) {
            return p.der;
        }
        int y = inmediatoSuperior(p.der);
        p.elem = y;
        p.der = eliminar(p.der, y);
        return p;
    }
    
//A1.eliminar(x) : Método que elimina el elemento x, del árbol A1.
    public void eliminar(int x) {
        raiz = eliminar(raiz, x);
    }

    public Nodo eliminar(Nodo p, int x) {
        if (p == null) {
            return null;
        }
        if (x == p.elem) {
            return eliminarNodo(p);
        }
        if (x < p.elem) {
            p.izq = eliminar(p.izq, x);
        } else {
            p.der = eliminar(p.der, x);
        }
        return p;
    }

    //A1.eliminarPares() : Método que elimina los elementos pares del árbol
    public void eliminarPar() {
        raiz = eliminarPar(raiz);
    }

    public Nodo eliminarPar(Nodo p) {
        if (p == null) {
            return null;
        }
        if (isHoja(p)) {
            if (p.elem % 2 == 0) {
                return eliminarNodo(p);
            } else {
                return p;
            }
        }
        p.izq = eliminarPar(p.izq);
        p.der = eliminarPar(p.der);
        if (p.elem % 2 == 0) {
            p = eliminarNodo(p);
        }
        
        return p;
    }
//A1.eliminar(L1) : Método que elimina los elementos de la lista L1 que se encuentran en el árbol A1.

    public void eliminar(ArrayList<Integer> a) {
        raiz = eliminar(raiz, a);
    }

    public Nodo eliminar(Nodo p, ArrayList<Integer> a) {
        if (p == null) {
            return null;
        }
        if (isHoja(p)) {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) == p.elem) {
                    return eliminarNodo(p);
                }
            }
        }
        for (int i = 0; i < a.size(); i++) {
            if (p.elem == a.get(i)) {
                p = eliminarNodo(p);
            }
        }
        p.izq = eliminar(p.izq, a);
        p.der = eliminar(p.der, a);
        return p;

    }

    //obtener el menor elemento, caso contrario que no se encuentra retorna-1
 public int obtenerMenor(Nodo p) {
        if (p == null) {
            return -1;
        } else {
            if (isHoja(p)) {
                return p.elem;
            }
            int i = obtenerMayor(p.izq);
            int d = obtenerMayor(p.der);
            if (i < d) {
                return i;
            } else {
                return d;
            }
        }
    }
//A1.eliminarMenor(): Método que elimina el elemento menor del árbol A1.

    public void eliminarMenor() {
        int menor = obtenerMenor(raiz);
        eliminar(raiz, menor);
    }
    //Metodo que obtiene el mayor elemento del arbol

    private int obtenerMayor() {
        return obtenerMayor(raiz);
    }
    
    //Metodo auxiliar para eliminar numeros primos

       public boolean verificarPrimo(int x) {
        if (x == 1) {
            return false;
        } else {
            int divisor = 1;
            int residuo;
            boolean bandera;
                do
                {
                    divisor++;
                    residuo = x % divisor;
                } while (residuo != 0);
                //residuo = valorNumerico % divisor;
                if (x == divisor)
                {
                    bandera = true;
                }
                else
                {
                    bandera = false;
                }
                return bandera;
            }
            
        }


//A1.eliminarMayor(): Método que elimina el elemento mayor del árbol A1.
    public int obtenerMayor(Nodo p) {
        if (p == null) {
            return -1;
        } else {
            if (isHoja(p)) {
                return p.elem;
            }
            int i = obtenerMayor(p.izq);
            int d = obtenerMayor(p.der);
            return i > d ? i : d;

        }

    }
    
    public static void main(String[] args) {
        ArbolABB_Eliminar ae = new ArbolABB_Eliminar();
        
        ae.insertar(10);
        ae.insertar(20);
        ae.insertar(9);
        ae.insertar(6);
        ae.insertar(4);
        ae.insertar(1);
        ae.insertar(30);
        
        ae.inOrden();
        ae.eliminar(30);
        ae.inOrden();
        ae.eliminarHojas();
        ae.inOrden();
        ae.eliminarPar();
        ae.inOrden();
        ae.eliminarMenor();
        ae.inOrden();
    }

}
