package dk.kea.model.Interface;

        import dk.kea.model.entities.Indlæg;

        import java.sql.SQLException;
        import java.util.ArrayList;

public interface IInlægRep {

    ArrayList<Indlæg> readAll();

    void create(Indlæg i, int userId) throws SQLException;

    void delete(int indlægId);
}
