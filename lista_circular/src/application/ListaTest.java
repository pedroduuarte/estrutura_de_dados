package application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import entities.Lista;

class ListaTest {

	@Test
    void testImprimirVazia() {
        Lista lista = new Lista();
        String ret = lista.imprime();
        assertEquals("lista vazia", ret);
    }

    @Test
    void testInserirCrescente() {
        Lista lista = new Lista();
        lista.insere(1);
        lista.insere(2);
        lista.insere(3);
        String ret = lista.imprime();
        assertEquals("1 2 3", ret);
    }
    
    @Test
    void testInserirDecrescente() {
        Lista lista = new Lista();
        lista.insere(3);
        lista.insere(2);
        lista.insere(1);
        String ret = lista.imprime();
        assertEquals("1 2 3", ret);
    }
    
    @Test
    void testInserirForaDeOrdem() {
        Lista lista = new Lista();
        lista.insere(2);
        lista.insere(1);
        lista.insere(3);
        String ret = lista.imprime();
        assertEquals("1 2 3", ret);
    }
    
    @Test
    void testInserirRepetidoForaDeOrdem() {
        Lista lista = new Lista();
        lista.insere(2);
        lista.insere(2);
        lista.insere(3);
        lista.insere(1);
        lista.insere(3);
        lista.insere(2);
        lista.insere(3);
        lista.insere(0);
        lista.insere(3);
        String ret = lista.imprime();
        assertEquals("0 1 2 2 2 3 3 3 3", ret);
    }
    
    @Test
    void testRemoverSemElemento() {
        Lista lista = new Lista();
        lista.remove(1, false);
        String ret = lista.imprime();
        assertEquals("lista vazia", ret);
    }
    
    @Test
    void testRemoverUnicoElemento() {
        Lista lista = new Lista();
        lista.insere(1);
        lista.remove(1, false);
        String ret = lista.imprime();
        assertEquals("lista vazia", ret);
    }
    
    @Test
    void testRemoverInicio() {
        Lista lista = new Lista();
        lista.insere(1);
        lista.insere(2);
        lista.insere(3);
        lista.remove(1, false);
        String ret = lista.imprime();
        assertEquals("2 3", ret);
    }
    
    @Test
    void testRemoverMeio() {
        Lista lista = new Lista();
        lista.insere(1);
        lista.insere(2);
        lista.insere(3);
        lista.remove(2, false);
        String ret = lista.imprime();
        assertEquals("1 3", ret);
    }
    
    @Test
    void testRemoverFim() {
        Lista lista = new Lista();
        lista.insere(1);
        lista.insere(2);
        lista.insere(3);
        lista.remove(3, false);
        String ret = lista.imprime();
        assertEquals("1 2", ret);
    }
    
    @Test
    void testRemoverSemDuplicados() {
        Lista lista = new Lista();
        lista.insere(1);
        lista.insere(2);
        lista.insere(2);
        lista.insere(3);
        lista.remove(2, false);
        String ret = lista.imprime();
        assertEquals("1 2 3", ret);
    }
    
    @Test
    void testRemoverComDuplicados() {
        Lista lista = new Lista();
        lista.insere(1);
        lista.insere(2);
        lista.insere(2);
        lista.insere(3);
        lista.remove(2, true);
        String ret = lista.imprime();
        assertEquals("1 3", ret);
    }
    
    // Testes do professor
    @Test
    void testVazia() {
        Lista lista = new Lista();
        String ret = lista.imprime();
        assertEquals("lista vazia", ret);
    }
    
    @Test
    void test1() {
        Lista lista = new Lista();
        lista.insere(5);
        lista.insere(4);
        lista.insere(3);
        lista.insere(2);
        lista.insere(1);
        String ret = lista.imprime();
        assertEquals("1 2 3 4 5", ret);
    }
    
    @Test
    void test2() {
        Lista lista = new Lista();
        lista.insere(3);
        lista.insere(5);
        lista.insere(4);
        lista.insere(3);
        lista.insere(2);
        lista.insere(1);
        lista.remove(3,false);
        String ret = lista.imprime();
        assertEquals("1 2 3 4 5", ret);
    }
    
    @Test
    void test3() {
        Lista lista = new Lista();
        lista.insere(5);
        lista.insere(4);
        lista.insere(3);
        lista.insere(2);
        lista.insere(3);
        lista.insere(1);
        lista.remove(3,true);
        String ret = lista.imprime();
        assertEquals("1 2 4 5", ret);
    }
    
    @Test
    void test4() {
        Lista lista = new Lista();
        lista.insere(2);
        lista.insere(3);
        lista.insere(1);
        lista.insere(1);
        lista.remove(1,true);
        String ret = lista.imprime();
        assertEquals("2 3", ret);
    }
    
    @Test
    void test5() {
        Lista lista = new Lista();
        lista.insere(2);
        lista.insere(3);
        lista.insere(1);
        lista.insere(3);
        lista.insere(3);
        lista.remove(3,true);
        String ret = lista.imprime();
        assertEquals("1 2", ret);
    }
    
    @Test
    void test6() {
        Lista lista = new Lista();

        lista.insere(2);
        lista.insere(1);
        lista.insere(3);
        lista.insere(1);
        lista.insere(3);
        lista.insere(4);
        lista.remove(3,true);
        lista.remove(1,true);
        lista.remove(4,true);
        lista.remove(2,false);
        lista.insere(150);
        lista.insere(100);
        String ret = lista.imprime();
        assertEquals("100 150", ret);
    }
    
    // Testes adicionais
    @Test
    void test7() {
        Lista lista = new Lista();
        lista.insere(2);
        lista.insere(1);
        lista.insere(50);
        lista.insere(1);
        lista.insere(3);
        lista.insere(4);
        lista.remove(51,true);
        lista.remove(1,true);
        lista.remove(4,true);
        lista.insere(150);
        lista.remove(150,true);
        lista.remove(2,false);
        lista.insere(100);
        String ret = lista.imprime();
        assertEquals("3 50 100", ret);
    }
    
    @Test
    void test8() {
        Lista lista = new Lista();
        lista.insere(2);
        lista.insere(3);
        lista.insere(1);
        lista.insere(1);
        lista.insere(1);
        lista.insere(1);
        lista.remove(1,true);
        String ret = lista.imprime();
        assertEquals("2 3", ret);
    }
    
    @Test
    void test9() {
        Lista lista = new Lista();
        lista.insere(2);
        lista.remove(2,true);
        String ret = lista.imprime();
        assertEquals("lista vazia", ret);
    }
   
}
