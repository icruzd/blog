/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jugareto.blog.dao;

/**
 *
 * @author icruz
 */
import java.util.List;
import com.jugareto.blog.model.Articulo;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @author J. David Mendoza <jdmendoza@um.edu.mx>
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:blog.xml"})
@Transactional
public class ArticuloDaoTest {
    
    private static final Logger log = LoggerFactory.getLogger(ArticuloDaoTest.class);
    @Autowired
    private ArticuloDao instance;
    
    public ArticuloDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
* Test of crea method, of class ArticuloDao.
*/
    @Test
    public void testCrea() {
        log.debug("Crea Articulo");
        Articulo articulo = new Articulo(
                "TITULO 1",
                "Esta es la descripcion",
                "Este es el contenido",
                "David Mendoza");
        articulo = instance.crea(articulo);
        assertNotNull(articulo);
        assertNotNull(articulo.getId());
    }

    /**
* Test of actualiza method, of class ArticuloDao.
*/
    @Test
    public void testActualiza() {
        log.debug("Actualiza articulo");
        Articulo articulo = new Articulo(
                "TITULO 1",
                "Esta es la descripcion",
                "Este es el contenido",
                "David Mendoza");
        articulo = instance.crea(articulo);
        assertNotNull(articulo);
        assertNotNull(articulo.getId());
        
        Long id = articulo.getId();
        Articulo prueba = instance.obtiene(id);
        prueba.setAutor("Dulce Alvarado");
        instance.actualiza(prueba);
        
        Articulo demo = instance.obtiene(id);
        assertNotNull(demo);
        assertEquals("Dulce Alvarado", demo.getAutor());
    }

    /**
* Test of elimina method, of class ArticuloDao.
*/
    @Test
    public void testElimina() {
        log.debug("Elimina articulo");
        Articulo articulo = new Articulo(
                "TITULO 1",
                "Esta es la descripcion",
                "Este es el contenido",
                "David Mendoza");
        articulo = instance.crea(articulo);
        assertNotNull(articulo);
        assertNotNull(articulo.getId());
        
        Long id = articulo.getId();
        String titulo = instance.elimina(id);
        assertNotNull(titulo);
        assertEquals("TITULO 1", titulo);
        
        Articulo prueba = instance.obtiene(id);
        assertNull(prueba);
    }

    /**
* Test of lista method, of class ArticuloDao.
*/
    @Test
    public void testLista() {
        System.out.println("lista");
        Articulo articulo = new Articulo(
                "TITULO 1",
                "Esta es la descripcion",
                "Este es el contenido",
                "David Mendoza");
        instance.crea(articulo);
        
        articulo = new Articulo(
                "TITULO 2",
                "Esta es la descripcion",
                "Este es el contenido",
                "Dulce Alvarado");
        instance.crea(articulo);
        
        List<Articulo> articulos = instance.lista();
        assertNotNull(articulos);
        assertTrue(articulos.size() >= 2);
    }
}


