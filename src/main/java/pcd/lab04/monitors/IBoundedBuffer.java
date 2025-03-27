package pcd.lab04.monitors;

public interface IBoundedBuffer<Item> {

    void put(Item item) throws InterruptedException;
    
    Item get() throws InterruptedException;
    
}

/* In Java, il costrutto <Item> che vedi in IBoundedBuffer<Item> fa parte del meccanismo
dei generics. I generics sono un modo per scrivere classi, interfacce e metodi che
funzionano con diversi tipi di dati. Questo permette di scrivere codice riutilizzabile e
sicuro, eliminando la necessità di scrivere versioni separate del codice per diversi
tipi di dati.
<Item>: è un parametro di tipo. È un segnaposto per un tipo che verrà specificato quando
verrà utilizzata l'interfaccia o la classe. In altre parole, Item è un tipo generico che
verrà sostituito con un tipo concreto (come Integer, String, Double, ecc.) quando
l'interfaccia o la classe viene effettivamente utilizzata.
In questo caso, la variabile item in put(Item item) è un parametro di tipo 'Item', e il
metodo get() restituisce un oggetto di tipo 'Item'. */