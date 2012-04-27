/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jugareto.blog.dao;

/**
 *
 * @author icruz
 */
import java.util.Date;
import java.util.List;
import com.jugareto.blog.model.Articulo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @author J. David Mendoza <jdmendoza@um.edu.mx>
*/
@Repository
@Transactional
public class ArticuloDao {
    private static final Logger log = LoggerFactory.getLogger(ArticuloDao.class);
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public Articulo crea(Articulo articulo) {
        articulo.setFecha(new Date());
        currentSession().save(articulo);
        return articulo;
    }
    
    public Articulo actualiza(Articulo articulo) {
        articulo.setFecha(new Date());
        currentSession().update(articulo);
        return articulo;
    }
    
    public String elimina(Long articuloId) {
        Articulo articulo = (Articulo)currentSession().get(Articulo.class, articuloId);
        String titulo = articulo.getTitulo();
        currentSession().delete(articulo);
        return titulo;
    }
    
    public Articulo obtiene(Long articuloId) {
        Articulo articulo = (Articulo)currentSession().get(Articulo.class, articuloId);
        return articulo;
    }
    
    public List<Articulo> lista() {
        Query query = currentSession().createQuery("select a from Articulo a order by fecha desc");
        return query.list();
    }
}