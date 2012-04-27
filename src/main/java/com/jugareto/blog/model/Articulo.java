/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jugareto.blog.model;

/**
 *
 * @author icruz
 */
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "articulos")
public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Integer version;
    @Column(length = 128, unique = true, nullable = false)
    private String titulo;
    @Column(length = 254, nullable = false)
    private String descripcion;
    @Column(length = 4000, nullable = false)
    private String contenido;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(length = 128, nullable = false)
    private String autor;

    public Articulo() {
    }

    public Articulo(String titulo, String descripcion, String contenido, String autor) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.autor = autor;
    }

    /**
* @return the id
*/
    public Long getId() {
        return id;
    }

    /**
* @param id the id to set
*/
    public void setId(Long id) {
        this.id = id;
    }

    /**
* @return the version
*/
    public Integer getVersion() {
        return version;
    }

    /**
* @param version the version to set
*/
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
* @return the titulo
*/
    public String getTitulo() {
        return titulo;
    }

    /**
* @param titulo the titulo to set
*/
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
* @return the descripcion
*/
    public String getDescripcion() {
        return descripcion;
    }

    /**
* @param descripcion the descripcion to set
*/
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
* @return the contenido
*/
    public String getContenido() {
        return contenido;
    }

    /**
* @param contenido the contenido to set
*/
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
* @return the fecha
*/
    public Date getFecha() {
        return fecha;
    }

    /**
* @param fecha the fecha to set
*/
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
* @return the autor
*/
    public String getAutor() {
        return autor;
    }

    /**
* @param autor the autor to set
*/
    public void setAutor(String autor) {
        this.autor = autor;
    }
}