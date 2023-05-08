package model.data.dao;

import model.Libro;
import model.data.DBConnector;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.Objects;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class bibliotecaDAO {
    public boolean agregarLibro(DSLContext query, Libro libro) {
        Table libros = table(name("libros"));
        String titulo = libro.getTitulo();
        String autor = libro.getAutor();
        String date = libro.getFechaPublicacion();
        String genero = libro.getGenero();

        if (!existeLibro(query,libros,libro)) {
            Field[] columnas = libros.fields(
                    "id",
                    "titulo",
                    "autor",
                    "fecha",
                    "genero",
                    "stock"
            );
            int results = query.insertInto(
                    libros,
                    columnas[0], columnas[1], columnas[2], columnas[3], columnas[4],columnas[5]
            ).values(
                    null,titulo, autor, date, genero,1
            ).execute();
            //query.close();
            DBConnector.closeConnection();
            return results == 1;
        } else {
            return false;
        }
    }
    public boolean existeLibro(DSLContext query, Table libros, Libro libro){
        String titulo = libro.getTitulo();
        String autor = libro.getAutor();
        String date = libro.getFechaPublicacion();
        String genero = libro.getGenero();
        int result=query.select().from(libros).where(
                DSL.field("titulo").eq(libro.getTitulo()).and(
        DSL.field("autor").eq(libro.getAutor()).and(DSL.field("fecha").eq(libro.getFechaPublicacion()))))
                .execute();
        return result==1;

    }
    public ArrayList<Libro> buscarLibros(DSLContext query, Libro libro,boolean estado){
        ArrayList<Libro>librosEncontrados=new ArrayList<>();
        Table libros=table(name("libros"));
        Result result=query.select().from(libros).where(
                DSL.field("autor").eq(libro.getAutor()))
                        .and(DSL.field("stock").eq(estado))
        .fetch();
        for (int i = 0; i < result.size(); i++) {
            librosEncontrados.add(
                    new Libro(Objects.requireNonNull(result.getValue(i, "titulo")).toString(),
                            Objects.requireNonNull(result.getValue(i, "autor")).toString(),
                            Objects.requireNonNull(result.getValue(i, "fecha")).toString(),
                            Objects.requireNonNull(result.getValue(i, "genero")).toString()
                    ));
        }
        return librosEncontrados;
    }
}
